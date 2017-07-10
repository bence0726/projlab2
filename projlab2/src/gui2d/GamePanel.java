package gui2d;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{

	public Map map;
	public JLabel LabNumberOfZPMS;
	public JLabel OneilNumberOfZPMS;
	public JLabel JaffaNumberOfZPMS;
	public JLabel CiklusszamlaloErtek;
	
	public JButton btnEndGame;
	private JLabel lblOneilGundir;
	public JLabel oneilgundirlabel;
	private JLabel lblJaffaGundir;
	public JLabel jaffagundirvalue;
	public JLabel jatekvegelabel;
	public JLabel nyerteslabel;
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
		mainPanel.setBackground(SystemColor.activeCaption);
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
		btnEndGame.setBounds(810, 645, 188, 68);
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
		
		JLabel lblCiklusszmll = new JLabel("Ciklusszámláló");
		lblCiklusszmll.setBounds(810, 251, 88, 30);
		lblCiklusszmll.setVisible(false);
		mainPanel.add(lblCiklusszmll);
		
		CiklusszamlaloErtek = new JLabel("");
		CiklusszamlaloErtek.setBounds(908, 251, 70, 30);
		CiklusszamlaloErtek.setVisible(false);
		mainPanel.add(CiklusszamlaloErtek);
		
		lblOneilGundir = new JLabel("Oneil gundir");
		lblOneilGundir.setBounds(810, 292, 96, 30);
		mainPanel.add(lblOneilGundir);
		
		oneilgundirlabel = new JLabel("");
		oneilgundirlabel.setBounds(918, 286, 53, 36);
		mainPanel.add(oneilgundirlabel);
		
		lblJaffaGundir = new JLabel("jaffa gundir");
		lblJaffaGundir.setBounds(810, 330, 80, 30);
		mainPanel.add(lblJaffaGundir);		
		
		jaffagundirvalue = new JLabel("");
		jaffagundirvalue.setBounds(908, 338, 70, 22);
		mainPanel.add(jaffagundirvalue);
		
		jatekvegelabel = new JLabel("Vége a játéknak.");
		jatekvegelabel.setFont(new Font("Consolas", Font.PLAIN, 50));
		jatekvegelabel.setBounds(174, 611, 440, 56);
		jatekvegelabel.setVisible(false);
		mainPanel.add(jatekvegelabel);
		
		nyerteslabel = new JLabel("A nyertes: ");
		nyerteslabel.setFont(new Font("Consolas", Font.PLAIN, 50));
		nyerteslabel.setBounds(166, 671, 549, 73);
		nyerteslabel.setVisible(false);
		mainPanel.add(nyerteslabel);
	}
}
