package Exercise;

import java.util.Scanner;

public class E10_Sum {

	public static int sum(int a) {
		if (a == 1)
			return 1;
		else
			return a + sum(a - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		int a = scanner.nextInt();
		System.out.println("Sum 1->a: " + sum(a));
		scanner.close();
	}
}
