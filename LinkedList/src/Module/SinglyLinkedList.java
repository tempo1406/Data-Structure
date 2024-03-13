package Module;

public class SinglyLinkedList<E> {

	private int size;
	private Node<E> headNode;

	// Constructor new empty linked list
	public SinglyLinkedList() {
		this.headNode = null;
	}

	// Constructor new linked list
	public SinglyLinkedList(Node<E> headNode) {
		this.headNode = headNode;
		countSize();
	}

	// Count size of linked list
	public int countSize() {
		int size = 0;
		if (headNode != null) {
			Node<E> tempNode = headNode;
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
			Node<E> tempNode = headNode;
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
	public Node<E> addFirst(E value) {
		Node<E> newNode = new Node<E>(value,headNode);
		headNode = newNode;
		this.size++;
		return headNode;
	}

	// Add last
	public Node<E> addLast(E value) {
		Node<E> newNode = new Node<E>(value);
		if (headNode == null) {
			this.size++;
			return headNode = newNode;
		} else {
			Node<E> nextNode = headNode;
			while (nextNode.next != null)
				nextNode = nextNode.next;
			nextNode.next = newNode;
			this.size++;
			return headNode;
		}
	}
	
	// Add node
	public Node<E> add(E value) {
		Node<E> newNode = new Node<E>(value);
		if (headNode == null) {
			this.size++;
			return headNode = newNode;
		} else {
			Node<E> nextNode = headNode;
			while (nextNode.next != null)
				nextNode = nextNode.next;
			nextNode.next = newNode;
			this.size++;
			return headNode;
		}
	}

	// Add at index
	public Node<E> addIndex(int index, E value) {
		if (index >= 0 && index <= this.size) {
			Node<E> newNode = new Node<E>(value);
			if (headNode == null || index == 0) {
				return addFirst(value);
			} else if (index == this.size) {
				return addLast(value);
			}
			int count = 1;
			Node<E> curNode = headNode;
			Node<E> nextNode = curNode.next;
			while (count != index) {
				curNode = nextNode;
				nextNode = nextNode.next;
				count++;
			}
			curNode.next = newNode;
			newNode.next = nextNode;
			this.size++;
			return headNode;
		} else {
			System.err.println("Invalid index!!!");
			return null;
		}
	}

	// Remove first
	public Node<E> removeFirst() {
		if (headNode != null) {
			Node<E> removeNode = headNode;
			headNode = headNode.next;
			this.size--;
			return removeNode;
		}
		return null;
	}

	// Remove last
	public Node<E> removeLast() {
		if (headNode != null) {
			Node<E> curNode = headNode;
			Node<E> removeNode = curNode;
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
	public Node<E> removeIndex(int index) {
		if (headNode != null && index >= 0 && index < this.size) {
			if (index == 0) {
				return removeFirst();
			} else if (index == this.size - 1) {
				return removeLast();
			}
			Node<E> curNode = headNode;
			Node<E> removeNode = curNode;
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
			Node<E> curNode = headNode;
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
			Node<E> curNode = headNode;
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
			Node<E> curNode = headNode;
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
			Node<E> curNode = headNode;
			while (curNode.next != null)
				curNode = curNode.next;
			return curNode.value;
		} else
			return null;
	}

	// Get last value at index of list
	public E getIndex(int index) {
		if (headNode != null && index >= 0 && index < this.size) {
			Node<E> curNode = headNode;
			int count = 0;
			while (curNode != null) {
				if (count == index)
					return curNode.value;
				curNode = curNode.next;
				count++;
			}
		}
		return null;
	}

	// To array linkedList
	public Object[] toArray() {
		Object arr[] = new Object[this.size];
		Node<E> curNode = headNode;
		int i = 0;
		while (curNode != null) {
			arr[i] = curNode.value;
			curNode = curNode.next;
			i++;
		}
		return arr;
	}
}
