package wileyassignments.linkedlist;

import java.util.Scanner;

public class CircularLinkedList {
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node head = null;
	public Node tail = null;
	public static int size = 0;

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null)
			head = newNode;
		else
			tail.next = newNode;
		tail = newNode;
		tail.next = head;
		size++;
	}

	public void deleteFromStart() {
		if (head == null)
			System.out.println("List is empty");
		else {
			if (head != tail) {
				head = head.next;
				tail.next = head;
			} else
				head = tail = null;
		}
	}

	public void deleteFromMid() {
		if (head == null)
			System.out.println("List is Empty");
		else {
			Node current, temp;
			int count = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);
			if (head != tail) {
				temp = head;
				current = null;
				for (int i = 0; i < count - 1; i++) {
					current = temp;
					temp = temp.next;
				}
				if (current != null) {
					current.next = temp.next;
					temp = null;
				} else {
					head = tail = temp.next;
					tail.next = head;
					temp = null;
				}

			} else
				head = tail = null;
		}
		size--;
	}

	public void deleteFromEnd() {
		if (head == null)
			System.out.println("List is Empty");
		else {
			if (head != tail) {
				Node current = head;
				while (current.next != tail) {
					current = current.next;
				}
				tail = current;
				tail.next = head;
			} else
				head = tail = null;
		}
	}

	public void display() {
		if (head == null)
			System.out.println("List is empty");
		else {
			Node current = head;
			System.out.println("Nodes of the circular linked list: ");
			do {
				System.out.print("-> " + current.data);
				current = current.next;
			} while (current != head);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of Nodes you want to enter");
		int n = sc.nextInt();
		CircularLinkedList list = new CircularLinkedList();
		System.out.println("Enter the Nodes");
		for (int i = 0; i < n; i++)
			list.addNode(sc.nextInt());
		list.display();
		n = 1;
		while (n > 0 && n < 5) {
			System.out.println(
					"Type\n1 to add node at end\n2 to delete node at beginning\n3 to delete node at middle\n4 for delete node at end\n5 to exit");
			n = sc.nextInt();
			if (n == 1) {
				System.out.println("Enter the node to add");
				list.addNode(sc.nextInt());
			} else if (n == 2)
				list.deleteFromStart();
			else if (n == 3)
				list.deleteFromMid();
			else if (n == 4)
				list.deleteFromEnd();
			list.display();
		}
	}

}
