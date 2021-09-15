package com.datastructure;

import java.util.Scanner;

public class BankCounter {
	Scanner sc =new Scanner(System.in);
	int minBalance=5000;
	
	/*Defining queue*/
	class Queue<T>{
		int queue[]= new int[100];
		int front;
		int rear;
		int size;
		
		public void enqueue(T data) {
			queue[rear]=(int) data;
			rear++;
			size++;
		}
		public int dequeue() {
			int a= queue[front];
			front++;
			size--;
			
			return a;
			
		}
		public int size() {
			return size;
		}
		public boolean isEmpty() {
			return size==0;
		}
		public boolean isFull(){
			return size==100;
		}
	}
	
	Queue queue= new Queue();
	
	/*to put people in queue*/
	public void queuing() {
		
		System.out.println("How many people to add");
		int num=sc.nextInt();
		for(int i=0;i<num;i++) {
			queue.enqueue(i);
		}
		choose(num);
		
	}
    /*function to choose to deposit or withdraw*/

	private void choose(int num) {
		
	int cash=minBalance;
	System.out.println("Available cash "+cash);
	int option =0;
	boolean done=false;
	while(!done) {
		System.out.println("\n1: Withdraw \n2: Deposit");
		option = sc.nextInt();
		switch(option) {
		case 1:System.out.println("Enter the amount to withdraw");
				int amount = sc.nextInt();
				if(amount>cash) {
					System.out.println("Not enough");
				}
				else
					cash= (cash-amount);
				done=true;
				queue.dequeue();
				num--;
				System.out.println("Available cash "+cash);
				
				break;
		case 2:System.out.println("Enter the required amount to deposit");
				int amount1 = sc.nextInt();
				System.out.println("amount deposited successfully");
				queue.dequeue();
				cash = cash + amount1;
				done=true;
				System.out.println("Available cash = " + cash);
				num--;
			
				break;
		default:System.out.println("Invalid input");
				
		}
	}
	
}
		
	
public static void main(String[] args) {
		
		BankCounter counter = new BankCounter();
		counter.queuing();
}


}
