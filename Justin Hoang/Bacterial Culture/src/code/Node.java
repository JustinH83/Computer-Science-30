package code;

public class Node {
	private Node up, down, left, right;
	private int data;
	private boolean flooded;
	
	public Node() {
		this.data = 0;
		flooded = false;
	}
	
	public Node(int data) {
		this.data = data;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isFlooded() {
		return flooded;
	}

	public void setFlooded(boolean flooded) {
		this.flooded = flooded;
	}
	
}
