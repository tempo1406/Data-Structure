import java.util.NoSuchElementException;

public class CircularArrayQueue {
	private Employee[] queue;
    private int front, rear, size;

    public CircularArrayQueue(int capacity) {
        queue = new Employee[capacity];
        front = rear = -1;
        size = 0;
    }

    public void enqueue(Employee employee) {
        if ((rear + 1) % queue.length == front)
            throw new IllegalStateException("Queue is full");
        rear = (rear + 1) % queue.length;
        queue[rear] = employee;
        if (front == -1)
            front = rear;
        size++;
    }

    public Employee dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        Employee employee = queue[front];
        queue[front] = null;
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % queue.length;
        size--;
        return employee;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
