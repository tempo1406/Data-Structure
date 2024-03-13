import java.util.Scanner;

public class selectSort {
	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int[] sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (arr[i] > arr[j])
					swap(arr, i, j);
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
