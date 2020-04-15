package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prosjekt", schema = "oblig_3")
public class Prosjekt {

    @Id
    Integer id;
    private String navn;
    private String beskrivelse;

    public Prosjekt() {
    }

    public Prosjekt(Integer id, String navn, String beskrivelse) {
        this.id = id;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Override
    public String toString() {
        return String.format("Prosjekt: %n ID: %d %n Navn: %s %n Beskrivelse: %s %n _________________", id, navn,
                beskrivelse);
    }

}