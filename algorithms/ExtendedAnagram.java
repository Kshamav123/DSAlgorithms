package com.algorithms;

import java.util.Scanner;

public class ExtendedAnagram {
	
	public static void extended() {
		for (int i = 2; i <= 100; i++) {
			boolean flag = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				palindrome(i);
			}
		}
	}
	private static void palindrome(int i) {
		int remainder, num, reversedNum = 0;
		num = i;
		int count = 0;
		while (i != 0) {
			remainder = i % 10;
			reversedNum = reversedNum * 10 + remainder;
			i = i / 10;
			count++;

		}
		if (num == reversedNum && count > 1) {
			System.out.print(num + " ");
		}
	}
	}
