package com.algorithms;

public class BubbleSort {
	
	/* sorting the integers using bubble sort*/
	
	public static void sort() {
		int arr[] = {34, 12, 78, 8, 54, 37, 89};
		 int n = arr.length;
	        for (int i = 0; i < n-1; i++)//no. of itterations 
	            for (int j = 0; j < n-i-1; j++)//each element is compared and swapped
	                if (arr[j] > arr[j+1])
	                {
	                    
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	}

}
