public class Term implements Comparable<Term> {
    private float coefficient;
    private int degree;

    public Term() {
        coefficient = 0.0f;
        degree = 0;
    }

    public Term(float coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public float getCoefficient() {
        return coefficient;
    }

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
        return "Coefficient: " + coefficient + "\nDegree: " + degree;
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
