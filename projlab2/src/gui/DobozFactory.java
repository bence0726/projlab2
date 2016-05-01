package gui;

import java.awt.Component;
import java.awt.Label;

import javax.swing.ComponentInputMap;

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
public class DobozFactory{

	public static Component BoxMaker(Elem e){
		Label picture;
		if(e instanceof Doboz){
			picture = new Label();
			//picture.imageUpdate(img, infoflags, x, y, w, h) - valahogy beállítjuk a képét
			return picture;
		}
		return null; //ha nem instanceof Doboz
	}
	
}
