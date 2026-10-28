/* ArrayListStack.java
 *
 * A Stack implemented using a java.util.ArrayList.
 *
 * DECIDE FIRST: which end of the ArrayList is the TOP?
 *   index 0?            push = add(0, x)  and pop = remove(0)
 *   index size() - 1?   push = add(x)     and pop = remove(size() - 1)
 * One choice makes push and pop O(1); the other makes both O(n).
 *
 * State your decsion and Describe why you made that decision here:
 *
 *
 *
 */
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements Stack<E> {

    private ArrayList<E> items = new ArrayList<E>();

    public void push(E item) {
        throw new UnsupportedOperationException("ArrayListStack.push: not written yet");
    }

    public E pop() {
        throw new UnsupportedOperationException("ArrayListStack.pop: not written yet");
    }

    public E peek() {
        throw new UnsupportedOperationException("ArrayListStack.peek: not written yet");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("ArrayListStack.isEmpty: not written yet");
    }

    public int size() {
        throw new UnsupportedOperationException("ArrayListStack.size: not written yet");
    }

    /** GIVEN.  Bottom to top:  [1, 2, 3]  means 3 is on top. */
    @Override
    public String toString() {
        return items.toString();
    }
}
