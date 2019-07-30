/**
 * Holds methods to input matrix[][]
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 * @see		by.epam.javatraining.shamshur.task3.maintask01.input.InputArray
 */
package by.epam.javatraining.shamshur.task3.maintask02.input;
import by.epam.javatraining.shamshur.task3.maintask01.input.InputArray;

public class InputMatr {
	
	/**
	 * Generate matrix with sizes x,y and random values
	 * @param 	x	rows
	 * @param 	y	columns
	 * @return	int[][]
	 * @see InputArray.randomIntArray
	 */
	public static int[][] inputRandomMatr(int x, int y)
	{
		int [][] matr = new int[x][y];
		
		for (int i = 0; i < x; i++)
		{
			matr[i] = InputArray.randomIntArray(y);
		}
		
		return matr;
	}
	
	/**
	 * Construct matrix with sizes x,y and user values
	 * @param 	x	rows
	 * @param 	y	columns
	 * @return	int[][]
	 * @see InputArray.consoleIntArray
	 */
	public static int[][] inputConsoleMatr(int x, int y)
	{
		int [][] matr = new int[x][y];
		
		for (int i = 0; i < x; i++)
		{
			matr[i] = InputArray.consoleIntArray(y);
			System.out.println("\n\n");
		}
		
		return matr;
	}
}
