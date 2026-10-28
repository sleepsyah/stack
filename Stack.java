/* Stack.java  --  GIVEN, COMPLETE.  DO NOT MODIFY.
 *
 * The Stack ADT (IB B2.2.3), written as a Java interface.  Last in, first out.
 * It says WHAT a stack does.  ArrayListStack and LinkedStack are two different
 * answers to HOW.
 */
public interface Stack<E> {

    /** Put item on the top. */
    void push(E item);

    /** Remove and return the top item.
     *  Empty stack: throw java.util.EmptyStackException. */
    E pop();

    /** Return the top item WITHOUT removing it.
     *  Empty stack: throw java.util.EmptyStackException. */
    E peek();

    /** True when there is nothing on the stack. */
    boolean isEmpty();

    /** How many items are on the stack. */
    int size();
}
