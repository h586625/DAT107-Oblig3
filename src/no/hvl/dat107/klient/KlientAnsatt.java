package no.hvl.dat107.klient;

import java.time.LocalDate;
import java.util.List;

import no.hvl.dat107.Ansatt;
import no.hvl.dat107.DAO.AnsattDAO;

public class KlientAnsatt {

    public static void main(String[] args) {

        AnsattDAO ansDAO = new AnsattDAO();
        Ansatt a = ansDAO.finnAnsattMedId(1002);
        System.out.println(a.toString());

        // Ansatt ny = new Ansatt(1000, "PE", "Pablo", "Escobar", LocalDate.of(2019, 07,
        // 19), "Sjef", 10);
        // ansDAO.LagNyAnsatt(ny);

        ansDAO.oppdaterAnsettelsesdato(1002, LocalDate.of(2019, 07, 19));

        List<Ansatt> alleAnsatte = ansDAO.finnAlleAnsatte();
        alleAnsatte.forEach(ansatt -> System.out.println("   " + ansatt));

    }

}
