package no.hvl.dat107.klient;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat107.DAO.AnsattDAO;
import no.hvl.dat107.DAO.AvdelingDAO;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;

public class KlientAvdeling {

    public static void main(String[] args) {

        // find a specific sector
        AvdelingDAO avdDAO = new AvdelingDAO();
        Avdeling a = avdDAO.finnAvdelingMedId(10);
        System.out.println(a.toString());

        // create new sector
        AnsattDAO ansDAO = new AnsattDAO();
        Ansatt ansatt = ansDAO.finnAnsattMedId(1000);
        List<Ansatt> ansatte = new ArrayList<Ansatt>();
        ansatte.add(ansatt);
        Avdeling ny = new Avdeling("Design", ansatt.getId(), ansatte);
        avdDAO.LagNyAvdeling(ny);

        //

        // find all sectors
        List<Avdeling> alleAvdelinger = avdDAO.finnAlleAvdelinger();
        alleAvdelinger.forEach(avd -> System.out.println("   " + avd));

    }

}
