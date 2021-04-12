package Client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.SystemColor;
import javax.swing.JComboBox;

public class ClientTranslateFrame extends JFrame implements ActionListener {
	
private static final long serialVersionUID = 1L;
	
	// Private attributes for frame size
	private int width = 900;
	private int height = 300;
	private JComboBox SentenceComboBox;
	private JComboBox LanguageComboBox;
	private JLabel ResultTranslateLabel;
	private int language, sentence;
	
	
	public ClientTranslateFrame () {
		this.setTitle("TCP Application: Client Side ");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	private JPanel getInputPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 886, 160);
		panel.setBackground(SystemColor.control);
		panel.setLayout(null);
		JLabel TextLabel = new JLabel ("Choose Your Word :");
		TextLabel.setBounds(10, 2, 276, 41);
		
		
		// Style the component
		TextLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		TextLabel.setBackground(SystemColor.control);
		TextLabel.setOpaque(true);
		
		// Organize components into panel
		
		panel.add(TextLabel);
		
		JComboBox comboBox = new JComboBox();
		// Set up translation language option in comboBox 
		String [] sentenceList = {"Good morning","Good night","How are you?", "Thank you", 
							"Goodbye","What's up?"};
		SentenceComboBox = new JComboBox(sentenceList);
		SentenceComboBox.setBounds(323, 4, 197, 45);
		SentenceComboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		panel.add(SentenceComboBox);
		
		
		JButton ComfirmButton = new JButton("Confirm");
		ComfirmButton.setBounds(530, 86, 110, 41);
		panel.add(ComfirmButton);
		ComfirmButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		ComfirmButton.setActionCommand("Comfirm");
		
		JButton ClearButton = new JButton("Cancel");
		ClearButton.setBounds(648, 84, 99, 42);
		panel.add(ClearButton);
		
		ClearButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		ClearButton.setActionCommand("Cancel");
		
		JLabel lblNewLabel_2 = new JLabel("Language :");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(135, 75, 178, 51);
		panel.add(lblNewLabel_2);
		
		// Set up translation language option in comboBox 
		String [] languageList = {"Bahasa Melayu","Korean","Arabic"};
		LanguageComboBox = new JComboBox(languageList);
		LanguageComboBox.setBounds(319, 85, 201, 37);
		LanguageComboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 23));
		panel.add(LanguageComboBox);
		
		ClearButton.addActionListener(this);
		ComfirmButton.addActionListener(this);
		return panel;
		
	}
	
	
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		getContentPane().setLayout(null);
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getInputPanel(font);		
		getContentPane().add(northPanel);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 159, 886, 94);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel ResultLabel = new JLabel("Result :");
		ResultLabel.setBounds(188, 3, 100, 41);
		ResultLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		panel_1.add(ResultLabel);
		
		JLabel ResultTranslateLabel = new JLabel("-");
		ResultTranslateLabel.setBounds(322, 7, 10, 36);
		ResultTranslateLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		panel_1.add(ResultTranslateLabel);
		
	}
	
	
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}

	public int getLanguage ()
	{
		return language;
	}
	
	public int getSentence ()
	{
		return sentence;
	}

public void updateTranslateResult (String resultAns) {
		
		Font font;
		
		if (language == 1)
		{	
			font = new Font("Malgun Gothic", Font.PLAIN, 30);
			this.ResultTranslateLabel.setFont(font);
		}
		else 
		{
			font = this.getFontStyle();
			this.ResultTranslateLabel.setFont(font);
		}
			
		
		this.ResultTranslateLabel.setText(resultAns);
		
	}

public void waitForInputs() throws InterruptedException {
    synchronized (this) 
    {
        
        wait();
    }
} 

	
public void actionPerformed(ActionEvent event) {
		

	
	language = LanguageComboBox.getSelectedIndex();
	sentence =SentenceComboBox.getSelectedIndex();
	
	synchronized (this)
	{
		
		this.notifyAll();
	}
		String actionCommand = event.getActionCommand();
		
		switch (actionCommand) {
			
		case "Comfirm":
			// Process word counting
			
			updateTranslateResult(actionCommand);
			
			break;
		
		case "Cancel": 
			// Clear the frame
			
			clearFrameDisplay();
			
			break;
			
		} // end of switch-actionCommand
		
		
	}




	private void clearFrameDisplay () {
		
		
		ResultTranslateLabel.setText("-");
	}



}
	

