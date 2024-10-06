import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {
    private final Scanner input = new Scanner(System.in);

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

    public void displayMenu() {
        System.out.println("-------------------------MENU-------------------------");
        System.out.println("1. Evaluate a Polynomial");
        System.out.println("2. Add Two Polynomials");
        System.out.println("3. Subtract a Polynomial from another Polynomial");
        System.out.println("4. Multiply Two Polynomial ");
        System.out.println("5. Divide a Polynomial from another Polynomial");
        System.out.println("6. Quit");
        System.out.println("------------------------------------------------------");
        System.out.print("Enter: ");
    }

    public int validateChoice() {
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