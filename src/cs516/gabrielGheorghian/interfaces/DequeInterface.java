/**
 * Gabriel Gheorghian
 * @author 0737019
 * Lab 2
 */
package cs516.gabrielGheorghian.interfaces;

import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;


public interface DequeInterface<T> {
	
	/**
	 * adds element to the front of the array
	 * @param t the object you want to push at the front of the array
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 */
	void addFront(T t) throws DAIllegalArgumentException, DAIndexOutOfBoundsException; // add to front
	
	
	/**
	 * adds element to the end of the array
	 * @param t object you wish to push at the end of the array
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException 
	 */
	void addLast(T t) throws DAIllegalArgumentException, DAIndexOutOfBoundsException; // add to end
	
	
	/**
	 * removes first element in array and returns it
	 * @return T the object you removed from the front of the array and returned
	 * @throws DAIndexOutOfBoundsException 
	 */
	T removeFront() throws DAIndexOutOfBoundsException; // remove from front
	
	
	/**
	 * removes last element and returns it
	 * @return T the object you removed from the end of the array and returned
	 * @throws DAIndexOutOfBoundsException 
	 */
	T removeLast() throws DAIndexOutOfBoundsException; // remove from end
	
	
	/**
	 * returns first element in the array without removing it
	 * @return T the object at the front of the array
	 * @throws DAIndexOutOfBoundsException
	 */
	T getFront() throws DAIndexOutOfBoundsException; // peek at front
	
	
	/**
	 * returns the last element without removing it
	 * @return T object that is placed at the end of the array
	 * @throws DAIndexOutOfBoundsException 
	 */
	T getLast() throws DAIndexOutOfBoundsException; // peek at end
	
	
	/**
	 * returns the size of the array
	 * @return size the size of the array
	 */
	int getSize();

}
