public class Term implements Comparable<Term> {
    private float coefficient;
    private char literal;
    private int degree;

    public Term() {
        coefficient = 0.0f;
        literal = 'x';
        degree = 0;
    }

    public Term(float coefficient, int degree) {
        this.coefficient = coefficient;
        literal = 'x';
        this.degree = degree;
    }

    public float getCoefficient() {
        return coefficient;
    }
    public char getLiteral() { return literal; }

    public int getDegree() {
        return degree;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }
    public void setLiteral(char literal) {
        this.literal = literal;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String toString() {
        return coefficient + "" + literal + "^" + degree;
    }

    @Override
    public int compareTo(Term other) {
        // Compare the degrees first
        if (this.getDegree() > other.getDegree()) return -1;
        else if (this.getDegree() < other.getDegree()) return 1;

        // If degrees are equal, compare coefficients
        return Float.compare(this.getCoefficient(), other.getCoefficient());
    }

    public boolean equals(Term other) {
        return this.getDegree() == other.getDegree();
    }
}
