package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel{
	public JButton startGameButton;
	private JLabel NamePanel;

	/**
	 * Create the application.
	 */
	public MenuPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 800, 600);
		setLayout(null);
		
		startGameButton = new JButton("Start Game");
		startGameButton.setFont(new Font("Arial", Font.PLAIN, 55));
		startGameButton.setBounds(219, 263, 373, 121);
		
		add(startGameButton);
		
		NamePanel = new JLabel("Portal");
		NamePanel.setFont(new Font("Arial", Font.PLAIN, 60));
		NamePanel.setHorizontalAlignment(SwingConstants.CENTER);
		NamePanel.setBounds(219, 47, 373, 110);
		add(NamePanel);
	}
}
