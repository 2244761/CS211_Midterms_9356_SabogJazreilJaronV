import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class PolynomialArithmetic {
    private final Scanner input = new Scanner(System.in);
    public void polynomialEvaluation() {
        LinkedList<Term> Polynomial = construct();

        System.out.print("Value to be assigned to the Literals of the Polynomial: ");
        byte value;

        while (true) {
            try {
                 value = Byte.parseByte(input.nextLine());
                break;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.print("Enter a valid input: ");
            }
        }

        float total = 0;

        for (Term term : Polynomial) {
            if (term.getDegree() <= 1) {
                total += term.getCoefficient() * value;
            } else {
                total += (float) (term.getCoefficient() * Math.pow(value, term.getDegree()));
            }
        }
        System.out.println("The polynomial evaluates to : " + total);
        System.out.print("Press ENTER to continue...");
        input.nextLine();
        System.out.println();
    }

    public void polynomialAddition() {
        System.out.println("POLYNOMIAL ADDITION");
        System.out.println("FIRST POLYNOMIAL");
        LinkedList<Term> firstPolynomial = construct();
        System.out.println("SECOND POLYNOMIAL");
        LinkedList<Term> secondPolynomial = construct();

        LinkedList<Term> sumPolynomial = new LinkedList<>();

        float sum;
        for (int i = 0 ; i <= firstPolynomial.size() - 1; i++) {
            Term firstPoly = firstPolynomial.get(i);
            boolean matchFound = false;
            for (int j = 0; j <= secondPolynomial.size() - 1 ; j++) {
                Term secondPoly = secondPolynomial.get(j);
                if (firstPoly.getDegree() == secondPoly.getDegree()) {
                    sum = firstPoly.getCoefficient() + secondPoly.getCoefficient();
                    sumPolynomial.add(new Term(sum, firstPoly.getDegree()));
                    matchFound = true;
                    break;
                }
            }

            if (!matchFound) sumPolynomial.add(firstPoly);
        }
        System.out.println("The Sum of " + printPolynomial(firstPolynomial) + " and " +
                printPolynomial(secondPolynomial)  + " is " + printPolynomial(sumPolynomial));
        System.out.print("Press ENTER to continue...");
        input.nextLine();
        System.out.println();

    }

    public void polynomialSubtraction() {

    }

    public void polynomialMultiplication() {

    }

    public void polynomialDivision() {

    }

    public LinkedList<Term> construct() {
        LinkedList<Term> Polynomial = new LinkedList<>();
        byte totalTerms = setTotalTerms();

        for (int i = totalTerms; i >= 0; i--) {
            System.out.print("Enter the Coefficient of the Term with Degree " + i + ": ");
            float num = validateCoefficient();
            if (num != 0) {
                Polynomial.add(new Term(num, i));
            }
        }
        System.out.print("The Polynomial entered is " + printPolynomial(Polynomial) + "\n");

        return Polynomial;
    }

    public float validateCoefficient() {
        float number = 0;
        boolean flag = false;

        while (!flag) {
            try {
                number = Float.parseFloat(input.nextLine());
                flag = true;
            } catch (NumberFormatException | InputMismatchException x) {
                System.out.print("Invalid Input. Please enter a number: ");
            }
        }
        return number;
    }

    public byte setTotalTerms() {
        System.out.print("How many terms will there be in the polynomial: ");
        byte totalTerms = 0;
        boolean flag = false;

        while (!flag) {
            try {
                totalTerms = Byte.parseByte(input.nextLine());
                if (totalTerms < 0) System.out.print("Number must not be negative. Enter again: ");
                else if (totalTerms > 10) System.out.print("Total terms is limited to 10 only. Enter a lower value: ");
                else flag = true;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.print("Invalid Input. Please enter a Integer: ");
            }
        }
        return totalTerms;
    }

    public String printPolynomial(LinkedList<Term> polynomial) {
        StringBuilder results = new StringBuilder();
//        for (Term term : polynomial) {
//            if (term.getDegree() == polynomial.getFirst().getDegree()) {
//                if (Math.signum(term.getCoefficient()) != 1) {
//                    results.append(" - ").append(term.getCoefficient()).append(term.getLiteral()).append("^").append(term.getDegree());
//                }
//            } else {
//                if (term.getCoefficient() == 1) {
//                    if (term.getDegree() == 1 || term.getDegree() == 0){
//                        results.append(term.getLiteral());
//                    } else {
//                        results.append(term.getLiteral()).append("^").append(term.getDegree());
//                    }
//                } else {
//                    if (term.getDegree() == 1 || term.getDegree() == 0){
//                        results.append(term.getCoefficient()).append(term.getLiteral());
//                    } else {
//                        results.append(term.getCoefficient()).append(term.getLiteral()).append("^").append(term.getDegree());
//                    }
//                }
//            }
//
//
//            if (term.getDegree() == polynomial.getFirst().getDegree()) {
//                if (Math.signum(term.getCoefficient()) != 1) {
//                    results.append(" - ").append(term.getCoefficient()).append(term.getLiteral()).append("^").append(term.getDegree());
//                }
//            } else {
//                if (Math.signum(term.getCoefficient()) != 1) {
//                    results.append(" - ").append(term.getCoefficient()).append(term.getLiteral());
//                } else {
//                    results.append(" + ").append(term.getCoefficient()).append(term.getLiteral());
//                }
//            }
//    }



//        for (Term term : polynomial) {
//            boolean isFirst = term.getDegree() == polynomial.getFirst().getDegree();
//            boolean isLast = term.getDegree() == polynomial.getLast().getDegree();
//            boolean impliedCoefficients = term.getCoefficient() == 1 || term.getCoefficient() == 0 || term.getCoefficient() == -1;
//            boolean impliedPowers = term.getDegree() <= 1;
//
//            if (isFirst) {
//                results.append((Math.signum(term.getCoefficient()) < 1) ? " - " : "");
//            } else {
//                results.append((Math.signum(term.getCoefficient()) == 1) ? " + " : " - ") ;
//            }
//
//            if (term.getCoefficient() < 0) {
//                if (impliedPowers && impliedCoefficients) results.append(term.getLiteral());
//                else if (impliedPowers) results.append(Math.abs(term.getCoefficient())).append(term.getLiteral());
//                else if (impliedCoefficients) results.append(term.getLiteral()).append("^").append(term.getDegree());
//                else results.append(Math.abs(term.getCoefficient())).append(term.getLiteral()).append("^").append(term.getDegree());
//            } else if (impliedCoefficients) {
//                if (impliedPowers) results.append(term.getLiteral());
//                else results.append(term.getLiteral()).append("^").append(term.getDegree());
//
//            } else {
//                if (impliedPowers) results.append(term.getCoefficient()).append(term.getLiteral());
//                else results.append(term);
//            }
//
//            // delete the last literal if the degree is 0
//            if (isLast) results.deleteCharAt(results.length() - 1);
//        }


        for (Term term : polynomial) {
            boolean isFirst = term.getDegree() == polynomial.getFirst().getDegree();
            boolean isLast = term.getDegree() == polynomial.getLast().getDegree();
            boolean impliedCoefficients = term.getCoefficient() == 1 || term.getCoefficient() == 0 || term.getCoefficient() == -1;
            boolean impliedPowers = term.getDegree() <= 1;

            if (term.getCoefficient() < 0) {
                if (isFirst) results.append("- ");
                else results.append(" - ");

                if (impliedCoefficients) {
                    results.append(term.getLiteral());
                } else {
                    results.append(Math.abs(term.getCoefficient())).append(term.getLiteral());
                }
            } else if (impliedCoefficients) {
                if (isLast) results.append(" + ").append(term.getCoefficient());
                else if (!isFirst) results.append(" + ").append(term.getLiteral());
                else results.append(term.getLiteral());
            } else {
                if(!isFirst) results.append(" + ");
                results.append(term.getCoefficient()).append(term.getLiteral());
            }

            if (!impliedPowers) {
                results.append("^").append(term.getDegree());
            }

            // delete the last literal if the degree is 0
            if (isLast && term.getDegree() == 0) results.deleteCharAt(results.length() - 1);
        }
        return results.toString();
    }

}
