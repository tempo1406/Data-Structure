package Module;

@SuppressWarnings("unused")
public class QueueLinkedList<E> implements IQueue<E> {

	private int size;
	private Node<E> first, last;

	public QueueLinkedList() {
		this.size = 0;
		this.first = this.last = null;
	}

	public QueueLinkedList(Node<E> first) {
		this.size = countSize();
		this.first = first;
		Node<E> curNode = first;
		while (curNode.next != null) {
			curNode = curNode.next;
		}
		this.last = curNode;
	}

	public int countSize() {
		int count = 0;
		if (first != null) {
			Node<E> curNode = first;
			while (curNode != null) {
				curNode = curNode.next;
				count++;
			}
		}
		return count;
	}

	@Override
	public E element() {
		if (!isEmpty())
			return first.value;
		return null;
	}

	@Override
	public E peek() {
		if (!isEmpty())
			return first.value;
		return null;
	}

	@Override
	public E remove() {
		if (!isEmpty()) {
			E value = first.value;
			first = first.next;
			return value;
		}
		return null;
	}

	@Override
	public E poll() {
		if (!isEmpty()) {
			E value = first.value;
			first = first.next;
			return value;
		}
		return null;
	}

	@Override
	public boolean add(E value) {
		Node<E> newNode = new Node<E>(value);
		if (first != null) {
			last.next = newNode;
			last = newNode;
		} else
			first = last = newNode;
		return true;
	}

	@Override
	public boolean offer(E value) {
		Node<E> newNode = new Node<E>(value);
		if (first != null) {
			last.next = newNode;
			last = newNode;
		} else
			first = last = newNode;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public String toString() {
		String str = "[ ";
		if (!isEmpty()) {
			Node<E> curNode = first;
			while (curNode != null) {
				str += curNode.value + " ";
				curNode = curNode.next;
			}
		}
		return str + "]";
	}

	public void output() {
		System.out.println(toString());
	}

}
