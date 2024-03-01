package org.acme;

import java.util.Scanner;

public class Main {
    public static void main(String... args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de la voiture : ");
        String nomVoiture = scanner.nextLine();

        Voiture voiture = new Voiture(nomVoiture);

        while (true) {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Avancer");
            System.out.println("2. Reculer");
            System.out.println("3. Monter");
            System.out.println("4. Descendre");
            System.out.println("5. Quitter");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    voiture.avancer();
                    break;
                case 2:
                    voiture.reculer();
                    break;
                case 3:
                    voiture.monter();
                    break;
                case 4:
                    voiture.descendre();
                    break;
                case 5:
                    System.out.println("Simulation terminée. Merci !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        }
    }
}