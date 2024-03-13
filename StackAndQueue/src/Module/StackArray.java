package Module;

@SuppressWarnings("unchecked")
public class StackArray<E> implements IStack<E> {

	private int size;
	private int top;
	private E arr[];

	public StackArray() {
		this.arr = (E[]) new Object[10];
		this.size = 10;
		this.top = -1;
	}

	public StackArray(int cap) {
		this.arr = (E[]) new Object[cap];
		this.size = cap;
		this.top = -1;
	}

	@Override
	public E push(E value) {
		if (!isFull()) {
			top++;
			arr[top] = value;
			return arr[top];
		}
		return null;
	}

	@Override
	public E pop() {
		if (!empty()) {
			this.top--;
			return arr[top + 1];
		} else
			return null;
	}

	@Override
	public E peek() {
		if (!empty()) {
			return arr[top];
		} else
			return null;
	}

	@Override
	public boolean empty() {
		return this.top < 0;
	}

	@Override
	public int search(E value) {
		if (!empty()) {
			for (int i = 0; i <=this.top; i++)
				if (arr[i].equals(value))
					return this.top-i+1;
			return -1;
		}
		return -1;
	}

	@Override
	public boolean isFull() {
		return this.top == this.size - 1;
	}

	@Override
	public String toString() {
		String str = "[ ";
		for (int i = this.top; i >= 0; i--)
			str += arr[i]+" ";
		return str+"]";
	}
	
	public void output() {
		System.out.println(toString());
	}

}
