package cs516.gabrielGheorghian.junit;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import cs516.gabrielGheorghian.dynamicArray.DynamicArray;
import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;

public class DynamicArrayIteratorJunit {

	private DynamicArray<Object> dynamic;
	
	
	/**
	 * Creating a Dynamic array of Object types and adding String objects inside
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Before
	public void doBefore() throws DAIndexOutOfBoundsException 
	{
		dynamic = new DynamicArray<Object>();
		try {
			dynamic.add(new String("A"));
			dynamic.add(new String("B"));
			dynamic.add(new String("C"));
			dynamic.add(new String("D"));
			
		} catch (DAIllegalArgumentException e) {
			e.printStackTrace();
		} catch (DAIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
//------ hasNext() Test ----//
	/** hasNext() method test
	 * 
	 * 1.Should work fine
	 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#hasNext()}. 
	 */
	@Test
	public void testHasNext() 
	{
		System.out.println();
		System.out.println("testHasNext()");
		
		int x = 0;
		Iterator<Object> it = dynamic.iterator();
		while (it.hasNext())
			System.out.println(x++ +":"+it.next());
	}
	
	
	/** hasNext() method test 2
	 * 
	 * 2.Should return a false boolean
	 * Test method for {@link cs516.gabrielGheorghian.dynamicArray.DynamicArray#hasNext()}. 
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testHasNext2() throws DAIndexOutOfBoundsException 
	{
		Iterator<Object> it = dynamic.iterator();
		
		for(int i = 0; i < 4; i++)
		{
			it.next();
		}
		
		assertEquals(false, it.hasNext());
	}
//------ END hasNext() Test ----//
		
	
//------ next() Test ----//
	/** next() method test 
	 * 
	 * 1.should throw NoSuchElementException
	 * @throws NoSuchElementException
	 */
	@Test(expected=NoSuchElementException.class)
	public void testNext() {
		Iterator<Object> it = dynamic.iterator();
		System.out.println();
		System.out.println("testNext()");
		for(int x=0; x < 7;++x)  // Will throw exception so good
			System.out.println(x+":"+it.next());
	}
	
	
	/** next() method test 2
	 * 
	 * 2.should work fine 
	 */
	@Test
	public void testNext2() {
		System.out.println();
		System.out.println("testNext2()");
		
		Iterator<Object> it = dynamic.iterator();
		for(int x=0; x < 4;++x)  
			System.out.println(x+":"+it.next());
	}
//------ END next() Test ----//
	

//------ remove() Test ----//
	/** remove() method test
	 * 
	 * 1.Should work fine
	 */
	@Test
	public void testRemove() throws DAIndexOutOfBoundsException 
	{		
		System.out.println();
		System.out.println("testRemove()");
		
		Iterator<Object> it = dynamic.iterator();
		for(int i = 0; i < 4; i++)
		{
			System.out.println(" " + i+": Removed "+it.next());
			it.remove();
		}
	}
	
	
	/** remove() method test 2
	 * 
	 * 2.Should throw a NoSuchElementException
	 * @throws UnsupportedOperationException
	 */
	@Test(expected=UnsupportedOperationException.class)
	public void testRemove2() 
	{
		System.out.println();
		System.out.println("testRemove2()");
		
		Iterator<Object> it = dynamic.iterator();
		for(int i = 0; i < 4; i++)
		{
			System.out.println(" " + i+": Removed "+it.next());
			it.remove();
		}
		
		it.remove();
	}
//------ END remove() Test ----//
	

}
