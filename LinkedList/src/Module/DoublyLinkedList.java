package Module;

public class DoublyLinkedList<E> {

	private int size;
	private Node2<E> headNode;

	// Constructor new empty linked list
	public DoublyLinkedList() {
		this.headNode = null;
	}

	// Constructor new linked list
	public DoublyLinkedList(Node2<E> headNode) {
		this.headNode = headNode;
		countSize();
	}

	// Count size of linked list
	public int countSize() {
		int size = 0;
		if (headNode != null) {
			Node2<E> tempNode = headNode;
			while (tempNode != null) {
				size++;
				tempNode = tempNode.next;
			}
			this.size = size;
			return size;
		} else
			return size;
	}

	// To string linkedList
	public String toString() {
		if (headNode != null) {
			String string = "";
			Node2<E> tempNode = headNode;
			while (tempNode != null) {
				string += tempNode.value;
				tempNode = tempNode.next;
				if (tempNode != null)
					string += "->";
			}
			return string;
		} else
			return null;
	}

	// Add first
	public Node2<E> addFirst(E value) {
		Node2<E> newNode = new Node2<E>(value, null, headNode);
		headNode = newNode;
		this.size++;
		return headNode;
	}

	// Add last
	public Node2<E> addLast(E value) {
		Node2<E> newNode;
		if (headNode == null) {
			newNode = new Node2<E>(value, null, headNode);
			this.size++;
			return headNode = newNode;
		} else {
			Node2<E> curNode = headNode;
			while (curNode.next != null)
				curNode = curNode.next;
			newNode = new Node2<E>(value, curNode, null);
			curNode.next = newNode;
			this.size++;
			return headNode;
		}
	}

	// Add node
	public Node2<E> add(E value) {
		Node2<E> newNode;
		if (headNode == null) {
			newNode = new Node2<E>(value, null, headNode);
			this.size++;
			return headNode = newNode;
		} else {
			Node2<E> curNode = headNode;
			while (curNode.next != null)
				curNode = curNode.next;
			newNode = new Node2<E>(value, curNode, null);
			curNode.next = newNode;
			this.size++;
			return headNode;
		}
	}

	// Add at index
	public Node2<E> addIndex(int index, E value) {
		if (index >= 0 && index <= this.size) {
			Node2<E> newNode;
			if (headNode == null || index == 0) {
				return addFirst(value);
			} else if (index == this.size) {
				return addLast(value);
			}
			int count = 1;
			Node2<E> curNode = headNode;
			while (count != index) {
				curNode = curNode.next;
				count++;
			}
			newNode = new Node2<E>(value, curNode, curNode.next);
			curNode.next = newNode;
			this.size++;
			return headNode;
		} else {
			System.err.println("Invalid index!!!");
			return null;
		}
	}

	// Remove first
	public Node2<E> removeFirst() {
		if (headNode != null) {
			Node2<E> removeNode = headNode;
			headNode = headNode.next;
			this.size--;
			return removeNode;
		}
		return null;
	}

	// Remove last
	public Node2<E> removeLast() {
		if (headNode != null) {
			Node2<E> curNode = headNode;
			Node2<E> removeNode = curNode;
			if (headNode.next == null) {
				headNode = null;
				this.size--;
				return removeNode;
			}
			while (curNode.next.next != null) {
				curNode = curNode.next;
				removeNode = curNode.next;
			}
			curNode.next = null;
			this.size--;
			return removeNode;
		}
		return null;
	}

	// Remove with index
	public Node2<E> removeIndex(int index) {
		if (headNode != null && index >= 0 && index < this.size) {
			if (index == 0) {
				return removeFirst();
			} else if (index == this.size - 1) {
				return removeLast();
			}
			Node2<E> curNode = headNode;
			Node2<E> removeNode = curNode;
			int count = 1;
			while (count != index) {
				curNode = curNode.next;
				count++;
			}
			removeNode = curNode.next;
			curNode.next = curNode.next.next;
			this.size--;
			return removeNode;
		}
		return null;
	}

	// Remove same value
	public void removeValue(E value) {
		if (headNode != null) {
			if (headNode.value.equals(value)) {
				removeFirst();
				return;
			}
			Node2<E> curNode = headNode;
			while (curNode.next != null && !curNode.next.value.equals(value))
				curNode = curNode.next;
			if (curNode.next != null) {
				curNode.next = curNode.next.next;
				this.size--;
			} else
				return;
		}
	}

	// Set value at index
	public void set(int index, E value) {
		if (headNode != null && index >= 0 && index < this.size) {
			Node2<E> curNode = headNode;
			int count = 0;
			while (curNode != null) {
				if (count == index) {
					curNode.value = value;
					return;
				}
				curNode = curNode.next;
				count++;
			}
		} else
			System.err.println("Invalid index!!!");
	}

	// Check value is contain value
	public boolean contain(E value) {
		if (headNode != null) {
			Node2<E> curNode = headNode;
			while (curNode != null) {
				if (curNode.value.equals(value))
					return true;
				curNode = curNode.next;
			}
		}
		return false;
	}

	// Get first value of list
	public E getFirst() {
		if (headNode != null)
			return headNode.value;
		else
			return null;
	}

	// Get last value of list
	public E getLast() {
		if (headNode != null) {
			Node2<E> curNode = headNode;
			while (curNode.next != null)
				curNode = curNode.next;
			return curNode.value;
		} else
			return null;
	}

	// Get value at index of list
	public E getIndex(int index) {
		if (headNode != null && index >= 0 && index < this.size) {
			Node2<E> curNode = headNode;
			int count = 0;
			while (count != index) {
				curNode = curNode.next;
				count++;
			}
			return curNode.value;
		} else
			return null;
	}
	
	// To array linkedList
	public Object[] toArray() {
		Object arr[] = new Object[this.size];
		Node2<E> curNode = headNode;
		int i = 0;
		while (curNode != null) {
			arr[i] = curNode.value;
			curNode = curNode.next;
			i++;
		}
		return arr;
	}
}
