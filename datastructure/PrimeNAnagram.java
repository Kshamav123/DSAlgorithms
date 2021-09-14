package com.datastructure;

import java.util.Arrays;

public class PrimeNAnagram {
	static int array[][] = new int[10][100];
	static int prime[][] = new int[10][100];
	static int anagram[][] = new int[10][100];
	static int notanagram[][] = new int[10][100];

	public static void primeArray() {

		int temp = 1;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				array[i][j] = temp;
				temp++;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (checkPrime(array[i][j])) {
					prime[i][j] = array[i][j];
				} else {
					prime[i][j] = 0;
				}
			}
		}
		/* Printing the prime numbers */

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (prime[i][j] != 0) {
					System.out.print(prime[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static boolean checkPrime(int num) {

		boolean flag = true;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	/* Logic for anagram */
	public static boolean anagram(String string1, String string2) {
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
	/* segregating anagram and non anagram */

	public static void isAnagram() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (prime[i][j] != 0) {
					for (int k = j + 1; k < 100; k++) {
						if (prime[i][k] != 0 && anagram(String.valueOf(prime[i][j]), String.valueOf(prime[i][k]))) {
							anagram[i][j] = prime[i][j];
							anagram[i][k] = prime[i][k];

						}
					}
				}
			}
		}

		/* Moving the values from prime array to not anagram array */

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {

				if (prime[i][j] != anagram[i][j]) {
					notanagram[i][j] = prime[i][j];

				}
			}

		}

	}
	/* To print the anagram */

	public static void printAnagrams() {
		System.out.println("Anagrams are");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (anagram[i][j] != 0) {
					System.out.print(anagram[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

	/* To print the not anagram */

	public static void printnotAnagram() {
		System.out.println("Non Anagrams are");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (notanagram[i][j] != 0) {
					System.out.print(notanagram[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		primeArray();
		isAnagram();
		printAnagrams();
		printnotAnagram();

	}

}
