package Exercise;

public class E14_BinarySearch {

	public static int binarySearch(int arr[], int left, int right, int value) {
		if (left > right)
			return -1;
		int middle = (left + right) / 2;
		if (arr[middle] == value)
			return middle;
		else if (arr[middle] > value)
			return binarySearch(arr, left, middle - 1, value);
		else
			return binarySearch(arr, middle + 1, right, value);
	}

	public static void main(String[] args) {
		int[] arr = { -4, -2, 0, 3, 10 };
		System.out.println("Index of value in array is: " + binarySearch(arr, 0, arr.length - 1, -4));
	}
}
