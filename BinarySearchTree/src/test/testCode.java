package test;

public class testCode<E> {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		public boolean isValidBST(TreeNode root) {
			if (root != null) {
				if (root.left == null && root.right != null)
					return isValidBST(root, root.val - 1, root.right.val);
				else if (root.left != null && root.right == null)
					return isValidBST(root, root.left.val, root.val + 1);
				else if (root.left != null && root.right != null)
					return isValidBST(root, root.left.val, root.right.val);
				else if (root.left == null && root.right == null)
					return true;
			}
			return false;
		}

//		private boolean isValidBST(TreeNode root, int leftVal, int rightVal) {
//			if (root != null) {
//				int val = root.val;
//				if (root.left == null && root.right != null && root.right.val > val && root.right.val > leftVal) {
//					if (leftVal < val)
//						return false;
//					else
//						return isValidBST(root.right, leftVal, rightVal);
//				} else if (root.right == null && root.left != null && root.left.val < val && root.left.val < rightVal) {
//					if (rightVal > val)
//						return false;
//					else
//						return isValidBST(root.left, leftVal, rightVal);
//
//				} else if (root.left != null && root.left.val < val && root.right != null && root.right.val > val
//						&& root.left.val < leftVal && root.right.val > rightVal)
//					return isValidBST(root.left, leftVal, rightVal) && isValidBST(root.right, leftVal, rightVal);
//				else if (root.left == null && root.right == null)
//					return true;
//				else
//					return false;
//			} else
//				return true;
//		}
		private boolean isValidBST(TreeNode root, int leftVal, int rightVal) {
			if (root != null) {
				int val = root.val;
				if (root.left == null && root.right != null && root.right.val > val) {
					if ((leftVal > val && root.right.val < leftVal) || (val > rightVal && root.right.val > rightVal))
						return isValidBST(root.right, leftVal, rightVal);
					else
						return false;
				} else if (root.right == null && root.left != null && root.left.val < val) {
					if ((leftVal > val && root.right.val < leftVal) || (val > rightVal && root.right.val > rightVal))
						return isValidBST(root.left, leftVal, rightVal);
					else
						return false;

				} else if (root.left != null && root.left.val < val && root.right != null && root.right.val > val
						&& root.left.val < leftVal && root.right.val > rightVal)
					return isValidBST(root.left, leftVal, rightVal) && isValidBST(root.right, leftVal, rightVal);
				else if (root.left == null && root.right == null)
					return true;
				else
					return false;
			} else
				return true;
		}
	}
}
