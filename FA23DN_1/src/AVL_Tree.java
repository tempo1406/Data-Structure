
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
	TreeNode left;
	TreeNode right;
	Country val;

	public TreeNode() {
	}

	public TreeNode(Country val) {
		this.val = val;
	}

	public TreeNode(Country val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class AVL_Tree {

	TreeNode root;
	Scanner scanner = new Scanner(System.in);

	public AVL_Tree(Country[] arr) {
		for (Country country : arr)
			root = add(root, country);
	}

	public AVL_Tree(TreeNode root) {
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

	private TreeNode add(TreeNode root, Country val) {
		if (root == null)
			root = new TreeNode(val);
		else {
			if (root.val.compareTo(val) > 0)
				root.left = add(root.left, val);
			if (root.val.compareTo(val) < 0)
				root.right = add(root.right, val);
		}
		return updateAVL(root);
	}

	public void add(Country country) {
		root = add(root, country);
	}

	public void add() {
		System.out.println("Enter information country");
		System.out.print("Enter Code: ");
		int code = scanner.nextInt();
		System.out.print("Enter rank: ");
		int rank = scanner.nextInt();
		System.out.print("Enter name: ");
		String name = scanner.next().trim();
		Country newCountry = new Country(code, rank, name);
		root = add(root, newCountry);
	}

	public List<Country> breadthFirst() {
		List<Country> list = new LinkedList<>();
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

	public Country[] toArray() {
		List<Country> countrys = breadthFirst();
		Country[] arr = new Country[countrys.size()];
		for (int i = 0; i < countrys.size(); i++)
			arr[i] = countrys.get(i);
		return arr;
	}

	public void levelOrderTraversal() {
		for (Country country : breadthFirst()) {
			System.out.println(country.toString());
		}
		System.out.println();
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.val.toString());
		inorder(root.right);
	}

	public void inorder() {
		inorder(root);
	}

	private TreeNode deleteByName(TreeNode root, String name) {
		if (root == null) {
			System.err.println("This name does not exist!!!");
			return null;
		} else {
			if (root.val.name.compareTo(name) > 0) {
				root.left = deleteByName(root.left, name);
			} else if ((root.val.name.compareTo(name) < 0)) {
				root.right = deleteByName(root.right, name);
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
					root.left = deleteByName(root.left, root.val.name);
				}
			}
		}
		return (root != null) ? updateAVL(root) : root;
	}

	public void deleteByName() {
		System.out.print("Enter name country want romove: ");
		String name = scanner.nextLine();
		root = deleteByName(root, name);
	}

	private void searchByName(TreeNode root, String name) {
		if (root == null)
			System.err.println("This country name is empty!!!");
		else {
			if (root.val.name.compareTo(name) > 0) {
				searchByName(root.left, name);
			} else if ((root.val.name.compareTo(name) < 0)) {
				searchByName(root.right, name);
			} else {
				System.out.println(root.val.toString());
				System.out.println("Done!!!");
				return;
			}
		}
	}

	public void searchByName() {
		System.out.print("Enter name country want search: ");
		String name = scanner.nextLine();
		searchByName(root, name);
	}
}
