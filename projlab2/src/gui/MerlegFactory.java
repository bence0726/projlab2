package gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Elem;
import model.Merleg;

/**
 * Az osztálynak majd átadunk egy Elem típusú objektumot,
 * és ha az Doboz típusú, akkor egy adott képű Label
 * lesz a mapon a reprezentációja.
 * Ennek mintájára lehet majd létrehozni KarakterFactory-t,
 * ReplikatorFactory-t, stb.
 * @author zsigatibor
 *
 *FIXME: A hozzá tartozó ajtót is jó lenne itt beállíteni, de csak 1 visszatérési értéke van.
 * 
 */
public class MerlegFactory implements Factory{

	public JComponent ComponentFactory(Elem e){
		if(!(e instanceof Merleg))
			return null;			//ha nem instanceof Doboz, akkor null-t ad vissza
		
		
		//Merleg
		ImageIcon imageIcon = new ImageIcon("src/textures/Merleg.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance((int)e.getPos().getWidth(),(int) e.getPos().getHeight(), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		JLabel picture =  new JLabel(imageIcon,JLabel.CENTER);
		picture.setBounds((int)e.getPos().getKezd().getVx(), (int)e.getPos().getVeg().getVy(), (int)e.getPos().getWidth(), (int)e.getPos().getHeight());
		return picture;
	}
}

