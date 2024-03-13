package Module;

@SuppressWarnings("unchecked")
public class QueueArray<E> implements IQueue<E> {

	private int size;
	private E[] arr;
	private int first, last;

	public QueueArray() {
		this.size = 10;
		this.arr = (E[]) new Object[10];
		this.first = this.last = -1;
	}

	public QueueArray(int cap) {
		this.size = cap;
		this.arr = (E[]) new Object[cap];
		this.first = this.last = -1;
	}

	@Override
	public E element() {
		if (!isEmpty()) {
			return arr[first];
		}
		return null;
	}

	@Override
	public E peek() {
		if (!isEmpty()) {
			return arr[first];
		}
		return null;
	}

	@Override
	public E remove() {
		if (!isEmpty()) {
			E value = arr[first];
			for (int i = first; i < last; i++)
				arr[i] = arr[i + 1];
			last--;
			if (first > last)
				first = last = -1;
			return value;
		}
		return null;
	}

	@Override
	public E poll() {
		if (!isEmpty()) {
			E value = arr[first];
			for (int i = first; i < last; i++)
				arr[i] = arr[i + 1];
			last--;
			if (first > last)
				first = last = -1;
			return value;
		}
		return null;
	}

	@Override
	public boolean add(E value) {
		if (!isFull()) {
			if (isEmpty())
				first++;
			last++;
			arr[last] = value;
			return true;
		}
		return false;
	}

	@Override
	public boolean offer(E value) {
		if (!isFull()) {
			if (isEmpty())
				first++;
			last++;
			arr[last] = value;
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return this.first == -1 && this.last == -1;
	}

	@Override
	public String toString() {
		String str = "[ ";
		if (!isEmpty())
			for (int i = this.first; i <= this.last; i++)
				str += arr[i] + " ";
		return str + "]";

	}

	public boolean isFull() {
		return this.last - this.first == this.size - 1;
	}

	public void output() {
		System.out.println(toString());
	}

}
