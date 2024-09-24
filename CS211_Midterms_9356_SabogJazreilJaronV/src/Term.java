public class Term implements Comparable<Term> {
    private float numerical;
    private char literal;
    private int degree;

    public Term() {
        numerical = 0.0f;
        literal = 'x';
        degree = 0;
    }

    public Term(float numerical, int degree) {
        this.numerical = numerical;
        literal = 'x';
        this.degree = degree;
    }

    public float getCoefficient() {
        return numerical;
    }
    public char getLiteral() { return literal; }

    public int getDegree() {
        return degree;
    }

    public void setNumerical(float numerical) {
        this.numerical = numerical;
    }
    public void setLiteral(char literal) {
        this.literal = literal;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String toString() {
        return numerical + "" + literal + "^" + degree;
    }

    @Override
    public int compareTo(Term another) {
        // Compare the degrees first
        if (this.getDegree() > another.getDegree()) return -1;
        else if (this.getDegree() < another.getDegree()) return 1;

        // If degrees are equal, compare coefficients
        return Float.compare(this.getCoefficient(), another.getCoefficient());
    }
}
