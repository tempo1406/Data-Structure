package Exercise;

import java.util.Scanner;

public class E9_ReverseNum {

	public static int reverse(int a) {
		if (a < 10)
			return a;
		else
			return a % 10 * ((int) Math.pow(10, Math.round(Math.log10(a)))) + reverse(a / 10);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numbers a: ");
		int a = scanner.nextInt();
		System.out.println("Reverse num: " + reverse(a));
		scanner.close();
	}
}
