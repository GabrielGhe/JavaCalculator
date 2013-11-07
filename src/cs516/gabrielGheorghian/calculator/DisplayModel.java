package cs516.gabrielGheorghian.calculator;

import java.util.Observable;

import cs516.gabrielGheorghian.dynamicArray.DynamicArray;
import cs516.gabrielGheorghian.exceptions.BadNextValueException;
import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;
import cs516.gabrielGheorghian.exceptions.ShouldNotBeHereException;
import cs516.gabrielGheorghian.interfaces.DequeInterface;
import cs516.gabrielGheorghian.interfaces.QueueInterface;

/**
 * @author Gabriel Gheorghian
 * 
 */
public class DisplayModel extends Observable {
	// ---------------DECLARING VARIABLES ---------------- //

	private String displayText = null;
	private DequeInterface<String> displayTextTop;

	// for checking the input type
	private final String OPERAND = "([0-9.])";
	private final String OPERATOR = "[+-/*]";
	private final String OPENP = "[(]";
	private final String CLOSEP = "[)]";
	private final String SOPERAND = "(^-?[0-9]{1,}([.][0-9]{1,})?)";

	// for checking next value
	private final String FOROPERATOR = "[(0-9]";
	private final String FOROPERAND = "[.0-9)+-/*]";
	private final String FORCLOSEP = "[+-/*)]";
	private int nextShouldBe;

	// constants for checking
	private final int FOROPRTOR = 1;
	private final int FOROPRND = 2;
	private final int FOROPAR = 3;
	private final int FORCPAR = 4;
	private final int FORRSLT = 5;
	private final int FORSTRT = 6;

	// parenthesis counters
	private int openP;
	private int closeP;
	private boolean resulted;

	// ---------------END DECLARING VARIABLES ---------------- //

	/**
	 * Constructor
	 */
	public DisplayModel() {
		super();
		resulted = false;
		openP = 0;
		closeP = 0;
		nextShouldBe = FORSTRT;
		displayText = "";
		displayTextTop = new DynamicArray<String>();
	}

	/**
	 * This method returns the displayText
	 * 
	 * @return displayText
	 */
	public String getDisplayText() {
		return displayText;
	}

	/**
	 * Displays the Equation until now
	 * 
	 * @return string showing the current equation
	 */
	public String getQueueText() {
		String temp = "";
		String show = "";
		DequeInterface<String> newD = new DynamicArray<String>();

		while (displayTextTop.getSize() != 0) {
			try {
				temp = displayTextTop.removeFront();
				show += temp;
				newD.addLast(temp);
			} catch (DAIndexOutOfBoundsException | DAIllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		displayTextTop = newD;
		return show;
	}

	/**
	 * returns a queue with the equation
	 * 
	 * @return queue with equation
	 * @throws DAIndexOutOfBoundsException
	 * @throws DAIllegalArgumentException
	 */
	public QueueInterface<String> calculate()
			throws DAIllegalArgumentException, DAIndexOutOfBoundsException {

		if (displayText != "")
			displayTextTop.addLast(displayText);
		if (displayTextTop.getSize() > 2) {
			QueueInterface<String> deque = new DynamicArray<String>();

			while (displayTextTop.getSize() > 0) {
				deque.addLast(displayTextTop.removeFront());
			}
			openP = 0;
			closeP = 0;
			nextShouldBe = FORRSLT;
			return deque;
		}

		return null;
	}

	/**
	 * Clears the number currently up
	 */
	public void clearEntry() {
		displayText = "";
		resulted = false;

		setChanged();
		// notify Observers that model has changed
		notifyObservers();
	}

	/**
	 * Clears the number and the equation
	 */
	public void clear() {
		displayText = "";
		while (displayTextTop.getSize() > 0)
			try {
				displayTextTop.removeLast();
			} catch (DAIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		resulted = false;
		openP = 0;
		closeP = 0;
		nextShouldBe = FOROPRND;

		setChanged();
		// notify Observers that model has changed
		notifyObservers();
	}

	/**
	 * negates if the current entry is a number
	 */
	public void negate() {
		if (displayText.matches(SOPERAND)) {
			displayText = "" + (-1 * Double.parseDouble(displayText));
		}

		setChanged();
		// notify Observers that model has changed
		notifyObservers();
	}

	/**
	 * An error has occured
	 */
	public void error() {
		clear();
		displayText = "Error";

		setChanged();
		// notify Observers that model has changed
		notifyObservers();
	}

	/**
	 * This method gets the text of the button that was pressed and sets it
	 * 
	 * @param input
	 *            the button that was pressed
	 * @throws ShouldNotBeHereException
	 * @throws DAIllegalArgumentException
	 */
	public void receiveInput(String input) throws ShouldNotBeHereException {
		if (displayText == "Error") {
			clear();
			clearEntry();
		}
		if (followingItem(input)) {
			// the input is an operand
			if (input.matches(OPERAND)) {

				// if the input is a . you should make sure there is no . in the
				// number already
				if (input == ".") {
					if (displayText.indexOf(".") == -1)
						displayText += input;
				} else {
					if (resulted)
						clearEntry();
					displayText += input;
				}

			} else if (input.matches(OPERATOR)) {
				// means that there is something in the deque and that the
				// displayText is empty
				if (displayText == "" && displayTextTop.getSize() > 1) {
					try {
						if (displayTextTop.getLast().matches(OPERATOR)) {
							displayTextTop.removeLast();
						}
						displayTextTop.addLast(input);
					} catch (DAIndexOutOfBoundsException e) {
						e.printStackTrace();
					} catch (DAIllegalArgumentException e) {
						e.printStackTrace();
					}
					// means that there is a number in the displayText
				} else {
					try {
						displayTextTop.addLast(displayText);
						displayTextTop.addLast(input);
						displayText = "";
					} catch (DAIllegalArgumentException e) {
						e.printStackTrace();
					} catch (DAIndexOutOfBoundsException e) {
						e.printStackTrace();
					}
				}
				// result
			} else if (input.matches(SOPERAND)) {
				resulted = true;
				displayText = input;
				// means that input are parenthesis
			} else {
				try {
					if (input == "(")
						openP++;
					if (input == ")" && openP >= closeP + 1)
						closeP++;
					if (openP >= closeP && openP > 0) {
						if (displayText != "")
							displayTextTop.addLast(displayText);
						displayTextTop.addLast(input);
						displayText = "";
					}

				} catch (DAIllegalArgumentException e) {
					e.printStackTrace();
				} catch (DAIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}

			setChanged();
			// notify Observers that model has changed
			notifyObservers();
		}
	}

	/*
	 * Checks if the next item (input) is allowed
	 * 
	 * @param input current input
	 * 
	 * @throws ShouldNotBeHereException
	 */
	private boolean followingItem(String input) throws ShouldNotBeHereException {
		boolean good = false;

		// checks to see if the input matches what the next value is expected
		switch (nextShouldBe) {
		// incase the next value should be something after an operator
		case FOROPRTOR:
			if (input.matches(FOROPERATOR)) {
				good = true;
			}
			break;
		// incase the next value should be something after an operand
		case FOROPRND:
			if (input.matches(FOROPERAND)) {
				good = true;
			}
			break;
		// incase the next value should be something after a open parenthesis
		case FOROPAR:
			if (input.matches(FOROPERATOR)) {
				good = true;
			}
			break;
		// incase the next value should be something after a closing parenthesis
		case FORCPAR:
			if (input.matches(FORCLOSEP)) {
				good = true;
			}
			break;
		// incase the next value should be something after a result
		case FORRSLT:
			good = true;
			break;
		// incase the next value should be something that should be at the
		// beginning
		case FORSTRT:
			if (input.matches(FOROPERATOR))
				good = true;
			break;
		default:
			break;
		}
		// if the value that should be expected is valid, determine what the
		// next value should be
		if (good) {
			if (input.matches(OPERAND)) {
				nextShouldBe = FOROPRND;
			} else if (input.matches(OPERATOR)) {
				nextShouldBe = FOROPRTOR;
			} else if (input.matches(OPENP)) {
				nextShouldBe = FOROPAR;
			} else if (input.matches(CLOSEP)) {
				nextShouldBe = FORCPAR;
			} else if (input.matches(SOPERAND)) {
				nextShouldBe = FOROPRND;
			} else
				throw new ShouldNotBeHereException();
		}
		return good;
	}
}
