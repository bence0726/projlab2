package gui;

import java.awt.GridLayout;
import java.awt.Image;
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
public class FalFactory implements Factory{

	public JComponent ComponentFactory(Elem e){
		if(!(e instanceof Fal))
			return null;			//ha nem instanceof Doboz, akkor null-t ad vissza
		
		int rows =(int)Math.round(e.getPos().getHeight()/20*2);
		int columns =(int)Math.round(e.getPos().getWidth()/20);
		JPanel panel = new JPanel(new GridLayout(rows,columns,0,0));
		panel.setBounds((int)e.getPos().getKezd().getVx(), (int)e.getPos().getKezd().getVy(), (int)e.getPos().getWidth()*2, (int)e.getPos().getHeight()*2);
		ImageIcon imageIcon = new ImageIcon("src/textures/Fal.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance((int)e.getPos().getWidth()/columns*2,(int) e.getPos().getHeight()/rows*2, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		for (int i=0;i<rows*columns;i++)
		{
			JLabel label = new JLabel(imageIcon,JLabel.CENTER);
			panel.add(label);
		}
		return panel;
	}
}

