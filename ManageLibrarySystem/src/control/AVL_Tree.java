package control;

import java.util.LinkedList;
import java.util.Queue;

import module.Book;

class Node {
	public Book val;
	public Node left, right;

	public Node() {

	}

	public Node(Book book) {
		this.val = book;
		this.left = null;
		this.right = null;
	}

	public Node(Book val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}

public class AVL_Tree {
	Node root;

	public AVL_Tree() {
		this.root = null;
	}

	public AVL_Tree(Node root) {
		this.root = root;
	}

	private Node add(Node root, Book value) {
		if (root == null)
			root = new Node(value);
		else {
			if (root.val.getId() > value.getId())
				root.left = add(root.left, value);
			else
				root.right = add(root.right, value);
		}
		return updateAVLTree(root);
	}

	public void add(Book value) {
		root = add(root, value);
	}

	private int height(Node root) {
		if (root == null)
			return -1;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;

	}

	public int height() {
		return height(root);
	}

	private boolean isBalance(Node root) {
		if (root == null)
			return true;
		if (Math.abs(height(root.left) - height(root.right)) > 1)
			return false;
		return isBalance(root.left) && isBalance(root.right);
	}

	public boolean isBalance() {
		return isBalance(root);
	}

	private Node rotationLeft(Node root) {
		Node right = root.right;
		Node temp = right.left;
		root.right = temp;
		right.left = root;
		return right;
	}

	private Node rotationRight(Node root) {
		Node left = root.left;
		Node temp = left.right;
		root.left = temp;
		left.right = root;
		return left;
	}

	private Node updateAVLTree(Node root) {
		if (Math.abs(height(root.left) - height(root.right)) > 1) {
			if (height(root.left) > height(root.right)) {
				Node node = root.left;
				if (height(node.left) >= height(node.right))
					root = rotationRight(root);
				else {
					root.left = rotationLeft(root.left);
					root = rotationRight(root);
				}
			} else {
				Node node = root.right;
				if (height(node.left) <= height(node.right))
					root = rotationLeft(root);
				else {
					root.right = rotationRight(root.right);
					root = rotationLeft(root);
				}
			}
		}
		return root;
	}

	public void updateAVLTree() {
		while (!isBalance(root))
			root = updateAVLTree(root);
	}

	private void breadthFirst(Node root) {
		if (root == null)
			System.err.println("Tree is empty!!!");
		Queue<Node> queue = new LinkedList<Node>();
		Node node = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.println(node.val.toString());
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	public void breadthFirst() {
		breadthFirst(root);
	}

	private Node delete(Node root, int id) {
		if (root == null)
			return null;
		else {
			if (root.val.getId() > id)
				root.left = delete(root.left, id);
			else if (root.val.getId() < id)
				root.right = delete(root.right, id);
			else {
				if (root.left != null && root.right == null)
					root = root.left;
				else if (root.left == null && root.right != null)
					root = root.right;
				else if (root.left == null && root.right == null)
					root = null;
				else if (root.left != null && root.right != null) {
					Node left = root.left;
					while (left.right != null)
						left = left.right;
					root.val = left.val;
					root.left = delete(root.left, root.val.getId());
				}
			}
		}
		return (root != null) ? updateAVLTree(root) : root;
	}

	public void delete(int id) {
		root = delete(root, id);
	}

	private Node search(Node root, int id) {
		if (root == null)
			return null;
		if (root.val.getId() > id)
			return search(root.left, id);
		if (root.val.getId() < id)
			return search(root.right, id);
		return root;
	}

	public void search(int id) {
		if (search(root, id) != null)
			System.out.println(search(root, id).val.toString());
		else
			System.err.println("Does not exist!!!");
	}

	private void searchAuthor(Node root, String author) {
		if (root == null)
			return;
		if (root.val.getAuthor().split(" ")[root.val.getAuthor().split(" ").length - 1].equals(author))
			System.out.println(root.val.toString());
		searchAuthor(root.left, author);
		searchAuthor(root.right, author);
	}

	public void searchAuthor(String author) {
		searchAuthor(root, author);
	}
}
