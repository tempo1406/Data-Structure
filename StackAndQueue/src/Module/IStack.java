package Module;

public interface IStack<E> {
	public E push(E value);
	public E pop();
	public E peek();
	public boolean empty();
	public int search(E value);
	public String toString();
	public boolean isFull();
}