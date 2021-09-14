package com.algorithms;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	static Scanner r = new Scanner(System.in);
	public static int binarySearch(String[] splitArray, String word, int length)
	{
		int l = 0;
		int searchTill = length - 1;
        while (l <= searchTill)
        {
            int m = l + (searchTill - l) / 2;
            int pos = -1;
            if(word.compareToIgnoreCase(splitArray[m])==0)
            {
            	pos = 0;
            }
            if(pos == 0)
            {
            	return m;
            }
            if(word.compareToIgnoreCase(splitArray[m])>0)
            {
            	 l = m + 1;
            }
            else
            {
            	searchTill = m - 1;
            }
        }
        return -1;
	}
	

	public static void readFile() {
		BufferedReader buffereader = null;
		try {
			buffereader = new BufferedReader(new FileReader ("/Users/kshamavidyananda/eclipse-workspace/Algorithms/src/com/algorithms/binarysearch.txt"));
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
        Scanner sc = new Scanner(System.in);
        String line = null;
        try {
			while ((line = buffereader.readLine()) != null) 
			{
			  String[] splitArray = line.split(",");
			  Arrays.sort(splitArray);
			  int length = splitArray.length;
			  System.out.println("Enter the word you want to search: ");
			  String word = sc.next();
			  int position = binarySearch(splitArray, word, length);
			  if (position == -1)
			      System.out.println("Sorry, the word '" + word +"' is not present.");
			  else
			      System.out.println("The word '"+word+"' is found at position: " + (position+1));
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        sc.close();
      try {
    	  buffereader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	
}