package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

public class Menu {

	private JFrame frmPortal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmPortal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmPortal = new JFrame();
		frmPortal.setTitle("Bitang_PortalGame");
		frmPortal.setBounds(100, 100, 800, 600);
		frmPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPortal.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 55));
		btnNewButton.setBounds(219, 263, 373, 121);
		frmPortal.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Portal");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(219, 47, 373, 110);
		frmPortal.getContentPane().add(lblNewLabel);
	}
}
