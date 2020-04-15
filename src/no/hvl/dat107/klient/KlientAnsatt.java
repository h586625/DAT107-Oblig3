package no.hvl.dat107.klient;

import java.util.List;

import no.hvl.dat107.Ansatt;
import no.hvl.dat107.DAO.AnsattDAO;

public class KlientAnsatt {

    public static void main(String[] args) {

        AnsattDAO ansDAO = new AnsattDAO();
        // Ansatt a = ansDAO.finnAnsatt(1002);
        // System.out.println(a.toString());

        // Ansatt ny = new Ansatt(1004, "PE", "Pablo", "Escobar", "Sjef", 2000000);
        // ansDAO.LagNyAnsatt(ny);

        List<Ansatt> alleAnsatte = ansDAO.finnAlleAnsatte();
        alleAnsatte.forEach(a -> System.out.println("   " + a));

    }

}
