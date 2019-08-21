/**
 * Calls methods that are needed to perform task3 part 1
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 * @see		by.epam.javatraining.shamshur.task3.maintask01.input.InputArray;
 * @see		by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayBuilder;
 * @see		by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayRepresentator;
 */
package by.epam.javatraining.shamshur.task3.maintask01.controller;

import by.epam.javatraining.shamshur.task3.maintask01.input.InputArray;
import by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayBuilder;
import by.epam.javatraining.shamshur.task3.maintask01.arrayutils.ArrayRepresentator;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//may insert keyboard input of size
		int size = 10;
		
		System.out.printf("Input %d elements of int array\n", size);
		
		//27th string: console input, 28th: random generation
		//int [] array = InputArray.consoleIntArray(size);
		int [] array = InputArray.randomIntArray(size);
		
		//output inputed array
		ArrayRepresentator.printMasWithText("INPUTED ARRAY:", array);
		
		//print min/max positions
		ArrayRepresentator.printMinMaxPos(array);
		
		//print ari/geo avg values of array
		ArrayRepresentator.printArythmeticGeometricAVG(array);
		
		//print if array ASC/DESC sorted or not
		ArrayRepresentator.printIsSorted(array);
		
		//print local extremums
		ArrayRepresentator.printLocalExtremumPos(array);
		
		//asks user to input search value
		System.out.print("\nInput number to search in array\n");
		int search = InputArray.consoleIntArray(1)[0];
		
		//output search result
		ArrayRepresentator.printLinear(array, search);
		ArrayRepresentator.printBinary(array, search);
		
		//print array as reversed
		ArrayRepresentator.printReversed(array);
		
		//SORTS
		//ArrayRepresentator.printMasWithText("\nBUBBLE SORT:", ArrayBuilder.bubleSortInt(array));
		//ArrayRepresentator.printMasWithText("\nINSERT SORT:", ArrayBuilder.insertionSortInt(array));
		ArrayRepresentator.printMasWithText("\nSELECT SORT:", ArrayBuilder.selectionSortInt(array));
		//ArrayRepresentator.printMasWithText("\nMERGE  SORT:", ArrayBuilder.mergeSortInt(array,array.length));
		//ArrayRepresentator.printMasWithText("\nQUICK  SORT:", ArrayBuilder.quickSortInt(array, 0, array.length-1));
		
		
	}

}
