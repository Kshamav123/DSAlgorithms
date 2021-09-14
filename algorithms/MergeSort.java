package com.algorithms;

public class MergeSort {

	/*
	 * method to sort integers using merge sort
	 */
	public static void calculation() {
		int arr[] = { 87, 19, 33, 25, 69, 7 };

		System.out.println("Given Array");
		printArray(arr);

		sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}

	static void sort(int arr[], int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sort(arr, left, mid);
			sort(arr, mid + 1, right);

			// Merge the sorted halves
			merge(arr, left, mid, right);
		}
	}

	/* function to print array of size n */

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static void merge(int arr[], int left, int mid, int right) {
		
		// Find sizes of two sub arrays to be merged
		
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temp arrays */
		
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		
		for (int i = 0; i < n1; ++i)
			L[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[mid + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second sub arrays
		
		int i = 0, j = 0;

		// Initial index of merged sub array array
		
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

}
