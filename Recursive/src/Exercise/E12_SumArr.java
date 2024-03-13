package Exercise;

public class E12_SumArr {
	public static int sumArr(int arr[], int n) {
		if (n == 1)
			return arr[0];
		else
			return arr[n - 1] + sumArr(arr, n - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 0, -98, 3, 4, -9 };
		System.out.println("Minimun in array is: " + sumArr(arr, arr.length));
	}
}
