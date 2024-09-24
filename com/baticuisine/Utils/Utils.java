package com.baticuisine.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);



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


    public static LocalDate getInputDate(String prompt) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, dateFormatter); 
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Erreur: Veuillez entrer une date valide au format jj/mm/aaaa.");
               logger.error("Format date is not valid ", e);
            }
        }

        return date;
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
