package no.hvl.dat107.meny;

import java.util.Scanner;

public class StartMenu implements MenyInterface {
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
        while (choice < 0 || choice > 3) {
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
        System.out.println("+--------------------------------+");
        System.out.println("|  Start Meny for Ansatt Program |");
        System.out.println("+--------------------------------+");
        System.out.println("\nVelg hvilken kategori du vil gjøre operasjoner på: ");
        System.out.println("_____________________________________________________");
        System.out.println("(1) Ansatt");
        System.out.println("(2) Avdeling");
        System.out.println("(3) Prosjekt");
        System.out.println("(0) Avslutt");
    }

    @Override
    public void performAction(int choice) {
        switch (choice) {
        case 0:
            System.out.println("Avsluttet");
            break;
        case 1:
            AnsattMenu ansattMenu = new AnsattMenu();
            ansattMenu.runMenu();
            break;
        case 2:
            AvdelingMenu avdelingMenu = new AvdelingMenu();
            avdelingMenu.runMenu();
            break;
        case 3:
            ProsjektMenu prosjektMenu = new ProsjektMenu();
            prosjektMenu.runMenu();
            break;
        default:
            // TODO:
            break;
        }
    }
}
