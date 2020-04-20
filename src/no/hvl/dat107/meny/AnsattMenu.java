package no.hvl.dat107.meny;

import java.util.Scanner;

public class AnsattMenu implements MenyInterface {
    boolean exit = false;

    @Override
    public void runMenu() {
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    @Override
    public int getInput() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 9) {
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException numf) {
                System.out.println("Skriv inn ett tall fra menyen");
            }
        }
        return choice;
    }

    @Override
    public void printMenu() {
        System.out.println("+--------------------+");
        System.out.println("|  Ansatt Meny Valg  |");
        System.out.println("+--------------------+");
        System.out.println("(1) Alle ansatte");
        System.out.println("(2) Legg til ansatt");
        System.out.println("(3) Søk etter ansatt med ID");
        System.out.println("(4) Oppdater Ansatt sin Fornavn");
        System.out.println("(5) Oppdater Ansatt sin Etternavn");
        System.out.println("(6) Oppdater Ansatt sin Brukernavn");
        System.out.println("(7) Oppdater Ansatt sin Lønn");
        System.out.println("(8) Oppdater Ansatt sin Avdeling");
        System.out.println("(9) Oppdater Ansatt sin Stilling");
        System.out.println("(0) Avslutt");

    }

    @Override
    public void performAction(int choice) {
        switch (choice) {
        case 0:
            exit = true;
            System.out.println("Avsluttet");
        case 1:
            break;
        case 2:
            break;
        case 3:
        case 4:
            break;
        case 5:
            break;
        case 6:
        case 7:
            break;
        case 8:
            break;
        case 9:
            break;
        default:
            // TODO:
            break;
        }

    }
}
