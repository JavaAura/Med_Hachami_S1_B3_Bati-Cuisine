package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);


    public static  String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInputInt(String prompt) {
        int input = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt(); 
                scanner.nextLine(); 
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Erreur: Veuillez entrer un nombre valide."); 
                scanner.next(); 
            }
        }

        return input;
    }

    public static double getInputDouble(String prompt) {
        double input = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            try {
                input = scanner.nextDouble(); 
                scanner.nextLine(); 
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Erreur: Veuillez entrer un nombre valide."); 
                scanner.next(); 
            }
        }

        return input;
    }


    public static void clear() { 
        try { 
            if (System.getProperty("os.name").contains("Windows")) { 
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            } else { 
                new ProcessBuilder("clear").inheritIO().start().waitFor(); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
}
