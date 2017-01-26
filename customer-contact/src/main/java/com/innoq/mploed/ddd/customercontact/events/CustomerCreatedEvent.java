package com.innoq.mploed.ddd.customercontact.events;

import com.innoq.mploed.ddd.customercontact.domain.Address;

public class CustomerCreatedEvent {
    private Long id;
    private String vorname;
    private String nachname;
    private String strasse;
    private String plz;
    private String stadt;

    public Address toAddress() {
        Address address = new Address();
        address.setCustomerId(this.id.toString());
        address.setName(this.vorname + " " + this.nachname);
        address.setStreet(this.strasse);
        address.setCity(this.plz + " " + this.stadt);
        return address;
    }

    @Override
    public String toString() {
        return "CustomerCreatedEvent{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", strasse='" + strasse + '\'' +
                ", plz='" + plz + '\'' +
                ", stadt='" + stadt + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }
}
