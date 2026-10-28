/* Node.java  --  GIVEN, COMPLETE.  DO NOT MODIFY.
 *
 * The node from our List classes made GENERIC: it can hold any one type E.
 *     [ value | next ]--->
 */
public class Node<E> {
    public E value;
    public Node<E> next;

	//makes it even easier to construct a node, and have it reference another node.
	//supports top = new Node(value, top); // to make this Node the new top Node.
    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
	
	//make a Node that references nothing yet.
	public Node(E value) {
        this.value = value;
        this.next = null;
    }
}
