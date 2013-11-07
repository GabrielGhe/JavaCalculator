package cs516.gabrielGheorghian.infixPostfix;

import java.util.Arrays;
import java.util.Queue;

import cs516.gabrielGheorghian.dynamicArray.DynamicArray;
import cs516.gabrielGheorghian.exceptions.BadNextValueException;
import cs516.gabrielGheorghian.exceptions.BadPostfixException;
import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;
import cs516.gabrielGheorghian.exceptions.NotEnoughOperandsException;
import cs516.gabrielGheorghian.exceptions.ShouldNotBeHereException;
import cs516.gabrielGheorghian.exceptions.UnmatchingParenthesisException;
import cs516.gabrielGheorghian.interfaces.DequeInterface;
import cs516.gabrielGheorghian.interfaces.QueueInterface;
import cs516.gabrielGheorghian.interfaces.StackInterface;

public class InfixToPostfix<T> {
	
	final String OPERAND = "(^-?[0-9]{1,}([.][0-9]?{1,})?)";
	final String OPERATOR = "[+-/*]";
	final String ALLOPERATOR = "[(|)|+|-|/|*]";
	final String PARA1 = "[(]";
	final String PARA2 = "[)]";
	final String OPERATORD = "[/]";

	
//--------------------------------------------infixToPostfix in alphabetical and access order ---------------------------------//
	/**Given a infix of type String it returns a postfix
	 * @param a Queue which contains the infix (human version of calculation)
	 * @return a Queue which contains the postfix (calculation which the machine can read and calculate)
	 * @throws DAIndexOutOfBoundsException 
	 * @throws DAIllegalArgumentException 
	 * @throws BadNextValueException 
	 * @throws ShouldNotBeHereException 
	 * @throws UnmatchingParenthesisException 
	 */
	public QueueInterface<T> infixToPostfix(QueueInterface<T> infix) throws DAIndexOutOfBoundsException, DAIllegalArgumentException, ShouldNotBeHereException, BadNextValueException, UnmatchingParenthesisException, NullPointerException
	{
		if(infix.getSize() < 3 && (infix.getSize()%2) == 1)//makes sure the size of infix is greater than 3 and is an odd number
		{
			throw new DAIllegalArgumentException();
		}
		infix = checkPara(infix);
		
		QueueInterface<T> postfix = new DynamicArray<T>();
		postfix = (QueueInterface<T>) calculateInfixToPostfix(infix);
		return  postfix;
	}
	
	
	/**Displays the Queue as a String
	 * @param thing
	 * @return
	 * @throws DAIllegalArgumentException
	 * @throws DAIndexOutOfBoundsException
	 */
	public String stringTrans(QueueInterface<T> thing) throws DAIllegalArgumentException, DAIndexOutOfBoundsException
	{
		String x ="";
		while(thing.getSize() != 0)
		{
			x+=thing.removeFront();
		}
		return x;
	}
	
	
	public String calculate(QueueInterface<T> infix)  throws DAIndexOutOfBoundsException, DAIllegalArgumentException, ShouldNotBeHereException, BadNextValueException, UnmatchingParenthesisException, NumberFormatException, NotEnoughOperandsException, BadPostfixException{
		return evaluatePostfix(infixToPostfix(infix));
	}
	
	
	/**Assigns a value to the operator
	 * @param a string operator
	 * @return the int value of the operator
	 */
	private int assignValue(T item)
	{
		int value;
		switch((String)item)
		{
			case "+":
				value = 1;
				break;
			case "-":
				value = 1;
				break;
			case "/":
				value = 2;
				break;
			case "*":
				value = 2;
				break;
			default:
				value = 0;
		}
		return value;
	}

	
	/**Given a infix it calculates and returns a postfix
	 * @param a Queue which contains the infix (human version of calculation)
	 * @return a Queue which contains the postfix (calculation which the machine can read and calculate)
	 * @throws DAIndexOutOfBoundsException 
	 * @throws DAIllegalArgumentException 
	 * @throws BadNextValueException 
	 * @throws ShouldNotBeHereException 
	 */
	private QueueInterface<T> calculateInfixToPostfix(QueueInterface<T> infix) throws DAIndexOutOfBoundsException, DAIllegalArgumentException, ShouldNotBeHereException, BadNextValueException {
		QueueInterface<T> postfix = new DynamicArray<T>();
		StackInterface<T> operatorStack = new DynamicArray<T>();
		
		while(infix.getSize() != 0)
		{			
			String currentItem = (String) infix.getFront();
			
			//if it maches a number, you add it to the postfix ---------------------------------
			if(currentItem.matches(OPERAND))
			{
				postfix.addLast(infix.removeFront());
				if(infix.getSize() > 0)
					followingItem(infix.getFront(), 0); //if next value is good or bad
			}
			//if it's an operator -------------------------------------------------------------
			else if(currentItem.matches(OPERATOR))
			{				
				if(operatorStack.getSize() == 0) // if the stack is empty, add it
				{
					operatorStack.addLast(infix.removeFront());
					if(infix.getSize() > 0)
						followingItem(infix.getFront(), 1); //if next value is good or bad
				}
				else //if it's not empty, must check things
				{
					// check if the operator from infix is inferior to the operator from the stack
					if(!compareOperators(infix.getFront(), operatorStack.getLast()))
					{
						//while the latest item in infix is inferior to the top of the stack add from the top of the stack to postfix
						while(!compareOperators(infix.getFront(), operatorStack.getLast()))
						{
							postfix.addLast(operatorStack.removeLast());
							try
							{
								operatorStack.getLast();
							}
							catch(IndexOutOfBoundsException iob)
							{
								break;
							}
						}
					}
					//once the infix item is the most superior
					operatorStack.addLast(infix.removeFront());
					if(infix.getSize() > 0)
						followingItem(infix.getFront(), 1); //if next value is good or bad
				}
				
				if(currentItem.matches(OPERATORD))
					if(infix.getFront() == "0")
						throw new DAIllegalArgumentException();
			}
			// if the item is an opening parenthesis-------------------------------------------------
			else if(currentItem.matches("[(]"))
			{
				infix.removeFront();
				if(infix.getSize() > 0)
					followingItem(infix.getFront(), 2); //if next value is good or bad
				
				QueueInterface<T> inPara = new DynamicArray<T>();
				inPara = calculateInfixToPostfix(infix);
				
				while(inPara.getSize() != 0)
				{
					postfix.addLast(inPara.removeFront());
				}
			}
			// if the item is a closing parenthesis-------------------------------------------------
			else if(currentItem.matches("[)]"))
			{
				infix.removeFront();
				if(infix.getSize() > 0)
					followingItem(infix.getFront(), 0); //if next value is good or bad
				
				break;
			}
			else  // the string isn't an operator or an operand... someone made a mistake
			{
				throw new DAIllegalArgumentException();
			}
		}
		//if the operator stack is not empty, dump it into the postfix queue
		while(operatorStack.getSize() != 0)
		{
				postfix.addLast(operatorStack.removeLast());
		}
		return postfix;
	}
	
	
	@SuppressWarnings("unchecked")
	private QueueInterface<T> checkPara(QueueInterface<T> infix) throws DAIllegalArgumentException, DAIndexOutOfBoundsException, UnmatchingParenthesisException
	{
		QueueInterface<T> newInfix = new DynamicArray<T>();
		int openingB = 0;
		int closingB = 0;
		String item = null;
		while(infix.getSize() != 0)
		{
			item = (String)infix.removeFront();
			switch(item)
			{
			case "(":
				openingB++;
				break;
			case ")":
				closingB++;
				break;
			default:
				break;
			}
			newInfix.addLast((T)item);
		}
		if(openingB != closingB)
		{
			throw new UnmatchingParenthesisException();
		}
		
		return newInfix;
	}
	
	
	/**Compares 2 operators
	 * @param the latest item in infix
	 * @param the last item in stack
	 * @return boolean saying which operator is more important
	 */
	private boolean compareOperators(T infix, T stack) {
		int infixValue = assignValue(infix);
		int stackValue = assignValue(stack);
		boolean greatness;
		
		if(infixValue > stackValue)
			greatness = true; // the infix is superior
		else
			greatness = false; // the infix is inferior
		return greatness;
	}
	
	
	/**Checks if the next item (infix) is allowed
	 * @param infix nextvalue
	 * @param degree what type
	 * @throws ShouldNotBeHereException
	 * @throws BadNextValueException
	 */
	private void followingItem(T infix, int degree) throws ShouldNotBeHereException, BadNextValueException
	{
		switch(degree)
		{
			case 0:
				if(((String)infix).matches(OPERAND) || ((String)infix).matches(PARA1)) // no number or parenthesis
					{throw new BadNextValueException("Opening parenthesis or number following a number");}
				
				break;
			case 1:
				if(((String)infix).matches(OPERATOR)) // no operators
				{throw new BadNextValueException("Operator following Operator");}
			break;
			case 2:
				if(((String)infix).matches(PARA2)) // no )
					{throw new BadNextValueException(") following (");}
				break;
			default:
				throw new ShouldNotBeHereException();
		}
	}
	//--------------------------------------------END infixToPostfix ---------------------------------//
	
	
	
	//------------------------------------- Evaluate Postfix ------------------------------------//
	/**
	 * Evaluates postfix
	 * @param postfix
	 * @return
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 * @throws NumberFormatException
	 * @throws NotEnoughOperandsException 
	 * @throws BadPostfixException 
	 */
	public String evaluatePostfix(QueueInterface<T> postfix) throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException, BadPostfixException
	{
		postfix = checkPostfix(postfix);
		return calculatePostfix(postfix);
	}
	
	
	/** Calculates the expressionDeque
	 * @param exprDeque
	 * @return result
	 * @throws DAIndexOutOfBoundsException
	 * @throws NumberFormatException
	 * @throws DAIllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	private T calculateExpr(DequeInterface<T> exprDeque) throws DAIndexOutOfBoundsException, NumberFormatException, DAIllegalArgumentException
	{
		Double operandF = Double.parseDouble((String)exprDeque.removeFront());
		String operator = (String) exprDeque.removeFront();
		Double operandB = Double.parseDouble((String)exprDeque.removeFront());
		Double result = 0.0;
		
		switch(operator)
		{
			case "+":
				result = operandF + operandB;
				break;
			case "-":
				result = operandF - operandB;
				break;
			case "*":
				result = operandF * operandB;
				break;
			case "/":
				if(operandB != 0.0){
					result = operandF / operandB;
				}
				else
					throw new DAIllegalArgumentException();
				break;
			default:
				break;
		}
		
		return (T)("" +result);
	}
	
	
	/**Calculates the postfix
	 * @param postfix
	 * @return
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 * @throws NumberFormatException
	 * @throws NotEnoughOperandsException 
	 */
	private String calculatePostfix(QueueInterface<T> postfix) throws DAIndexOutOfBoundsException, DAIllegalArgumentException, NumberFormatException, NotEnoughOperandsException
	{
		StackInterface<T> operandStack = new DynamicArray<T>();
		DequeInterface<T> exprDeque = new DynamicArray<T>();
		String result = "";
		
		while(postfix.getSize() != 0)
		{
			String currentItem = (String) postfix.getFront();
			
			if(currentItem.matches(OPERAND))
			{
				operandStack.addLast(postfix.removeFront());
			}
			else if(currentItem.matches(OPERATOR))
			{
				if(operandStack.getSize() >= 2)
				{
					exprDeque.addLast(operandStack.removeLast()); //adding last operand in expression
					exprDeque.addFront(postfix.removeFront()); //adding the operator
					exprDeque.addFront(operandStack.removeLast()); //adding first operand in expression
					operandStack.addLast(calculateExpr(exprDeque)); //adding the result to the stack
				}
				else
				{
					throw new NotEnoughOperandsException();
				}
			}
		}
		if(operandStack.getSize() == 1)
			result = (String) operandStack.removeLast();
		return result;
	}
	
	
	private QueueInterface<T> checkPostfix(QueueInterface<T> postfix) throws DAIllegalArgumentException, DAIndexOutOfBoundsException, BadPostfixException
	{
		if(postfix.getSize() < 3 && (postfix.getSize()%2) == 1)//makes sure the size of infix is greater than 3 and is an odd number
		{
			throw new BadPostfixException();
		}
		
		QueueInterface<T> newPostfix = new DynamicArray<T>();
		
		if(((String)postfix.getFront()).matches(OPERATOR))//first element can't be an operator
		{
			throw new BadPostfixException();
		}
		
		newPostfix.addLast(postfix.removeFront());
		
		
		newPostfix.addLast(postfix.removeFront());
		
		while(postfix.getSize() != 0)
		{
			if(postfix.getSize() == 1)
			{
				if(((String)postfix.getFront()).matches(OPERAND)) //second element can't be an operator
				{
					throw new BadPostfixException();
				}
			}
			if(!(((String)postfix.getFront()).matches(OPERAND) || ((String)postfix.getFront()).matches(OPERATOR)))
			{
				throw new BadPostfixException();
			}
			
			newPostfix.addLast(postfix.removeFront());
		}
		
		return newPostfix;
	}
	//-------------------------------------END Evaluate Postfix ------------------------------------//
}
