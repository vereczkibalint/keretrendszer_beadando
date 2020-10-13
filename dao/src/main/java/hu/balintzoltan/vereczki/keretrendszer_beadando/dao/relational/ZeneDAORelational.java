package hu.balintzoltan.vereczki.keretrendszer_beadando.dao.relational;


import hu.balintzoltan.vereczki.keretrendszer_beadando.dao.ZeneDAO;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.DateIsAfterTodayException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.MusicLengthTooShortException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.ValueTooShortException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Mufaj;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Zene;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class ZeneDAORelational implements ZeneDAO {
    private static SessionFactory factory;

    public ZeneDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createZene(Zene zene) {
        Session session = factory.openSession();
        Transaction createZeneTransaction = session.beginTransaction();
        session.save(zene);
        createZeneTransaction.commit();
        session.close();
    }

    @Override
    public Zene getZeneById(String id) {
        Session session = factory.openSession();
        Zene result = session.get(Zene.class, id);
        session.close();
        return result;
    }

    @Override
    public Collection<Zene> getAllZene() {
        Session session = factory.openSession();
        List result = session.createQuery("from Zene").list();
        session.close();
        return result;
    }

    @Override
    public Collection<Zene> getZeneByMufaj(Mufaj mufaj) {
        Session session = factory.openSession();
        String hql = "From Zene WHERE mufaj = :mufaj";
        Query q = session.createQuery(hql);
        q.setParameter("mufaj", mufaj);
        Collection<Zene> result = q.list();
        session.close();
        return result;
    }

    @Override
    public void updateZene(Zene zene) {
        Session session = factory.openSession();
        Transaction updateTransaction = session.beginTransaction();
        Zene zeneToUpdate = session.get(Zene.class, zene.getId());
        try {
            zeneToUpdate.setEloado(zene.getEloado());
            zeneToUpdate.setMufaj(zene.getMufaj());
            zeneToUpdate.setKiadas(zene.getKiadas());
            zeneToUpdate.setHossz(zene.getHossz());
            zeneToUpdate.setCim(zene.getCim());
            zeneToUpdate.setAlbum(zene.getAlbum());
            session.update(zeneToUpdate);
            updateTransaction.commit();
        } catch (ValueTooShortException | DateIsAfterTodayException | MusicLengthTooShortException ex) {
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void removeZene(Zene zene) {
        Session session = factory.openSession();
        Transaction deleteTransaction = session.beginTransaction();
        session.delete(zene);
        deleteTransaction.commit();
        session.close();
    }
}
