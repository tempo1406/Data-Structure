import java.util.Scanner;

public class bubbleSort {
	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int[] sort(int arr[]) {
		for (int i = arr.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
		return arr;
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
		printArr(sort(arr));
		scanner.close();
	}
}
