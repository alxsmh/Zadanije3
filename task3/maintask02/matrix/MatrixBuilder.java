/**
 * Holds methods to build transponired matrix
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 */
package by.epam.javatraining.shamshur.task3.maintask02.matrix;

public class MatrixBuilder {
	
	/**
	 * Return transponired !quadric! matrix 
	 * @param 	array	int[][]
	 * @return	int[][]
	 */
	public static int[][] transponirQuadricMatrix(int[][] array)
	{
		int size = array.length;
			
		for(int i = 0; i < size; i++)
		{
			//switch elements in row and column by XOR way
			for(int j = i+1; j < size; j++)
			{
				array[i][j] = array[i][j] ^ array[j][i];
				array[j][i] = array[i][j] ^ array[j][i];
				array[i][j] = array[i][j] ^ array[j][i];
			}
		}
		
		return array;
	}
}
