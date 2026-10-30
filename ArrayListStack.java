/* ArrayListStack.java
 *
 * A Stack implemented using a java.util.ArrayList.
 *
 * DECIDE FIRST: which end of the ArrayList is the TOP?
 *   index 0?            push = add(0, x)  and pop = remove(0)
 *   index size() - 1?   push = add(x)     and pop = remove(size() - 1)
 * One choice makes push and pop O(1); the other makes both O(n).
 *
 * The top is at index size() - 1, the end of the ArrayList.
 * Adding and removing there does not shift the other elements. Pop is O(1),
 * and push is amortized O(1): an occasional resize copies the backing array.
 * At index 0, both operations would shift elements and take O(n).
 */
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements Stack<E> {

    private ArrayList<E> items = new ArrayList<E>();

    public void push(E item) {
        items.add(item);
    }

    public E pop() {
        if (isEmpty()){
            
            throw new EmptyStackException();

        }

        return items.remove(items.size() - 1);
    }

    public E peek() {
       if(isEmpty()){
            
            throw new EmptyStackException();

        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    /** GIVEN.  Bottom to top:  [1, 2, 3]  means 3 is on top. */
    @Override
    public String toString() {
        return items.toString();
    }
}
