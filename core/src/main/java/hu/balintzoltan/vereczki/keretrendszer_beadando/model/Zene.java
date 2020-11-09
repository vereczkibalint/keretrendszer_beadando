package hu.balintzoltan.vereczki.keretrendszer_beadando.model;

import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.DateIsAfterTodayException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.MusicLengthTooShortException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.ValueTooShortException;

import java.time.LocalDate;
import java.util.UUID;

public class Zene {
    private String id;
    private String eloado;
    private String album;
    private String cim;
    private LocalDate kiadas;
    private Mufaj mufaj;
    private int hossz;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEloado() {
        return eloado;
    }

    public void setEloado(String eloado) {
        this.eloado = eloado;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) throws ValueTooShortException {
        if(album.length() == 0) {
            throw new ValueTooShortException("Az album nevének megadása kötelező!");
        }
        this.album = album;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) throws ValueTooShortException {
        if(cim.length() == 0) {
            throw new ValueTooShortException("A cím megadása kötelező!");
        }
        this.cim = cim;
    }

    public LocalDate getKiadas() {
        return kiadas;
    }

    public void setKiadas(LocalDate kiadas) throws DateIsAfterTodayException {
        if(kiadas.isAfter(LocalDate.now())) {
            throw new DateIsAfterTodayException("A kiadás dátuma csak a mai napot megelőző détum lehet!");
        }
        this.kiadas = kiadas;
    }

    public Mufaj getMufaj() {
        return mufaj;
    }

    public void setMufaj(Mufaj mufaj) {
        this.mufaj = mufaj;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) throws MusicLengthTooShortException {
        if(hossz == 0) {
            throw new MusicLengthTooShortException("A zene hossza túl rövid!");
        }
        this.hossz = hossz;
    }

    public Zene() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Zene{" +
                "id='" + id + '\'' +
                ", eloado=" + eloado +
                ", album='" + album + '\'' +
                ", cim='" + cim + '\'' +
                ", kiadas=" + kiadas +
                ", mufaj=" + mufaj +
                ", hossz=" + hossz +
                '}';
    }
}
