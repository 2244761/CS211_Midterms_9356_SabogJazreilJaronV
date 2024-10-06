/*
    Name: Sabog, Jazreil Jaron V.
    Date: October 7, 2024,
    Due Date: Oct 9, 2024 - 11:55 AM
    Class Code: CS 9356
 */

package midterms.datastructures;

import java.util.*;

/**
 * Provides methods for performing arithmetic operations on polynomials
 */
public class PolynomialArithmetic {
    public static Scanner input = new Scanner(System.in);

    /**
     * Evaluates a polynomial
     */

    public void polynomialEvaluation() {
        Polynomial polynomial = construct(1);
        float total = evaluate(polynomial);

        System.out.println("The midterms.datastructures.Polynomial [" + formatPolynomial(polynomial.terms()) + "] evaluates to " + total + "\n");

        System.out.print("Press ENTER to continue...");
        input.nextLine();
        System.out.println();
    }

    /**
     * Adds two polynomials
     */
    public void polynomialAddition() {
        System.out.println("FIRST POLYNOMIAL");
        Polynomial firstPolynomial = construct(1);
        System.out.println("SECOND POLYNOMIAL");
        Polynomial secondPolynomial = construct(1);

        Polynomial resultant = add(firstPolynomial, secondPolynomial);

        printResults(firstPolynomial, secondPolynomial, resultant);
    }

    /**
     * Subtract two polynomials
     */
    public void polynomialSubtraction() {
        System.out.println("FIRST POLYNOMIAL");
        Polynomial firstPolynomial = construct(1);
        System.out.println("SECOND POLYNOMIAL");
        Polynomial secondPolynomial = construct(1);

        Polynomial resultant = subtract(firstPolynomial, secondPolynomial);

        printResults(firstPolynomial, secondPolynomial, resultant);
    }

    /**
     * Multiply two polynomials
     */
    public void polynomialMultiplication() {
        System.out.println("FIRST POLYNOMIAL");
        Polynomial firstPolynomial = construct(1);
        System.out.println("SECOND POLYNOMIAL");
        Polynomial secondPolynomial = construct(1);

        Polynomial resultant = multiply(firstPolynomial, secondPolynomial);

        printResults(firstPolynomial, secondPolynomial, resultant);
    }

    /**
     * Divide two polynomials
     */
    public void polynomialDivision() {
        System.out.println("FIRST POLYNOMIAL");
        Polynomial firstPolynomial = construct(2);
        System.out.println("SECOND POLYNOMIAL");
        Polynomial secondPolynomial = construct(2);

        String resultant = divide(firstPolynomial, secondPolynomial);

        System.out.printf("%-22s %-5s %s \n%-22s %-5s %s \n%-22s %-5s %s\n\n", "FIRST POLYNOMIAL", ":", formatPolynomial(firstPolynomial.terms()), "SECOND POLYNOMIAL",
                ":", formatPolynomial(secondPolynomial.terms()), "RESULTANT POLYNOMIAL", ":", resultant);

        System.out.print("Press ENTER to continue...");
        input.nextLine();
        System.out.println();
    }

    /**
     * Evaluates a polynomial at a specified value
     * @param poly The polynomial to evaluate
     * @return The Evaluated value of the polynomial
     */
    private static float evaluate(Polynomial poly) {
        System.out.print("Enter the value for the variable: ");
        byte value;

        while (true) {
            try {
                value = Byte.parseByte(input.nextLine());
                break;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.print("Invalid Input. Please enter a Number: ");
            }
        }

        float total = 0;
        for (Term term : poly.terms()) {
            if (term.getDegree() <= 1) {
                total += term.getCoefficient() * value;
            } else {
                total += (float) (term.getCoefficient() * Math.pow(value, term.getDegree()));
            }
        }
        return total;
    }

    /**
     * Adds two polynomials together
     * @param firstPoly The first polynomial to add
     * @param secondPoly The second polynomial to add
     * @return The resulting polynomial after adding the two input polynomials
     */
    private static Polynomial add(Polynomial firstPoly, Polynomial secondPoly) {
        LinkedList<Term> resultant = new LinkedList<>();

        for (Term p1 : firstPoly.terms()) {
            boolean matchFound = false;

            for (Term p2 : secondPoly.terms()) {
                if (p1.getDegree() == p2.getDegree()) {
                    float sum = p1.getCoefficient() + p2.getCoefficient();
                    resultant.add(new Term(sum, p1.getDegree()));
                    matchFound = true;
                    break;
                } // end of if statement

            } // end of inner loop
            if (!matchFound) resultant.add(p1);
        } // end of for loop

        for (Term p2 : secondPoly.terms()) {
            boolean matchFound = false;

            for (Term r : resultant) {
                if (p2.getDegree() == r.getDegree()) {
                    matchFound = true;
                    break;
                }
            }

            if (!matchFound) {
                resultant.add(p2);
            }
        }
        return new Polynomial(resultant);
    }

    /**
     * Subtract two polynomials together
     * @param firstPoly The first polynomial to subtract
     * @param secondPoly The second polynomial to subtract
     * @return The resulting polynomial after subtracting the two input polynomials
     */
    private static Polynomial subtract(Polynomial firstPoly, Polynomial secondPoly) {
        LinkedList<Term> resultant = new LinkedList<>();

        for (Term p1 : firstPoly.terms()) {
            boolean matchFound = false;

            for (int i = 0; i < secondPoly.size(); i++) {
                Term p2 = secondPoly.terms().get(i);

                if (p1.getDegree() == p2.getDegree()) {
                    float difference = p1.getCoefficient() - p2.getCoefficient();
                    if (difference > 0 || difference < 0) {
                        resultant.add(new Term(difference, p1.getDegree()));
                    } else {
                        secondPoly.removeTerm(i);
                    }
                    matchFound = true;
                    break;
                } // end of if statement

            } // end of inner loop
            if (!matchFound) resultant.add(p1);
        } // end of for loop

        for (Term p2 : secondPoly.terms()) {
            boolean matchFound = false;

            for (Term r : resultant) {
                if (p2.getDegree() == r.getDegree()) {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                resultant.add(p2);
            }
        }
        return new Polynomial(resultant);
    }

    /**
     * Multiplies two polynomials together
     * @param firstPoly The first polynomial to multiply
     * @param secondPoly The second polynomial to multiply
     * @return The resulting polynomial after multiplying the two input polynomials
     */
    private static Polynomial multiply(Polynomial firstPoly, Polynomial secondPoly) {
        LinkedList<Term> resultant = new LinkedList<>();

        for (Term p1 : firstPoly.terms()) {
            for (Term p2 : secondPoly.terms()) {
                int degree = p1.getDegree() + p2.getDegree();
                float coefficient = p1.getCoefficient() * p2.getCoefficient();
                resultant.add(new Term(coefficient, degree));
            }
        }

        // Sort the terms by degree in descending order
        Collections.sort(resultant);

        // Combine terms with the same degree
        for (int i = 0; i < resultant.size() - 1; i++) {
            if (resultant.get(i).getDegree() == resultant.get(i + 1).getDegree()) {
                resultant.get(i).setCoefficient(resultant.get(i).getCoefficient() + resultant.get(i + 1).getCoefficient());
                resultant.remove(i + 1);
                i--;
            }
        }
        return new Polynomial(resultant);
    }

    /**
     * Divides two polynomials
     * @param firstPoly The dividend polynomial
     * @param secondPoly The divisor polynomial
     * @return A string representing the quotient and remainder of the division.
     */
    private static String divide(Polynomial firstPoly, Polynomial secondPoly) {
        // Quotient
        LinkedList<Term> quotient = new LinkedList<>();

        // Subtrahend
        LinkedList<Term> subtrahendTerms = new LinkedList<>();
        Polynomial subtrahend = new Polynomial(subtrahendTerms);

        // Remainder
        LinkedList<Term> remainderTerms = new LinkedList<>();
        Polynomial remainder;

        // String representative of the final remainder
        LinkedList<String> finalRemainder = new LinkedList<>();

        Term leadingDivisor = secondPoly.terms().getFirst();
        Term leadingDividend = firstPoly.terms().getFirst();

        Polynomial temp = new Polynomial(firstPoly.terms());

        int indexOfQuotient = 0;

        do {
            if (leadingDividend.getDegree() < leadingDivisor.getDegree()) {
                finalRemainder.add("(" + formatPolynomial(remainderTerms) + "/" + formatPolynomial(secondPoly.terms()) + ")");

                String s = finalRemainder.toString();
                return formatPolynomial(quotient) + " + " + s.substring(1, s.length()-1);
            }

            float quotientCoefficient = leadingDividend.getCoefficient() / leadingDivisor.getCoefficient();
            int quotientDegree = leadingDividend.getDegree() - leadingDivisor.getDegree();
            quotient.add(new Term(quotientCoefficient, quotientDegree));

            subtrahendTerms.clear();
            for (int i = 0; i < secondPoly.terms().size(); i++) {
                float coefficient = quotient.get(indexOfQuotient).getCoefficient() * secondPoly.terms().get(i).getCoefficient();
                int degree = quotient.get(indexOfQuotient).getDegree() + secondPoly.terms().get(i).getDegree();
                subtrahendTerms.add((new Term(coefficient, degree)));
            }

            remainderTerms = subtract(temp, subtrahend).terms();
            remainder = new Polynomial(remainderTerms);
            temp = remainder;

            if (!remainder.terms().isEmpty()) {
                leadingDividend = remainder.terms().getFirst();
            } else {
                break;
            }
            indexOfQuotient++;

        } while (remainder.terms().getFirst().getCoefficient() != 0 ||
                remainder.terms().getFirst().getDegree() > secondPoly.terms().getFirst().getDegree());

        return formatPolynomial(quotient);
    }

    /**
     * Constructs a polynomial based on user input
     * @param option An integer indicating how the polynomial will be constructed.
     * @return The constructed polynomial.
     */
    private Polynomial construct(int option) {
        LinkedList<Term> terms = new LinkedList<>();
        Polynomial polynomial = new Polynomial(terms);

        byte totalTerms = setTerms();

        for (int i = totalTerms; i >= 0; i--) {
            System.out.print("Enter the Coefficient of the midterms.datastructures.Term with Degree " + (i) + ": ");
            float num = validateCoefficient();

            switch (option) {
                case 1 -> {
                    if (num != 0) {
                        polynomial.addTerm(new Term(num, i));
                    }
                }
                case 2 -> {
                    if (num != 0) {
                        polynomial.addTerm(new Term(num, i));
                    } else {
                        polynomial.addTerm(new Term(num, i));
                    }
                }
            }
        }
        System.out.println("midterms.datastructures.Polynomial Entered : [" + formatPolynomial(polynomial.terms()) + "]\n");

        return polynomial;
    }

    /**
     * Validates the coefficient entered by the user
     * @return The validated float coefficient
     */
    private float validateCoefficient() {
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

    /**
     * Validates and returns the highest degree of the polynomial
     * @return The validated highest degree of the polynomial
     */
    private byte setTerms() {
        System.out.print("Highest Degree of the midterms.datastructures.Polynomial: ");
        byte totalTerms = 0;
        boolean flag = false;

        while (!flag) {
            try {
                totalTerms = Byte.parseByte(input.nextLine());
                if (totalTerms < 0) System.out.print("Number must not be negative. Enter again: ");
                else if (totalTerms > 10) System.out.print("Highest Degree can only reach to 10. Enter a lower value: ");
                else flag = true;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.print("Invalid Input. Please Enter a Integer: ");
            }
        }
        return totalTerms;
    }

    /**
     * Prints the results of a polynomial after arithmetic calculation
     * @param firstPolynomial The first polynomial
     * @param secondPolynomial The second polynomial
     * @param resultant The resulting polynomial after an arithmetic calculation
     */
    private void printResults(Polynomial firstPolynomial, Polynomial secondPolynomial,
                              Polynomial resultant) {
        System.out.printf("%-22s %-5s %s \n%-22s %-5s %s \n%-22s %-5s %s\n\n", "FIRST POLYNOMIAL", ":", formatPolynomial(firstPolynomial.terms()), "SECOND POLYNOMIAL",
                ":", formatPolynomial(secondPolynomial.terms()), "RESULTANT POLYNOMIAL", ":", formatPolynomial(resultant.terms()));

        System.out.print("Press ENTER to continue...");
        input.nextLine();
        System.out.println();
    }

    /**
     * Formats a polynomial as a string
     * @param polynomial The polynomial to format
     * @return The formatted string representation of the polynomial
     */
    private static String formatPolynomial(LinkedList<Term> polynomial) {
        StringBuilder results = new StringBuilder();

        Collections.sort(polynomial);

        for (Term term : polynomial) {
            boolean isFirst = term.getDegree() == polynomial.getFirst().getDegree();
            boolean isLast = term.getDegree() == polynomial.getLast().getDegree();
            boolean impliedCoefficients = term.getCoefficient() == 1 || term.getCoefficient() == 0 || term.getCoefficient() == -1;
            boolean impliedPowers = term.getDegree() <= 1;

            if (term.getCoefficient() < 0) {
                if (isFirst) results.append("- ");
                else results.append(" - ");

                if (impliedCoefficients && !isLast) {
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
