package demoCountWordClient;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class WordCountFrame extends JFrame implements ActionListener {
	
private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel WordCountLabel;
	private JTextArea wordToCountText;
	
	// Private attributes for frame size
	private int width = 900;
	private int height = 300;
	
	/**
	 * The constructor that initialize and organize the Swing components on 
	 * the frame.
	 */
	public WordCountFrame () {
		
		// Default frame setting
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side ");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
        WordCountLabel = new JLabel("");
        WordCountLabel.setBounds(289, 5, 10, 39);
		
		// Row, Column
		this.wordToCountText = new JTextArea(10, 30);
		wordToCountText.setBackground(Color.WHITE);
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	private JPanel getInputPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		JLabel TextLabel = new JLabel ("Enter text: ");
		JButton ComfirmButton = new JButton("Comfirm");
		ComfirmButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		JButton ClearButton = new JButton("Cancel");
		ClearButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		
		
		// Set action command - All buttons are registered to one listener
		ComfirmButton.setActionCommand("Comfirm");
		ClearButton.setActionCommand("Cancel");
		
		// Register button to listener
		ComfirmButton.addActionListener(this);
		ClearButton.addActionListener(this);
		
		// Style the component
		TextLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		TextLabel.setBackground(SystemColor.control);
		TextLabel.setOpaque(true);
		
		// Styling the request text
		wordToCountText.setFont(new Font("Courier", Font.PLAIN, 15));
		wordToCountText.setLineWrap(true);
		
		// Organize components into panel
		
		panel.add(TextLabel);
		panel.add(wordToCountText);
		panel.add(ClearButton);
		panel.add(ComfirmButton);
		
		return panel;
		
	}
	
	
	private JPanel getOutputPanel(Font font) {
		
		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel TotalWordLabel = new JLabel ("Total Words: ");
		TotalWordLabel.setBounds(104, 4, 213, 39);

		// Style the component
		TotalWordLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		WordCountLabel.setFont(font);
		TotalWordLabel.setBackground(SystemColor.control);
		WordCountLabel.setBackground(Color.WHITE);
		WordCountLabel.setOpaque(true);
		panel.setLayout(null);

		// Organize components into panel
		panel.add(TotalWordLabel);
		panel.add(WordCountLabel);
		
		return panel;
	} 
	
	
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getInputPanel(font);		
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		// Get server date's panel and add to frame
		JPanel center = getOutputPanel(font);
		getContentPane().add(center, BorderLayout.CENTER);
		
	}
	
	
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		String actionCommand = event.getActionCommand();
		
		switch (actionCommand) {
			
		case "Comfirm":
			// Process word counting
			
			try {
				
				// Send data to server for processing
				ClientWordCount wordCount = new ClientWordCount();
				
				String totalWords = wordCount.countWord(wordToCountText.getText());
				
				this.WordCountLabel.setText(totalWords);
				
			} catch (Exception exception) {
				
				
			}
			
			break;
		
		case "Cancel": 
			// Clear the frame
			
			clearFrameDisplay();
			
			break;
			
		} // end of switch-actionCommand
		
		
	}




	private void clearFrameDisplay () {
		
		wordToCountText.setText("");
		WordCountLabel.setText("-");
	}

}