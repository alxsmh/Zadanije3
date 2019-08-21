/**
 * Prints the results from ArrayExplorer class
 * or int[] array
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 * @see		by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayBuilder;
 * @see		by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayExplorer;
 */
package by.epam.javatraining.shamshur.task3.maintask01.arrayutils;
import by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayBuilder;
import by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayExplorer;

public class ArrayRepresentator {
	
	/**
	 * Prints int[] to console
	 * @param a	int[]
	 */
	public static void printIntArray (int[] a)
	{
		int len = a.length;
		
		for (int i = 0; i < len; i++)
		{
			System.out.printf("%d, ", a[i]);
		}
	}
	
	/**
	 * Print max/min positions
	 * @param a	int[]
	 * @see ArrayExplorer.findExtremumsInIntArray
	 */
	public static void printMinMaxPos(int[] a)
	{
		System.out.print("\n");
		
		int[] pos = ArrayExplorer.findExtremumsInIntArray(a);
		
		System.out.printf("Max element pos : %d \n", pos[1]+1);
		System.out.printf("Min element pos : %d \n", pos[3]+1);
		
		System.out.print("\n");
	}
	
	/**
	 * Prints aritmetic and geometric average of int[]
	 * @param a int[]
	 * @see	ArrayExplorer.findArythmeticAVG
	 * @see ArrayExplorer.findGeometicAVG
	 */
	public static void printArythmeticGeometricAVG(int[] a)
	{
		System.out.print("\n");
		
		System.out.printf("Art AVG : %.2f \n",ArrayExplorer.findArythmeticAVG(a));
		System.out.printf("Geo AVG : %.2f \n",ArrayExplorer.findGeometicAVG(a));
		
		System.out.print("\n");
	}
	
	/**
	 * Print if int[] sorted
	 * @param a int[]
	 * @see ArrayExplorer.checkArraySort
	 */
	public static void printIsSorted(int[] a)
	{
		switch(ArrayExplorer.checkArraySort(a))
		{
			case 0: System.out.print("\n Sorted Ascending"); break;
			
			case 1: System.out.print("\n Sorted Descending"); break;
			
			default: System.out.print("\nNot sorted"); break;
		}
	}
	
	/**
	 * Print first local extremums
	 * @param a	int[]
	 * @see	ArrayExplorer.firstLocalMaxPos
	 * @see ArrayExplorer.firstLocalMinPos
	 */
	public static void printLocalExtremumPos(int[] a)
	{
		int maxPos = ArrayExplorer.firstLocalMaxPos(a);
		int minPos = ArrayExplorer.firstLocalMinPos(a);
		
		if ((maxPos == -1) || (minPos == -1))
		{
			System.out.print("\n");
			
			System.out.print("Extremums not found");
			
			System.out.print("\n");
		}
		else
		{
			int max = a[maxPos];
			int min = a[minPos];
			
			System.out.print("\n");
			
			System.out.printf("First Local Maximum : %d; Its pos: %d \n", max, maxPos);
			System.out.printf("First Local Minimum : %d; Its pos: %d \n", min, minPos);
			
			System.out.print("\n");
		}
	}
	
	/**
	 * Print result of search
	 * if	(int): element fount print its position
	 * else	(-1) : not found message
	 * @param result	position
	 */
	public static void printSearchResult(int result)
	{
		if (result == -1)
		{
			System.out.print("\nNot Found");
		}
		else
		{
			System.out.printf("\nSucsess. Result position: %d", result);
		}
	}

	/**
	 * Print result of binary search
	 * @param a			int[]
	 * @param lookup	value to search
	 * @see ArrayExplorer.binarySearch
	 */
	public static void printBinary(int[] a, int lookup)
	{
		System.out.println("\nBinary search for array\n");
		printSearchResult(ArrayExplorer.binarySearch(a, lookup));
	}
	
	/**
	 * Print result of linear search
	 * @param a			int[]
	 * @param lookup	value to search
	 * @see ArrayExplorer.linearSearch
	 */
	public static void printLinear(int[] a, int lookup)
	{
		System.out.println("\nLinear search for array\n");
		printSearchResult(ArrayExplorer.linearSearch(a, lookup));
	}
	
	/**
	 * Print int[] with text
	 * @param text	text to print
	 * @param a		array to print
	 * @see printIntArray
	 */
	public static void printMasWithText(String text, int[] a)
	{
		System.out.println(text);
		printIntArray(a);
	}

	/**
	 * Print reversed int[]
	 * @param a	int[]
	 * @see	ArrayBuilder.reverseArray
	 */
	public static void printReversed(int[] a)
	{
		System.out.print("\nReversed:  ");
		
		printIntArray(ArrayBuilder.reverseArray(a));
		
		System.out.print("\n");
	}
	
	
}
