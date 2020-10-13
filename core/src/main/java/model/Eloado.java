package model;

import exceptions.DateIsAfterTodayException;
import exceptions.ValueTooShortException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Eloado {
    private UUID id;
    private String szuletesiNev;
    private String muveszNev;
    private LocalDate szuletesiDatum;
    private String allampolgarsag;
    private List<Mufaj> mufajok;

    public UUID getId() {
        return this.id;
    }
    public void setId() {
        this.id = UUID.randomUUID();
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

    public List<Mufaj> getMufajok() {
        return mufajok;
    }

    public void setMufajok(List<Mufaj> mufajok) {
        this.mufajok = mufajok;
    }

    public Eloado(String szuletesiNev, String muveszNev, LocalDate szuletesiDatum, String allampolgarsag, List<Mufaj> mufajok)
            throws ValueTooShortException, DateIsAfterTodayException {
        this.setId();
        this.setSzuletesiNev(szuletesiNev);
        this.setMuveszNev(muveszNev);
        this.setSzuletesiDatum(szuletesiDatum);
        this.setAllampolgarsag(allampolgarsag);
        this.setMufajok(mufajok);
    }

    public Eloado(String szuletesiNev, LocalDate szuletesiDatum, String allampolgarsag)
            throws ValueTooShortException, DateIsAfterTodayException {
        this.setId();
        this.setSzuletesiNev(szuletesiNev);
        this.setSzuletesiDatum(szuletesiDatum);
        this.setAllampolgarsag(allampolgarsag);
    }
}
