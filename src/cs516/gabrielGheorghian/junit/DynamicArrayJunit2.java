/**
 * Gabriel Gheorghian
 * @author 0737019
 * lab 2
 */
package cs516.gabrielGheorghian.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import cs516.gabrielGheorghian.dynamicArray.DynamicArray;
import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;


public class DynamicArrayJunit2 {

	private DynamicArray<Object> array;
	
	
	/**
	 * Instantiate the DynamicArray object before each test
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Object first = new Object();
		Object second = new Object();
		Object third = new Object();
		Object forth = new Object();
		
		array = new DynamicArray<Object>();
		array.addLast(first);
		array.addLast(second);
		array.addLast(third);
		array.addLast(forth);
	}
	

	
	
//------ add() Test ----//
		/** add() method test
		 * 
		 * 1.If parameter is null will throw IllegalArgumentException
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#add(java.lang.Object)}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test (expected=IllegalArgumentException.class)
		public void testAdd() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			try{
				Object test = null;
				
				array.add(test);
			}
			catch(IllegalArgumentException iae)
			{throw iae;}
		}
		
		
		/** add() method test 2
		 * 
		 * 2.If added properly, should have the object at index 0
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#add(java.lang.Object)}.
		 * @throws DAIllegalArgumentException
		 * @throws DAIndexOutOfBoundsException
		 */
		@Test 
		public void testAdd2() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			Object test = new Object();
			Object expected = test;
			array.add(test);
			
			assertEquals(expected, array.getAt(4));
		}
//----- END add() test----//
	
	
	
	
//------ delete() Test ----//
		/** delete() method test
		 * 
		 * 1.If size is 0, will throw IndexOutOfBoundsException
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#delete()}.
		 * @throws DAIndexOutOfBoundsException
		 */
		@Test (expected=IndexOutOfBoundsException.class)
		public void testDelete() throws DAIndexOutOfBoundsException {
			try{
				array.delete();
				array.delete();
				array.delete();
				array.delete();
				array.delete();
			}
			catch(IndexOutOfBoundsException iob)
			{throw iob;}
		}
		
		
		/** delete() method test 2
		 * 
		 * 2.If deleted properly, size should be 0
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#delete()}.
		 * @throws DAIllegalArgumentException
		 * @throws DAIndexOutOfBoundsException
		 */
		@Test
		public void testDelete2() throws DAIndexOutOfBoundsException, DAIllegalArgumentException {
			Object test = new Object();
			array.add(test);
			
			assertEquals(test, array.delete());
		}
//------END delete() Test ----//
		
		
		
//------ deleteAt() Test ----//
		/** deleteAt() method test
		 * 
		 * 1.If not in range, throws IndexOutOfBoundsException 
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#deleteAt(int)}.
		 * @throws DAIndexOutOfBoundsException 
		 */
		@Test (expected=IndexOutOfBoundsException.class)
		public void testDeleteAt() throws DAIndexOutOfBoundsException {
			try
			{
				array.deleteAt(5);
			}
			catch(IndexOutOfBoundsException ioe)
			{throw ioe;}	
		}
		
		
		/** deleteAt() method test 2
		 * 
		 * 2.Deletes properly
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#deleteAt(int)}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test 
		public void testDeleteAt2() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			Object test = new Object();
			array.insertAt(test, 1);
			
			assertEquals(test, array.deleteAt(1));
		}
//------END deleteAt() Test ----//

	

//------ getAt() Test ----//
		/** getAt() method test
		 * 
		 * 1.If index is not in range, throws IndexOutOfBoundsException
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#getAt(int)}.
		 * @throws DAIndexOutOfBoundsException 
		 */
		@Test (expected=IndexOutOfBoundsException.class)
		public void testGetAt() throws DAIndexOutOfBoundsException{
			try
			{
				array.getAt(8);
			}
			catch(IndexOutOfBoundsException iob)
			{throw iob;}
		}
		
		
		/** getAt() method test 2
		 * 
		 * 2.Returns the right Object
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#getAt(int)}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testGetAt2() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			Object test = new Object();
			array.add(test);
			
			assertEquals(test, array.getAt(4));
		}
//------END getAt() Test ----//
		
		

//------ getSize() Test ----//
		/** getSize() method test
		 * 
		 * 1.Returns the amount of Objects currently in array
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#getSize()}.
		 */
		@Test
		public void testGetSize() {
			assertEquals(4, array.getSize());
		}
//------END getSize() Test ----//
		
		
		
//------ getCapacity() Test ----//
		/** getCapacity() method test
		 * 
		 * 1.Returns the capacity of array
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#getCapacity()}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testGetCapacity() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			Object test = new Object();
			Object test2 = new Object();
			Object test3 = new Object();
			
			array.add(test);
			array.add(test2);
			array.add(test3);
			array.delete();
			
			assertEquals(10, array.getCapacity());
			
		}
//------END getCapacity() Test ----//
		

	
//------ insertAt() Test ----//
	/** insertAt() method test
	 * 
	 * 1.If null, throws IllegalArgumentException
	 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#insertAt(java.lang.Object, int)}.
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testInsertAt() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
		try
		{
			Object test = null;
			
			array.insertAt(test, 1);
		}
		catch(IllegalArgumentException iae)
		{throw iae;}
	}
	
	
	/** insertAt() method test 2
	 * 
	 * 2.If not in range should throw IndexOutOfBoundsException
	 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#insertAt(java.lang.Object, int)}.
	 * @throws IllegalArgumentException
	 * @throws IndexOutOfBoundsException
	 */
	@Test (expected=IndexOutOfBoundsException.class)
	public void testInsertAt2() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
		try
		{
			Object test = new Object();
			
			array.insertAt(test, 6);
		}
		catch(IndexOutOfBoundsException ioe)
		{throw ioe;}
	}
	
	
	/** insertAt() method test 3
	 * 
	 * 3.Added at right location
	 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#insertAt(java.lang.Object, int)}.
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 */
	@Test
	public void testInsertAt3() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
		Object test = new Object();
		array.insertAt(test, 1);
		
		assertEquals(test, array.getAt(1));
	}
//------ END insertAt() Test ----//
	
	
//------ getFront() Test ----//
			/**getFront() method test
			 * 
			 * 1.returns the front element of the array without removing it
			 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#getFront()}.
			 * @throws DAIndexOutOfBoundsException 
			 * @throws DAIllegalArgumentException 
			 */
			@Test
			public void testGetFront() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
				Object test = new Object();
				array.addFront(test);
				
				assertEquals(test, array.getFront());
			}
			
			
			/**getFront() method test 2
			 * 
			 * 2.makes sure the size does not change
			 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#getFront()}.
			 * @throws DAIndexOutOfBoundsException 
			 */
			@Test
			public void testGetFront2() throws DAIndexOutOfBoundsException {
				array.getFront();
				
				assertEquals(4, array.getSize());
			}
//------ END getFront() Test ----//
		

//------ getLast() Test ----//
		/**getLast() method test
		 * 
		 * 1.returns the last element in the array without removing it
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#getLast()}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testGetLast() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			Object test = new Object();
			array.addLast(test);
			
			assertEquals(test, array.getLast());
		}
		
		
		/**getLast() method test 2
		 * 
		 * 2.makes sure the size stays the same
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#getLast()}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testGetLast2() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			Object test = new Object();
			array.addLast(test);
			array.getLast();
			
			assertEquals(5, array.getSize());
		}
//------END getLast() Test ----//	

	
//------ removeFront() Test ----//
		/**removeFront() method test
		 * 
		 * 1.removes the first element of the array and returns it
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#removeFront()}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testRemoveFront() throws DAIllegalArgumentException, DAIndexOutOfBoundsException  {
			Object test = new Object();
			array.addFront(test);
			
			assertEquals(test, array.removeFront());
		}
		
		
		/**removeFront() method test 2
		 * 
		 * 2.makes sure the size is changed
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#removeFront()}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testRemoveFront2() throws DAIllegalArgumentException, DAIndexOutOfBoundsException{
			Object test = new Object();
			array.addFront(test);
			array.removeFront();
			
			assertEquals(4, array.getSize());
		}
//------ END removeFront() Test ----//
	
	

//------ removeLast() Test ----//
		/**removeLast() method test
		 * 
		 * 1.Deletes last element in the array and returns it
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#removeLast()}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testRemoveLast() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			Object test = new Object();
			array.add(test);
			
			assertEquals(test, array.removeLast());
		}
		
		
		/**removeLast() method test 2
		 * 
		 * 2.checks to see if the size was altered
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#removeLast()}.
		 * @throws DAIndexOutOfBoundsException 
		 */
		@Test
		public void testRemoveLast2() throws DAIndexOutOfBoundsException {
			array.removeLast();
			
			assertEquals(3, array.getSize());
		}
//------END removeLast() Test ----//



//------ addFront() Test ----//
		/**addFront() method test
		 * 
		 * 1.adds element to the front of the array, pushing the others back
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#addFront(java.lang.Object)}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testAddFront() throws DAIllegalArgumentException, DAIndexOutOfBoundsException{
			Object test = new Object();
			array.addFront(test);
			
			assertEquals(test, array.getAt(0));
		}
//------ END addFront() Test ----//
	
	

//------ addLast() Test ----//
		/**addLast() method test
		 * 
		 * 1.adds an element to the end of the array, makes sure the element is there
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#addLast(java.lang.Object)}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testAddLast() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
			Object test = new Object();
			array.addLast(test);
			
			assertEquals(test, array.getAt(4));
		}
		
		
		/**addLast() method test 2
		 * 
		 * 2.makes sure the size stays the same
		 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#addLast(java.lang.Object)}.
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException 
		 */
		@Test
		public void testAddLast2() throws DAIllegalArgumentException, DAIndexOutOfBoundsException{
			Object test = new Object();
			array.addLast(test);
			
			assertEquals(5, array.getSize());
		}
//------END addLast() Test ----//

		
	
//------ setAt() Test ----//
	/** setAt() method test
	 * 
	 * 1.If null throw IllegalArgumentException
	 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#setAt(java.lang.Object, int)}.
	 * @throws DAIndexOutOfBoundsException 
	 * @throws DAIllegalArgumentException 
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testSetAt() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
		try
		{
			Object test = null;
			
			array.setAt(test, 1);
		}
		catch(IllegalArgumentException iae)
		{throw iae;}
	}
	
	
	/** setAt() method test 2
	 * 
	 * 2.If index out of range throw IndexOutOfBoundsException
	 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#setAt(java.lang.Object, int)}.
	 * @throws DAIndexOutOfBoundsException 
	 * @throws DAIllegalArgumentException 
	 */
	@Test (expected=IndexOutOfBoundsException.class)
	public void testSetAt2() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
		try
		{
			Object test = new Object();
			
			array.setAt(test, 5);
		}
		catch(IndexOutOfBoundsException iob)
		{throw iob;}
	}
	
	
	/** setAt() method test 3
	 * 
	 * 3.Sets Object at right index
	 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#setAt(java.lang.Object, int)}.
	 * @throws DAIndexOutOfBoundsException 
	 * @throws DAIllegalArgumentException 
	 */
	@Test
	public void testSetAt3() throws DAIllegalArgumentException, DAIndexOutOfBoundsException {
		Object test = new Object();
		array.setAt(test, 1);
		
		assertEquals(test, array.getAt(1));
	}
//------END setAt() Test ----//
	

}
