package Exercise;

import java.util.Scanner;

public class E1_GCD {

	public static int GCD(int a, int b) {

		if (b == 0)
			return a;
		else
			return GCD(b, a % b);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter two numbers a and b: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println("GCD of a and b is: "+GCD(a, b));
		scanner.close();
	}
}