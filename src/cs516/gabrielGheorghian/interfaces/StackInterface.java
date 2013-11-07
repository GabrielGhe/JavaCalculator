/**
 * Gabriel Gheorghian
 * @author 0737019
 * Lab 2
 */
package cs516.gabrielGheorghian.interfaces;

import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;

public interface StackInterface<T> {
	
	/**
	 * adds element to the end of the array
	 * @param t object you wish to push at the end of the array
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException 
	 */
	void addLast(T t) throws DAIllegalArgumentException, DAIndexOutOfBoundsException; // adds to end of array
	
	
	/**
	 * removes last element and returns it
	 * @return T the object you removed from the end of the array and returned
	 * @throws DAIndexOutOfBoundsException 
	 */
	T removeLast() throws DAIndexOutOfBoundsException; // removes last in array
	
	
	/**
	 * returns the last element without removing it
	 * @return T object that is placed at the end of the array
	 * @throws DAIndexOutOfBoundsException 
	 */
	T getLast() throws DAIndexOutOfBoundsException; // returns at last element in array 
	
	
	/**
	 * returns the size of the array
	 * @return size the size of the array
	 */
	int getSize();
}
