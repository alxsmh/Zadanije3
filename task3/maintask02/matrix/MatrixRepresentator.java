/**
 * Prints results from MatrixExplorer class
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 * @see		by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayRepresentator
 * @see		by.epam.javatraining.shamshur.task3.maintask02.matrix.MatrixExplorer
 * @see		by.epam.javatraining.shamshur.task3.maintask02.matrix.MatrixBuilder
 */

package by.epam.javatraining.shamshur.task3.maintask02.matrix;
import by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayRepresentator;
import by.epam.javatraining.shamshur.task3.maintask02.matrix.MatrixExplorer;
import by.epam.javatraining.shamshur.task3.maintask02.matrix.MatrixBuilder;

public class MatrixRepresentator {
	
	/**
	 * Output matrix to console
	 * @param a int[][]
	 * @see ArrayRepresentator
	 */
	public static void printIntMatrix (int[][] a)
	{
		int exLen = a.length;
		
		for (int i = 0; i < exLen; i++)
		{
			System.out.println("");
			ArrayRepresentator.printIntArray(a[i]);
		}
	}
	
	/**
	 * Print max and min element pos
	 * @param a
	 * @see MatrixExplorer
	 */
	public static void printMinMaxPos(int[][] a)
	{
		System.out.print("\n");
		
		System.out.printf("Max element : %d \n",MatrixExplorer.pickMaxElement(a));
		System.out.printf("Min element : %d \n",MatrixExplorer.pickMinElement(a));
		
		System.out.print("\n");
	}
	
	/**
	 * Print Aritmetic and Geometric AVGs to console
	 * @param a
	 * @see MatrixExplorer
	 */
	public static void printArythmeticGeometricAVG(int[][] a)
	{
		System.out.print("\n");
		
		System.out.printf("Art AVG : %.2f \n",MatrixExplorer.calculateArithmeticAVG(a));
		System.out.printf("Geo AVG : %.2f \n",MatrixExplorer.calculateGeometricAVG(a));
		
		System.out.print("\n");
	}
	
	/**
	 * Print if inputed matrix is symetric 
	 * @param a
	 * @see MatrixExplorer
	 */
	public static void printIsSymmetric(int[][] a)
	{
		System.out.print("\n");
		
		if(MatrixExplorer.isSymetricMatrix(a))
		{
			System.out.print("Symetric matrix");
		}
		else
		{
			System.out.print("Non symetric Matrix");
		}
		
		System.out.print("\n");
	}
	
	/**
	 * Print local extremums
	 * @param a
	 * @see MatrixExplorer
	 */
	public static void printFirstLocalExtremums(int[][] a)
	{
		int [] maxPos = MatrixExplorer.firstLocalMaxPos(a);
		int [] minPos = MatrixExplorer.firstLocalMinPos(a);
		
		//if poses are not found, there be -1 in min or max poses
		if ((maxPos[1] == -1) || (minPos[1] == -1))
		{
			System.out.print("\n");
			
			System.out.print("Extremums not found");
			
			System.out.print("\n");
		}
		else
		{
			int max = MatrixExplorer.pickElement(a, maxPos[0], maxPos[1]);
			int min = MatrixExplorer.pickElement(a, minPos[0], minPos[1]);
			
			System.out.print("\n");
			
			System.out.printf("First Local Maximum : %d; Its pos: x%d y%d \n", max, maxPos[0], maxPos[1]);
			System.out.printf("First Local Minimum : %d; Its pos: x%d y%d \n", min, minPos[0], minPos[1]);
			
			System.out.print("\n");
		
		}	
	}
	
	/**
	 * Prints transpointed matrix
	 * @param a
	 * @see MatrixBuilder
	 */
	public static void printTranspMatrix(int[][] a)
	{
		System.out.print("\n");
		System.out.print("\n-----Transponent-----");
		System.out.print("\n");
		
		printIntMatrix(MatrixBuilder.transponirQuadricMatrix(a));
		
		System.out.print("\n");
	}
	
}
