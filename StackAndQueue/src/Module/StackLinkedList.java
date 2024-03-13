package Module;

public class StackLinkedList<E> implements IStack<E> {

	private int size;
	private Node<E> top;

	public StackLinkedList() {
		this.size = 0;
		this.top = null;
	}

	public StackLinkedList(Node<E> node) {
		this.size = countSize();
		this.top = node;
	}

	public int countSize() {
		int count = 0;
		if (top != null) {
			Node<E> curNode = top;
			while (curNode != null) {
				count++;
				curNode = curNode.next;
			}
		}
		return count;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public E push(E value) {
		Node<E> newNode = new Node<E>(value);
		if (top != null)
			newNode.next = top;
		top = newNode;
		return top.value;
	}

	@Override
	public E pop() {
		if (!empty()) {
			E value = top.value;
			top = top.next;
			return value;
		}
		return null;
	}

	@Override
	public E peek() {
		if (!empty()) {
			return top.value;
		}
		return null;
	}

	@Override
	public boolean empty() {
		return top == null;
	}

	@Override
	public int search(E value) {
		if (!empty()) {
			int count = 0;
			Node<E> curNode = top;
			while (curNode != null) {
				if (curNode.value.equals(value))
					return count+1;
				curNode = curNode.next;
				count++;
			}
		}
		return -1;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public String toString() {
		String str = "[ ";
		if (!empty()) {
			Node<E> curNode = top;
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
