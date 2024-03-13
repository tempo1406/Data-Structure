package Exercise;

import java.util.Scanner;

public class E2_POW {

	public static int pow(int a, int b) {
		if (b == 0)
			return 1;
		else
			return a * pow(a, b - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter two numbers a and b: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println("Result of a^b is: " + pow(a, b));
		scanner.close();
	}
}
