package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class GameWindow {

	private JFrame frmBitangportalgame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frmBitangportalgame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBitangportalgame = new JFrame();
		frmBitangportalgame.setType(Type.UTILITY);
		frmBitangportalgame.setTitle("Bitang_PortalGame");
		frmBitangportalgame.setBounds(100, 100, 542, 371);
		frmBitangportalgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBitangportalgame.setSize(1024, 768);
		frmBitangportalgame.getContentPane().setLayout(new BorderLayout(0, 0));
		frmBitangportalgame.setResizable(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		frmBitangportalgame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		Map map = new Map(); 								//pálya létrehozása
		map.setBounds(0, 0, 800, 729);
		map.setBackground(Color.WHITE);
		mainPanel.add(map);
		
		JLabel lblOneil = new JLabel("Oneil ZPM:");
		lblOneil.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOneil.setHorizontalAlignment(SwingConstants.LEFT);
		lblOneil.setBounds(810, 124, 96, 56);
		mainPanel.add(lblOneil);
		
		JLabel lblNewLabel = new JLabel("Jaffa ZPM:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(810, 184, 96, 56);
		mainPanel.add(lblNewLabel);
		
		JLabel lblZpmekSzmaA = new JLabel("Összes ZPM:");
		lblZpmekSzmaA.setFont(new Font("Arial", Font.PLAIN, 14));
		lblZpmekSzmaA.setHorizontalAlignment(SwingConstants.LEFT);
		lblZpmekSzmaA.setBounds(810, 62, 96, 56);
		mainPanel.add(lblZpmekSzmaA);
		
		JButton btnNewButton = new JButton("Játék befejezése");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(810, 594, 188, 68);
		mainPanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("42");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(928, 62, 46, 56);
		mainPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(928, 124, 46, 56);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(928, 184, 46, 56);
		mainPanel.add(lblNewLabel_3);
		
	}
}
