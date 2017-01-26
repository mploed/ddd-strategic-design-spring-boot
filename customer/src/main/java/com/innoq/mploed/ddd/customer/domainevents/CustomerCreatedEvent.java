package com.innoq.mploed.ddd.customer.domainevents;

import com.innoq.mploed.ddd.customer.domain.Kunde;

public class CustomerCreatedEvent {
    private Long id;
    private String vorname;
    private String nachname;
    private String strasse;
    private String plz;
    private String stadt;

    public CustomerCreatedEvent(Kunde kunde) {
        this.id = kunde.getId();
        this.vorname = kunde.getVorname();
        this.nachname = kunde.getNachname();
        this.plz = kunde.getPlz();
        this.stadt = kunde.getStadt();
        this.strasse = kunde.getStrasse();
    }

    public Long getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getPlz() {
        return plz;
    }

    public String getStadt() {
        return stadt;
    }
}
