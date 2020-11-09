import hu.balintzoltan.vereczki.keretrendszer_beadando.dao.ZeneDAO;
import hu.balintzoltan.vereczki.keretrendszer_beadando.dao.relational.ZeneDAORelational;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.DateIsAfterTodayException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.MusicLengthTooShortException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.NoMatchingId;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.ValueTooShortException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Mufaj;
import hu.balintzoltan.vereczki.keretrendszer_beadando.model.Zene;

import org.junit.Before;
import org.junit.Test;

import java.text.MessageFormat;
import java.time.LocalDate;

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
            zene.setEloado("Avicii");
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
    public void testGetZeneById() throws NoMatchingId {
        System.out.println(dao.getZeneById("00c291c2-f918-40c6-8c71-fb5a071c7415"));
    }

    @Test
    public void testGetAllZene() {
        System.out.println(dao.getAllZene());
    }

    @Test
    public void testGetZeneByMufaj() {
        System.out.println(dao.getZeneByMufaj(Mufaj.ELEKTRONIKUS));
    }

    @Test
    public void testZeneUpdate() throws NoMatchingId {
        Zene oldZene = dao.getZeneById("00c291c2-f918-40c6-8c71-fb5a071c7415");
        Zene updatedZene = oldZene;

        oldZene.setMufaj(Mufaj.HIPHOP);

        dao.updateZene(updatedZene);

        System.out.println(dao.getZeneById("00c291c2-f918-40c6-8c71-fb5a071c7415"));
    }

    @Test
    public void testZeneDelete() throws NoMatchingId {
        System.out.println(dao.getAllZene());
        dao.removeZene(dao.getZeneById("00c291c2-f918-40c6-8c71-fb5a071c7415"));
        System.out.println(dao.getAllZene());
    }
}
