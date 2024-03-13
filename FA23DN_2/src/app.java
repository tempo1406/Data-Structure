import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class app {
	private static Pupil getMax(Pupil[] arr) {
		Pupil max = arr[0];
		for (Pupil num : arr) {
			if (Math.abs(num.mark) > Math.abs(max.mark)) {
				max = num;
			}
		}
		return max;
	}

	public static void RadixSort(Pupil[] arr) {
		Pupil max = getMax(arr);
		for (int k = 1; max.mark / k > 0; k *= 10) {
			Queue<Pupil>[] list = new LinkedList[10];

			for (int i = 0; i < 10; i++) {
				list[i] = new LinkedList<>();
			}

			for (Pupil num : arr) {
				int digit = (num.mark / k) % 10;
				list[digit].offer(num);
			}

			int index = 0;
			for (int i = 0; i < 10; i++) {
				while (!list[i].isEmpty()) {
					arr[index++] = list[i].poll();
				}
			}
		}
	}

	private static void printArray(Pupil[] arr) {
		for (Pupil num : arr) {
			System.out.println(num.toString());
		}
		System.out.println();
	}

	////
	public static void heapSort(Pupil arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		for (int i = n - 1; i > 0; i--) {
			Pupil temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}
	///
	public static void shellSort(Pupil arr[]) {
		int interval, i, j;
		Pupil temp;
		int n = arr.length;
		for (interval = n / 2; interval > 0; interval /= 2) {
			for (i = interval; i < n; i++) {
				temp = arr[i];
				for (j = i; j >= interval && arr[j - interval].mark > temp.mark; j -= interval) {
					arr[j] = arr[j - interval];
				}
				arr[j] = temp;
			}
		}
	}

	static void heapify(Pupil arr[], int n, int i) {
		int largest = i;
		int l = 2 * i; // left = 2*i
		int r = 2 * i + 1; // right = 2*i + 1

		// Change to ascending
		if (l < n && arr[l].mark > arr[largest].mark)
			largest = l;

		// Change to ascending
		if (r < n && arr[r].mark > arr[largest].mark)
			largest = r;

		if (largest != i) {
			Pupil swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, n, largest);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Pupil[] pupils = new Pupil[] { new Pupil(5, 5), new Pupil(3, 3), new Pupil(2, 2), new Pupil(4, 44),
				new Pupil(7, 47), new Pupil(6, 100), new Pupil(8, 88), new Pupil(1, 111), new Pupil(9, 99) };
		Scanner scanner = new Scanner(System.in);
		BST tree = new BST();
		int choice = 0;
		do {
			System.out.println("====================================== Menu ======================================");
			System.out.println("1. To obtain the tree T from A.");
			System.out.println("2. Decrease m/2.0 to the mark of each pupil where m is the minimum mark.");
			System.out.println("3. Determine the field level for all node. ");
			System.out.println("4. Check if T is an AVL tree.");
			System.out.println("5. Traversal preorder. ");
			System.out.println("6. Sort pupils (RadixSort). ");
			System.out.println("7. Exit.");
			System.out.print("Enter choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				tree = new BST(pupils);
				System.out.println();
				break;
			case 2:
				tree.decrease();
				break;
			case 3:
				tree.level();
				System.out.println();
				break;
			case 4:
				tree.isBalenceTree();
				System.out.println();
				break;
			case 5:
				tree.preOrder();
				System.out.println();
				break;
			case 6:
				shellSort(pupils);
				printArray(pupils);
				System.out.println();
				break;
			}
		} while (choice != 7);
		scanner.close();
		System.out.println("Good bye!!!");
	}
}
