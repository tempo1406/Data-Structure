package Module;

import java.util.Random;

public class ArrayOfInteger {

	private int size;
	private int[] arr;

	// Constructor with default size = 10
	public ArrayOfInteger() {
		this.size = 10;
		this.arr = new int[this.size];
		Random random = new Random();
		for (int i = 0; i < this.size; i++) {
			this.arr[i] = random.nextInt(100) + 1;
		}
	}

	// Constructor accept size is capacity
	public ArrayOfInteger(int capacity) {
		this.size = capacity;
		this.arr = new int[this.size];
		Random random = new Random();
		for (int i = 0; i < this.size; i++) {
			this.arr[i] = random.nextInt(1000) + 1;
		}
	}

	// Print array
	public void output() {
		for (int i = 0; i < this.size; i++)
			System.out.print(this.arr[i] + "  ");
		System.out.println();
	}

	// Add value in last array
	public void add(int value) {
		int newArr[] = new int[this.size + 1];
		for (int i = 0; i < this.size; i++)
			newArr[i] = this.arr[i];
		newArr[this.size] = value;
		this.arr = newArr;
		this.size++;
	}

	// Add value with index
	public void add(int index, int value) {
		if (index >= 0 && index <= this.size) {
			int newArr[] = new int[this.size + 1];
			for (int i = 0; i < index; i++)
				newArr[i] = this.arr[i];
			newArr[index] = value;
			for (int i = index; i < this.size; i++)
				newArr[i + 1] = this.arr[i];
			this.arr = newArr;
			this.size++;
		} else
			System.err.println("Invalid index!!!");
	}

	// Get value at index
	public int getValue(int index) {
		if (index >= 0 && index < this.size) {
			return this.arr[index];
		} else
			return -1;
	}

	// Set value at index
	public void setValue(int index, int value) {
		if (index >= 0 && index < this.size) {
			this.arr[index] = value;
		} else
			System.err.println("Invalid index!!!");
	}

	// Check value is exist in array
	public boolean contains(int value) {
		for (int i = 0; i < this.size; i++) {
			if (this.arr[i] == value)
				return true;
		}
		return false;
	}

	// Get index of value
	public int indexOf(int value) {
		for (int i = 0; i < this.size; i++)
			if (this.arr[i] == value)
				return i;
		return -1;
	}

	// Get last index of value
	public int lastIndexOf(int value) {
		for (int i = this.size - 1; i >= 0; i--)
			if (this.arr[i] == value)
				return i;
		return -1;
	}

	// Remove value at index
	public void remove(int index) {
		if (index >= 0 && index < this.size) {
			int newArr[] = new int[this.size - 1];
			for (int i = 0; i < index; i++)
				newArr[i] = this.arr[i];
			for (int i = index + 1; i < this.size; i++)
				newArr[i - 1] = this.arr[i];
			this.arr = newArr;
			this.size--;
		} else
			System.err.println("Invalid index!!!");

	}
}
