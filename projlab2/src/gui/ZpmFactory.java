package gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Elem;
import model.Fal;

/**
 * Az osztálynak majd átadunk egy Elem típusú objektumot,
 * és ha az Doboz típusú, akkor egy adott képű Label
 * lesz a mapon a reprezentációja.
 * Ennek mintájára lehet majd létrehozni KarakterFactory-t,
 * ReplikatorFactory-t, stb.
 * @author zsigatibor
 *
 */
public class ZpmFactory implements Factory{

	public JComponent ComponentFactory(Elem e){
		if(!(e instanceof Fal))
			return null;			//ha nem instanceof Doboz, akkor null-t ad vissza
		
		
		
		ImageIcon imageIcon = new ImageIcon("src/textures/zpm.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance((int)e.getPos().getWidth(),(int) e.getPos().getHeight(), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		JLabel picture =  new JLabel(imageIcon,JLabel.CENTER);
		picture.setBounds((int)e.getPos().getKezd().getVx(), (int)e.getPos().getVeg().getVy(), (int)e.getPos().getWidth(), (int)e.getPos().getHeight());
		//picture.imageUpdate(img, infoflags, x, y, w, h) - valahogy beállítjuk a képét
		return picture;
	}
}

