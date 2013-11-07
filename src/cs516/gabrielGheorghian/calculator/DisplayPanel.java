package cs516.gabrielGheorghian.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel containing a text field BorderLayout is used so that the text field is
 * always the same size as the panel. Make the panel uneditable which turns it
 * grey so change its background color to white When sent a message from the
 * frame, change the font size When sent a message, set the text in the text
 * field Updates the model for the display that in turn uses the
 * observer/observable pattern to update the display
 */
public class DisplayPanel extends JPanel implements Observer {
	// need these because they give random warnings
	private static final long serialVersionUID = 1337L;

	private static final int FONT_SIZE = 18;
	private JTextField textField = null;
	private JTextField textFieldTop = null;
	private int currentFontSize = FONT_SIZE;
	private Font theFont = null;
	private GridBagLayout gridBagLayout;

	/**
	 * Constructor, calls its super() then sets the layout, font makes the
	 * textField nice and adds it to the panel
	 */
	public DisplayPanel() {
		super();
		gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		theFont = new Font(Font.DIALOG, Font.BOLD, 18);
		this.setSize(gridBagLayout.preferredLayoutSize(this));

		configureTextFieldTop();
		add(textFieldTop, makeConstraints(0, 0, 1, 1));
		configureTextField();
		add(textField, makeConstraints(0, 1, 1, 1));
	}

	/**
	 * Initialize and configure the text field
	 */
	private void configureTextField() {
		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.RIGHT);
		theFont = theFont.deriveFont(Font.BOLD, FONT_SIZE);
		textField.setFont(theFont);
		textField.setEditable(false);

		textField.setBackground(Color.WHITE);
	}

	/**
	 * Initialize and configure the text field that is on top
	 */
	private void configureTextFieldTop() {
		textFieldTop = new JTextField();
		textFieldTop.setHorizontalAlignment(JTextField.RIGHT);
		theFont = theFont.deriveFont(Font.BOLD, FONT_SIZE);
		textFieldTop.setFont(theFont);
		textFieldTop.setEditable(false);

		textFieldTop.setBackground(Color.WHITE);
	}

	/**
	 * Receive message from the AppFrame to change font size Used when window
	 * changes size
	 * 
	 * @param percentage
	 */
	public void setDisplayFontSize(double percentage) {
		currentFontSize = (int) (FONT_SIZE * percentage);
		theFont = theFont.deriveFont(Font.BOLD, currentFontSize);
		textField.setFont(theFont);
		textFieldTop.setFont(theFont);
	}

	/**
	 * Receive a message from the ButtonPanel to update the display Used when
	 * button is clicked or key is pressed
	 * 
	 * @param text
	 */
	public void setEntryFieldText(String text) {
		textField.setText(text);
	}

	/**
	 * updates the display
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof DisplayModel) {
			DisplayModel localDisplayModel = (DisplayModel) o;
			textField.setText(localDisplayModel.getDisplayText());

			textFieldTop.setText(localDisplayModel.getQueueText());
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
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		return gbc;
	}
}
