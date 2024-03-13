package test;

import Module.BinarySearchTree;

public class test {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(10);
		bst.add(7);
		bst.add(18);
		bst.add(8);
		bst.add(3);
		bst.add(15);
		bst.add(20);
		bst.add(35);
		bst.add(19);
		bst.add(2);
		bst.add(9);

		bst.preOrder();
		bst.inOrder();
		bst.postOrder();
		System.out.println("Total node: " + bst.count());
		System.out.println("Search node: " + bst.search(35));
		System.out.println("Minimum value: " + bst.min());
		System.out.println("Maximum value: " + bst.max());
		System.out.println("Sum tree: " + bst.sum());
		System.out.println("Average tree: " + bst.avg());
		System.out.println("Count leaf tree: " + bst.countLeaf());
		System.out.println("Count degree 1 tree: " + bst.degree1());
		System.out.println("Count degree 2 tree: " + bst.degree2());
		System.out.println("Count immediate node: " + bst.immediate());
		System.out.println("Height of tree: " + bst.height());
		bst.deepth();
		bst.breadth();
		System.out.println("Level of value: " + bst.level(9));
		bst.printNodesAtLevel(4);
		bst.remove(10);
		bst.breadth();
		bst.sortTree();
	}
}
