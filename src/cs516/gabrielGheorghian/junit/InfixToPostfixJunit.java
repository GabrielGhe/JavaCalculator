package cs516.gabrielGheorghian.junit;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import cs516.gabrielGheorghian.dynamicArray.DynamicArray;
import cs516.gabrielGheorghian.exceptions.BadNextValueException;
import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;
import cs516.gabrielGheorghian.exceptions.ShouldNotBeHereException;
import cs516.gabrielGheorghian.exceptions.UnmatchingParenthesisException;
import cs516.gabrielGheorghian.infixPostfix.InfixToPostfix;
import cs516.gabrielGheorghian.interfaces.QueueInterface;

public class InfixToPostfixJunit {
	InfixToPostfix<String> calc;
	QueueInterface<String> infix;

	/**
	 * Creating and assigning the Dynamic array and the InfixToPostfix objects
	 * also adding a few items to the DynamicArray
	 */
	@Before
	public void doBefore() {
		infix = new DynamicArray<String>();
		calc = new InfixToPostfix<String>();

		try {
			infix.addLast("2");
			infix.addLast("+");
			infix.addLast("4");
		} catch (DAIllegalArgumentException | DAIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

	// ------ infixToPostfix() Test ----//
	/**
	 * infixToPostfix() method test
	 * 
	 * 1.Should work fine
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix1() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "24+";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 2.Should work with multiplication
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix2() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("*");
			infix.addLast("5");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "245*+";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 3.Should work with multiplication and addition
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix3() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("*");
			infix.addLast("5");
			infix.addLast("+");
			infix.addLast("3");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "245*+3+";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 4.Should work with parenthesis
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix4() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("+");
			infix.addLast("(");
			infix.addLast("1");
			infix.addLast("+");
			infix.addLast("2");
			infix.addLast(")");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "24+12++";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 5.Should work with division
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix5() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("/");
			infix.addLast("5");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "245/+";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 6.Should work with division and subtraction
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix6() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("-");
			infix.addLast("5");
			infix.addLast("/");
			infix.addLast("5");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "24+55/-";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 7.Should work with multiple operators including multiple parenthesis
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix7() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("+");
			infix.addLast("(");
			infix.addLast("(");
			infix.addLast("1");
			infix.addLast("+");
			infix.addLast("3");
			infix.addLast(")");
			infix.addLast("-");
			infix.addLast("9");
			infix.addLast(")");
			infix.addLast("+");
			infix.addLast("1");
			infix.addLast("/");
			infix.addLast("3");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "24+13+9-+13/+";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 8.Should throw a BadNextValueException because 2 numbers are following
	 * each other
	 * 
	 * @throws BadNextValueException
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws UnmatchingParenthesisException
	 */
	@Test(expected = BadNextValueException.class)
	public void testInfixToPostfix8() throws BadNextValueException,
			DAIllegalArgumentException, DAIndexOutOfBoundsException,
			ShouldNotBeHereException, UnmatchingParenthesisException {
		try {
			infix.addLast("5");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);

		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 9.Should throw a BadNextValueException because 2 parenthesis are
	 * following each other
	 * 
	 * @throws BadNextValueException
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws UnmatchingParenthesisException
	 */
	@Test(expected = UnmatchingParenthesisException.class)
	public void testInfixToPostfix9() throws BadNextValueException,
			DAIllegalArgumentException, DAIndexOutOfBoundsException,
			ShouldNotBeHereException, UnmatchingParenthesisException {
		try {
			infix.addLast("(");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 10.Should throw a BadNextValueException because 2 parenthesis are
	 * following each other
	 * 
	 * @throws BadNextValueException
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws UnmatchingParenthesisException
	 */
	@Test(expected = BadNextValueException.class)
	public void testInfixToPostfix10() throws BadNextValueException,
			DAIllegalArgumentException, DAIndexOutOfBoundsException,
			ShouldNotBeHereException, UnmatchingParenthesisException {
		try {
			infix.addLast("+");
			infix.addLast("(");
			infix.addLast(")");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);

		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 11.Should work with a lot of crazy parameters
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix11() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {

		try {
			String completeOperation = "2+4+((5+9)/2 +3)+(9-(5+2)-8*9)";
			infix.addLast("+");
			infix.addLast("(");
			infix.addLast("(");
			infix.addLast("5");
			infix.addLast("+");
			infix.addLast("9");
			infix.addLast(")");
			infix.addLast("/");
			infix.addLast("2");
			infix.addLast("+");
			infix.addLast("3");
			infix.addLast(")");
			infix.addLast("+");
			infix.addLast("(");
			infix.addLast("9");
			infix.addLast("-");
			infix.addLast("(");
			infix.addLast("5");
			infix.addLast("+");
			infix.addLast("2");
			infix.addLast(")");
			infix.addLast("-");
			infix.addLast("8");
			infix.addLast("*");
			infix.addLast("9");
			infix.addLast(")");

			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "24+59+2/3++952+-89*-+";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}

	}

	// ------ infixToPostfix() Test ----//
	/**
	 * infixToPostfix() method test
	 * 
	 * 12.Should throw an UnmatchingParenthesisException
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test(expected = UnmatchingParenthesisException.class)
	public void testInfixToPostfix12() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast(")");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	// ------ infixToPostfix() Test ----//
	/**
	 * infixToPostfix() method test
	 * 
	 * 13.Should not work because it doesnt match any of the regex
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test(expected = DAIllegalArgumentException.class)
	public void testInfixToPostfix13() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("+");
			infix.addLast("hello");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	// ------ infixToPostfix() Test ----//
	/**
	 * infixToPostfix() method test
	 * 
	 * 14.Should not work because of division by 0
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test(expected = DAIllegalArgumentException.class)
	public void testInfixToPostfix14() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("/");
			infix.addLast("0");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	// ------ infixToPostfix() Test ----//
	/**
	 * infixToPostfix() method test
	 * 
	 * 15.Should work fine with negative numbers
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix15() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.addLast("+");
			infix.addLast("-23");
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "24+-23+";
			String inCalc = calc.stringTrans(postFix);

			System.out.println(inCalc);
			assertEquals(result, inCalc);

		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	/**
	 * infixToPostfix() method test
	 * 
	 * 1.Should work fine
	 * 
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 * @throws UnmatchingParenthesisException
	 */
	@Test
	public void testInfixToPostfix16() throws DAIllegalArgumentException,
			DAIndexOutOfBoundsException, ShouldNotBeHereException,
			BadNextValueException, UnmatchingParenthesisException {
		try {
			infix.removeFront();
			infix.removeFront();
			infix.removeFront();
			infix.addLast("(");
			infix.addLast("2");
			infix.addLast("+");
			infix.addLast("4");
			infix.addLast(")");
			
			QueueInterface<String> postFix = calc.infixToPostfix(infix);
			String result = "24+";

			assertEquals(result, calc.stringTrans(postFix));
		} catch (DAIllegalArgumentException e) {
			throw new DAIllegalArgumentException();
		} catch (DAIndexOutOfBoundsException e) {
			throw new DAIndexOutOfBoundsException();
		} catch (ShouldNotBeHereException e) {
			throw new ShouldNotBeHereException();
		} catch (BadNextValueException e) {
			throw new BadNextValueException();
		} catch (UnmatchingParenthesisException e) {
			throw new UnmatchingParenthesisException();
		}
	}

	// ------END infixToPostfix() Test ----//

}
