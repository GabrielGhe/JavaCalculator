/**
 *  Gabriel Gheorghian
 *  @author 0737019
 *  Lab 2
 */
package cs516.gabrielGheorghian.interfaces;

import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;


public interface QueueInterface<T> {

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
	T removeFront() throws DAIllegalArgumentException, DAIndexOutOfBoundsException; // remove from front
	
	
	/**
	 * returns first element in the array without removing it
	 * @return T the object at the front of the array
	 * @throws DAIndexOutOfBoundsException
	 */
	T getFront() throws DAIndexOutOfBoundsException; // peek at front
	
	/**
	 * returns the size of the array
	 * @return size the size of the array
	 */
	int getSize();
}
