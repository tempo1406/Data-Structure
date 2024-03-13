package app;

import control.AVL_Tree;
import module.Book;

public class application {
	public static void main(String[] args) {
		AVL_Tree tree = new AVL_Tree();
//		tree.add(new Book(70, "Tenet", "Christopher Nolan", 1951));
//		tree.add(new Book(80, "Interstellar", "Christopher Nolan", 2014));
//		tree.add(new Book(100, "1984", "George Orwell", 1949));
//		tree.add(new Book(40, "Oppenheimer", "Christopher Nolan", 2023));
//		tree.add(new Book(30, "The Lord of the Rings", "Tolkien", 1954));
//		tree.add(new Book(60, "The Hobbit", "Tolkien", 1937));
//		tree.add(new Book(90, "guardian of the galaxy 3", "James Gunn", 2023));
//		tree.add(new Book(110, "One Hundred Years of Solitude", "Garcia Marquez", 1967));
//		tree.add(new Book(50, "Memento", "Christopher Nolan", 2000));
		tree.add(new Book(1, "Tenet", "Christopher Nolan", 1951));
		tree.add(new Book(2, "Interstellar", "Christopher Nolan", 2014));
		tree.add(new Book(3, "1984", "George Orwell", 1949));
		tree.add(new Book(4, "Oppenheimer", "Christopher Nolan", 2023));
		tree.add(new Book(5, "The Lord of the Rings", "Tolkien", 1954));
		tree.add(new Book(6, "The Hobbit", "Tolkien", 1937));
		tree.add(new Book(7, "guardian of the galaxy 3", "James Gunn", 2023));
		tree.add(new Book(8, "guardian of the galaxy 3", "James Gunn", 2023));
		tree.add(new Book(9, "The Lord of the Rings", "Tolkien", 1954));
		tree.add(new Book(10, "The Lord of the Rings", "Tolkien", 1954));

		System.out.println("Height: " + tree.height());
		// Print
		tree.breadthFirst();
		System.out.println();
		// Delete
		tree.delete(3);
		tree.delete(4);
		tree.delete(9);
		tree.breadthFirst();
		System.out.println();
		// Search
		tree.search(40);
		System.out.println();
		// Search author
		tree.searchAuthor("Nolan");
	}

}
