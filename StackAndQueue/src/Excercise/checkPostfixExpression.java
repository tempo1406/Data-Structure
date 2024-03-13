package Excercise;

import java.util.Scanner;

import Module.StackLinkedList;

public class checkPostfixExpression {

	public static boolean isOperator(char sign) {
		return "+-*/^".contains(sign + "");
	}

	public static boolean isPostfixExpression(String exp) {
		StackLinkedList<Character> stack = new StackLinkedList<Character>();
		for (int i = 0; i < exp.length(); i++) {
			char temp = exp.charAt(i);
			if (Character.isLetterOrDigit(temp))
				stack.push(exp.charAt(i));
			else if (isOperator(temp)) {
				if (stack.countSize() < 2)
					return false;
				stack.pop();
			} else
				return false;
		}
		return (stack.countSize() == 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Postfix Expression: ");
		String exp = scanner.nextLine().trim();
		System.out.println("Postfix Expression: " + isPostfixExpression(exp));
		scanner.close();

	}
}
