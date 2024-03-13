package Module;

public class Node<E> {

	public Comparable<E> value;
	public Node<E> left, right;

	public Node(Comparable<E> value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public Node(Comparable<E> value, Node<E> left, Node<E> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

}
