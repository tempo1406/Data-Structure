import javax.xml.validation.Validator;

class TreeNode {
	TreeNode left;
	TreeNode right;
	Pupil val;

	public TreeNode() {
	}

	public TreeNode(Pupil val) {
		this.val = val;
	}

	public TreeNode(Pupil val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BST {
	TreeNode root;
	int minMark;

	public BST() {
		this.root = null;
	}

	public BST(Pupil[] data) {
		for (Pupil pupil : data) {
			add(pupil);
			minMark = Math.min(minMark, pupil.mark);
		}
		System.out.println("Input data successfully!!!");
	}

	public BST(TreeNode root) {
		this.root = root;
	}

	public TreeNode add(TreeNode root, Pupil value) {
		if (root == null)
			root = new TreeNode(value);
		else {

			if (root.val.rollNum > value.rollNum)
				root.left = add(root.left, value);
			else if (root.val.rollNum < value.rollNum)
				root.right = add(root.right, value);
		}
		return root;
	}

	public void add(Pupil value) {
		root = add(root, value);
	}

	private void decrease(TreeNode root) {
		if (root == null)
			return;
		root.val.mark /= 2.0;
		decrease(root.left);
		decrease(root.right);
	}

	public void decrease() {
		decrease(root);
		System.out.println("Done!!!");
	}

	private int level(TreeNode root) {
		if (root == null)
			return -1;
		int left = level(root.left);
		int right = level(root.right);
		return Math.max(left, right) + 1;
	}

	public void level() {
		System.out.println("Level: " + level(root));
	}

	private boolean isBalenceTree(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(level(root.left) - level(root.right)) > 1)
			return false;
		return isBalenceTree(root.left) && isBalenceTree(root.right);
	}

	public void isBalenceTree() {
		System.out.println("Is balence tree: " + isBalenceTree(root));
	}
	private void preOrder(TreeNode root) {
		if (root==null)
			return;
		System.out.println(root.val.toString());
		preOrder(root.left);
		preOrder(root.right);
	}
	public void preOrder() {
		preOrder(root);
	}
}
