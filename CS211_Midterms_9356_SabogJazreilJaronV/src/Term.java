public class Term implements Comparable<Term> {
    private float coefficient;
    private final char LITERAL;
    private int degree;

    public Term() {
        coefficient = 0.0f;
        LITERAL = 'x';
        degree = 0;
    }

    public Term(float coefficient, int degree) {
        this.coefficient = coefficient;
        LITERAL = 'x';
        this.degree = degree;
    }

    public float getCoefficient() {
        return coefficient;
    }
    public char getLiteral() { return LITERAL; }

    public int getDegree() {
        return degree;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String toString() {
        return coefficient + "" + LITERAL + "^" + degree;
    }

    @Override
    public int compareTo(Term other) {
        // Compare the degrees first
        if (this.getDegree() > other.getDegree()) return -1;
        else if (this.getDegree() < other.getDegree()) return 1;

        // If degrees are equal, compare coefficients
        return Float.compare(this.getCoefficient(), other.getCoefficient());
    }
}
