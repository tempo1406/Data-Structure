package Excercise;

import java.util.Scanner;

import Module.StackLinkedList;

public class convertNum {

	public static String converNum(int num, int type) {
		String result = "";
		StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
		while (num > 0) {
			stack.push(num % type);
			num /= type;
		}
		while (!stack.empty()) {
			int temp = stack.pop();
			if (temp < 10)
				result += temp;
			else
				result += (char) (temp + 55);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = scanner.nextInt();
		System.out.print("Enter type: ");
		int type = scanner.nextInt();
		System.out.println("Conver num to " + type + " :" + converNum(num, type));
		scanner.close();
	}
}
