package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avdeling", schema = "oblig_3")
public class Avdeling {

    @Id
    Integer id;
    private String navn;
    private Ansatt sjef;

    public Avdeling() {
    }

    public Avdeling(Integer id, String navn, Ansatt sjef) {
        this.id = id;
        this.navn = navn;
        this.sjef = sjef;
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

    public Ansatt getSjef() {
        return sjef;
    }

    public void setSjef(Ansatt sjef) {
        this.sjef = sjef;
    }

    @Override
    public String toString() {
        return String.format("Avdeling: %n ID: %d %n Navn: %s %n Sjef: %s %n _________________", id, navn,
                sjef.getFornavn());
    }

}