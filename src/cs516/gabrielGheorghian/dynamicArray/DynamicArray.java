/**
 * Gabriel Gheorghian
 * 0737019
 * Lab 1
 * DynamicArray.java
 */
package cs516.gabrielGheorghian.dynamicArray;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;
import cs516.gabrielGheorghian.interfaces.DequeInterface;
import cs516.gabrielGheorghian.interfaces.DynamicArrayInterface;
import cs516.gabrielGheorghian.interfaces.QueueInterface;
import cs516.gabrielGheorghian.interfaces.StackInterface;


public class DynamicArray<T> implements DynamicArrayInterface<T>, QueueInterface<T>, StackInterface<T>, DequeInterface<T>, Iterable<T> {
	private Object[] array;
	private int size;
	
	
	/**
	 * constructor that sets default values for the variables
	 */
	public DynamicArray()
	{
		array = new Object[10];
		size = 0;
	}
	
// -------------------------------------- Add/Remove/Set/Get Array methods ---------------------------------//
	
	/**adds an object at the end of the array
	 * @param object the element you wish to add to the array 
	 * @throws DAIllegalArgumentException
	 */
	@Override
	public void add(T object) throws DAIllegalArgumentException, DAIndexOutOfBoundsException
	{
		insertAt(object, size);
	}
	
	
	/**
	 * deletes object at the end of the array and returns it
	 * @return returner object you have just deleted
	 * @throws DAIndexOutOfBoundsException
	 */
	@Override
	public T delete() throws DAIndexOutOfBoundsException
	{		
		return deleteAt(size - 1);
	}
	
	

	/**
	 * inserts an object at position index -1 (can't be at the end of array)
	 * @param object item you wish to insert
	 * @param index location where you wish to insert the element
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 */
	@Override
	public void insertAt(T object, int index) throws DAIllegalArgumentException, DAIndexOutOfBoundsException
	{
		if(object == null)
		{
			throw new IllegalArgumentException();
		}
		else if((index >= 0) && (index <= size))
		{
			if(size >= array.length)
			{
				growArray();
			}
			
			//starts at the end and shifts everything up by 1
			System.arraycopy(array, index, array, index + 1, size - index);
			
			// sets the object at position index
			array[index] = object;
			
			size++;
		}
		else if((index < 0) || (index > size))
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	

	/**
	 * deletes an object at position index and returns the object that was deleted (can't be at the end of array)
	 * @param index location where you wish to delete
	 * @return returner the item you just deleted
	 * @throws DAIndexOutOfBoundsException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T deleteAt(int index) throws DAIndexOutOfBoundsException
	{
		T returner = null;
		
		if((index >= 0) && (index <= size - 1))
		{
			returner = (T)array[index];
			
			// starts at index and shifts every object down by 1		
			System.arraycopy(array, index + 1, array, index, size - index - 1);
					
			// sets the last item to null
			array[size - 1] = null;
			
			size--;
			
			packArray();	
		}
		else if((index < 0) || (index > size - 1))
		{
			throw new IndexOutOfBoundsException();
		}
		
		return returner;
	}

	
	/**
	 * sets an object at an index
	 * @param object the item you wish to set
	 * @param index the location where you wish to set the element
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 */
	@Override
	public void setAt(T object, int index) throws DAIllegalArgumentException, DAIndexOutOfBoundsException
	{
		if(object == null)
		{
			throw new IllegalArgumentException();
		}
		else if((index < 0) || (index > size - 1))
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			array[index] = object;
		}
	}


	/**
	 * gets object at position index
	 * @param index the location where you wish to get the element
	 * @return T the element you want to get
	 * @throws DAIndexOutOfBoundsException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getAt(int index) throws DAIndexOutOfBoundsException
	{
		if((index < 0) || (index > size - 1))
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			return (T)array[index];
		}
		
	}
	
// -----------------------------End of    Add/Remove/Set/Get Array methods ---------------------------------//
	
	

// --------------------------------  Array helper methods methods ---------------------------------//
	
	/**
	 * Makes the array capacity smaller
	 */
	private void packArray()
	{
		array = Arrays.copyOf(array, (size * 3)/2 + 1);		
	}
	
	
	/**
	 * Makes the array capacity more
	 */
	private void growArray()
	{
		array = Arrays.copyOf(array, (array.length * 3)/2 + 1);
	}


	/**
	 * returns the size of the array
	 * @return size the size of the array
	 */
	@Override
	public int getSize() 
	{
		return size;
	}



	/**
	 * returns the capacity of the array
	 * @return length the capacity of the array
	 */
	@Override
	public int getCapacity()
	{
		return array.length;
	}	
// -----------------------------END  Array helper methods methods ---------------------------------//	

	
	/**
	 * adds element to the front of the array
	 * @param t the object you want to push at the front of the array
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 */
	@Override
	public void addFront(T t) throws DAIllegalArgumentException, DAIndexOutOfBoundsException
	{
		this.insertAt(t, 0);
	}

	
	/**
	 * adds element to the end of the array
	 * @param t object you wish to push at the end of the array
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Override
	public void addLast(T t) throws DAIllegalArgumentException, DAIndexOutOfBoundsException
	{
		this.insertAt(t, size);
	}
	
	
	/**
	 * removes last element and returns it
	 * @return T the object you removed from the end of the array and returned
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Override
	public T removeLast() throws DAIndexOutOfBoundsException
	{
		return this.deleteAt(size-1);
	}
	
	
	/**
	 * removes first element in array and returns it
	 * @return T the object you removed from the front of the array and returned
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Override
	public T removeFront() throws DAIndexOutOfBoundsException
	{
		return this.deleteAt(0);
	}

	
	/**
	 * returns the last element without removing it
	 * @return T object that is placed at the end of the array
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Override
	public T getLast() throws DAIndexOutOfBoundsException
	{
		return this.getAt(size -1);
	}

	
	/**
	 * returns first element in the array without removing it
	 * @return T the object at the front of the array
	 * @throws DAIndexOutOfBoundsException
	 */
	@Override
	public T getFront() throws DAIndexOutOfBoundsException
	
	{
		return this.getAt(0);
	}

	
	/**
	 * @return Iterator to go through the array elements
	 */
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}
	
	
	/**
	 * Inner class MyIterator
	 * Used to go through the array
	 */
	class MyIterator<E> implements Iterator<E> 
	{
			int counter = -1;
			
		
			/** 
			 * @return boolean value if there is a value
			 */
		   public boolean hasNext() 
		   {
			   return ((counter+1) < size);
		   }
		   
		   /**
		    * @return value in the array at position counter
		    * @throws NoSuchElementException
		    */
			@SuppressWarnings("unchecked")
			public E next() throws NoSuchElementException
			{
				if (hasNext()) 
				{	
					try 
					{
						return (E) getAt(++counter);
					} 
					catch (DAIndexOutOfBoundsException e) 
					{
						e.printStackTrace();
					}
				}
				throw new NoSuchElementException(); //if you do next and you're at the end
			}
		   
		   
			/**
			 * removes item at the front of the array using the deleteAt(index) method
			 * @throws UnsupportedOperationException
			 */
			public void remove() throws UnsupportedOperationException
			{
				if(counter >= 0 && (counter < size))
				{
					try 
			        {
						deleteAt(counter);
						counter--;
					} 
			        catch (DAIndexOutOfBoundsException e) 
					{
						e.printStackTrace();
					}
				}
				else
				{
					throw new UnsupportedOperationException(); // doing remove and there are no elements
				}
		        
			}
	}
}















