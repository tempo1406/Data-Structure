package mergeSort;

public class parameterArray {
	public static int[] sortArray(int[] nums) {

		if (nums.length == 1) {
			int[] br = new int[1];
			br[0] = nums[0];
			return br;
		}

		int middle = (nums.length + 1) / 2;
		int[] left = new int[middle];
		for (int i = 0; i < middle; i++) {
			left[i] = nums[i];
		}
		int[] right = new int[nums.length - middle];
		for (int i = 0; i < nums.length - middle; i++) {
			right[i] = nums[i + middle];
		}

//		int[] arrL = sortArray(left);
//		int[] arrR = sortArray(right);

		int[] sorted = merge(sortArray(left), sortArray(right));
		return sorted;
	}

	public static int[] merge(int[] left, int[] right) {

		int i = 0, j = 0, k = 0;
		int[] merge = new int[left.length + right.length];

		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				merge[k] = left[i];
				k++;
				i++;
			} else {
				merge[k] = right[j];
				k++;
				j++;
			}
		}

		if (i == left.length) {
			while (j < right.length) {
				merge[k] = right[j];
				j++;
				k++;
			}
		}

		if (j == right.length) {
			while (i < left.length) {
				merge[k] = left[i];
				i++;
				k++;
			}
		}
		return merge;
	}

	public static void main(String[] args) {
		int[] arr = { 5,2,3,1};
		int[] merged = sortArray(arr);
		for (int val : merged) {
			System.out.print(val + " ");
		}
	}
}
