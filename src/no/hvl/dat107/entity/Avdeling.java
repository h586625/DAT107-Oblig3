package no.hvl.dat107.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import no.hvl.dat107.DAO.AnsattDAO;

@Entity
@Table(name = "avdeling", schema = "oblig_3")
public class Avdeling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer avdelingid;
    private String navn;
    private int sjef;
    @OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
    private List<Ansatt> ansatte;

    public Avdeling() {
    }

    public Avdeling(String navn, int sjef, List<Ansatt> ansatte) {
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

    public int getSjef() {
        return sjef;
    }

    public void setSjef(int sjef) {
        this.sjef = sjef;
    }

    public String getSjefNavn(int id) {
        AnsattDAO ansdao = new AnsattDAO();
        Ansatt ans = ansdao.finnAnsattMedId(id);

        return ans.getFornavn() + " " + ans.getEtternavn();
    }

    public List<Ansatt> getAnsatte() {
        return ansatte;
    }

    public void setAnsatte(List<Ansatt> ansatte) {
        this.ansatte = ansatte;
    }

    public void leggTilAnsatt(Ansatt a) {
        ansatte.add(a);
    }

    public void fjernAnsatt(Ansatt a) {
        ansatte.remove(a);
    }

    @Override
    public String toString() {
        String str = String.format("Avdeling: %n ID: %d %n Navn: %s %n Sjef: %s %n", avdelingid, navn,
                getSjefNavn(sjef));
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