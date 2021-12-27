package wileyassignments.Trees;

import java.util.Scanner;

public class TreeTraversals {
	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node root = null;

	void printPreorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	void printPostorder(Node node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeTraversals tree = new TreeTraversals();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.right.right.right = new Node(7);
		tree.root.right.right.right.right = new Node(8);

		int n = 1;
		while (n > 0 && n < 4) {
			System.out.println(
					"Type\n1 for PREORDER traversal\n2 for INORDER traversal\n3 for POSTORDER traversal\n4 for exit");
			n = sc.nextInt();
			if (n == 1) {
				System.out.println("PreOrder traversal of Tree");
				tree.printPreorder(tree.root);
			} else if (n == 2) {
				System.out.println("InOrder traversal of Tree");
				tree.printInorder(tree.root);
			} else if (n == 3) {
				System.out.println("PostOrder traversal of Tree");
				tree.printPostorder(tree.root);
			}
		}
	}

}
