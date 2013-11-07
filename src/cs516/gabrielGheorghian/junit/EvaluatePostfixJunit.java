package cs516.gabrielGheorghian.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs516.gabrielGheorghian.dynamicArray.DynamicArray;
import cs516.gabrielGheorghian.exceptions.BadNextValueException;
import cs516.gabrielGheorghian.exceptions.BadPostfixException;
import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;
import cs516.gabrielGheorghian.exceptions.NotEnoughOperandsException;
import cs516.gabrielGheorghian.exceptions.ShouldNotBeHereException;
import cs516.gabrielGheorghian.exceptions.UnmatchingParenthesisException;
import cs516.gabrielGheorghian.infixPostfix.InfixToPostfix;
import cs516.gabrielGheorghian.interfaces.QueueInterface;

public class EvaluatePostfixJunit {
	InfixToPostfix<String> calc;
	QueueInterface<String> postfix;
	
	
	/**
	 * Creating and assigning the Dynamic array and the InfixToPostfix objects
	 * also adding a few items to the DynamicArray
	 */
	@Before
	public void doBefore()
	{
		postfix = new DynamicArray<String>();
		calc = new InfixToPostfix<String>();
		
		try 
		{
			postfix.addLast("2");
			postfix.addLast("3");
			postfix.addLast("+");
		} 
		catch (DAIllegalArgumentException | DAIndexOutOfBoundsException e) 
		{
			e.printStackTrace();
		}
	}
	
	
//------ evaluatePostfix() Test ----//
		/** evaluatePostfix() method test
		 * 
		 * 1.Should work fine
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException
		 * @throws NumberFormatException
		 * @throws NotEnoughOperandsException 
		 * @throws BadPostfixException 
		 */
		@Test
		public void evaluatePostfix1() throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException, BadPostfixException
		{
			try 
			{
				String result = calc.evaluatePostfix(postfix);
				String expected = "5.0";
				assertEquals(expected, result);
			} 
			catch (DAIndexOutOfBoundsException e) 
			{
				throw new DAIndexOutOfBoundsException();
			} 
			catch (DAIllegalArgumentException e) 
			{
				throw new DAIllegalArgumentException();
			}
			catch (NumberFormatException e) 
			{
				throw new NumberFormatException();
			}
			catch (NotEnoughOperandsException e) 
			{
				throw new NotEnoughOperandsException();
			}
			catch (BadPostfixException e) 
			{
				throw new BadPostfixException();
			}
		}
		
		
		/** evaluatePostfix() method test
		 * 
		 * 2.Should throw a BadPostfixException if there's a number at the end
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException
		 * @throws NumberFormatException
		 * @throws NotEnoughOperandsException 
		 * @throws BadPostfixException 
		 */
		@Test(expected=BadPostfixException.class)
		public void evaluatePostfix2() throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException, BadPostfixException
		{
			try 
			{
				postfix.addLast("5");
				String result = calc.evaluatePostfix(postfix);
			} 
			catch (DAIndexOutOfBoundsException e) 
			{
				throw new DAIndexOutOfBoundsException();
			} 
			catch (DAIllegalArgumentException e) 
			{
				throw new DAIllegalArgumentException();
			}
			catch (NumberFormatException e) 
			{
				throw new NumberFormatException();
			}
			catch (NotEnoughOperandsException e) 
			{
				throw new NotEnoughOperandsException();
			}
			catch (BadPostfixException e) 
			{
				throw new BadPostfixException();
			}
		}
		
		
		/** evaluatePostfix() method test
		 * 
		 * 3.Should throw a BadPostfixException if there is an invalid character
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException
		 * @throws NumberFormatException
		 * @throws NotEnoughOperandsException 
		 * @throws BadPostfixException 
		 */
		@Test(expected=BadPostfixException.class)
		public void evaluatePostfix3() throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException, BadPostfixException
		{
			try 
			{
				postfix.addLast("^");
				String result = calc.evaluatePostfix(postfix);
			} 
			catch (DAIndexOutOfBoundsException e) 
			{
				throw new DAIndexOutOfBoundsException();
			} 
			catch (DAIllegalArgumentException e) 
			{
				throw new DAIllegalArgumentException();
			}
			catch (NumberFormatException e) 
			{
				throw new NumberFormatException();
			}
			catch (NotEnoughOperandsException e) 
			{
				throw new NotEnoughOperandsException();
			}
			catch (BadPostfixException e) 
			{
				throw new BadPostfixException();
			}
		}
		
		
		/** evaluatePostfix() method test
		 * 
		 * 4.Should throw a BadPostfixException for not having the right amount of characters
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException
		 * @throws NumberFormatException
		 * @throws NotEnoughOperandsException 
		 * @throws BadPostfixException 
		 */
		@Test(expected=BadPostfixException.class)
		public void evaluatePostfix4() throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException, BadPostfixException
		{
			try 
			{
				postfix.addLast("5");
				String result = calc.evaluatePostfix(postfix);
			} 
			catch (DAIndexOutOfBoundsException e) 
			{
				throw new DAIndexOutOfBoundsException();
			} 
			catch (DAIllegalArgumentException e) 
			{
				throw new DAIllegalArgumentException();
			}
			catch (NumberFormatException e) 
			{
				throw new NumberFormatException();
			}
			catch (NotEnoughOperandsException e) 
			{
				throw new NotEnoughOperandsException();
			}
			catch (BadPostfixException e) 
			{
				throw new BadPostfixException();
			}
		}
		
		
		
		/** evaluatePostfix() method test
		 * 
		 * 5.Should throw a NotEnoughOperandsException for having too few elements
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException
		 * @throws NumberFormatException
		 * @throws NotEnoughOperandsException 
		 * @throws BadPostfixException 
		 */
		@Test(expected=NotEnoughOperandsException.class)
		public void evaluatePostfix5() throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException, BadPostfixException
		{
			try 
			{
				postfix.removeFront();
				String result = calc.evaluatePostfix(postfix);
			} 
			catch (DAIndexOutOfBoundsException e) 
			{
				throw new DAIndexOutOfBoundsException();
			} 
			catch (DAIllegalArgumentException e) 
			{
				throw new DAIllegalArgumentException();
			}
			catch (NumberFormatException e) 
			{
				throw new NumberFormatException();
			}
			catch (NotEnoughOperandsException e) 
			{
				throw new NotEnoughOperandsException();
			}
			catch (BadPostfixException e) 
			{
				throw new BadPostfixException();
			}
		}
		
		
		/** evaluatePostfix() method test
		 * 
		 * 6.Should work with a long difficult expression
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException
		 * @throws NumberFormatException
		 * @throws NotEnoughOperandsException 
		 * @throws BadPostfixException 
		 */
		@Test
		public void evaluatePostfix6() throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException, BadPostfixException
		{
			try 
			{	String whatItStartsAs = "23+59+2/3++952+-89*-+";
				postfix.addLast("5");
				postfix.addLast("9");
				postfix.addLast("+");
				postfix.addLast("2");
				postfix.addLast("/");
				postfix.addLast("3");
				postfix.addLast("+");
				postfix.addLast("+");
				postfix.addLast("9");
				postfix.addLast("5");
				postfix.addLast("2");
				postfix.addLast("+");
				postfix.addLast("-");
				postfix.addLast("8");
				postfix.addLast("9");
				postfix.addLast("*");
				postfix.addLast("-");
				postfix.addLast("+");
				String result = calc.evaluatePostfix(postfix);
				String expected = "-55.0";
				assertEquals(expected, result);
			} 
			catch (DAIndexOutOfBoundsException e) 
			{
				throw new DAIndexOutOfBoundsException();
			} 
			catch (DAIllegalArgumentException e) 
			{
				throw new DAIllegalArgumentException();
			}
			catch (NumberFormatException e) 
			{
				throw new NumberFormatException();
			}
			catch (NotEnoughOperandsException e) 
			{
				throw new NotEnoughOperandsException();
			}
			catch (BadPostfixException e) 
			{
				throw new BadPostfixException();
			}
		}
		
		
		/** evaluatePostfix() method test
		 * 
		 * 7.Should throw because you divide by 0
		 * @throws DAIndexOutOfBoundsException 
		 * @throws DAIllegalArgumentException
		 * @throws NumberFormatException
		 * @throws NotEnoughOperandsException 
		 * @throws BadPostfixException 
		 */
		@Test(expected=DAIllegalArgumentException.class)
		public void evaluatePostfix7() throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException, BadPostfixException
		{
			try 
			{
				postfix.removeFront();
				postfix.removeFront();
				postfix.removeFront();
				postfix.addLast("2");
				postfix.addLast("0");
				postfix.addLast("/");
				String result = calc.evaluatePostfix(postfix);
			} 
			catch (DAIndexOutOfBoundsException e) 
			{
				throw new DAIndexOutOfBoundsException();
			} 
			catch (DAIllegalArgumentException e) 
			{
				throw new DAIllegalArgumentException();
			}
			catch (NumberFormatException e) 
			{
				throw new NumberFormatException();
			}
			catch (NotEnoughOperandsException e) 
			{
				throw new NotEnoughOperandsException();
			}
			catch (BadPostfixException e) 
			{
				throw new BadPostfixException();
			}
		}
//------END evaluatePostfix() Test ----//
}
