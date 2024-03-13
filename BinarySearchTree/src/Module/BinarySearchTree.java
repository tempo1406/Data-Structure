package Module;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> {

	public Node<E> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(Node<E> roof) {
		this.root = roof;
	}

	// Add value
	private Node<E> add(Comparable<E> value, Node<E> node) {
		if (node == null) {
			node = new Node<E>(value);
		} else {
			if (node.value.compareTo((E) value) > 0)
				node.left = add(value, node.left);
			else if (node.value.compareTo((E) value) < 0)
				node.right = add(value, node.right);
			else
				System.err.println(value + " is exist!!!");
		}
		return node;
	}

	public void add(Comparable<E> value) {
		this.root = add(value, root);
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public void clear() {
		this.root = null;
	}

	// Search value
	private boolean search(Comparable<E> value, Node<E> node) {
		if (node == null)
			return false;

		if (node.value.compareTo((E) value) > 0)
			return search(value, node.left);
		else if (node.value.compareTo((E) value) < 0)
			return search(value, node.right);
		return true;
	}

	public boolean search(Comparable<E> value) {
		return search(value, root);
	}

	// PreOder tree
	private void preOrder(Node<E> node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void preOrder() {
		System.out.print("PreOrder: ");
		preOrder(root);
		System.out.println();
	}

	// InOder tree
	private void inOrder(Node<E> node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.value + " ");
			inOrder(node.right);
		}
	}

	public void inOrder() {
		System.out.print("InOrder: ");
		inOrder(root);
		System.out.println();
	}

	// PostOrder tree
	public void postOrder() {
		System.out.print("PostOrder: ");
		postOder(root);
		System.out.println();
	}

	private void postOder(Node<E> node) {
		if (node != null) {
			postOder(node.left);
			postOder(node.right);
			System.out.print(node.value + " ");
		}
	}

	// Count node
	private int count(Node<E> node) {
		if (node == null)
			return 0;
		return count(node.left) + count(node.right) + 1;
	}

	public int count() {
		return count(root);
	}

	// Minimum
	private E min(Node<E> node) {
		if (node.left == null)
			return (E) node.value;
		else
			return min(node.left);
	}

	public E min() {
		return min(root);
	}

	// Maximum
	private E max(Node<E> node) {
		if (node.right == null)
			return (E) node.value;
		else
			return max(node.right);
	}

	public E max() {
		return max(root);
	}

	// Sum
	private int sum(Node<E> node) {
		if (node == null)
			return 0;
		else
			return sum(node.left) + sum(node.right) + (int) node.value;
	}

	public int sum() {
		return sum(root);
	}

	// Average
	public double avg() {
		return (double) sum() / count();
	}

	// Count leaf
	private int countLeaf(Node<E> node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;

		else
			return countLeaf(node.left) + countLeaf(node.right);
	}

	public int countLeaf() {
		return countLeaf(root);
	}

	// Count node have only one child
	private int degree1(Node<E> node) {
		if (node == null)
			return 0;
		else if ((node.left == null && node.right != null) || (node.left != null && node.right == null))
			return 1;
		else
			return degree1(node.left) + degree1(node.right);
	}

	public int degree1() {
		return degree1(root);
	}

	// Count node have two child
	private int degree2(Node<E> node) {
		if (node.left != null && node.right != null && node != null)
			return degree2(node.left) + degree2(node.right) + 1;
		else
			return 0;
	}

	public int degree2() {
		return degree2(root);
	}

	// Count immediate
	private int immediate(Node<E> node) {
		if (node != null && (node.left != null || node.right != null))
			return immediate(node.left) + immediate(node.right) + 1;
		else
			return 0;
	}

	public int immediate() {
		return immediate(root);
	}

	// Height of tree
	private int height(Node<E> node) {
		if (node == null)
			return 0;
		int left = height(node.left);
		int right = height(node.right);
		return Math.max(left, right) + 1;
	}

	public int height() {
		return height(root);
	}

	// Depth-first tree
	public void deepth() {
		System.out.print("Deepth first: ");
		Stack<Node<E>> stack = new Stack<Node<E>>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<E> node = stack.pop();
			System.out.print(node.value + " ");
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		System.out.println();
	}

	// Breadth-first tree
	public void breadth() {
		System.out.print("Breadth first: ");
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			System.out.print(node.value + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		System.out.println();
	}

	// Find level of value
	private int level(int value, Node<E> root, int level) {
		if (root == null)
			return -1;
		if ((int) root.value == value)
			return level;
		if ((int) root.value > value)
			return level(value, root.left, level + 1);
		else
			return level(value, root.right, level + 1);
	}

	public int level(int value) {
		return level(value, root, 1);
	}

	// Print node at level
	private void printNodesAtLevel(int k, Node<E> node, int level) {
		if (level == k) {
			System.out.print(node.value + " ");
			return;
		}
		if (node.left != null)
			printNodesAtLevel(k, node.left, level + 1);
		if (node.right != null)
			printNodesAtLevel(k, node.right, level + 1);
	}

	public void printNodesAtLevel(int k) {
		if (k > 0 || k <= height()) {
			System.out.print("Total node at level " + k + ": ");
			printNodesAtLevel(k, root, 1);
		} else
			System.err.print("Invalid level!!!");
		System.out.println();
	}

	// Remove node
	private Node<E> remove(int x, Node<E> node) {
		if (node == null)
			return null;
		else {
			if ((int) node.value > x)
				node.left = remove(x, node.left);
			else if ((int) node.value < x)
				node.right = remove(x, node.right);
			else {
				if (node.left == null && node.right != null)
					node = node.right;
				else if (node.left != null && node.right == null)
					node = node.left;
				else if (node.left == null && node.right == null)
					node = null;
				else if (node.left != null && node.right != null) {
					Node<E> leftNode = node.left;
					while (leftNode.right != null)
						leftNode = leftNode.right;
					node.value = leftNode.value;
					node.left = remove((int) leftNode.value, node.left);
				}
			}
		}
		return node;
	}

	public void remove(int x) {
		remove(x, root);
	}

	// Sort tree
	private void sortedArray(Node<E> node, LinkedList<E> list) {
		if (node != null) {
			sortedArray(node.left, list);
			list.add((E) node.value);
			sortedArray(node.right, list);
		}
	}

	public void sortTree() {
		LinkedList<E> list = new LinkedList<>();
		sortedArray(root, list);
		BinarySearchTree<E> sortTree = new BinarySearchTree<E>();
		for (E e : list) {
			sortTree.add((Comparable<E>) e);
		}
		root = sortTree.root;
		preOrder();
	}

	// Is balance tree
	private void inOrder(Node<E> node, List<E> list) {
		if (node != null) {
			inOrder(node.left, list);
			list.add((E) node.value);
			inOrder(node.right, list);
		}
	}

	public boolean isValidBST(Node<E> root) {
		List<E> list = new ArrayList<>();
		inOrder(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			if ((int) list.get(i) > (int) list.get(i + 1))
				return false;
		}
		return true;
	}
}
