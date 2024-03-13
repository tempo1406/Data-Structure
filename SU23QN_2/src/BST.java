import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.sound.midi.VoiceStatus;

class TreeNode {
	TreeNode left;
	TreeNode right;
	Student val;

	public TreeNode() {
	}

	public TreeNode(Student val) {
		this.val = val;
	}

	public TreeNode(Student val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BST {
	TreeNode root;

	public BST() {
		this.root = null;
	}

	public BST(TreeNode root) {
		this.root = root;
	}

	public TreeNode add(TreeNode root, Student value) {
		if (root == null)
			root = new TreeNode(value);
		else {

			if (root.val.id > value.id)
				root.left = add(root.left, value);
			else if (root.val.id < value.id)
				root.right = add(root.right, value);
		}
		return root;
	}

	public void add(Student value) {
		root = add(root, value);
	}

	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter information student");
		System.out.print("Enter ID: ");
		int id = scanner.nextInt();
		System.out.print("Enter full name: ");
		String fullName = scanner.next().trim();
		System.out.print("Enter yearOfBirth: ");
		int yearOfBirth = scanner.nextInt();
		System.out.print("Enter avg: ");
		double avg = scanner.nextDouble();
		Student newStudent = new Student(id, fullName, yearOfBirth, avg);
		root = add(root, newStudent);
	}

	public List<Student> breadthFirst() {
		List<Student> list = new LinkedList<>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode node = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			node = queue.poll();
			list.add(node.val);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return list;
	}

	public void levelOrderTraversal() {
		if (root == null)
			System.out.println("Is empty!!!");
		else
			for (Student student : breadthFirst())
				System.out.println(student.toString());
		System.out.println();
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}

	public void descendingOrder() {
		inOrder(root);
	}

	public void countMark() {
		if (root == null) {
			System.out.println("Is empty!!!");
			return;
		} else {
			int count = 0;
			for (Student student : breadthFirst())
				if (student.avg < 5)
					count++;
			System.out.println("Total: " + count);
		}
		System.out.println();
	}

	public TreeNode delete(TreeNode root, int id) {
		if (root == null)
			return null;
		else {
			if (root.val.id > id)
				root.left = delete(root.left, id);
			else if (root.val.id < id)
				root.right = delete(root.right, id);
			else {
				if (root.right == null && root.left == null)
					root = null;
				else if (root.right != null && root.left == null)
					root = root.right;
				else if (root.right == null && root.left != null)
					root = root.left;
				else if (root.right != null && root.left != null) {
					TreeNode left = root.left;
					while (left.right != null)
						left = left.right;
					root.val = left.val;
					root.left = delete(root.left, root.val.id);
				}
			}
		}
		return root;
	}

	public void deleteByAge() {
		if (root == null) {
			System.out.println("Is empty!!!");
			return;
		} else {
			int count = 0;
			for (Student student : breadthFirst()) {
				if (2024 - student.yearOfBirth == 19)
					root = delete(root, student.id);
				count++;
			}
			if (count != 0)
				System.out.println("Done\n");
			else
				System.err.println("Done have student satisfied!!!");
		}
	}
}
