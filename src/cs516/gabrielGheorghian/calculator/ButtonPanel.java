package cs516.gabrielGheorghian.calculator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import cs516.gabrielGheorghian.exceptions.BadNextValueException;
import cs516.gabrielGheorghian.exceptions.BadPostfixException;
import cs516.gabrielGheorghian.exceptions.DAIllegalArgumentException;
import cs516.gabrielGheorghian.exceptions.DAIndexOutOfBoundsException;
import cs516.gabrielGheorghian.exceptions.NotEnoughOperandsException;
import cs516.gabrielGheorghian.exceptions.ShouldNotBeHereException;
import cs516.gabrielGheorghian.exceptions.UnmatchingParenthesisException;
import cs516.gabrielGheorghian.infixPostfix.InfixToPostfix;

public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = -5623966350427734736L;
	private static final int FONT_SIZE = 24;
	private int currentFontSize = FONT_SIZE;

	private JButton[] theButtons = null;
	// text for button face
	private String[] keys = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			".", "CE", "C", "+/-", "(", ")", "+", "-", "*", "/", "=" };
	private GridBagLayout gridBagLayout = null;
	private DisplayModel displayModel = null;
	private InfixToPostfix<String> calc = null;
	private Font theFont;

	/**
	 * Constructor
	 */
	public ButtonPanel(DisplayModel displayModel) {
		super();
		setTheFont();
		this.displayModel = displayModel;
		calc = new InfixToPostfix<String>();
		initialize();
	}

	/**
	 * Initialize the panel
	 */
	private void initialize() {
		gridBagLayout = new GridBagLayout();
		// Set Layout
		this.setLayout(gridBagLayout);

		// Create the buttons and place on the display
		createAndPlaceButtons();
		setButtonsWidthAndHeight();
		this.setSize(gridBagLayout.preferredLayoutSize(this));
		theButtons[0].requestFocusInWindow();
	}

	/**
	 * Instantiate the buttons and add them to the panel Use the length of the
	 * array of strings for loops
	 */
	private void createAndPlaceButtons() {
		// Create a single KeyListener object to be shared by all buttons
		MyKeyListener myKeyListener = new MyKeyListener();
		MyActionListener myActionListener = new MyActionListener();

		// CompoundBorder b = BorderFactory.createCompoundBorder(
		// BorderFactory.createBevelBorder(BevelBorder.RAISED),
		// BorderFactory.createEmptyBorder(4, 4, 4, 4));

		theButtons = new JButton[keys.length];
		for (int x = 0; x < keys.length; ++x) {
			theButtons[x] = new JButton(keys[x]);
			// In Windows DIALOG and SERIF are the same
			if (x < 11) {
				theFont = theFont.deriveFont(Font.BOLD, currentFontSize);
			} else {
				theFont = theFont.deriveFont(Font.PLAIN, currentFontSize);
			}
			theButtons[x].setFont(theFont);
			// theButtons[x].setBorder(b);
			theButtons[x].addKeyListener(myKeyListener);
			theButtons[x].addActionListener(myActionListener);

		}

		add(theButtons[11], makeConstraints(0, 0, 2, 1));
		add(theButtons[12], makeConstraints(2, 0, 2, 1));
		add(theButtons[13], makeConstraints(4, 0, 1, 1));

		add(theButtons[7], makeConstraints(0, 1, 1, 1));
		add(theButtons[8], makeConstraints(1, 1, 1, 1));
		add(theButtons[9], makeConstraints(2, 1, 1, 1));
		add(theButtons[14], makeConstraints(3, 1, 1, 1));
		add(theButtons[15], makeConstraints(4, 1, 1, 1));

		add(theButtons[4], makeConstraints(0, 2, 1, 1));
		add(theButtons[5], makeConstraints(1, 2, 1, 1));
		add(theButtons[6], makeConstraints(2, 2, 1, 1));
		add(theButtons[16], makeConstraints(3, 2, 1, 1));
		add(theButtons[17], makeConstraints(4, 2, 1, 1));

		add(theButtons[1], makeConstraints(0, 3, 1, 1));
		add(theButtons[2], makeConstraints(1, 3, 1, 1));
		add(theButtons[3], makeConstraints(2, 3, 1, 1));
		add(theButtons[18], makeConstraints(3, 3, 1, 1));
		add(theButtons[20], makeConstraints(4, 3, 1, 2));

		add(theButtons[0], makeConstraints(0, 4, 2, 1));
		add(theButtons[10], makeConstraints(2, 4, 1, 1));
		add(theButtons[19], makeConstraints(3, 4, 1, 1));

	}

	/**
	 * Determines which button is widest and use that to make all buttons the
	 * same width and height
	 * 
	 */
	private void setButtonsWidthAndHeight() {
		Dimension newSize = new Dimension(0, 0);
		Dimension currentSize = new Dimension(0, 0);

		// Get the size of each button and preserve the widest
		for (int x = 0; x < keys.length; x++) {
			currentSize = theButtons[x].getPreferredSize();
			if (currentSize.width > newSize.width) {
				newSize.width = currentSize.width;
			}
		}
		// Set height to width for square buttons
		newSize.height = newSize.width;

		// Set the new preferred size for each button
		for (int x = 0; x < keys.length; x++) {
			theButtons[x].setPreferredSize(newSize);
		}
	}

	/**
	 * Make a GridBagConstraints object using the method's parameters
	 * 
	 */
	private GridBagConstraints makeConstraints(int gridx, int gridy,
			int gridwidth, int gridheight) {
		GridBagConstraints gbc = new GridBagConstraints();

		// Commented out items will use default value
		// gbc.anchor =
		gbc.gridheight = gridheight;
		gbc.gridwidth = gridwidth;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		// gbc.ipadx =
		// gbc.ipady =

		// Override default but use for all components
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		return gbc;
	}

	/**
	 * Receive message to change font size Used when window changes size
	 * 
	 * @param size
	 */
	public void setButtonFontSize(double percentage) {
		currentFontSize = (int) (FONT_SIZE * percentage);
		for (int x = 0; x < keys.length; x++) {
			if (x < 11) {
				theFont = theFont.deriveFont(Font.BOLD, currentFontSize);
			} else {
				theFont = theFont.deriveFont(Font.ITALIC, currentFontSize);
			}
			theButtons[x].setFont(theFont);
		}
	}

	/**
	 * Handle special font requirement of Napkin
	 */
	private void setTheFont() {
		LookAndFeel currentLF = UIManager.getLookAndFeel();
		theFont = new Font(Font.DIALOG, Font.BOLD, 18);
	}

	/**
	 * Set the focus to a button. Since JButton objects are private this public
	 * method is used
	 */
	public void setFocusToButton() {
		theButtons[0].requestFocusInWindow();
	}

	/**
	 * Inner class action listener for buttons
	 * 
	 * @author neon
	 * 
	 */
	private class MyActionListener implements ActionListener {

		/**
		 * Send the button text to the input handler
		 * 
		 * @param e
		 *            the ActionEvent
		 */
		public void actionPerformed(ActionEvent e) {
			String buttonText = ((JButton) e.getSource()).getText();
			switch (buttonText) {
			case "C":
				displayModel.clear();
				break;
			case "=":
				try {
					String result = "";
					result = calc.calculate(displayModel.calculate());
					displayModel.receiveInput(result);
				} catch (DAIndexOutOfBoundsException e1) {
					displayModel.error();
				} catch (DAIllegalArgumentException e1) {
					displayModel.error();
				} catch (ShouldNotBeHereException e1) {
					displayModel.error();
				} catch (BadNextValueException e1) {
					displayModel.error();
				} catch (UnmatchingParenthesisException e1) {
					displayModel.error();
				} catch (NumberFormatException e1) {
					displayModel.error();
				} catch (NotEnoughOperandsException e1) {
					displayModel.error();
				} catch (BadPostfixException e1) {
					displayModel.error();
				}
				catch (NullPointerException e1) {
					displayModel.error();
				}
				break;
			case "+/-":
				displayModel.negate();
				break;
			case "CE":
				displayModel.clearEntry();
				break;
			default:
				try {
					displayModel.receiveInput(buttonText);
				} catch (ShouldNotBeHereException e1) {
					displayModel.error();
				}
				break;
			}

		}
	}

	/**
	 * Inner class action listener for key press from the keyboard
	 * 
	 * @author neon
	 * 
	 */
	private class MyKeyListener extends KeyAdapter {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.KeyAdapter#keyTyped(java.awt.event.KeyEvent)
		 */
		public void keyTyped(KeyEvent evt) {
			int keyChar = evt.getKeyChar();

			switch (keyChar) {
			case KeyEvent.VK_0:
			case KeyEvent.VK_NUMPAD0:
				theButtons[0].doClick();
				break;
			case KeyEvent.VK_1:
			case KeyEvent.VK_NUMPAD1:
				theButtons[1].doClick();
				break;
			case KeyEvent.VK_2:
			case KeyEvent.VK_NUMPAD2:
				theButtons[2].doClick();
				break;
			case KeyEvent.VK_3:
			case KeyEvent.VK_NUMPAD3:
				theButtons[3].doClick();
				break;
			case KeyEvent.VK_4:
			case KeyEvent.VK_NUMPAD4:
				theButtons[4].doClick();
				break;
			case KeyEvent.VK_5:
			case KeyEvent.VK_NUMPAD5:
				theButtons[5].doClick();
				break;
			case KeyEvent.VK_6:
			case KeyEvent.VK_NUMPAD6:
				theButtons[6].doClick();
				break;
			case KeyEvent.VK_7:
			case KeyEvent.VK_NUMPAD7:
				theButtons[7].doClick();
				break;
			case KeyEvent.VK_8:
			case KeyEvent.VK_NUMPAD8:
				theButtons[8].doClick();
				break;
			case KeyEvent.VK_9:
			case KeyEvent.VK_NUMPAD9:
				theButtons[9].doClick();
				break;
			case KeyEvent.VK_PERIOD:
				theButtons[10].doClick();
				break;
			case KeyEvent.VK_DELETE:
				theButtons[11].doClick();
				break;
			case KeyEvent.VK_BACK_SPACE:
				theButtons[12].doClick();
				break;
			case '(':
				theButtons[14].doClick();
				break;
			case ')':
				theButtons[15].doClick();
				break;
			case '+':
				theButtons[16].doClick();
				break;
			case KeyEvent.VK_MINUS:
				theButtons[17].doClick();
				break;
			case '*':
				theButtons[18].doClick();
				break;
			case KeyEvent.VK_SLASH:
				theButtons[19].doClick();
				break;
			case KeyEvent.VK_ENTER:
				theButtons[20].doClick();
				break;
			}
		}
	}
}
