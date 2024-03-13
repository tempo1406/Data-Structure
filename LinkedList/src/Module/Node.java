package Module;

public class Node<E> implements Comparable<E> {

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

	public Node() {
		this.value = null;
		this.next = null;
	}

	@Override
	public int compareTo(E o) {
		int a = (int) this.value;
		int b = (int) o;
		if (a > b)
			return -1;
		else if (a < b)
			return 1;
		return 0;
	}

}
