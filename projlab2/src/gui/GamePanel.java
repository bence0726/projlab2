package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{

	public Map map;
	public JLabel LabNumberOfZPMS;
	public JLabel OneilNumberOfZPMS;
	public JLabel JaffaNumberOfZPMS;
	
	public JButton btnEndGame;
	/**
	 * Create the application.
	 */
	public GamePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 542, 371);
		setSize(1024, 768);
		setLayout(new BorderLayout(0, 0));
		
		setVisible(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		map = new Map(); 								//pálya létrehozása		
		mainPanel.add(map);
		
		JLabel lblOneil = new JLabel("Oneil ZPM:");
		lblOneil.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOneil.setHorizontalAlignment(SwingConstants.LEFT);
		lblOneil.setBounds(810, 124, 96, 56);
		mainPanel.add(lblOneil);
		
		JLabel lblJaffa = new JLabel("Jaffa ZPM:");
		lblJaffa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblJaffa.setHorizontalAlignment(SwingConstants.LEFT);
		lblJaffa.setBounds(810, 184, 96, 56);
		mainPanel.add(lblJaffa);
		
		JLabel lblZPMinLab = new JLabel("Összes ZPM:");
		lblZPMinLab.setFont(new Font("Arial", Font.PLAIN, 14));
		lblZPMinLab.setHorizontalAlignment(SwingConstants.LEFT);
		lblZPMinLab.setBounds(810, 62, 96, 56);
		mainPanel.add(lblZPMinLab);
		
		btnEndGame = new JButton("Játék befejezése");
		btnEndGame.setFont(new Font("Arial", Font.BOLD, 16));
		btnEndGame.setBounds(810, 594, 188, 68);
		mainPanel.add(btnEndGame);
		
		LabNumberOfZPMS = new JLabel("42");
		LabNumberOfZPMS.setHorizontalAlignment(SwingConstants.CENTER);
		LabNumberOfZPMS.setFont(new Font("Arial", Font.BOLD, 14));
		LabNumberOfZPMS.setBounds(928, 62, 46, 56);
		mainPanel.add(LabNumberOfZPMS);
		
		OneilNumberOfZPMS = new JLabel("0");
		OneilNumberOfZPMS.setHorizontalAlignment(SwingConstants.CENTER);
		OneilNumberOfZPMS.setFont(new Font("Arial", Font.BOLD, 14));
		OneilNumberOfZPMS.setBounds(928, 124, 46, 56);
		mainPanel.add(OneilNumberOfZPMS);
		
		JaffaNumberOfZPMS = new JLabel("2");
		JaffaNumberOfZPMS.setFont(new Font("Arial", Font.BOLD, 14));
		JaffaNumberOfZPMS.setHorizontalAlignment(SwingConstants.CENTER);
		JaffaNumberOfZPMS.setBounds(928, 184, 46, 56);
		mainPanel.add(JaffaNumberOfZPMS);
		
	}
}
