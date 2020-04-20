package no.hvl.dat107.klient;

import java.util.List;

import no.hvl.dat107.DAO.ProsjektDAO;
import no.hvl.dat107.entity.Prosjekt;

public class KlientProsjekt {

    public static void main(String[] args) {

        ProsjektDAO prosjektDAO = new ProsjektDAO();
        Prosjekt p = prosjektDAO.finnProsjektMedId(2);
        System.out.println(p.toString());

        // avdDAO.LagNyAvdeling(ny);

        List<Prosjekt> alleProsjekter = prosjektDAO.finnAlleProsjekter();
        alleProsjekter.forEach(prj -> System.out.println("   " + prj));

    }

}
