package Module;

public interface IQueue<E> {
	public E element();
	public E peek();
	public E remove();
	public E poll();
	public boolean add(E value);
	public boolean offer(E value);
	public boolean isEmpty();
	public String toString();
}
