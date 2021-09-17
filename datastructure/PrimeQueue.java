package com.datastructure;

import java.util.Arrays;

class QueueLL<T> {
	Node<T> front;
	Node<T> rear;
	int count = 0;

	class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	/*
	 * Queue constructor
	 */
	public QueueLL() {
		this.front = null;
		this.rear = null;
	}

	/*
	 * Enqueue the item
	 */
	public void enqueue(T item) {
		Node<T> temp = new Node<T>(item);
		if (rear == null) {
			front = temp;
			rear = temp;
			count++;
			return;
		}
		rear.next = temp;
		rear = temp;
		count++;
	}

	/*
	 * Display the Queue data
	 */

	public void display() {
		Node<T> node = this.front;
		while (node.next != null) {
			System.out.println( node.data);
			node = node.next;
		}
		System.out.print("Data :" + node.data);
	}
}

public class PrimeQueue {

	public void queueAnagram() {

		QueueLL<String> q = new QueueLL<>();
		String[] primeNumbers = prime(1000);

		for (int i = 0; i < primeNumbers.length; i++) {
			for (int j = i + 1; j < primeNumbers.length; j++) {
				if (anagram(primeNumbers[i], primeNumbers[j])) {
					q.enqueue(primeNumbers[i]);
					q.enqueue(primeNumbers[j]);
				}
			}
		}
		q.display();

	}

	public String[] prime(int range) {
		int position = 0;
		String[] array = new String[1000];
		for (int i = 2; i <= range; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= i / 2; j++) {
				if ((i % j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				array[position] = String.valueOf(i);
				position++;

			}
		}
		String[] returnArray = new String[position];
		for (int k = 0; k < position; k++) {
			returnArray[k] = array[k];
		}
		return returnArray;

	}

	public boolean anagram(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		char[] array1 = string1.toCharArray();
		Arrays.sort(array1);
		char[] array2 = string2.toCharArray();
		Arrays.sort(array2);

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PrimeQueue queue = new PrimeQueue();
		queue.queueAnagram();

	}
}
