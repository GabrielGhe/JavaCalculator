package cs516.gabrielGheorghian.interfaces;

import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;

public interface DynamicArrayInterface<T> {

	
	/**
	 * returns the size of the array
	 * @return size the size of the array
	 */
	int getSize();
	
	
	/**
	 * returns the capacity of the array
	 * @return length the capacity of the array
	 */
	int getCapacity();
	
	
	/**adds an object at the end of the array
	 * @param object the element you wish to add to the array 
	 * @throws DAIllegalArgumentException
	 */
	void add(T object) throws DAIllegalArgumentException, DAIndexOutOfBoundsException;
	
	
	/**
	 * deletes object at the end of the array and returns it
	 * @return returner object you have just deleted
	 * @throws DAIndexOutOfBoundsException
	 */
	T delete() throws DAIndexOutOfBoundsException;
	
	
	/**
	 * inserts an object at position index -1 (can't be at the end of array)
	 * @param object item you wish to insert
	 * @param index location where you wish to insert the element
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 */
	void insertAt(T object, int index) throws DAIllegalArgumentException, DAIndexOutOfBoundsException;
	
	
	/**
	 * deletes an object at position index and returns the object that was deleted (can't be at the end of array)
	 * @param index location where you wish to delete
	 * @return returner the item you just deleted
	 * @throws DAIndexOutOfBoundsException
	 */
	T deleteAt( int index) throws DAIndexOutOfBoundsException;
	
	
	/**
	 * sets an object at an index
	 * @param object the item you wish to set
	 * @param index the location where you wish to set the element
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 */
	void setAt(T object, int index) throws DAIllegalArgumentException, DAIndexOutOfBoundsException;
	
	
	/**
	 * gets object at position index
	 * @param index the location where you wish to get the element
	 * @return T the element you want to get
	 * @throws DAIndexOutOfBoundsException
	 */
	T getAt(int index) throws DAIndexOutOfBoundsException;
	
}
