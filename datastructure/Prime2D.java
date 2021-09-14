package com.datastructure;

public class Prime2D {
	
	public static void primeArray() {
		
		int array[][] = new int[10][100];
		int prime[][] = new int[10][100];
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

	public static void main(String[] args) {
		
		primeArray();

	}
}
