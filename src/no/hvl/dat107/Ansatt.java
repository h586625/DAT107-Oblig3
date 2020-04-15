package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ansatt", schema = "oblig_3")
public class Ansatt {

    @Id
    Integer id;
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    // dato vent med denne, spesiell variabel
    private String stilling;
    private int lonn;
    // vent med denne Avdeling avdeling;
    // vent med denne Prosjekt prosjekt;

    public Ansatt() {
    }

    public Ansatt(Integer id, String brukernavn, String fornavn, String etternavn, String stilling, int lonn) {
        this.id = id;
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.stilling = stilling;
        this.lonn = lonn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public int getLonn() {
        return lonn;
    }

    public void setLonn(int lonn) {
        this.lonn = lonn;
    }

    @Override
    public String toString() {
        return String.format(
                "Ansatt: %n ID: %d %n Fornavn: %s %n Etternavn: %s %n Brukernavn: %s %n Lønn: %d %n Stilling: %s %n _________________",
                id, fornavn, etternavn, brukernavn, lonn, stilling);
    }

}