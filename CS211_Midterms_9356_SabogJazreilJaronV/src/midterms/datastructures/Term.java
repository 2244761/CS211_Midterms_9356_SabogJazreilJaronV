/*
    Name: Sabog, Jazreil Jaron V.
    Date: October 7, 2024,
    Due Date: Oct 9, 2024 - 11:55 AM
    Class Code: CS 9356
 */

package midterms.datastructures;

/**
 * Represents a term in a polynomial
 * The term consists of a coefficient, a literal (typically 'x'), and a degree
 */
public class Term implements Comparable<Term> {

    /**
     * The coefficient attribute
     */
    private float coefficient;

    /**
     * The literal attribute
     */
    private final char LITERAL;

    /**
     * The degree attribute
     */
    private int degree;

    /**
     * Default Constructor
     */
    public Term() {
        coefficient = 0.0f;
        LITERAL = 'x';
        degree = 0;
    }

    /**
     * Constructor that initializes the term with a specified coefficient and degree
     * @param coefficient The coefficient of the term
     * @param degree The degree of the term
     */
    public Term(float coefficient, int degree) {
        this.coefficient = coefficient;
        LITERAL = 'x';
        this.degree = degree;
    }

    /**
     * Return the coefficient value of the term
     * @return The coefficient of the term
     */
    public float getCoefficient() {
        return coefficient;
    }

    /**
     * Return the literal coefficient of the term
     * @return The literal of the term
     */
    public char getLiteral() { return LITERAL; }

    /**
     * Return the degree value of the term
     * @return The degree of the term
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Modify the coefficient of the term
     * @param coefficient The new coefficient value
     */
    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * Modify the degree of the term
     * @param degree The new degree value
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }


    /**
     * Provide a string representation of the term
     * @return A string representation of the term
     */
    public String toString() {
        return coefficient + "" + LITERAL + "^" + degree;
    }

    /**
     * Terms are sorted in descending order of degree.
     * If degrees are equal, coefficients are compared
     *
     * @param other The other term to compare with
     * @return A negative integer if this term's degree is greater than the other term's degree,
     *         a positive integer if this term's degree is less than the other term's degree,
     *         or 0 if the degrees are equal and the coefficients are also equal.
     */
    @Override
    public int compareTo(Term other) {
        // Compare the degrees first
        if (this.getDegree() > other.getDegree()) return -1;
        else if (this.getDegree() < other.getDegree()) return 1;

        // If degrees are equal, compare coefficients
        return Float.compare(this.getCoefficient(), other.getCoefficient());
    }
}
