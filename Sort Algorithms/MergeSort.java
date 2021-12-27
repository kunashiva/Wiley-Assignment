package wileyassignments;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of numbers you want to enter");
		int n = sc.nextInt();
		System.out.println("Enter the numbers");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sort(arr, 0, n - 1);
		System.out.println("After Sorting");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void sort(int[] arr, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int i = 0;
		int endOfFirstHalf = mid - start;
		int j = mid + 1;
		int endOfSecondHalf = end - start;
		int[] tempArr = new int[end - start];
		int k = 0;
		while (i <= endOfFirstHalf && j <= endOfSecondHalf) {
			if (arr[i] <= arr[j]) {
				tempArr[k] = arr[i];
				i++;
			} else if (arr[i] > arr[j]) {
				tempArr[k] = arr[j];
				j++;
			}
			k++;
		}
		while (i <= endOfFirstHalf) {
			tempArr[k] = arr[i];
			k++;
			i++;
		}
		while (j <= endOfSecondHalf) {
			tempArr[k] = arr[j];
			k++;
			j++;
		}
		for (k = 0; k < (end - start); k++)
			arr[start + k] = tempArr[k];
	}

}
