package Exercise;

import java.util.Scanner;

public class E5_Mod_subtraction {

	public static int remainder_mod(int a, int b) {
		if (a < b)
			return a;
		else
			return remainder_mod(a - b, b);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter two numbers a and b: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println("Remender of division a and b is: " + remainder_mod(a, b));
		scanner.close();
	}
}
