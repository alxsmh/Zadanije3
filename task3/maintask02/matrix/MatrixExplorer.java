/**
 * Explores int[][] for:
 * - max element and its pos
 * - min element and its pos
 * - aritmetic and geometric averages
 * - sum of elements
 * - multiplication of elements
 * - is matrix symetric and quadric
 * - first local min pos
 * - first local max pos
 * Aso contains methods to:
 * - compare int[] arrays
 * - get main and nonmain diagonal from int[][]
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 * @see		by.epam.javatraining.shamshur.task3.maintask01.arrayutils.*
 */
package by.epam.javatraining.shamshur.task3.maintask02.matrix;
import by.epam.javatraining.shamshur.task3.maintask01.arrayutils.*;

public class MatrixExplorer 
{
	/**
	 * Find max element position
	 * @param array int[][]
	 * @return	int[0]	row pos
	 * @return	int[1]	cell pos
	 */
	public static int[] maxPos(int[][] array)
	{
		int[] maxPos = new int[2];
		
		int extLen = array.length;
		int inbLen = array[0].length;
		
		//fetch poses
		for (int i = 0; i < extLen; i++)
		{
			for (int j = 0; j < inbLen; j++)
			{
				if(array[i][j] > array[maxPos[0]][maxPos[1]])
				{
					maxPos[0] = i;
					maxPos[1] = j;
				}
			}
		}
		
		return maxPos;
	}
	
	/**
	 * Find min element position
	 * @param array	int[][]
	 * @return	int[0]	row pos
	 * @return	int[1]	cell pos
	 */
	public static int[] minPos(int[][] array)
	{
		int[] minPos = new int[2];
		
		int extLen = array.length;
		int inbLen = array[0].length;
		
		//fetch minimal element positions
		for (int i = 0; i < extLen; i++)
		{
			for (int j = 0; j < inbLen; j++)
			{
				if(array[i][j] < array[minPos[0]][minPos[1]])
				{
					minPos[0] = i;
					minPos[1] = j;
				}
			}
		}
		
		return minPos;
	}
	
	/**
	 * Pick element in int[][]
	 * @param array	int[][]
	 * @param x		row number
	 * @param y		cel number
	 * @return		int element
	 */
	public static int pickElement(int[][] array, int x, int y)
	{
		return array[x][y];
	}
	
	/**
	 * Return max element
	 * @param array	int[][]
	 * @return	int max elment
	 * @see maxPos
	 */
	public static int pickMaxElement(int[][] array)
	{
		int[] pos = maxPos(array);
		
		return pickElement(array, pos[0], pos[1]);
	}
	
	/**
	 * Return min element
	 * @param array	int[][]
	 * @return	int min elment
	 * @see minPos
	 */
	public static int pickMinElement(int[][] array)
	{
		int[] pos = minPos(array);
		
		return pickElement(array, pos[0], pos[1]);
	}
	
	/**
	 * Calculate aritmetic average of matrix
	 * @param array	int[][]
	 * @return	double aritmetic average of matrix
	 * @see sumMatrix
	 * @see calculateMatrixSize
	 */
	public static double calculateArithmeticAVG(int[][] array)
	{
		return (double)sumMatrix(array)/calculateMatrixSize(array);
	}
	
	/**
	 * Calculate geometric average of matrix
	 * @param array	int[][]
	 * @return	double geometric average of matrix
	 * @see mulMatrix
	 * @see calculateMatrixSize
	 */
	public static double calculateGeometricAVG(int[][] array)
	{
		return Math.pow(mulMatrix(array), (double)1/calculateMatrixSize(array));
	}
	
	/**
	 * Computes sum of matrix elements
	 * @param array	int[][]
	 * @return		sum(int[][])
	 * @see ArrayExplorer.sumIntArray
	 */
	public static int sumMatrix(int[][] array)
	{
		int exSize = array.length;
		
		int sum = 0;
		
		for (int i = 0; i < exSize; i++)
		{
			sum += ArrayExplorer.sumIntArray(array[i]);
		}
		
		return sum;
	}
	
	/**
	 * Computes multiplication of matrix elements
	 * @param array	int[][]
	 * @return		sum(int[][])
	 * @see ArrayExplorer.mulIntArray
	 */
	public static double mulMatrix(int[][] array)
	{
		int exSize = array.length;
		
		double mul = 1;
		
		for (int i = 0; i < exSize; i++)
		{
			mul *= ArrayExplorer.mulIntArray(array[i]);
		}
		
		return mul;
	}
	
	private static int calculateMatrixSize(int[][] array)
	{
		return array.length * array[0].length;
	}
	
	public static boolean isSymetricMatrix(int[][] array)
	{
		if (isQuadric(array)) 
		{
			return compareArrays(calculateMainDiagonal(array), calculateNonMainDiagonal(array));
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isQuadric(int[][] array)
	{	
		int rowSize = array.length;
		int colSize = array[0].length;
		
		if (rowSize != colSize)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public static int[] calculateMainDiagonal(int[][] array)
	{
		int rowSize = array.length;
		
		int[] diagArr = new int[rowSize];
		
		while (--rowSize > 0)
		{
			diagArr[rowSize] = array[rowSize][rowSize];
		}
		
		return diagArr;
	}
	
	public static int[] calculateNonMainDiagonal(int[][] array)
	{
		int rowSize = array.length;
		int colSize = 0;
		
		int[] diagArr = new int[rowSize];
		
		while (--rowSize > 0)
		{
			diagArr[rowSize] = array[rowSize][colSize++];
		}
		
		return diagArr;
	}
	
	public static boolean compareArrays(int[] a, int[] b)
	{
		if (a.length != b.length)
		{
			return false;
		}
		else
		{
			int size = a.length;
			
			while (--size > 0)
			{
				if(a[size] != b[size])
				{
					return false;
				}
			}
		}
		
		return false;
	}
	
	public static int[] firstLocalMinPos(int[][] array)
	{
		int rowSize = array.length;
		
		int[] pos = new int[] {-1, -1};
		
		for (int i = 0; i < rowSize; i++)
		{
			pos[1] = ArrayExplorer.firstLocalMinPos(array[i]);
			
			if (pos[1] != -1)
			{
				pos[0] = i;
				
				i = rowSize;
			}
		}
		
		return pos;
		
	}
	
	public static int[] firstLocalMaxPos(int[][] array)
	{
		int rowSize = array.length;
		
		int[] pos = new int[] {-1, -1};
		
		for (int i = 0; i < rowSize; i++)
		{
			pos[1] = ArrayExplorer.firstLocalMaxPos(array[i]);
			
			if (pos[1] != -1)
			{
				pos[0] = i;
				
				i = rowSize;
			}
		}
		
		return pos;
		
	}
	
}
