package mergeSort;

public class parameterArrAndIndex {
	public static void main(String[] args) {

		int[] arr = { 5,2,3,1};
		int[] merged = mergeSort(arr, 0, arr.length - 1);
		for (int val : merged) {
			System.out.print(val + " ");
		}
	}

	// Separation array
	public static int[] mergeSort(int arr[], int left, int right) {

		// Return array
		if (left == right) {
			int[] br = new int[1];
			br[0] = arr[left];
			return br;
		}

		// Find middle value
		int middle = (left + right) / 2;

		// Call recursive sort left array and right array
		int[] arrL = mergeSort(arr, left, middle);
		int[] arrR = mergeSort(arr, middle + 1, right);

		// Merge left array and right array
		int merge[] = merge(arrL, arrR);

		return merge;
	}

	// Merge two array
	public static int[] merge(int one[], int two[]) {

		int sorted[] = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;

		// Drop elements into the array
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				sorted[k] = one[i];
				k++;
				i++;
			} else {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}

		/*
		 * Drop extant element into the array if another array also have element
		 */
		if (i == one.length) {
			while (j < two.length) {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}
		if (j == two.length) {
			while (i < one.length) {
				sorted[k] = one[i];
				k++;
				i++;
			}
		}

		return sorted;
	}
}
