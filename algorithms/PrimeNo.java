package com.algorithms;

import java.util.Scanner;

public class PrimeNo {
	public static void prime() {
		// range
		int min = 2;
		System.out.println("Enter the range");
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();

		// find all prime numbers in the given range
		for (int n = min; n <= max; n++) {
			// check if this number is prime
			if (isPrime(n)) {
				System.out.println(n);
			}
		}
	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= num / i; ++i) {
			if (num % i == 0) {
				return false;
			}

		}
		return true;
	}
}
