package no.hvl.dat107.meny;

import java.util.Scanner;

public class ProsjektMenu implements MenyInterface {
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
        while (choice < 0 || choice > 5) {
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
        System.out.println("|  Prosjekt Meny Valg  |");
        System.out.println("+--------------------+");
        System.out.println("(1) Alle Prosjekt");
        System.out.println("(2) Legg til prosjekt");
        System.out.println("(3) S�k etter prosjekt med ID");
        System.out.println("(4) S�k etter prosjekt med navn");
        System.out.println("(5) S�k etter prosjektbeskrivelse");
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
            break;
        case 4:
            break;
        case 5:
            break;
        case 6:
        default:
            // TODO:
            break;
        }

    }

}
