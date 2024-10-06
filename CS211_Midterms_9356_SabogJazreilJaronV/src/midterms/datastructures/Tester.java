/*
    Name: Sabog, Jazreil Jaron V.
    Date: October 7, 2024,
    Due Date: Oct 9, 2024 - 11:55 AM
    Class Code: CS 9356
 */

package midterms.datastructures;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Tester demo;
        try {
            demo = new Tester();
            demo.run();
        } catch (Exception x) {
            x.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * User interface loop. Displays a menu, validates user input, and calls the appropriate methods based on the user's choice.
     */
    public void run() {
        PolynomialArithmetic polynomialCalculator = new PolynomialArithmetic();

        int choice;

        while (true) {
            displayMenu();
            choice = validateChoice();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nPOLYNOMIAL EVALUATION");
                    System.out.println("------------------------------");
                    polynomialCalculator.polynomialEvaluation();
                }
                case 2 -> {
                    System.out.println("\nPOLYNOMIAL ADDITION");
                    System.out.println("------------------------------");
                    polynomialCalculator.polynomialAddition();
                }
                case 3 -> {
                    System.out.println("\nPOLYNOMIAL SUBTRACTION");
                    System.out.println("------------------------------");
                    polynomialCalculator.polynomialSubtraction();
                }
                case 4 -> {
                    System.out.println("\nPOLYNOMIAL MULTIPLICATION");
                    System.out.println("------------------------------");
                    polynomialCalculator.polynomialMultiplication();
                }
                case 5 -> {
                    System.out.println("\nPOLYNOMIAL DIVISION");
                    System.out.println("------------------------------");
                    polynomialCalculator.polynomialDivision();
                }
                case 6 -> {
                    System.out.println("System terminated.");
                    System.exit(0);
                }
                default -> System.out.println("Pick from the given options.\n");
            }
        }
    }

    /**
     * Displays the menu of available operations
     */
    public void displayMenu() {
        System.out.println("-------------------------MENU-------------------------");
        System.out.println("1. Evaluate a midterms.datastructures.Polynomial");
        System.out.println("2. Add Two Polynomials");
        System.out.println("3. Subtract a midterms.datastructures.Polynomial from another midterms.datastructures.Polynomial");
        System.out.println("4. Multiply Two midterms.datastructures.Polynomial ");
        System.out.println("5. Divide a midterms.datastructures.Polynomial from another midterms.datastructures.Polynomial");
        System.out.println("6. Quit");
        System.out.println("------------------------------------------------------");
        System.out.print("Enter: ");
    }

    /**
     * This method validates user input for the menu choice
     * @return The validated integer representing the user's menu choice
     */
    public int validateChoice() {
        Scanner input = new Scanner(System.in);

        boolean flag = false;
        int choice = 0;

        while (!flag) {
            try {
                choice = Integer.parseInt(input.nextLine());
                flag = true;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.print("Invalid Input. Choose from the following options: ");
            }
        }
        return choice;
    }
}