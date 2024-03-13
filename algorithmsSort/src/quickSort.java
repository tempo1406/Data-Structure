import java.util.Scanner;

public class quickSort {
	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void sort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int key = arr[(left + right) / 2];
		int k = partition(arr, left, right, key);
		sort(arr, left, k - 1);
		sort(arr, k, right);
	}

	public static int partition(int arr[], int left, int right, int key) {
		while (left <= right) {
			while (arr[left] < key)
				left++;
			while (arr[right] > key)
				right--;
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void printArr(int arr[]) {
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scanner.nextInt();
		sort(arr, 0, arr.length - 1);
		printArr(arr);
		scanner.close();
	}
}
