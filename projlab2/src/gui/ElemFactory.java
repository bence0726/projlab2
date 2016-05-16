package gui;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;

public class ElemFactory {
	
	private static final double defaultMapScale = 1;
	private static final double defaultImageScale = 2; //Azért kettő mert így néz ki jól.
	private static final String textureFolder = "src/textures";

	public static JComponent ComponentFactory(Elem e){
		if(e instanceof Ajto)
		{
			Ajto door = (Ajto)e;
			if (door.isAccessable())
				return createComponent("nyitottajto.png",defaultMapScale,defaultImageScale,e);
			else
				return createComponent("csukottajto.png",defaultMapScale,defaultImageScale,e);
		}
		
		if(e instanceof Doboz)
			return createComponent("doboz.png",defaultMapScale,defaultImageScale,e);
		
		if((e instanceof EndElem))
			return createComponent("endelem.png",defaultMapScale,defaultImageScale,e);
		
		if(e instanceof Golyo)
		{
			Golyo bullet = (Golyo)e;
			return createComponent(bullet.getSzin().toString()+"golyo.png",defaultMapScale,defaultImageScale,e);
		}
		
		if(e instanceof Merleg)
			return createComponent("merleg.png",defaultMapScale,defaultImageScale,e);
		
		if(e instanceof Oneil)
			return createComponent("karakter1.png",defaultMapScale,defaultImageScale,e);
		
		if(e instanceof Replikator)
			return createComponent("replikator.png",defaultMapScale,defaultImageScale,e);
		
		if(e instanceof SpecFal){
			SpecFal specfal = (SpecFal)e;
			if (!(specfal.isAccessable()))
				return createComponent("specfal.png",defaultMapScale,defaultImageScale,e);
			else
				return createComponent(specfal.getSzin().toString()+"specfal.png",defaultMapScale,defaultImageScale,e);
		}
		if(e instanceof StartElem)
			return createComponent("startelem.png",defaultMapScale,defaultImageScale,e);
		
		if(e instanceof Szakadek)
			return createComponent("szakadek.jpg",defaultMapScale,defaultImageScale,e);
		
		if(e instanceof ZPM)
			return createComponent("zpm.png",defaultMapScale,defaultImageScale,e);
		
		if(e instanceof Karakter) //majd kell ide kicsit több logika, hogy arra nézzen, amerre mozog a karakter
			return createComponent("karakter2.png",defaultMapScale,defaultImageScale,e);
		
		if(e instanceof Fal)
			return createComponent("fal.jpg",defaultMapScale,defaultImageScale,e);
		
		return null;
	}
	
	
	private static JComponent createComponent(String imagestr,double mapscale,double imagescale,Elem e){
		int rows =(int)Math.round(e.getPos().getHeight()/20*mapscale);
		int columns =(int)Math.round(e.getPos().getWidth()/20*mapscale);
		JPanel panel = new JPanel(new GridLayout(rows,columns,0,0));
		panel.setBounds((int)e.getPos().getKezd().getVx(), (int)e.getPos().getKezd().getVy(), (int)(e.getPos().getWidth()*mapscale), (int)(e.getPos().getHeight()*mapscale));
		String file = textureFolder + "/" + imagestr;
		ImageIcon imageIcon = new ImageIcon(file); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance((int)(e.getPos().getWidth()/columns*imagescale),(int)(e.getPos().getHeight()/rows*imagescale), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		for (int i=0;i<rows*columns;i++)
		{
			JLabel label = new JLabel(imageIcon,JLabel.CENTER);
			panel.add(label);
		}
		return panel;
	}
	
}
