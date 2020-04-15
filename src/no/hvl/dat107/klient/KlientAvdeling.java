package no.hvl.dat107.klient;

import java.util.List;

import no.hvl.dat107.Avdeling;
import no.hvl.dat107.DAO.AvdelingDAO;

public class KlientAvdeling {

    public static void main(String[] args) {

        AvdelingDAO avdDAO = new AvdelingDAO();
//        Avdeling a = avdDAO.finnAvdelingMedId(2);
//        System.out.println(a.toString());

        // avdDAO.LagNyAvdeling(ny);

        List<Avdeling> alleAvdelinger = avdDAO.finnAlleAvdelinger();
        alleAvdelinger.forEach(avd -> System.out.println("   " + avd));

    }

}
