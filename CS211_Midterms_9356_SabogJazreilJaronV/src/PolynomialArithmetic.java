import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class PolynomialArithmetic {
    private final Scanner input = new Scanner(System.in);
    public void polynomialEvaluation() {
        System.out.println("POLYNOMIAL EVALUATION");
        LinkedList<Term> Polynomial = construct();

        System.out.print("Value to be assigned to the literals of the polynomial: ");
        byte value = Byte.parseByte(input.nextLine());
        float total = 0;

        for (Term term : Polynomial) {
            if (term.getDegree() <= 1) {
                total += term.getCoefficient() * value;
            } else {
                total += (float) (term.getCoefficient() * Math.pow(value, term.getDegree()));
            }
        }
        System.out.println("The polynomial evaluates to : " + total);
    }

    public void polynomialAddition() {
        System.out.println("POLYNOMIAL ADDITION");
        System.out.println("First Polynomial: ");
        LinkedList<Term> firstPoly = construct();
        System.out.println("Second Polynomial: ");
        LinkedList<Term> secondPoly = construct();

        LinkedList<Term> finalPoly = new LinkedList<>();

        int degrees = Math.max(firstPoly.getFirst().getDegree(), secondPoly.getFirst().getDegree());
        int less = Math.min(firstPoly.getFirst().getDegree(), secondPoly.getFirst().getDegree());


        for(int i = degrees; i >= 0; i--) {
            for (int j = less; j >= 0; j--) {
                if (firstPoly.get(i).getDegree() == secondPoly.get(j).getDegree()) {
                    float sum = firstPoly.get(i).getCoefficient() + secondPoly.get(j).getCoefficient();
                    finalPoly.add(new Term(sum, i));
                }
            }
//            if (firstPoly.get(i).getDegree() == secondPoly.get(i).getDegree()) {
//                float sum = firstPoly.get(i).getCoefficient() + secondPoly.get(i).getCoefficient();
//                finalPoly.add(new Term(sum, i));
//            } else {
//                finalPoly.add(new Term());
//            }

        }
        System.out.print("The Sum of the two polynomials is " + printPolynomial(finalPoly) + "\n");
    }

    public void polynomialSubtraction() {

    }

    public void polynomialMultiplication() {

    }

    public void polynomialDivision() {

    }


    public LinkedList<Term> construct() {
        LinkedList<Term> Polynomial = new LinkedList<>();
        byte degrees = setDegreesOfPolynomial();

        for (int i = degrees; i >= 0; i--) {
            System.out.print("Enter the numerical coefficient of the term with degree " + i + ": ");
            float num = validateNumCoefficient();
            if (num != 0) {
                Polynomial.add(new Term(num, i));
            }
        }
        System.out.print("The Polynomial entered is " + printPolynomial(Polynomial) + "\n");

        return Polynomial;
    }

    public float validateNumCoefficient() {
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

    public byte setDegreesOfPolynomial() {
        System.out.print("How many degree are there in the polynomial: ");
        byte degrees = 0;
        boolean flag = false;

        while (!flag) {
            try {
                degrees = Byte.parseByte(input.nextLine());
                flag = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid Input. Please enter a number: ");
            }
        }
        return degrees;
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

//            if (isFirst) results.append((term.getCoefficient()) >= 0 ? " - " : "");

            if (term.getCoefficient() < 0) {
                results.append(" - ");
                if (impliedCoefficients) {
                    results.append(term.getLiteral());
                } else {
                    results.append(Math.abs(term.getCoefficient())).append(term.getLiteral());
                }
            } else if (impliedCoefficients) {
                results.append(term.getLiteral());
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
