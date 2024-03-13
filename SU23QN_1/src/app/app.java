package app;

import java.util.Scanner;

import control.AVLTree;
import module.Student;

public class app {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.add(new Student(1, "Thang", 2004, 6.3));
		tree.add(new Student(2, "Vy", 2004, 9.2));
		tree.add(new Student(3, "Dung", 2005, 4.2));
		tree.add(new Student(4, "Toan", 2005, 4.1));
		tree.add(new Student(5, "Trong", 2007, 6.7));
		tree.add(new Student(6, "Viet", 2003, 8.7));
		tree.add(new Student(7, "Dung", 2008, 2.3));
		tree.add(new Student(8, "Nguyen", 2004, 7.8));
		tree.add(new Student(9, "Luat", 2005, 3.4));
		tree.add(new Student(10, "Khai", 2004, 6));

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("=================== Menu ===================");
			System.out.println("1. Add student: ");
			System.out.println("2. Level Order Traversal : ");
			System.out.println("3. Traverse the tree in descending order: ");
			System.out.println("4. Count average mark is less than five: ");
			System.out.println("5. Deletes students whose age is 19: ");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				tree.add();
				break;
			case 2:
				tree.levelOrderTraversal();
				break;
			case 3:
				tree.descendingOrder();
				break;
			case 4:
				tree.countMark();
				break;
			case 5:
				tree.deleteByAge();
				tree.levelOrderTraversal();
				break;
			}
		} while (choice != 6);
		scanner.close();
		System.out.println("Good bye!!!");
	}
}
