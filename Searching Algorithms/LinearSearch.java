package wileyassignments;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of numbers you want to enter");
		int n = sc.nextInt();
		System.out.println("Enter the numbers");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the number you want to search");
		int key = sc.nextInt();
		int position = search(arr, key);
		System.out.println(key + " found at position " + position);
	}

	public static int search(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

}
