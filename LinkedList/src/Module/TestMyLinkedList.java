package Module;

public class TestMyLinkedList<E> {

	private int size;
	private Node<E> headNode;

	// Constructor new empty linked list
	public TestMyLinkedList() {
		this.headNode = null;
	}

	// Constructor new linked list
	public TestMyLinkedList(Node<E> headNode) {
		this.headNode = headNode;
		countSize();
	}

	// Get headNode
	public Node<E> getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Node<E> headNode) {
		this.headNode = headNode;
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
		Node<E> newNode = new Node<E>(value, headNode);
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

	///////// Test question 2

	// Sum list
	public int sum() {
		int sum = 0;
		Node<E> curNode = headNode;
		while (curNode != null) {
			sum += (int) curNode.value;
			curNode = curNode.next;
		}
		return sum;
	}

	// Count odd value in list
	public int odd() {
		int count = 0;
		Node<E> curNode = headNode;
		while (curNode != null) {
			if ((int) (curNode.value) % 2 == 0)
				count++;
			curNode = curNode.next;
		}
		return count;
	}

	// Difference of largest and smallest in list
	public int diff() {
		if (headNode != null && headNode.next != null) {
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			Node<E> curNode = headNode;
			while (curNode != null) {
				if (max <= (int) curNode.value)
					max = (int) curNode.value;
				if (min >= (int) curNode.value)
					min = (int) curNode.value;
				curNode = curNode.next;
			}
			return Math.abs(max - min);
		} else
			return Integer.MIN_VALUE;
	}

	// Computing largest sum of two consecutive elements in the list
	public int largetSumConsecutive() {
		if (headNode != null) {
			if (headNode.next == null)
				return (int) headNode.value;
			if (headNode.next != null) {
				int sum = 0, max = Integer.MIN_VALUE;
				Node<E> curNode = headNode;
				while (curNode.next != null) {
					sum += ((int) curNode.value + (int) curNode.next.value);
					if (max <= sum)
						max = sum;
					curNode = curNode.next;
					sum = 0;
				}
				return max;
			}
		}
		return Integer.MIN_VALUE;

	}

	// Reverse list
	@SuppressWarnings("unchecked")
	public TestMyLinkedList<E> reverse() {
		Object[] objects = toArray();
		TestMyLinkedList<E> revewLinkedList = new TestMyLinkedList<E>();
		for (int i = objects.length - 1; i >= 0; i--) {
			revewLinkedList.add((E) objects[i]);
		}
		return revewLinkedList;
	}

	// Delete negative value
	public void removeNegative() {
		if (headNode != null) {
			Node<E> newHead = new Node<E>(headNode.value);
			Node<E> curNode = newHead;
			headNode = headNode.next;
			while (headNode != null) {
				if ((int) headNode.value >= 0) {
					if ((int) newHead.value < 0) {
						newHead = new Node<E>(headNode.value);
						curNode = newHead;
					} else {
						Node<E> tempNode = new Node<E>(headNode.value, null);
						curNode.next = tempNode;
						curNode = curNode.next;
					}
				}
				headNode = headNode.next;
			}
			if ((int) newHead.value < 0)
				newHead = null;
			else
				headNode = newHead;
		} else
			System.err.println("List is empty!!!");
	}

	// Delete all similar in list
	public void removeSimilar() {
		if (headNode != null) {
			TestMyLinkedList<E> list = new TestMyLinkedList<E>(headNode);
			TestMyLinkedList<E> newList = new TestMyLinkedList<E>();
			int index = 0, size = list.countSize();
			while (index != size) {
				if (!newList.contain(list.getIndex(index)))
					newList.add(getIndex(index));
				index++;
			}
			headNode = newList.getHeadNode();
		} else
			System.err.println("List is empty!!!");

	}

	// Delete all similar specified in list
	public void removeSimilarSpecified(E value) {
		if (headNode != null) {
			TestMyLinkedList<E> list = new TestMyLinkedList<E>(headNode);
			TestMyLinkedList<E> newList = new TestMyLinkedList<E>();
			int index = 0, size = list.countSize();
			while (index != size) {
				if (!newList.contain(value))
					newList.add(getIndex(index));
				index++;
			}
			headNode = newList.getHeadNode();
		} else
			System.err.println("List is empty!!!");

	}

	// Check list is sorted
	public boolean isSorted() {
		if (headNode != null) {
			Node<E> curNode = headNode;
			if (curNode.next != null) {
				if ((int) curNode.value >= (int) curNode.next.value) {
					while (curNode.next != null) {
						if ((int) curNode.value < (int) curNode.next.value)
							return false;
						curNode = curNode.next;
					}
					return true;
				}
				if ((int) curNode.value <= (int) curNode.next.value) {
					while (curNode.next != null) {
						if ((int) curNode.value > (int) curNode.next.value)
							return false;
						curNode = curNode.next;
					}
					return true;
				}
			} else
				return true;
		}
		return false;
	}

	// Add node to increasing linked list
	public void insertIncreasing(E value) {
		if (headNode != null) {
			Node<E> curNode = headNode;
			Node<E> newNode;
			while (curNode.next != null) {
				if (curNode.compareTo(value) > 0 && curNode.next.compareTo(value) <= 0) {
					newNode = new Node<E>(value, curNode.next);
					curNode.next = newNode;
					this.size++;
					return;
				}
				curNode = curNode.next;
			}
			newNode = new Node<E>(value);
			curNode.next = newNode;
		}
	}

	// Attach two linked list
	public void attach(TestMyLinkedList<E> o) {
		if (headNode != null) {
			Node<E> lastNode = headNode;
			while (lastNode.next != null)
				lastNode = lastNode.next;
			lastNode.next = o.getHeadNode();
		} else
			headNode = o.getHeadNode();
	}

	// Check is same of two linked list
	public boolean isSame(TestMyLinkedList<E> o) {
		if (headNode != null || countSize() != o.countSize()) {
			Node<E> curNode = headNode;
			while (curNode != null) {
				if (!o.contain(curNode.value))
					return false;
				curNode = curNode.next;
			}
			return true;
		} else
			return false;
	}

	// Merge two sorted list
	public TestMyLinkedList<E> mergeArray(TestMyLinkedList<E> one, TestMyLinkedList<E> two) {

		int i = 0, j = 0;
		TestMyLinkedList<E> mergeArray = new TestMyLinkedList<E>();

		// Drop value into the merge array
		while (i < one.countSize() && j < two.countSize()) {
			if ((int) (one.getIndex(i)) <= (int) (two.getIndex(j))) {
				mergeArray.add(one.getIndex(i));
				i++;
			} else {
				mergeArray.add(two.getIndex(j));
				j++;
			}
		}

		//Drop extant element into the array if another array also have element
		if (i == one.countSize()) {
			while (j < two.countSize()) {
				mergeArray.add(two.getIndex(j));
				j++;
			}
		}
		if (j == two.countSize()) {
			while (i < one.countSize()) {
				mergeArray.add(one.getIndex(i));
				i++;
			}
		}

		return mergeArray;
	}
}
