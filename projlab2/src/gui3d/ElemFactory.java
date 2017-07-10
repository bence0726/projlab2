package gui3d;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.javafx.geom.Shape;

import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Shape3D;
import model.Ajto;
import model.Doboz;
import model.Elem;
import model.EndElem;
import model.Fal;
import model.Golyo;
import model.Karakter;
import model.Merleg;
import model.Oneil;
import model.Replikator;
import model.SpecFal;
import model.StartElem;
import model.Szakadek;
import model.ZPM;

public class ElemFactory {
	
	
	public static Shape3D ComponentFactory(Elem e){
		if(e instanceof ZPM)
			return createBoxComponent(new PhongMaterial(Color.AQUA),e);
		
		if(e instanceof Szakadek)
			return createBoxComponent(new PhongMaterial(Color.BLACK),e);
		
		if(e instanceof SpecFal){
			SpecFal specfal = (SpecFal)e;
			if (!(specfal.isAccessable()))
				return createBoxComponent(new PhongMaterial(Color.GREY),e);
			else
				switch(specfal.getSzin()){
				case Kek:
					return createBoxComponent(new PhongMaterial(Color.BLUE),e);
				case Piros:
					return createBoxComponent(new PhongMaterial(Color.RED),e);
				case Sarga:
					return createBoxComponent(new PhongMaterial(Color.YELLOW),e);
				case Zold:
					return createBoxComponent(new PhongMaterial(Color.GREEN),e);
				}	
		}
		
		if(e instanceof Ajto)
		{
			Ajto door = (Ajto)e;
			if (door.isAccessable())
				return createBoxComponent(new PhongMaterial(Color.WHITE),e);
			else
				return createBoxComponent(new PhongMaterial(Color.PINK),e);
		}
		
		if(e instanceof Doboz)
			return createBoxComponent(new PhongMaterial(Color.BROWN),e);
		
		if((e instanceof EndElem))
			return createBoxComponent(new PhongMaterial(Color.PURPLE),e);
		
		if(e instanceof Golyo)
		{
			Golyo bullet = (Golyo)e;
			switch(bullet.getSzin()){
			case Kek:
				return createBoxComponent(new PhongMaterial(Color.BLUE),e);
			case Piros:
				return createBoxComponent(new PhongMaterial(Color.RED),e);
			case Sarga:
				return createBoxComponent(new PhongMaterial(Color.YELLOW),e);
			case Zold:
				return createBoxComponent(new PhongMaterial(Color.GREEN),e);
			}			
		}
		
		if(e instanceof Merleg)
			return createBoxComponent(new PhongMaterial(Color.GREY),e);
		
		if(e instanceof Oneil)
			return createBoxComponent(new PhongMaterial(Color.BLACK),e);
		
		if(e instanceof Replikator)
			return createBoxComponent(new PhongMaterial(Color.BLANCHEDALMOND),e);
		
		
		if(e instanceof StartElem)
			return createBoxComponent(new PhongMaterial(Color.WHITE),e);

		if(e instanceof Karakter) //majd kell ide kicsit több logika, hogy arra nézzen, amerre mozog a karakter
			return createBoxComponent(new PhongMaterial(Color.BLACK),e);
		
		//if (!wallAlreadyDrew)
			if(e instanceof Fal)
				return createBoxComponent(new PhongMaterial(Color.DARKGREY),e);
		
		return null;
	}
	
	private static Shape3D createBoxComponent(PhongMaterial material,Elem e){
		Box box = new Box(e.getPos().getHeight(), e.getPos().getWidth(), 100);
		box.setCullFace(CullFace.NONE);
		box.setMaterial(material);
		box.setTranslateX(e.getPos().getKezd().getVx());
		box.setTranslateY(e.getPos().getKezd().getVy());
		return box;
	}
}
