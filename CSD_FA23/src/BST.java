import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


class TreeNode {
	TreeNode left;
	TreeNode right;
	Employee val;

	public TreeNode() {
	}

	public TreeNode(Employee val) {
		this.val = val;
	}

	public TreeNode(Employee val, TreeNode left, TreeNode right) {
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
	
	public TreeNode add(TreeNode root, Employee value) {
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

	public void add(Employee value) {
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
		int salary = scanner.nextInt();
		Employee newEmployee = new Employee(id, fullName, yearOfBirth, salary);
		root = add(root, newEmployee);
	}
	
	public void minimunSlaryStudent() {
		int min = Integer.MAX_VALUE;
		Employee minEmployee = null;
		if (root == null) {
			System.out.println("Is empty!!!");
			return;
		} else {
			for (Employee employee : breadthFirst()) {
				if (employee.salary < min) {
					min = employee.salary;
					minEmployee = employee;
				}
			}
		}
		if (minEmployee != null) {
	        System.out.println("Employee with minimum salary:");
	        System.out.println("ID: " + minEmployee.id);
	        System.out.println("Full Name: " + minEmployee.fullName);
	        System.out.println("Year of Birth: " + minEmployee.yearOfBirth);
	        System.out.println("Salary: " + minEmployee.salary);
	    } else {
	        System.out.println("No employee found!!!");
	    }
	}
	
	public List<Employee> breadthFirst() {
		List<Employee> list = new LinkedList<>();
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
	
	public void inOrderDescending(TreeNode node, ArrayList<Employee> result) {
        if (node == null)
            return;
        inOrderDescending(node.right, result);
        System.out.println(node.val.id + " " + node.val.fullName + " " + node.val.yearOfBirth + " " + node.val.salary);
        result.add(node.val);
        inOrderDescending(node.left, result);
    }
	
	public int height(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            if (nodeCount == 0)
                return height;
            height++;
            while (nodeCount > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                nodeCount--;
            }
        }
        return height;
    }
}
