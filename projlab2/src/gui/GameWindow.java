package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	public MenuPanel mp;
	public GamePanel gp;

	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setType(Type.UTILITY);
		setTitle("Bitang_PortalGame");
//		setBounds(100, 100, 542, 371);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setVisible(true);
		
		mp = new MenuPanel();		
		add(mp);
		gp = new GamePanel();		
		add(gp);
		
		addActionListeners();		
	}
	
	/**
	 * Eseményfigyelők hozzáadása
	 */
	private void addActionListeners(){
		mp.startGameButton.addActionListener(e->{
			mp.setVisible(false);
			gp.setVisible(true);
		});
		
		//gombnyomásra alkalmazás bezárása
		gp.btnEndGame.addActionListener(e->{
			System.exit(0);
		});
		
		//további eseményfigyelők hozzáadása...
	}
}
