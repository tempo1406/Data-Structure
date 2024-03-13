import java.util.Scanner;

public class app {
	public static void swap(Country arr[], int a, int b) {
		Country temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void sort(Country[] arr, int left, int right) {
		if (left >= right)
			return;
		Country key = arr[(left + right) / 2];
		int k = partition(arr, left, right, key);
		sort(arr, left, k - 1);
		sort(arr, k, right);
	}

	public static int partition(Country arr[], int left, int right, Country key) {
		while (left <= right) {
			while (arr[left].compareTo(key) < 0)
				left++;
			while (arr[right].compareTo(key) > 0)
				right--;
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void printArr(Country arr[]) {
		for (Country i : arr)
			System.out.println(i.toString());
	}

	public static void main(String[] args) {
		Country[] countrys = new Country[] { new Country(1, 1, "USA"), new Country(2, 3, "England"),
				new Country(3, 6, "Canada"), new Country(4, 89, "VietNam"), new Country(5, 123, "ThaiLand"),
				new Country(6, 2, "China"), new Country(7, 23, "Portugal"), new Country(8, 234, "Laos") };
		AVL_Tree tree = new AVL_Tree(countrys);
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("=================== Menu ===================");
			System.out.println("1. Use quick sort: ");
			System.out.println("2. Add country: ");
			System.out.println("3. Search by name: ");
			System.out.println("4. Delete by name: ");
			System.out.println("5. Traversal inorder: ");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Country[] arr = tree.toArray();
				sort(arr, 0, arr.length - 1);
				printArr(arr);
				System.out.println();
				break;
			case 2:
				tree.add();
				break;
			case 3:
				tree.searchByName();
				System.out.println();
				break;
			case 4:
				tree.deleteByName();
				System.out.println();
				break;
			case 5:
				tree.inorder();
				System.out.println();
				break;
			}
		} while (choice != 6);
		scanner.close();
		System.out.println("Good bye!!!");
	}
}
