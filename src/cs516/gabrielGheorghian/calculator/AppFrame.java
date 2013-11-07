package cs516.gabrielGheorghian.calculator;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import cs516.gabrielGheorghian.calculator.ButtonPanel;
import cs516.gabrielGheorghian.calculator.DisplayModel;
import cs516.gabrielGheorghian.calculator.DisplayPanel;


/**
 * JFrame that holds a button panel and display panel Listens for changes to
 * window size Sends a message to the button and display panels of a percentage
 * to change their font size Button panel has action listener Button panel has
 * reference to the display panel so that it may update the display when a
 * button is clicked. Button panel has a key listener that clicks the button
 * corresponding to the key.
 * 
 * @author Gabriel Gheorghian
 * 
 */
public class AppFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final boolean DEBUG = false;

	private ButtonPanel buttonPanel = null;
	private DisplayPanel displayPanel = null;
	private DisplayModel displayModel = null;
	
	
	
	/**
	 * Constructor
	 * @author 0737019
	 */
	public AppFrame(){
		super();
		setLookAndFeel(3);
			
		//initialize the model and display and button panels
		displayModel = new DisplayModel();
		displayPanel = new DisplayPanel();
		displayModel.addObserver(displayPanel);
			
			
		buttonPanel = new ButtonPanel(displayModel);
	
		initialize();
		setTitle("Calculator");
		pack();
		this.addComponentListener(new FrameSizeListener(this.getPreferredSize()));
		// Display the window.
		this.setVisible(true);
		
		buttonPanel.setFocusToButton();
	}
	
	
	/**
	 * The main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Create and set up the window.
				AppFrame frame = new AppFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
	

	/**
	 * Initialize the frame setting its constraints and add its components
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		GridBagConstraints constraints = new GridBagConstraints();

		// Prepare and add the display panel
		constraints.gridx = 0; // Column
		constraints.gridy = 0; // Row
		constraints.weightx = 0.2;
		constraints.weighty = 0.2;
		constraints.fill = GridBagConstraints.BOTH;
		// constraints.fill = GridBagConstraints.HORIZONTAL;
		// constraints.fill = GridBagConstraints.VERTICAL;
		add(displayPanel, constraints);

		// Prepare and add the button panel
		constraints.gridx = 0; // Column
		constraints.gridy = 1; // Row
		constraints.weightx = 0.8;
		constraints.weighty = 0.8;
		add(buttonPanel, constraints);
		buttonPanel.requestFocusInWindow();
	}
	
	
	/**
	 * Set the look and feel
	 */
	private void setLookAndFeel(int choice) {
		try {
			switch (choice) {

			case 0:
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
				break;
			case 1:
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				break;
			case 2:
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;
			case 3:
				UIManager
						.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				break;
			case 4:
				UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
				break;
			case 5:
				UIManager.setLookAndFeel(UIManager
						.getCrossPlatformLookAndFeelClassName());
				break;
			case 6:
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;
			case 7:
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				break;
			default:
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Th Look and Feel you selected is not supported.",
					"Look & Feel Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	
	/**
	 * Inner class listener for changes to the size of the window
	 * 
	 * @author neon
	 * 
	 */
	class FrameSizeListener extends ComponentAdapter {

		Dimension preferredFrameSize = null;

		/**
		 * Store the preferred size of the frame
		 * 
		 * @param preferredFrameSize
		 */
		public FrameSizeListener(Dimension preferredFrameSize) {
			super();
			this.preferredFrameSize = preferredFrameSize;
			if (DEBUG)
				System.out.println("Listener: " + preferredFrameSize.width
						+ "  x  " + preferredFrameSize.height);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seejava.awt.event.ComponentAdapter#componentResized(java.awt.event.
		 * ComponentEvent) Receives size events Calculate a percentage change in
		 * the height of the window Use this percentage to send a message to the
		 * displayPanel and the buttonPanel to change their font size
		 */
		public void componentResized(ComponentEvent e) {
			if (e.getComponent() instanceof AppFrame) {
				AppFrame cf = (AppFrame) e.getComponent();
				Dimension newSize = cf.getSize();
				if (!preferredFrameSize.equals(newSize)) {
					double percentage = (double) newSize.height
							/ preferredFrameSize.height;
					buttonPanel.setButtonFontSize(percentage);
					displayPanel.setDisplayFontSize(percentage);
					if (DEBUG) {
						System.out.println(newSize.width + "  x  "
								+ newSize.height);
						System.out.println(newSize.height + "  >>  "
								+ preferredFrameSize.height + "  : "
								+ percentage);
					}
				}
			}
		}
	}
	
}
