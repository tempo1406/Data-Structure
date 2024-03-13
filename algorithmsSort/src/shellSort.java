import java.util.Scanner;

public class shellSort {

	public static int[] sort(int arr[]) {
		int interval, i, j, temp;
		int n = arr.length;
		for (interval = n / 2; interval > 0; interval /= 2) {
			for (i = interval; i < n; i++) {
				temp = arr[i];
				for (j = i; j >= interval && arr[j - interval] > temp; j -= interval) {
					arr[j] = arr[j - interval];
				}
				arr[j] = temp;
			}
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
