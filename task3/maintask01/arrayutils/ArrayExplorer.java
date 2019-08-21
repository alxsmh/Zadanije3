/**
 * Explores array on extremums, local extremums,
 * finds aritmetic and geometric AVG, 
 * computes sum and multiplication of array elements
 * checks if array is sorted in ASC/DESC order
 * performs linear and binary searches
 * @author 	Shamshur Aliaksandr
 * @version	1.0
 * @date	29.07.2019
 */

package by.epam.javatraining.shamshur.task3.maintask01.arrayutils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayExplorer 
{
	/**
	 * Log variable
	 */
	private static final Logger LOG = LogManager.getLogger(ArrayExplorer.class);
	
	/**
	 * find max/min element and its position
	 * @param array
	 * @return extremum[]
	 */
	public static int[] findExtremumsInIntArray(int[] array)
	{
		//ouput array
		//extrem[0] : max element value
		//extrem[1] : max element pos
		//extrem[2] : min element value
		//extrem[3] : min element pos
		int[] extrem = new int[4];
		
		//pick length
		int size = array.length;
		
		//fetch max/min element array[0] value
		extrem[0]=array[0];
		extrem[2]=array[0];
		
		//look up max/min elemnts 
		//fetch them to extrem[]
		for (int i = 0; i < size; i++)
		{
			if (extrem[0] < array[i])
			{
				extrem[0] = array[i];
				extrem[1] = i;
			}
			else if (extrem[2] > array[i])
			{
				extrem[2] = array[i];
				extrem[3] = i;
			}
		}
		
		//if no extremums return {-1}
		if (extrem[0] == extrem[2])
		{
			LOG.warn("extremums not found");
			return new int[] {-1};
		}
		
		return extrem;
	}
	
	/**
	 * Compute arithmetic average in int[]
	 * @param array
	 * @return	arithmetic average
	 * @see		sumInArray
	 */
	public static double findArythmeticAVG(int[] array)
	{
		//pick length
		int size = array.length;
		
		//get sum of array elements and divide them on array length
		return (double)sumIntArray(array)/(double)size;
	}
	
	/**
	 * Compute geometric average in int[]
	 * @param array
	 * @return	geometric average
	 */
	public static double findGeometicAVG(int[] array)
	{
		//pick length
		double size = array.length;
		//compute sqr pow 
		double power = 1 / size;
		
		//get multiplication of array elements and power it
		return Math.pow(mulIntArray(array), power);
	}
	
	/**
	 * Compute sum of elements in int[]
	 * @param array
	 * @return sum of elements
	 */
	public static int sumIntArray(int[] array)
	{
		int size = array.length;
		int sum = 0;
		
		while(--size >= 0)
		{
			sum += array[size];
		}
		
		return sum;
	}
	
	/**
	 * Compute multiplication of elements in int[]
	 * @param array
	 * @return	multiplication
	 */
	public static double mulIntArray(int[] array)
	{
		//pick length
		int size = array.length;
		//set first multiplicator as 1 to avoid 0 result
		int mul = 1;
		
		while(--size >= 0)
		{
			mul *= array[size];
		}
		
		return mul;
	}
	
	/**
	 * Check if int[] sorted in ASC/DESC order
	 * @param array
	 * @return	0 	ASC
	 * @return	1 	DESC
	 * @return	-1 	Not sorted properly
	 */
	public static int checkArraySort(int[] array)
	{
		//return codes
		int ascendingSorted = 0;
		int descendingSorted = 1;
		int notSorted = -1;
		
		//counters for DESC/ASC sort
		int depos = 0;
		int apos = 0;
		
		//pick length
		int size = array.length - 1;
		
		//ride array and incriment depos//apos
		for (int i = 0; i < size; i++)
		{
			if(array[i]>array[i+1])
			{
				depos++;
			}
			if(array[i]<array[i+1])
			{
				apos++;
			}
		}
		
		//check block
		//if apos or depos equals array size - array is sorted
		if(apos == size)
		{
			//0
			return ascendingSorted;
		}
		
		if(depos == size)
		{
			//1
			return descendingSorted;
		}
		
		LOG.warn("array not sorted");
		//else return -1
		return notSorted;
	}

	/**
	 * Find first local minimum position
	 * @param array
	 * @return first local minimum position
	 * @return -1	if not found
	 */
	public static int firstLocalMinPos(int[] array)
	{
		int i = 0;
		int len = array.length;
		
        for (; i < len; i++) 
        {
            if (array[i] < (i > 0 ? array[i - 1] : Integer.MAX_VALUE)
                    && array[i] < (i < array.length - 1 ? array[i + 1] : Integer.MAX_VALUE)) 
            {
                return i;
            }
        }
        LOG.warn("local min not found");
        //if not found -1
		return -1;
	}
	
	/**
	 * Find first local maximum position
	 * @param array
	 * @return first local maximum position
	 * @return -1	if not found
	 */
	public static int firstLocalMaxPos(int[] array)
	{
		int i = 0;
		int len = array.length;
		
        for (; i < len; i++) 
        {
            if (array[i] > (i > 0 ? array[i - 1] : Integer.MIN_VALUE)
                    && array[i] > (i < len - 1 ? array[i + 1] : Integer.MIN_VALUE)) 
            {
                return i;
            }
        }
        LOG.warn("local max not found");
        //if not found -1
		return -1;
	}
	
	/**
	 * Perform linear search
	 * @param array	int[]
	 * @param value	search value
	 * @return		position of searched value
	 * @return		-1	if not found
	 */
	public static int linearSearch(int[] array, int value)
	{
		int size = array.length;
		
		//search from end to begin
		while (--size > 0)
		{
			if(array[size] == value)
			{
				return size;
			}
		}
		
		//-1 if value not found
		LOG.warn("value not found");
		return -1;
	}
	
	/**
	 * Perform binary search
	 * @param array int[]
	 * @param value	search value
	 * @return		position of searched value
	 * @return		-1	if not found
	 */
	public static int binarySearch(int[] array, int value)
	{
		int last = array.length - 1;
		int first = 0;
		
		//search
		while (first <= last)
		{
			//pick mid position
			int center = (first + last) / 2;
			
			if (array[center] == value)
			{
				return center;
			}
			
			if (array[center] > value)
			{
				last = center - 1;
			}
			else
			{
				first = center + 1;
			}
		}
		LOG.warn("value not found");
		//-1 if value not found
		return -1;
	}
}
