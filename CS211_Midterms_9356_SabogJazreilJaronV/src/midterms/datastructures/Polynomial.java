/*
    Name: Sabog, Jazreil Jaron V.
    Date: October 7, 2024,
    Due Date: Oct 9, 2024 - 11:55 AM
    Class Code: CS 9356
 */

package midterms.datastructures;

import java.util.LinkedList;

/**
 * Represents a polynomial as a linked list of terms
 * @param terms The linked list of terms representing the polynomial
 */
public record Polynomial(LinkedList<Term> terms) {
    /**
     * Returns the number of terms in the polynomial
     * @return The size of the polynomial
     */
    public int size() {
        return terms.size();
    }

    /**
     * Adds a term to the polynomial
     * @param term The term to added
     */
    public void addTerm(Term term) {
        terms.add(term);
    }

    /**
     * Removes a term from the polynomial at the specified index
     * @param index The index of the term to be removed
     */
    public void removeTerm(int index) {
        terms.remove(index);
    }
}
