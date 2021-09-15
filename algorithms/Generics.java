package com.algorithms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Generics {
	
	static Scanner sc = new Scanner(System.in);

	/**
	 *sorting using bubble sort of type T
	 * 
	 * @param 
	 * @return
	 */
	public static <T extends Comparable<T>> T[] bubbleSort(T[] a) {

		int len = a.length;
		T temp;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		System.out.println("After sorting");
		printArray(a);
		return a;

	}

	/**
	 * sorting using insertion sort of type T
	 * 
	 * @param <T>
	 * @return
	 */
	public static <T extends Comparable<T>> T[] insertionSort(T[] a) {
		T item;
		for (int i = 1; i < a.length; i++) {
			item = a[i];
			int j = i - 1;
			while (j >= 0 && a[j].compareTo(item) > 0) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = item;
		}
		System.out.println("Sorted array");
		printArray(a);
		return a;
	}

	/**
	 * searching the key in the array
	 * 
	 * @param <T>
	 */
	public static <T extends Comparable<T>> void binarySearch(T[] array, T key) {

		//System.out.println("Input for binary search is");
		//printArray(array);

		T[] a = bubbleSort(array);
		int l = 0, r = a.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid].compareTo(key) == 0) {
				System.out.println(key + " found at position " + (mid + 1));
				return;
			}
			if (a[mid].compareTo(key) > 0)
				r = mid - 1;
			else
				l = mid + 1;
		}
		System.out.println("Not found");
	}

	/**
	 * method to read input from file
	 * 
	 * @param <T>
	 * @param 
	 */
	private static <T extends Comparable<T>> void readInput(T key) {

		try {
			sc = new Scanner(new File("/Users/kshamavidyananda/eclipse-workspace/Algorithms/src/com/algorithms/binarysearch.txt"));

			String whole = "";
			while (sc.hasNext()) {
				whole = whole + sc.next() + " ";
			}
			T[] array = (T[]) whole.split(" ");
			sc.close();
			binarySearch(array, key);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return;

	}

	/**
	 * method to print array
	 * 
	 * @param <T>
	 * @param a
	 */
	public static <T> void printArray(T[] arr) {
		for (T t : arr) {
			System.out.print(t + " ");

		}
		System.out.println();
	}

	/*
	 * method to take key element to perform binary search
	 */
	private static <T extends Comparable<T>> void getKey() {

		System.out.println("Enter the key to search");
		T key = (T) sc.next();

		Generics.readInput((T) key);

	}

	public static <T extends Comparable<T>> void mergeSort(T[] a, int beg, int end) {
		if (beg == end) {
			return;
		}
		int mid = (beg + end) / 2;

		mergeSort(a, beg, mid);
		mergeSort(a, mid + 1, end);
		merge(a, beg, mid, end);
	}

	/**
	 * method to merge to array thats split
	 * 
	 * @param a
	 * @param beg
	 * @param mid
	 * @param end
	 */
	public static <T extends Comparable<T>> void merge(T[] a, int lef, int mid, int rig) {
		int n = rig - lef + 1;
		T[] b = (T[]) new Comparable[n];
		int i = lef;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= rig) {
			if (a[i].compareTo(a[j]) < 0) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			b[k] = a[i];
			i++;
			k++;
		}

		while (j <= rig) {
			b[k] = a[j];
			j++;
			k++;
		}

		for (j = 0; j < n; j++) {
			a[lef + j] = b[j];
		}
	}

	public static void main(String[] args) {

		String[] arr1 = { "tomato", "apple", "temple", "blue" };
		Integer[] arr2 = { 8, 34, 76, 1};
		Float[] arr3 = { 56.9f, 34.4f, 12.5f, 44.5f, 44.2f, 1.3f, 123f };

		Generics.bubbleSort(arr1);
		Generics.insertionSort(arr2);
		Generics.mergeSort(arr3, 0, 6);
		Generics.printArray(arr3);
		Generics.getKey();

	}
}



