/**
 * Swaps elements in int[]
 * Sorts int[]
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 */

package by.epam.javatraining.shamshur.task3.maintask01.arrayutils;

public class ArrayBuilder {
	
	/**
	 * swap element on xPos with yPos in int[]
	 * @param array 	input array
	 * @param xPos 		position of element
	 * @param yPos 		position to swap with
	 */
	private static int[] swapEl(int[]array, int xPos, int yPos)
	{
		//XOR swap
		array[xPos] = array[xPos] ^ array[yPos];
		array[yPos] = array[xPos] ^ array[yPos];
		array[xPos] = array[xPos] ^ array[yPos];
		
		return array;
	}
	
	/**
	 * Return reversed int[]
	 * @param array	input int[] array
	 */
	public static int[] reverseArray(int[] array)
	{
		//pick array lenght
		int size = array.length;
		
		//swap elements till size => i
		for (int i = 0; i <= size--; i++)
		{
			array = swapEl(array,i,size);
		}
		
		return array;
	}
	
	/**
	 * Sort int[] with bubble method
	 * Sort order: ASC
	 * @param array 	input array
	 */
	public static int[] bubleSortInt(int[] array)
	{
		//variable to detect swaps in sort
		int swaping = 0;
		
		//Length of array -1 to avoid indexOutOfBounds
		int size = array.length - 1;
		
		for (int i = 0; i < size; i++)
		{
			//ascending swap
			if(array[i] > array[i+1])
			{
				array = swapEl(array,i,i+1);
				
				swaping++;
			}
			
			//check if array has swaps and i near end of arrays length
			//drop swaping to 0
			//drop i to -1
			//cicle rides array again
			if ((swaping > 0) & (i + 1 == size))
			{
				swaping = 0;
				i = -1;
			}
		}
		
		return array;
	}
	
	/**
	 * Sort int[] with insertion method
	 * Sort order: ASC
	 * @param array 	input array
	 */
	public static int[] insertionSortInt(int[] array)
	{
		//pick length 
		int size = array.length;
		
		//outbound array
		for (int i = 0; i < size; i++)
		{
			//inbound array
			for (int j = 0; j < i; j++) 
			{
				//ascending sort
				if (array[i] < array[j]) 
				{
					array = swapEl(array, i, j);
				}
			}
		}
		
		return array;
	}
	
	/**
	 * Sort int[] with selection method
	 * Sort order: ASC
	 * @param array 	input array
	 */
	public static int[] selectionSortInt(int[] array)
	{
		//pick length
		int size = array.length;
		
		//starts from 1, compares previous elements
		for (int i = 1; i < size; i++)
		{
		    for (int j = i; j > 0 && array[j-1] > array[j]; j--)
		    {
		    	array = swapEl(array, j, j - 1);
		    }
		}
		
		return array;
	}
	
	/**
	 * Sort int[] with merge method
	 * Sort order: ASC
	 * @param array 	input array
	 * @param size		array size
	 */
	public static int[] mergeSortInt(int[] array, int size)
	{
		//check, if array divided to 1 element
		if (size < 2) 
		{
			return null;
		}
		
		//pick mid position
		int mid = size / 2;
		//make left side array
		int[] l = new int[mid];
		//make right side array
		int[] r = new int[size - mid];
		 
		//fetch values to l and r from array
		for (int i = 0; i < mid; i++) 
		{
			l[i] = array[i];
		}
		for (int i = mid; i < size; i++) 
		{
			r[i - mid] = array[i];
		}
		    
		//sort l and r
		mergeSortInt(l, mid); 
		mergeSortInt(r, size - mid);
		   
		//glue l and r
		merge(array, l, r, mid, size - mid);
		
		return array;
	}
		
	/**
	 * merge branches of array
	 * @param a 	input array
	 * @param l		left part of param a
	 * @param r		right part of param a
	 * @param left	left part index
	 * @param right	right part index
	 */
	private static void merge(int[] a, int[] l, int[] r, int left, int right) 
	{ 
	    int i = 0;
	    int j = 0; 
	    int k = 0;
	    
	    //unite l and r
	    while (i < left && j < right) 
	    {
	        if (l[i] <= r[j]) 
	        {
	            a[k++] = l[i++];
	        }
	        else 
	        {
	            a[k++] = r[j++];
	        }
	    }
	    while (i < left) 
	    {
	        a[k++] = l[i++];
	    }
	    while (j < right) 
	    {
	        a[k++] = r[j++];
	    }
	}
	
	/**
	 * Sort int[] with quickSort method
	 * Sort order: ASC
	 * @param array 	input array
	 * @param low		left index
	 * @param high		right index
	 */
	public static int[] quickSortInt(int[] array, int low, int high)
	{
		//if array is not valid
		if ((array.length == 0) | (array == null))
		{
            return null;
		}
 
		//exit condition
        if (low >= high)
        {
            return null;
        }
 
        //pick middle pos
        int middle = low + (high - low) / 2;
        //pick threshold element on middle pos
        int threshold = array[middle];
 
        //Fetch low and high border
        int i = low; 
        int j = high;
        
        //compute sort criteria
        while (i <= j) 
        {
            while (array[i] < threshold) 
            {
                i++;
            }
 
            while (array[j] > threshold) 
            {
                j--;
            }
            
            //swap element on computed criteria
            if (i <= j) 
            {
            	array = swapEl(array,i,j);
            	
                i++;
                j--;
            }
        }
 
        //if low border lower than j
        //pass to sort j as high border
        if (low < j)
        {
        	array = quickSortInt(array, low, j);
        }
 
        //if high border greater than i
        //pass to sort i as low border
        if (high > i)
        {
        	array = quickSortInt(array, i, high);
        }
 
		return array;
	}

}
