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

    public void run() {
        PolynomialArithmetic polynomialCalculator = new PolynomialArithmetic();

         Scanner input = new Scanner(System.in);
        int choice = 0;

        while (true) {
            displayMenu();
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> polynomialCalculator.polynomialEvaluation();
                case 2 -> polynomialCalculator.polynomialAddition();
                case 6 -> {
                    System.out.println("System terminated.");
                    System.exit(0);
                }
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
}