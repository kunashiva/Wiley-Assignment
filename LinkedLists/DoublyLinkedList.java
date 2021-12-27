package wileyassignments.linkedlist;

import java.util.Scanner;

public class DoublyLinkedList {
	class Node {
		int data;
		Node previous;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	Node head, tail = null;
	public static int size = 0;

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			head.previous = null;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		tail.next = null;
		size++;
	}

	public void display() {
		Node current = head;
		if (head == null)
			System.out.println("List is empty");
		else {
			System.out.println("Nodes of doubly linked list: ");
			while (current != null) {
				System.out.print("-> " + current.data);
				current = current.next;
			}
			System.out.println();
		}
	}

	public void deleteFromStart() {
		if (head == null)
			System.out.println("List is Empty");
		else {
			if (head != tail) {
				head = head.next;
				head.previous = null;
			} else
				head = tail = null;
		}
	}

	public void deleteFromMid() {
		if (head == null)
			System.out.println("List is Empty");
		else {
			Node current = head;
			int mid = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);
			for (int i = 1; i < mid; i++)
				current = current.next;
			if (current == head)
				head = current.next;
			else if (current == tail)
				tail = tail.previous;
			else {
				current.previous.next = current.next;
				current.next.previous = current.previous;
			}
			current = null;
		}
		size--;
	}

	public void deleteFromEnd() {
		if (head == null)
			System.out.println("List is Empty");
		else {
			if (head != tail) {
				tail = tail.previous;
				tail.next = null;
			} else {
				head = tail = null;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of Nodes you want to enter");
		int n = sc.nextInt();
		DoublyLinkedList list = new DoublyLinkedList();
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
