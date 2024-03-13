package Exercise;

import java.util.Scanner;

public class E7_POW2 {

	public static int pow_2(int a) {
		if (a == 0)
			return 1;
		else
			return pow_2(a - 1) + pow_2(a - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numbers a: ");
		int a = scanner.nextInt();
		System.out.println("Result of 2^a: " + pow_2(a));
		scanner.close();
	}
}
