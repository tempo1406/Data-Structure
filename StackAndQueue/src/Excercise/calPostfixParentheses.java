package Excercise;

import java.util.Scanner;

import Module.StackLinkedList;

public class calPostfixParentheses {

	public static boolean isOperator(String sign) {
		return "+-*/^".contains(sign);
	}

	public static double calOperator(double a, double b, String ope) {
		switch (ope) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "^":
			return Math.pow(a, b);
		case "/":
			try {
				if (b != 0) {
					double temp = a / b;
					return temp;
				} else
					throw new ArithmeticException("Invalid expression!!!");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				System.exit(0);
			}
		}
		return 0;
	}

	public static double calPostFix(String exp) {
		StackLinkedList<Double> stack = new StackLinkedList<Double>();
		String arr[] = exp.split(" ");
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i];
			if (!isOperator(temp)) {
				double num = Double.parseDouble(temp);
				stack.push(num);
			} else {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(calOperator(a, b, temp));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Postfix Expression: ");
		String exp = scanner.nextLine().trim();
		System.out.println("Result: " + calPostFix(exp));
		scanner.close();
	}
}
