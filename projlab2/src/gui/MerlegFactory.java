package gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
		Image newimg = image.getScaledInstance((int)Math.round(e.getPos().getWidth()),
				(int) Math.round(e.getPos().getHeight()),
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		JLabel picture =  new JLabel(imageIcon,JLabel.CENTER);
		picture.setBounds((int)Math.round(e.getPos().getKezd().getVx()), (int)Math.round(e.getPos().getVeg().getVy()),
				(int)Math.round(e.getPos().getWidth()), (int)Math.round(e.getPos().getHeight()));
		return picture;
	}
}

