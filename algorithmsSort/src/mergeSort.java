import java.util.Scanner;

public class mergeSort {
	public static int[] merge(int arr[], int brr[]) {
		int i = 0, j = 0, k = 0;
		int merge[] = new int[arr.length + brr.length];
		while (i < arr.length && j < brr.length) {
			if (arr[i] < brr[j]) {
				merge[k] = arr[i];
				i++;
				k++;
			} else {
				merge[k] = brr[j];
				j++;
				k++;
			}
		}
		if (i == arr.length) {
			while (j < brr.length) {
				merge[k] = brr[j];
				j++;
				k++;
			}
		}
		if (j == brr.length) {
			while (i < arr.length) {
				merge[k] = arr[i];
				i++;
				k++;
			}
		}
		return merge;
	}

	public static int[] sort(int arr[], int left, int right) {
		if (left == right) {
			int b[] = new int[1];
			b[0] = arr[left];
			return b;
		}
		int middle = (left + right) / 2;
		int arrL[] = sort(arr, left, middle);
		int arrR[] = sort(arr, middle + 1, right);
		int merge[] = merge(arrL, arrR);
		return merge;
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
		printArr(sort(arr, 0, arr.length - 1));
		arr = sort(arr, 0, arr.length - 1);
		printArr(arr);
		scanner.close();
	}
}
