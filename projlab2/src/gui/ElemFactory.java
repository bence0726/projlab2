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
	public static boolean wallAlreadyDrew = false;

	//elemek képei:
	private static final Image nyitottAjtoImg 	=  (new ImageIcon(textureFolder+"/nyitottajto.png")).getImage();
	private static final Image csukottAjtoImg 	=  (new ImageIcon(textureFolder+"/csukottajto.png")).getImage();
	private static final Image dobozImg 		=  (new ImageIcon(textureFolder+"/doboz.png")).getImage();
	private static final Image endElemImg		=  (new ImageIcon(textureFolder+"/endelem.png")).getImage();
	private static final Image sargagolyoImg 	=  (new ImageIcon(textureFolder+"/Sargagolyo.png")).getImage();
	private static final Image kekgolyoImg 		=  (new ImageIcon(textureFolder+"/Kekgolyo.png")).getImage();
	private static final Image pirosgolyoImg 	=  (new ImageIcon(textureFolder+"/Pirosgolyo.png")).getImage();
	private static final Image zoldgolyoImg 	=  (new ImageIcon(textureFolder+"/Zoldgolyo.png")).getImage();
	private static final Image merlegImg 		=  (new ImageIcon(textureFolder+"/merleg.png")).getImage();
	private static final Image karakter1Img		=  (new ImageIcon(textureFolder+"/karakter1.png")).getImage();
	private static final Image replikatorImg 	=  (new ImageIcon(textureFolder+"/replikator.png")).getImage();
	private static final Image specfalImg 		=  (new ImageIcon(textureFolder+"/fal2.png")).getImage();
	private static final Image kekspecfalImg 	=  (new ImageIcon(textureFolder+"/Kekspecfal.png")).getImage();
	private static final Image sargaspecfalImg 	=  (new ImageIcon(textureFolder+"/Sargaspecfal.png")).getImage();
	private static final Image pirosspecfalImg 	=  (new ImageIcon(textureFolder+"/Pirosspecfal.png")).getImage();
	private static final Image zoldspecfalImg 	=  (new ImageIcon(textureFolder+"/Zoldspecfal.png")).getImage();
	private static final Image startElemImg 	=  (new ImageIcon(textureFolder+"/startelem.png")).getImage();
	private static final Image szakadekImg 		=  (new ImageIcon(textureFolder+"/szakadek.jpg")).getImage();
	private static final Image zpmImg			=  (new ImageIcon(textureFolder+"/zpm.png")).getImage();
	private static final Image karakter2Img 	=  (new ImageIcon(textureFolder+"/karakter2.png")).getImage();
	private static final Image falImg 			=  (new ImageIcon(textureFolder+"/fal.jpg")).getImage();
	
//	private static final ImageIcon nyitottAjtoImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon csukottAjtoImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon dobozImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon endElemImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon sargagolyoImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon kekgolyoImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon pirosgolyoImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon zoldgolyoImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon merlegImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon karakter1Img =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon replikatorImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon specfalImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon kekspecfalImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon sargaspecfalImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon pirosspecfalImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon zoldspecfalImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon startElemImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon szakadekImg =  new ImageIcon(textureFolder+"/Zoldspecfal.jpg");
//	private static final ImageIcon zpmImg =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon karakter2Img =  new ImageIcon(textureFolder+"/Zoldspecfal.png");
//	private static final ImageIcon falImg =  new ImageIcon(textureFolder+"/Zoldspecfal.jpg");
	
	
	
	
	public static JComponent ComponentFactory(Elem e){
		if(e instanceof ZPM)
			return createComponent(zpmImg,defaultMapScale,1.5,e);
		
		if(e instanceof Szakadek)
			return createComponent(szakadekImg,defaultMapScale,defaultImageScale,e);
		
		if(e instanceof SpecFal){
			SpecFal specfal = (SpecFal)e;
			if (!(specfal.isAccessable()))
				return createComponent(specfalImg,defaultMapScale,1.8,e);
			else
				switch(specfal.getSzin()){
				case Kek:
					return createComponent(kekspecfalImg ,defaultMapScale,defaultImageScale,e);
				case Piros:
					return createComponent(pirosspecfalImg ,defaultMapScale,defaultImageScale,e);
				case Sarga:
					return createComponent(sargaspecfalImg ,defaultMapScale,defaultImageScale,e);
				case Zold:
					return createComponent(zoldspecfalImg ,defaultMapScale,defaultImageScale,e);
				}	
		}
		
		if(e instanceof Ajto)
		{
			Ajto door = (Ajto)e;
			if (door.isAccessable())
				return createComponent(nyitottAjtoImg,defaultMapScale,defaultImageScale,e);
			else
				return createComponent(csukottAjtoImg,defaultMapScale,defaultImageScale,e);
		}
		
		if(e instanceof Doboz)
			return createComponent(dobozImg,defaultMapScale,1.8,e);
		
		if((e instanceof EndElem))
			return createComponent(endElemImg,defaultMapScale,defaultImageScale,e);
		
		if(e instanceof Golyo)
		{
			Golyo bullet = (Golyo)e;
			switch(bullet.getSzin()){
			case Kek:
				return createComponent(kekgolyoImg ,defaultMapScale,defaultImageScale,e);
			case Piros:
				return createComponent(pirosgolyoImg ,defaultMapScale,defaultImageScale,e);
			case Sarga:
				return createComponent(sargagolyoImg ,defaultMapScale,defaultImageScale,e);
			case Zold:
				return createComponent(zoldgolyoImg ,defaultMapScale,defaultImageScale,e);
			}			
		}
		
		if(e instanceof Merleg)
			return createComponent(merlegImg,defaultMapScale,0.85,e);
		
		if(e instanceof Oneil)
			return createComponent(karakter1Img,defaultMapScale,defaultImageScale,e);
		
		if(e instanceof Replikator)
			return createComponent(replikatorImg,defaultMapScale,defaultImageScale,e);
		
		
		if(e instanceof StartElem)
			return createComponent(startElemImg,defaultMapScale,defaultImageScale,e);

		if(e instanceof Karakter) //majd kell ide kicsit több logika, hogy arra nézzen, amerre mozog a karakter
			return createComponent(karakter2Img,defaultMapScale,defaultImageScale,e);
		
		//if (!wallAlreadyDrew)
			if(e instanceof Fal)
				return createComponent(falImg,defaultMapScale,defaultImageScale,e);
		
		return null;
	}
	
	
	private static JComponent createComponent(Image image,double mapscale,double imagescale,Elem e){
		int rows =(int)Math.round(e.getPos().getHeight()/20*mapscale);
		int columns =(int)Math.round(e.getPos().getWidth()/20*mapscale);
		JPanel panel = new JPanel(new GridLayout(rows,columns,0,0));
		panel.setBounds((int)e.getPos().getKezd().getVx(), (int)e.getPos().getKezd().getVy(), (int)(e.getPos().getWidth()*mapscale), (int)(e.getPos().getHeight()*mapscale));
		Image newimg = image.getScaledInstance((int)(e.getPos().getWidth()/columns*imagescale),(int)(e.getPos().getHeight()/rows*imagescale), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//		imageIcon = new ImageIcon(newimg);  // transform it back
		for (int i=0;i<rows*columns;i++)
		{
			JLabel label = new JLabel(new ImageIcon(newimg),JLabel.CENTER);
			panel.add(label);
		}
		return panel;
	}
	
}
