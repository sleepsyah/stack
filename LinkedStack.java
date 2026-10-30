/* LinkedStack.java  --  S3.18 Part A  --  YOUR FILE.
 *
 * A Stack built from YOUR OWN nodes -- no java.util classes.
 *
 *   top --> [30|*]--> [20|*]--> [10|/]
 *
 * The top is the HEAD of a singly linked list.  Why the head and not the tail?
 * At the head, push links a new node to the old top, and pop moves top to
 * the next node. Both take O(1), with no traversal. Removing the tail of a
 * singly linked list requires finding its predecessor, which takes O(n),
 * even if we keep a reference to the tail.
 */
import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;  
    private int size;

    public void push(E item) {
        top = new Node<E>(item, top);
        size++;
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E item = top.value;
        top = top.next;
        size--;
        return item;
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
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
