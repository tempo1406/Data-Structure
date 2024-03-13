public class heapSort {
	public static void sort(int arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}

	static void heapify(int arr[], int n, int i) {
		int largest = i;
		int l = 2 * i; // left = 2*i
		int r = 2 * i + 1; // right = 2*i + 1

		// Change to ascending
		if (l < n && arr[l] < arr[largest])
			largest = l;

		// Change to ascending
		if (r < n && arr[r] < arr[largest])
			largest = r;

		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, n, largest);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 4, 10, 3, 5, 1 };
		int n = arr.length;

		System.out.println("Mảng ban đầu:");
		printArray(arr);

		sort(arr);

		System.out.println("Mảng sau khi sắp xếp:");
		printArray(arr);
	}
}