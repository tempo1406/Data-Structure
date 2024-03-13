package control;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import module.Student;

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

public class AVLTree {

	TreeNode root;

	public AVLTree() {
		this.root = null;
	}

	public AVLTree(TreeNode root) {
		this.root = root;
	}

	public int height(TreeNode root) {
		if (root == null)
			return -1;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}

	public TreeNode rotationLeft(TreeNode root) {
		TreeNode right = root.right;
		TreeNode temp = right.left;
		root.right = temp;
		right.left = root;
		return right;
	}

	public TreeNode rotationRight(TreeNode root) {
		TreeNode left = root.left;
		TreeNode temp = left.right;
		root.left = temp;
		left.right = root;
		return left;
	}

	public TreeNode updateAVL(TreeNode root) {
		if (Math.abs(height(root.left) - height(root.right)) > 1) {
			if (height(root.left) > height(root.right)) {
				TreeNode node = root.left;
				if (height(node.left) >= height(node.right))
					root = rotationRight(root);
				else {
					root.left = rotationLeft(root.left);
					root = rotationRight(root);
				}
			} else {
				TreeNode node = root.right;
				if (height(node.right) >= height(node.left))
					root = rotationLeft(root);
				else {
					root.right = rotationRight(root.right);
					root = rotationLeft(root);
				}
			}
		}

		return root;
	}

	private TreeNode add(TreeNode root, Student val) {
		if (root == null)
			root = new TreeNode(val);
		else {
			if (root.val.id > val.id)
				root.left = add(root.left, val);
			if (root.val.id < val.id)
				root.right = add(root.right, val);
		}
		return updateAVL(root);
	}

	public void add(Student student) {
		root = add(root, student);
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

	public List<Student> breadthFirst(TreeNode root) {
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
		for (Student student : breadthFirst(root)) {
			System.out.println(student.toString());
		}
		System.out.println();
	}

	public void descendingOrder(TreeNode root) {
		if (root == null)
			return;
		descendingOrder(root.right);
		System.out.println(root.val.toString());
		descendingOrder(root.left);
	}

	public void descendingOrder() {
		descendingOrder(root);
		System.out.println();
	}

	public void countMark() {
		int count = 0;
		for (Student student : breadthFirst(root)) {
			if (student.avg < 5)
				count++;
		}
		System.out.println("Total: " + count);
	}

	private TreeNode deleteByID(TreeNode root, int id) {
		if (root == null)
			return null;
		else {
			if (root.val.id > id) {
				root.left = deleteByID(root.left, id);
			} else if (root.val.id < id) {
				root.right = deleteByID(root.right, id);
			} else {
				if (root.left != null && root.right == null)
					root = root.left;
				else if (root.left == null && root.right != null)
					root = root.right;
				else if (root.left == null && root.right == null)
					root = null;
				else if (root.left != null && root.right != null) {
					TreeNode left = root.left;
					while (left.right != null)
						left = left.right;
					root.val = left.val;
					root.left = deleteByID(root.left, root.val.id);
				}
			}
		}
		return (root != null) ? updateAVL(root) : root;
	}

	public void deleteByAge() {
		int count = 0;
		for (Student student : breadthFirst(root)) {
			if (2024 - student.yearOfBirth == 19) {
				root = deleteByID(root, student.id);
				count++;
			}
		}
		if (count != 0)
			System.out.println("Done\n");
		else
			System.err.println("Done have student satisfied!!!");
	}
}
