/**
 * Calls methods that are needed to perform task3 part 2
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 * @see		by.epam.javatraining.shamshur.task3.maintask02.input.InputMatr
 * @see		by.epam.javatraining.shamshur.task3.maintask02.matrix.MatrixRepresentator
 */
package by.epam.javatraining.shamshur.task3.maintask02.controller;
import by.epam.javatraining.shamshur.task3.maintask02.input.InputMatr;
import by.epam.javatraining.shamshur.task3.maintask02.matrix.MatrixRepresentator;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.print("Input 3x3 elements of int matrix\n");
		//input block
		//to use keyboard input - uncomment 20th string, but comment 21th 
		//int[][] matr = InputMatr.inputConsoleMatr(3, 3);
		int[][] matr = InputMatr.inputRandomMatr(3, 3);
		
		//output inputed matrix
		System.out.print("INPUTED MATRIX\n");
		MatrixRepresentator.printIntMatrix(matr);
		
		//print max/min element positions
		MatrixRepresentator.printMinMaxPos(matr);
		
		//print ari/geo average
		MatrixRepresentator.printArythmeticGeometricAVG(matr);
		
		//print if matrix is symetric
		MatrixRepresentator.printIsSymmetric(matr);
		
		//print first local extremums
		MatrixRepresentator.printFirstLocalExtremums(matr);
		
		//print transponired matrix
		MatrixRepresentator.printTranspMatrix(matr);
	}
	
}
