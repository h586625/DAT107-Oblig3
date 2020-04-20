package no.hvl.dat107.klient;

import java.time.LocalDate;
import java.util.List;

import no.hvl.dat107.DAO.AnsattDAO;
import no.hvl.dat107.entity.Ansatt;

public class KlientAnsatt {

    public static void main(String[] args) {

        AnsattDAO ansDAO = new AnsattDAO();
        Ansatt a = ansDAO.finnAnsattMedId(1);
        System.out.println(a.toString());

        // create new employee
//        AvdelingDAO avdDAO = new AvdelingDAO();
//        Avdeling avd = avdDAO.finnAvdelingMedId(10);
//        Ansatt ny = new Ansatt("BW", "Bat", "Man", LocalDate.of(2012, 07, 19), "Guard", 1000000, avd);
//        ansDAO.LagNyAnsatt(ny);

        // update hiringdate
        ansDAO.oppdaterAnsettelsesdato(1002, LocalDate.of(2019, 07, 19));

        // update sector for an employee
        ansDAO.oppdaterAvdeling(a.getId(), 30);

        // list all employees
        List<Ansatt> alleAnsatte = ansDAO.finnAlleAnsatte();
        alleAnsatte.forEach(ansatt -> System.out.println("   " + ansatt));
    }
}
