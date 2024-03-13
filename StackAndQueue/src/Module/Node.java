package Module;

public class Node<E> {

	public E value;
	public Node<E> next;

	public Node(E value) {
		this.value = value;
		this.next = null;
	}

	public Node(E value, Node<E> next) {
		this.value = value;
		this.next = next;
	}
}
