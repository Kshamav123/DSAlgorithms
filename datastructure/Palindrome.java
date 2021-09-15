package com.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
	public static void checkPalindrome(String word) {
		Stack stack = new Stack();
	
		char arr[] = word.toCharArray();//converting to array
		for (char l: arr) {
			stack.push(l);
		}
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str = str + stack.pop();
		}
		if (word.equals(str)) {
			System.out.println("palindrome");
		} else {
			System.out.println("not a palidrome");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the word ");
		String word = sc.nextLine();
		
		checkPalindrome(word);
	}
	}

