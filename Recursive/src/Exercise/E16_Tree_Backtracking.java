package Exercise;

import java.util.Arrays;

public class E16_Tree_Backtracking {

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void generateBinaryStrings(int length, String curent) {
		if (length == 0)
			System.out.println(curent);
		else {
			generateBinaryStrings(length - 1, curent + "0");
			generateBinaryStrings(length - 1, curent + "1");
		}
	}

	public static void generateCombinations(int arr[], int k, int start, String current) {
		if (k == 0) {
			System.out.println(current);
		} else
			for (int i = start; i < arr.length; i++)
				generateCombinations(arr, k - 1, i + 1, current + arr[i]);
	}

	public static void generatePermutations(char[] arr, int start) {

		if (start == arr.length - 1)
			System.out.println(Arrays.toString(arr));
		else
			for (int i = start; i < arr.length; i++) {
				swap(arr, start, i);
				generatePermutations(arr, start + 1);
				swap(arr, start, i);
			}
	}

	public static void generateSubsets(char[] arr, int start, String current) {
		System.out.println("{" + current + "}");

		for (int i = start; i < arr.length; i++) {
			generateSubsets(arr, i + 1, current + arr[i]);
		}
	}

	public static void main(String[] args) {

		/// Binary string
		System.out.println("Binary string: ");
		int length = 3;
		generateBinaryStrings(length, "");
		System.out.println();

		/// Combinations string
		System.out.println("Combinations string: ");
		int[] arr = { 1, 2, 3 };
		int k = 2;
		generateCombinations(arr, k, 0, "");
		System.out.println();

		/// Permutations string
		System.out.println("Permutations string: ");
		char[] chars1 = { 'A', 'B', 'C', 'D' };
		generatePermutations(chars1, 0);
		System.out.println();

		/// Subsets string
		System.out.println("Subsets string: ");
		char[] chars2 = { 'A', 'B', 'C' };
		generateSubsets(chars2, 0, "");
	}
}
