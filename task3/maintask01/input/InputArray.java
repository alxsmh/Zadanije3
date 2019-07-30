/**
 * Input int[] array in random or console way
 * or int[] array
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 */
package by.epam.javatraining.shamshur.task3.maintask01.input;

import java.util.Random;
import java.util.Scanner;

public class InputArray {
	
	//random generation
	
	//int[]
	/**
	 * Generate int[] with random elements
	 * @param size	size of int[] to generate
	 * @return	int[]
	 * @see java.util.Random
	 */
	public static int[] randomIntArray(int size)
	{
		//tandom number block
		Random rand = new Random();
		int seed = 150;
		int balancer = 50;
		//
		
		//array to return
		int mas[] = new int[size];
		
		//fetch values  from end to begin
		while(--size >= 0)
		{
			mas[size] = rand.nextInt(seed) - balancer;
		}
		
		return mas;
	}
	
	/**
	 * Console manual array input
	 * @param size	size of int[] to construct
	 * @return	int[]
	 * @see java.util.Scanner
	 */
	public static int[] consoleIntArray(int size)
	{
		//input scanner
		Scanner in = new Scanner(System.in);
		
		//array to return
		int[] mas = new int[size];
		
		//fetch values to array from console input
		for (int i = 0; i < size; i++)
		{
			mas[i] = in.nextInt();
		}
		
		//close input stream
		in.close();
		
		return mas;
	}

}
