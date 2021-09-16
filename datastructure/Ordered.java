package com.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ordered<T> {

	Node head;
	static Scanner r = new Scanner(System.in);

	private class Node<T extends Comparable<T>> {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			next = null;
		}

	}

	public <T extends Comparable<T>> int getSize() {
		int count = 0;
		if (head == null) {
			return 0;
		} else {

			Node<T> temp = head;
			while (temp != null) {
				count++;
				temp = temp.next;

			}
		}
		return count;
	}

	public <T extends Comparable<T>> T get(int index) {
		Node<T> temp = head;
		Node<T> prev = null;

		for (int i = 0; i <= index; i++) {
			prev = temp;
			temp = temp.next;
		}
		return (T) prev.data;
	}

	private <T extends Comparable<T>> void addNormal(T input) {
		Node newNode = new Node(input);

		if (head == null)
			head = newNode;
		else {
			Node temp;
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}

	}

	public <T extends Comparable<T>> void add(T data) {
		
		Node<T> newNode = new Node<T>(data);
		if (head == null || head.data.compareTo(data) > 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null && temp.next.data.compareTo(data) < 0) {
				temp = temp.next;

			}
			newNode.next = temp.next;
			temp.next = newNode;
		}

	}

	public <T extends Comparable<T>> void pop(T input) {

		if (input.equals(head.data)) {
			head = head.next;
			return;
		}
		Node temp = head.next;
		Node cur = head;
		while (temp != null) {

			if (temp.data.equals(input)) {
				if (temp.next == null) {
					temp = temp.next;
					cur.next = null;
				} else {
					cur.next = temp.next;

					temp = temp.next;
				}
			} else {
				cur = temp;
				temp = temp.next;
			}
		}

	}

	public static <T extends Comparable<T>> T userInput() {

		T key = (T) r.next();
		return key;

	}

	public <T extends Comparable<T>> boolean searchInput(T input) {
		boolean flag = true;
		Node temp;
		temp = head;
		while (temp != null) {
			if (temp.data.equals(input)) {

				flag = false;
				pop(input);

				break;
			} else {
				temp = temp.next;
			}

		}
		return flag;

	}

	public <T extends Comparable<T>> void display() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	public <T extends Comparable<T>> T[] bubbleSort(T[] a) {

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
		for (T t : a) {
			addNormal(t);

		}

		System.out.println("Sorted array");
		printArray(a);

		return a;
	}

	public static <T extends Comparable<T>> void printArray(T[] a) {
		for (T t : a) {
			System.out.print(t + " ");

		}
		System.out.println();
	}

	public void write() {
		try {

			FileWriter fWriter = new FileWriter(
					"/Users/kshamavidyananda/eclipse-workspace/Algorithms/src/com/datastructure/data/Orderedresults.txt");

			String text = "";


			Node temp;
			temp = head;
			while (temp.next != null) {
				text = text + temp.data + "----->";
				temp = temp.next;
			}
			text = text + temp.data;
			fWriter.write(text);

			fWriter.close();

			System.out.println("File is created successfully with the content.");
		}

		catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner r = new Scanner(System.in);
		File file = new File(
				"/Users/kshamavidyananda/eclipse-workspace/Algorithms/src/com/datastructure/Orderedlist.txt");
		Scanner sc = new Scanner(file);
		Ordered list = new Ordered();
		String str;
		String s = "";
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			s = s + str;
		}
		sc.close();
		String[] arr = s.split(" ");
		Integer[] array = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(array.getClass());
		list.bubbleSort(array);

		System.out.println("Enter the element to be added or deleted");
		Integer user = r.nextInt();
		boolean b = list.searchInput(user);
		if (b) {
			list.add(user);
		}
		list.write();
		list.display();

	}

}