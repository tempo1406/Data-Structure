package Exercise;

import java.util.Scanner;

public class E15_HaNoiTower {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		int nDisks = scanner.nextInt();
		doTowers(nDisks, 'A', 'B', 'C');
		System.out.println("Minimun " + (int)(Math.pow(2, nDisks) - 1) + " steps.");
		scanner.close();

	}

	public static void doTowers(int topN, char a, char b, char c) {
		if (topN == 1)
			System.out.println("Disk 1: from " + a + " to " + c);
		else {
			doTowers(topN - 1, a, c, b);
			System.out.println("Disk " + topN + ": from " + a + " to " + c);
			doTowers(topN - 1, b, a, c);
		}
	}
}
