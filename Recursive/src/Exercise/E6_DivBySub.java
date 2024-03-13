package Exercise;

import java.util.Scanner;

public class E6_DivBySub {

	public static int Div(int a, int b) {
		if (a < b)
			return 0;
		else
			return Div(a - b, b) + 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter two numbers a and b: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println("Result of division a and b is: " + Div(a, b));
		scanner.close();
	}
}
