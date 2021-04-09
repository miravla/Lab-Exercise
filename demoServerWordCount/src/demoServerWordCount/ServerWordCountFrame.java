package demoServerWordCount;



import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class ServerWordCountFrame extends JFrame {

	
private static final long serialVersionUID = 1L;
	
	// Private components
	private JLabel StatusLabel;
	private JTextArea StatusOfServerLabel;
	
	// Private dimension
	private int width = 700;
	private int height = 500;

	public ServerWordCountFrame () {
		
		// Default frame setting
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("TCP Application: Server Side");
		this.setSize(new Dimension(width, height));  
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
 
		// Initialize component
		this.StatusLabel = new JLabel ("-");
		
		// Row, Column
		this.StatusOfServerLabel  = new JTextArea(20, 70);
		this.StatusOfServerLabel.setLineWrap(true);
		
		// Load more component
		loadComponent();
				
	}
	
	private JPanel getServerStatusPanel(Font font) {
		
		// Components to display server's status
		JPanel panel = new JPanel();
		JLabel ServerLabel = new JLabel ("Server status: ");
		
		// Style the components
		ServerLabel.setFont(font);
		StatusLabel.setFont(font);
		ServerLabel.setBackground(SystemColor.control);
		ServerLabel.setOpaque(true);
		StatusLabel.setBackground(SystemColor.control);
		StatusLabel.setOpaque(true);

		// Organize component into the panel
		panel.add(ServerLabel);
		panel.add(StatusLabel);
		
		return panel;
		
	}
	
	
	private JPanel getRequestStatusPanel () {
		
		// Component to display request's status
		JPanel panel = new JPanel();

		// Set default message when the frame launch for the first time
		StatusOfServerLabel.setText("\n > Server is running");
		StatusOfServerLabel.setEditable(false);
		
		// Styling the request text
		StatusOfServerLabel.setFont(new Font("Courier", Font.PLAIN, 15));


		// Add component to panel
		panel.add(StatusOfServerLabel);
		
		return panel;
		
	}
	
	public void loadComponent() {
		
		// Get the server status panel and add to frame
		Font font = this.getFontStyle();
		JPanel topPanel = this.getServerStatusPanel(font);
		getContentPane().add(topPanel, BorderLayout.NORTH);
		
		
		// Component to display request's status
		JPanel centrePanel = this.getRequestStatusPanel();		
		getContentPane().add(centrePanel, BorderLayout.CENTER);
		
		
	}
	
	
	public void updateServerStatus(boolean flag) {
		
		String status = "Waiting for connection.";
		
		if (flag)
			status = "Received connection";
		
		this.StatusLabel.setText(status);
		
	}
	

	public void updateRequestStatus (String status) {
		
		// Get current status displayed on the window
		String currentText = this.StatusOfServerLabel.getText();
		StatusOfServerLabel.setEditable(true);
		
		// Display the latest status on top
		status += "\n > " + currentText;
		this.StatusOfServerLabel.setText(status);
		StatusOfServerLabel.setEditable(false);
	}

	private Font getFontStyle() {
		
		Font font = new Font (Font.SANS_SERIF, Font.PLAIN, 30);
		
		return font;
		
	}
}
