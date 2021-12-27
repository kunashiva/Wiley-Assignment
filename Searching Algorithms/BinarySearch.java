package wileyassignments;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of numbers you want to enter");
		int n = sc.nextInt();
		System.out.println("Enter the numbers");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println("Enter the number you want to search");
		int key = sc.nextInt();
		int position = search(arr, 0, n - 1, key);
		System.out.println(key + " found at position " + position+1);

	}

	public static int search(int[] arr, int first, int last, int key) {
		if (first <= last) {
			int mid = (first + last) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] > key)
				return search(arr, first, mid - 1, key);
			return search(arr, mid + 1, last, key);
		}
		return -1;
	}

}
