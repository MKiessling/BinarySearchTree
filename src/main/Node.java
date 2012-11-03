package main;
/**
 * This class defines how a node is structured
 * 
 * @author Martin Kiessling
 */
public class Node {

	private int value;
	private Node left;
	private Node right;

	public Node(int value, Node leftChild, Node rightChild) {
		this.setValue(value);
		this.setLeft(leftChild);
		this.setRight(rightChild);
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getLeft() {
		return left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getRight() {
		return right;
	}

}