package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ansatt", schema = "oblig_3")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ansattid;
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private LocalDate ansettelsesdato;
    private String stilling;
    private int lonn;
    // One to one because each sector can only have one boss
    // and a boss can only be assigned one sector
    @OneToOne
    @JoinColumn(name = "avdelingid", referencedColumnName = "avdelingid")
    private Avdeling avdelingid;

    public Ansatt() {
    }

    public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansettelsesdato,
            String stilling, int lonn,
            Avdeling avdelingid) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.ansettelsesdato = ansettelsesdato;
        this.stilling = stilling;
        this.lonn = lonn;
        this.avdelingid = avdelingid;
    }

    public Integer getId() {
        return ansattid;
    }

    public void setId(Integer id) {
        this.ansattid = id;
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

    public LocalDate getAnsettelsesdato() {
        return ansettelsesdato;
    }

    public void setAnsettelsesdato(LocalDate ansettelsesdato) {
        this.ansettelsesdato = ansettelsesdato;
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

    public Avdeling getAvdeling() {
        return avdelingid;
    }

    public void setAvdeling(Avdeling avdeling) {
        this.avdelingid = avdeling;
    }

    @Override
    public String toString() {
        return String.format(
                "Ansatt: %n ID: %d %n Fornavn: %s %n Etternavn: %s %n Ansettelsesdato: " + ansettelsesdato.toString()
                        + " %n Brukernavn: %s %n Lønn: %d %n Stilling: %s %n Avdeling: %s %n _________________",
                ansattid, fornavn, etternavn, brukernavn, lonn, stilling, avdelingid.getNavn());
    }

}