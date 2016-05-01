package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Menu extends JFrame{
	public JButton startGameButton;
	private JLabel NamePanel;

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Bitang_PortalGame");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		startGameButton = new JButton("Start Game");
		startGameButton.setFont(new Font("Arial", Font.PLAIN, 55));
		startGameButton.setBounds(219, 263, 373, 121);
		
		getContentPane().add(startGameButton);
		
		NamePanel = new JLabel("Portal");
		NamePanel.setFont(new Font("Arial", Font.PLAIN, 60));
		NamePanel.setHorizontalAlignment(SwingConstants.CENTER);
		NamePanel.setBounds(219, 47, 373, 110);
		getContentPane().add(NamePanel);
	}
}
