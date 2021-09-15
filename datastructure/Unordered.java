package com.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Unordered {
	
    Node head;
	
	public class Node<T>{
		T data;
		Node next;
		
		Node(T data){
			this.data=data;
			next=null;
		}
		
	}
/*  @ author 
 * reading the unordered file and to an array*/
	
	public  <T> void readFile() {
		Scanner x;
		try {
			x = new Scanner(
					new File("/Users/kshamavidyananda/eclipse-workspace/Algorithms/src/com/datastructure/Unordered.txt"));

			String whole = "";
			while (x.hasNext()) {
				whole = whole + x.next()+" ";
			}
			T[] array =(T[]) whole.split(" ");
			
			for (T t : array) {
				add(t);
				
			}
			x.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	/*adding the word at the last to form a linked list*/

	public  <T> void add(T data) {
		
		
		Node newNode = new Node(data);
			
			if(head==null)
				head=newNode;
			else {
				Node temp;
				temp=head;
				while(temp.next!=null) {
					temp=temp.next;
				}
				temp.next=newNode;
			}
			
		}
		
	/* Printing the list*/
	public  <T> void print() {
		Node temp= head;
		while(temp.next!=null) {
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}

	/*Taking the input from the user*/

	public  <T> void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter word to search search");
		T word=(T) sc.next();
		search(word);
		
	}
	
	/*searching for the word entered by the user*/
   
	private <T> void search(T word) {
		Node temp;
		temp=head;
		while(temp!=null) {
			if(temp.data.equals(word)) {
				delete(word);
				break;
			}
			else {
				temp=temp.next;
			}
			
		}
		if(temp==null) {
			add(word);
		}
		
	}
	
     /*removing the word that has been searched*/
	
	private <T> void delete(T word) {
		
		
		if(word.equals(head.data)) { 
			head=head.next;
			return;
		}
		Node temp=head.next;
		Node cur=head;
		while(temp!=null) {
			
			
			if(temp.data.equals(word)) {
				
				if(temp.next==null) {
					temp=temp.next;
					//cur.next=null;
				}
				else {
					cur.next=temp.next;
					
					temp=temp.next;
				}
			}
			else {
				cur=temp;
				temp=temp.next;
			}
		}
		
	}
	/*@author
	 * to write into the file*/
	
	public void writeFile() {
		try {
			FileWriter writer = new FileWriter("/Users/kshamavidyananda/eclipse-workspace/Algorithms/src/com/datastructure/data/Unorderedresult.txt");
			Node temp;
			temp=head;
			while(temp.next!=null) {
				writer.write(temp.data+" ");
				temp=temp.next;
				
			}
			writer.write(temp.data+"");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public static void main(String[] args) {
		
	Unordered list=new Unordered();
		list.readFile();
		list.print();
		list.input();
		list.print();
		list.writeFile();
	}

}
