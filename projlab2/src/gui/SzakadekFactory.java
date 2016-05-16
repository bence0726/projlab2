package gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Elem;
import model.Szakadek;

/**
 * Az osztálynak majd átadunk egy Elem típusú objektumot,
 * és ha az Doboz típusú, akkor egy adott képű Label
 * lesz a mapon a reprezentációja.
 * Ennek mintájára lehet majd létrehozni KarakterFactory-t,
 * ReplikatorFactory-t, stb.
 * @author zsigatibor
 *
 */
public class SzakadekFactory implements Factory{

	public JComponent ComponentFactory(Elem e){
		if(!(e instanceof Szakadek))
			return null;			//ha nem instanceof Doboz, akkor null-t ad vissza
		
		int rows =(int)Math.round(e.getPos().getHeight()/20);
		int columns =(int)Math.round(e.getPos().getWidth()/20);
		JPanel panel = new JPanel(new GridLayout(rows,columns,0,0));
		panel.setBounds((int)e.getPos().getKezd().getVx(), (int)e.getPos().getKezd().getVy(), (int)e.getPos().getWidth(), (int)e.getPos().getHeight());
		ImageIcon imageIcon = new ImageIcon("src/textures/Szakadek.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
<<<<<<< HEAD
		Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
=======
		Image newimg = image.getScaledInstance(40,40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
>>>>>>> branch 'master' of https://github.com/bence0726/projlab2.git
		imageIcon = new ImageIcon(newimg);  // transform it back
		for (int i=0;i<rows*columns;i++)
		{
			JLabel label = new JLabel(imageIcon,JLabel.CENTER);
			panel.add(label);
		}
		return panel;
	}
}

