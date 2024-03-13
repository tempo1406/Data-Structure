package Module;

public class Node2<E> {

	public E value;
	public Node2<E> prev;
	public Node2<E> next;

	public Node2(E value) {
		this.value = value;
		this.prev = null;
		this.next = null;
	}

	public Node2(E value, Node2<E> prev, Node2<E> next) {
		this.value = value;
		this.prev = prev;
		this.next = next;
	}

}
