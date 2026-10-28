/* LinkedStack.java  --  S3.18 Part A  --  YOUR FILE.
 *
 * A Stack built from YOUR OWN nodes -- no java.util classes.
 *
 *   top --> [30|*]--> [20|*]--> [10|/]
 *
 * The top is the HEAD of a singly linked list.  Why the head and not the tail?
 * Explain here:
 *
 *
 *
 */
import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;     // null when empty
    private int size;

    public void push(E item) {
        throw new UnsupportedOperationException("LinkedStack.push: not written yet");
    }

    public E pop() {
        throw new UnsupportedOperationException("LinkedStack.pop: not written yet");
    }

    public E peek() {
        throw new UnsupportedOperationException("LinkedStack.peek: not written yet");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("LinkedStack.isEmpty: not written yet");
    }

    public int size() {
        throw new UnsupportedOperationException("LinkedStack.size: not written yet");
    }

    /** GIVEN.  Bottom to top, to match ArrayListStack:  [1, 2, 3] */
    @Override
    public String toString() {
        String s = "";
        for (Node<E> n = top; n != null; n = n.next) {
            s = (n.next == null ? "" : ", ") + n.value + s;
        }
        return "[" + s + "]";
    }
}
