package hu.balintzoltan.vereczki.keretrendszer_beadando.model;

import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.DateIsAfterTodayException;
import hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions.ValueTooShortException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Eloado {
    private String id;
    private String szuletesiNev;
    private String muveszNev;
    private LocalDate szuletesiDatum;
    private String allampolgarsag;
    private Mufaj mufaj;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSzuletesiNev() {
        return szuletesiNev;
    }

    public void setSzuletesiNev(String szuletesiNev) throws ValueTooShortException {
        if(szuletesiNev.length() == 0) {
            throw new ValueTooShortException("A név megadása kötelező!");
        }
        this.szuletesiNev = szuletesiNev;
    }

    public String getMuveszNev() {
        return muveszNev;
    }

    public void setMuveszNev(String muveszNev) {
        this.muveszNev = muveszNev;
    }

    public LocalDate getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(LocalDate szuletesiDatum) throws DateIsAfterTodayException {
        if(szuletesiDatum.isAfter(LocalDate.now())) {
            throw new DateIsAfterTodayException("A születési dátum nem lehet a mai napnál későbbi!");
        }
        this.szuletesiDatum = szuletesiDatum;
    }

    public String getAllampolgarsag() {
        return allampolgarsag;
    }

    public void setAllampolgarsag(String allampolgarsag) throws ValueTooShortException {
        if(allampolgarsag.length() == 0) {
            throw new ValueTooShortException("Az állampolgárság megadása kötelező!");
        }
        this.allampolgarsag = allampolgarsag;
    }

    public Mufaj getMufaj() {
        return mufaj;
    }

    public void setMufaj(Mufaj mufaj) {
        this.mufaj = mufaj;
    }

    public Eloado() {
        this.id = UUID.randomUUID().toString();
    }
}
