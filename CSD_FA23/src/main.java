import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void selectionSort(Employee[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].salary > arr[minIndex].salary)
                    minIndex = j;
            }
            Employee temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
	public static boolean checkArray(Employee[] arr1, Employee[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].id != arr2[i].id || !arr1[i].fullName.equals(arr2[i].fullName) || arr1[i].yearOfBirth != arr2[i].yearOfBirth || arr1[i].salary != arr2[i].salary)
                return false;
        }
        return true;
    }
	
	public static void printArr(Employee arr[]) {
		for (Employee i : arr)
			System.out.println(i.toString());
	}
	
	//
	public static void insertionSort(Employee[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Employee key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].salary < /* > */ key.salary) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
	//
	public static void bubbleSort(Employee[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].salary < /* > */ arr[j + 1].salary) {
                    Employee temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
	//
	public static void quickSort(Employee[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Employee[] arr, int low, int high) {
        int pivot = arr[high].salary;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].salary > /* < */ pivot) {
                i++;

                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Employee temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    //
    public static void mergeSort(Employee[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(Employee[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Employee L[] = new Employee[n1];
        Employee R[] = new Employee[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].salary >= /* <= */ R[j].salary) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	 public static void main(String[] args) {
	        Employee[] A = {
	            new Employee(5, "John", 2004, 5000),
	            new Employee(3, "David", 2003, 3000),
	            new Employee(2, "Kevin", 2005, 4000),
	            new Employee(4, "Paul", 2005, 6000),
	            new Employee(7, "Joe", 2004, 7000),
	            new Employee(6, "July", 2003, 9000),
	            new Employee(8, "Anna", 2004, 8000),
	            new Employee(1, "Bob", 2005, 5000),
	            new Employee(9, "Dona", 2005, 6000)
	        };
	        BST tree = new BST();
	        for (Employee employee : A) {
	            tree.add(employee);
	        }
	        Scanner scanner = new Scanner(System.in);
	        int choice = 0;
	        do {
	            System.out.println("=================== Menu ===================");
	            System.out.println("1. Add employees");
	            System.out.println("2. Employee with minimum salary");
	            System.out.println("3. Traverse the tree in descending order");
	            System.out.println("4. Height of the BST");
	            System.out.println("5. Selection sort descending");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");
	            choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    tree.add();
	                    break;
	                case 2:
	                    tree.minimunSlaryStudent();
	                    break;
	                case 3:
	                    ArrayList<Employee> inOrderDescResult = new ArrayList<>();
	                    tree.inOrderDescending(tree.root, inOrderDescResult);
	                    break;
	                case 4:
	                    int height = tree.height(tree.root);
	                    System.out.println("Height of the BST: " + height);
	                    break;
	                case 5:
	                	 Employee[] AIn = A.clone();
	                	 mergeSort(AIn, 0, AIn.length - 1);
	                     System.out.println("Sorted array:");
	                     for (Employee e : AIn) {
	                         System.out.println(e.toString());
	                     }
	                     System.out.println("Arrays equal? " + checkArray(A, AIn));
	                     break;
	            }
	        } while (choice != 6);
	        scanner.close();
	        System.out.println("Goodbye!");
	    }
}

