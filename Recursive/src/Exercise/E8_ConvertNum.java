package Exercise;

import java.util.Scanner;

public class E8_ConvertNum {

	public static String convert(int a, int b) {
		if (a < b)
			return a + "";
		else if (a % b < 10)
			return convert(a / b, b) + (a % b);
		else {
			char ch = (char) ((a % b) + 55);
			return convert(a / b, b) + ch;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numbers a and type b: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println("Result when concert a to type b is: " + convert(a, b));
		scanner.close();
	}
}
