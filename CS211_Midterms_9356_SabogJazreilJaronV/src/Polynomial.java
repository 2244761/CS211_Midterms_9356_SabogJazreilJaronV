import java.util.LinkedList;

public record Polynomial(LinkedList<Term> terms) {
    public int size() {
        return terms.size();
    }
    public void addTerm(Term term) {
        terms.add(term);
    }

    public void removeTerm(int term) {
        terms.remove(term);
    }

}
