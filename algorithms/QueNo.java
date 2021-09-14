package com.algorithms;

import java.util.Scanner;

public class QueNo {
	static int num;
	public static void findNum() {
		
		
		System.out.println("Enter a number between range 0 and N-1)");
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		System.out.println("Answer in yes, low, high");
		
		int low = 0;
		int high = num ;
		while (low <= high) {
			int middle = (low + high) / 2;
			System.out.println("Is your number " + middle + " ?");
			String input = sc.next();
			input = input.toLowerCase();
			if (input.equals("yes")) {
				System.out.println("Your number is " + middle);
				break;
			} else if (input.equals("low")) {
				high = middle - 1;
			}

			else if (input.equals("high")) {
				low = middle + 1;
			}
		}
		
	}
}
