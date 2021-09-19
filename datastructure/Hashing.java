package com.datastructure;
import java.io.*;

import java.util.Scanner;
import java.util.*;

public class Hashing <T>{
	Node<T>[] array=new Node[11];
	Node<T> next;
	
	
	class Node<T>{
		T data;
		

		Node next;
		
		Node(T data){
			this.data=data;
			

			next=null;
		}
	}
	
	public void add(int data) {
		Node<T> new_Node = new Node(data);
		int index = data % 11;
		if (array[index] == null) {
			array[index] = new_Node;
		}
		else
		{
			Node<T> temp = array[index];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_Node;
		}
	}
	
	public void display() {
		
		System.out.println("Remainder " + "values:-");
		for (int i = 0; i < array.length; i++) {
			Node<T> temp = array[i];
			if (temp != null) {
				System.out.print(" [" + i + "]      {");
				while (temp != null) {
					System.out.print(temp.data + "  ");
					temp = temp.next;
				}
			}
			System.out.println("}");
		}
	}
	
	public void write() {
		try {
            

            FileWriter fWriter = new FileWriter(
            		"/Users/kshamavidyananda/eclipse-workspace/Algorithms/src/com/datastructure/data/Hashingresult.txt");
            
            String text="";
            text="Remainder " + "values:-\n";
            fWriter.write(text);
            
            
            for (int i = 0; i < array.length; i++) {
            	text="";
    			Node<T> temp = array[i];
    			if (temp != null) {
    				

    				text=" [" + i + "] ------->{";
    				while (temp != null) {
    					text=text+temp.data+ " ";
    					//System.out.print(temp.data + "  ");
    					temp = temp.next;
    				}
    				text=text+"}\n";
    				fWriter.write(text);
    			}
    			else if(temp==null) {
    				text=" [" + i + "] ------->\n";
    				fWriter.write(text);
    			}
    			

    		}
            
           

            fWriter.close();
 

            System.out.println(
                "File is created successfully with the content.");
        }
 
        // Catch block to handle if exception occurs
        catch (IOException e) {
            // Print the exception
            System.out.print(e.getMessage());
        }
	}
	public static void main(String[] args) throws Exception
	 {
			Hashing<Integer> hash = new Hashing<Integer>();
			 
			
			 File file =
				      new File("/Users/kshamavidyananda/eclipse-workspace/Algorithms/src/com/datastructure/Hashing.txt");
				    Scanner sc = new Scanner(file);
				    String str;
					String s = "";
					while (sc.hasNextLine()) {
						str=sc.nextLine();
						s=s+str;
					}
					System.out.println(s);
					sc.close();
					String[] arr = s.split(" ");
					int[] arr2 = new int[arr.length];

					
					for (int i = 0; i < arr.length; i++) {
						arr2[i] = Integer.parseInt(arr[i]);
					}
					
					for (int i : arr2) {
						hash.add(i);
						
					}
					
					 try {  
		                 int a = Integer.parseInt(s);  
		        }catch(NumberFormatException ex){  
		            //System.err.println("Invalid string in argumment");  
		            //request for well-formatted string  
		        }  

				hash.write();
			

			hash.display();

		}
	}