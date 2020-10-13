import hu.balintzoltan.vereczki.keretrendszer_beadando.dao.ZeneDAO;
import hu.balintzoltan.vereczki.keretrendszer_beadando.dao.relational.ZeneDAORelational;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.DateIsAfterTodayException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.MusicLengthTooShortException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.ValueTooShortException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Eloado;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Mufaj;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Zene;

import org.junit.Before;
import org.junit.Test;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ZeneDAORelationalTest {

    ZeneDAO dao;

    @Before
    public void setUp() {
        dao = new ZeneDAORelational();
    }

    @Test
    public void testCreateZene() throws ValueTooShortException, DateIsAfterTodayException, MusicLengthTooShortException {
        try {
            Zene zene = new Zene();
            zene.setAlbum("album1");
            zene.setCim("cim1");
            zene.setKiadas(LocalDate.now().minusYears(1));
            zene.setHossz(120);
            zene.setMufaj(Mufaj.ELEKTRONIKUS);

            dao.createZene(zene);
            System.out.println("Zene sikeresen létrehozva:");
            System.out.println(zene.toString());
        } catch (ValueTooShortException | DateIsAfterTodayException | MusicLengthTooShortException ex) {
            System.out.println(MessageFormat.format("Hiba történt a zene mentése közben: {0}", ex.getMessage()));
        }
    }

    @Test
    public void testGetZeneById() {
        System.out.println(dao.getZeneById("ea1a9069-b630-4119-b5ed-02584047ac35"));
    }

    @Test
    public void testGetAllZene() {
        System.out.println(dao.getAllZene());
    }

    @Test
    public void testGetZeneByMufaj() {
        System.out.println(dao.getZeneByMufaj(Mufaj.POP));
    }

    @Test
    public void testZeneUpdate() {

    }

    @Test
    public void testZeneDelete() {
        System.out.println(dao.getAllZene());
        dao.removeZene(dao.getZeneById("ea1a9069-b630-4119-b5ed-02584047ac35"));
        System.out.println(dao.getAllZene());
    }
}
