package gui;

import javax.swing.JComponent;
import javax.swing.JLabel;

import model.Doboz;
import model.Elem;

/**
 * Az osztálynak majd átadunk egy Elem típusú objektumot,
 * és ha az Doboz típusú, akkor egy adott képű Label
 * lesz a mapon a reprezentációja.
 * Ennek mintájára lehet majd létrehozni KarakterFactory-t,
 * ReplikatorFactory-t, stb.
 * @author zsigatibor
 *
 */
public class DobozFactory implements Factory{

	public JComponent ComponentFactory(Elem e){
		if(!(e instanceof Doboz))
			return null;			//ha nem instanceof Doboz, akkor null-t ad vissza
		
		JLabel picture;
		
		picture = new JLabel();
		//picture.imageUpdate(img, infoflags, x, y, w, h) - valahogy beállítjuk a képét
		return picture;
	}
}
