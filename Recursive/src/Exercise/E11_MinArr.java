package Exercise;

public class E11_MinArr {

	public static int minArr(int[] arr, int n) {
		if (n == 1)
			return arr[0];
		int min = arr[n - 1], x = minArr(arr, n - 1);
		if (min > x)
			return x;
		else
			return min;
	}

	public static void main(String[] args) {
		int[] arr = { 0, -98, 3, 4, -9 };
		System.out.println("Minimun in array is: " + minArr(arr, arr.length));
	}
}
