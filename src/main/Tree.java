package main;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class gives a method to interact with a binary-search-tree
 * 
 * @author Martin Kiessling
 */
public class Tree {

	/* variables */
	private Node root;
	private int height;

	/**
	 * getter for tree-height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * setter for tree-height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * insert a new node into the tree
	 */
	private void insert(int value) {
		insert(new Node(value, null, null));
	}

	/**
	 * insert a new node into the tree
	 */
	private void insert(Node node) {

		Node i = null;
		Node r = root;

		while (r != null) {
			i = r;

			if (node.getValue() < r.getValue()) {
				r = r.getLeft();
			} else {
				r = r.getRight();
			}
		}

		if (i == null) {
			root = node;
		} else if (node.getValue() < i.getValue()) {
			i.setLeft(node);
		} else {
			i.setRight(node);
		}
	}

	/**
	 * return tree-height
	 */
	private int getTreeHeight(Node node) {
		if (node == null) {
			return -1;
		} else {
			return 1 + Math.max(getTreeHeight(node.getLeft()),
					getTreeHeight(node.getRight()));
		}
	}

	/**
	 * return pre-order traversal
	 */
	private void preorderTraversal() {
		preorderTraversal(root);
	}

	private void preorderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.getValue() + " ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());
		}
	}

	/**
	 * return in-order traversal
	 */
	private void inorderTraversal() {
		inorderTraversal(root);
	}

	private void inorderTraversal(Node node) {
		if (node != null) {
			inorderTraversal(node.getLeft());
			System.out.print(node.getValue() + " ");
			inorderTraversal(node.getRight());
		}
	}

	/**
	 * return post-order traversal
	 */
	private void postorderTraversal() {
		postorderTraversal(root);
	}

	private void postorderTraversal(Node node) {
		if (node != null) {
			postorderTraversal(node.getLeft());
			postorderTraversal(node.getRight());
			System.out.print(node.getValue() + " ");
		}
	}

	/**
	 * prints paths
	 */
	public void printPaths() {
		LinkedList<Integer> path = new LinkedList<Integer>();
		printPaths(root, path);
	}

	private void printPaths(Node n, LinkedList<Integer> path) {
		if (n == null)
			return;
		path.addLast(Integer.valueOf(Integer.toString(n.getValue())));
		if (n.getLeft() == null && n.getRight() == null) {
			printList(path);
		} else {
			printPaths(n.getLeft(), path);
			printPaths(n.getRight(), path);
		}
		path.removeLast();
	}

	private void printList(LinkedList<Integer> path) {
		System.out.println(path.toString());
	}

	/**
	 * search for a node
	 */
	private void findNode(int value) {
		Node node = root;
		Node x = findNode(node, value);

		System.out.println("Node " + x.getValue() + " exists in the tree.");
		if (x.getLeft() == null) {
			System.out.println("Node's left child is empty");
		} else {
			System.out
					.println("Node's left child is " + x.getLeft().getValue());
		}
		if (x.getRight() == null) {
			System.out.println("Node's right child is empty");
		} else {
			System.out.println("Node's right child is "
					+ x.getRight().getValue());
		}

	}

	/**
	 * return Node
	 */
	private Node findNode(Node node, int value) {
		while (node.getValue() != value && node != null) {
			if (value < node.getValue()) {
				node = node.getLeft();
			} else if (value > node.getValue() || value == node.getValue()) {
				node = node.getRight();
			}
		}
		return node;
	}

	/**
	 * show main-menu
	 */
	@SuppressWarnings("resource")
	public void getMethods() {
		boolean exit = false;
		boolean exist = false;
		System.out.println("Welcome to the binary search-tree application");
		do {
			System.out.println();
			System.out.println("Choose one of the following options:");
			System.out.println("Insert an element (i)");
			if (exist) {
				System.out.println("Search for an element (s)");
				System.out.println("Traversal (t)");
			}
			System.out.println("Exit (e)");
			System.out.print("Your choice: ");
			String x = new Scanner(System.in).next();
			System.out.println();
			switch (x.charAt(0)) {
			case 'i':
				try {
					System.out
							.println("How many elements would you like to insert?");
					int k = new Scanner(System.in).nextInt();
					for (int i = 0; i < k; i++) {
						System.out.println("Element " + (i + 1) + ": ");
						insert(new Scanner(System.in).nextInt());
					}
					exist = true;
					setHeight(getTreeHeight(root));
				} catch (InputMismatchException e) {
					System.out.println("Input is not valid!");
					e.printStackTrace();
				}
				break;
			case 's':
				System.out.println("Enter the value you are searching for: ");
				int s = new Scanner(System.in).nextInt();
				findNode(s);
				break;
			case 't':
				System.out.println("Preorder traversal (1)");
				System.out.println("Inorder traversal (2)");
				System.out.println("Postorder traversal (3)");
				System.out.println("Do all (4)");
				System.out.println("");
				System.out.println("Show all paths (5)");
				System.out.print("Your choice: ");
				int y = new Scanner(System.in).nextInt();
				System.out.println();
				switch (y) {
				case 1:
					System.out.println("Preorder Traversal:");
					preorderTraversal();
					System.out.println();
					break;
				case 2:
					System.out.println("\nInorder Traversal:");
					inorderTraversal();
					System.out.println();
					break;
				case 3:
					System.out.println("\nPostorder Traversal:");
					postorderTraversal();
					System.out.println();
					break;
				case 4:
					System.out.println("Preorder Traversal:");
					preorderTraversal();
					System.out.println("\nInorder Traversal:");
					inorderTraversal();
					System.out.println("\nPostorder Traversal:");
					postorderTraversal();
					System.out.println();
					break;
				case 5:
					System.out.println();
					printPaths();
					System.out.println();
					break;
				default:
					System.out.println("Input '" + y + "' is not valid!");
				}
				break;
			case 'e':
				System.out.println("Goodbye!");
				exit = true;
				break;
			default:
				System.out.println("Input '" + x.charAt(0) + "' is not valid!");
			}
		} while (!exit);
	}
}