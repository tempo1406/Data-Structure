package Exercise;

import java.util.Scanner;

public class E4_Fibonaci {

	public static int fibo(int n) {
		if (n <= 2)
			return 1;
		else
			return fibo(n - 1) + fibo(n - 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		int a = scanner.nextInt();
		System.out.println("Fibo at a-th is: " + fibo(a));
		scanner.close();
	}
}
