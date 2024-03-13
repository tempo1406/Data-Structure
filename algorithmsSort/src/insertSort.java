import java.util.Scanner;

public class insertSort {

	public static int[] sort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int curVal = arr[i];
			int index = i;
			while (index > 0 && arr[index - 1] < curVal) {
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = curVal;
		}
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
