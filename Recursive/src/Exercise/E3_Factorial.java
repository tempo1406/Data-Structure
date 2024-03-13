package Exercise;

import java.util.Scanner;

public class E3_Factorial {

	public static int fact(int a) {
		if (a == 0)
			return 1;
		else
			return a * fact(a - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		int a = scanner.nextInt();
		System.out.println("Factorial is: " + fact(a));
		scanner.close();
	}
}
