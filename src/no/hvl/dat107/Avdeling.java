package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avdeling", schema = "oblig_3")
public class Avdeling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer avdelingid;
    private String navn;
    // One to one because each sector can only have one boss
    // and a boss can only be assigned one sector
    @OneToOne(mappedBy = "avdelingid")
    @JoinColumn(name = "sjef", referencedColumnName = "ansattid")
    private Ansatt sjef;
    @OneToMany(mappedBy = "avdelingid", fetch = FetchType.EAGER)
    private List<Ansatt> ansatte;

    public Avdeling() {
    }

    public Avdeling(Integer id, String navn, Ansatt sjef, List<Ansatt> ansatte) {
        this.avdelingid = id;
        this.navn = navn;
        this.sjef = sjef;
        this.ansatte = ansatte;
    }

    public Integer getId() {
        return avdelingid;
    }

    public void setId(Integer id) {
        this.avdelingid = id;
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

    public List<Ansatt> getAnsatte() {
        return ansatte;
    }

    public void setAnsatte(List<Ansatt> ansatte) {
        this.ansatte = ansatte;
    }

    @Override
    public String toString() {
        String str = String.format("Avdeling: %n ID: %d %n Navn: %s %n Sjef: %s %n", avdelingid, navn,
                sjef.getFornavn());
        str += " Ansatte:\n";
        for (int i = 0; i < ansatte.size(); i++) {
            Ansatt ansatt = ansatte.get(i);
            if (i != 0) {
                str += ", ";
            }
            str += "\t " + ansatt.getFornavn() + " " + ansatt.getEtternavn();
        }
        str += "\n_________________";
        return str;
    }

}