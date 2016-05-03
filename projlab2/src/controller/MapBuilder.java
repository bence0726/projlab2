package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import model.Doboz;
import model.Elem;
import model.Fal;
import model.JatekMotor;
import model.Karakter;
import model.Labirintus;
import model.Merleg;
import model.Oneil;
import model.PortalManager;
import model.Replikator;
import model.SpecFal;
import model.Szakadek;
import model.Terulet;
import model.Vektor;
import model.ZPM;

/**
 * Pálya felépítéséhez készült. Egy fájlt kap, abból felépíti
 *  az egész labirintust. Az ehhez szükséges függvényeket
 *  gyűjti egy csokorba ez az osztály.
 * @author zsigatibor
 *
 */
public class MapBuilder {
	/**
	 * Tárolunk referenciát a Játékmotorra. Tőle fogjuk elkérni
	 * majd a labirintus és a portalmanager referenciáját,
	 * és azokat is fogjuk tárolni. De semmiképpen nem itt hozzuk létre.
	 */
	private JatekMotor jm;
	private Labirintus lab;
	private PortalManager pm;
	
	public MapBuilder(JatekMotor gameEngine){
		jm = gameEngine;
		lab = jm.getLab();
		pm = jm.getPortalManager();
	}	
	
	/**
	 * A paraméterül kapott fájlból beolvassa a
	 * sorokat, majd azok alapján felépíti 
	 * a labirintust.
	 * @param fp
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void buildMap(File fp) throws NumberFormatException, IOException{
	
	BufferedReader buffreader = new BufferedReader(new FileReader(fp));
	//String testName = fp.getName();
	//String[] piece = testName.split(".txt");
	String line;				
	while((line = buffreader.readLine()) != null){	
		
	//List<Elem> list = jm.getLab().getObjectsOnMapList();
	String[] pieces = line.split(" ");
	
	switch(pieces[0]){
	case "ADD":
		switch (pieces[1]) {
		case "FAL":
			//beforeAdd = list.size();
			addFal(Integer.parseInt(pieces[2]),
					Integer.parseInt(pieces[3]),
					Integer.parseInt(pieces[4]),
					Integer.parseInt(pieces[5]));					
			//afterAdd = list.size();					
			//if(beforeAdd < afterAdd)//megvizsgáljuk, hogy nőtt-e a lista mérete
			//	TO.AddResultRow("FAL ADDED");//(vagyis bekerült-e az elem)
			//else
			//	TO.AddResultRow("ADDING FAL FAILED");
			break;
		case "SPECFAL":
			//beforeAdd = list.size();
			addSpecFal(Integer.parseInt(pieces[2]),
					Integer.parseInt(pieces[3]),
					Integer.parseInt(pieces[4]),
					Integer.parseInt(pieces[5]),
					Integer.parseInt(pieces[6]),
					Integer.parseInt(pieces[7]));					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("SPECFAL ADDED");
			//else
			//	TO.AddResultRow("ADDING SPECFAL FAILED");
			break;
		case "STARTELEM":
			//beforeAdd = list.size();
			addStartElem(Integer.parseInt(pieces[2]),
					Integer.parseInt(pieces[3]),
					Integer.parseInt(pieces[4]),
					Integer.parseInt(pieces[5]));					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("STARTELEM ADDED");	
			//else
			//	TO.AddResultRow("ADDING STARTELEM FAILED");
			break;
		case "ENDELEM":
			//beforeAdd = list.size();
			addEndElem(Integer.parseInt(pieces[2]),
					Integer.parseInt(pieces[3]),
					Integer.parseInt(pieces[4]),
					Integer.parseInt(pieces[5]));					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("ENDELEM ADDED");	
			//else
			//	TO.AddResultRow("ADDING ENDELEM FAILED");
			break;
		case "SZAKADEK":
			//beforeAdd = list.size();
			addSzakadek(Integer.parseInt(pieces[2]),
					Integer.parseInt(pieces[3]),
					Integer.parseInt(pieces[4]),
					Integer.parseInt(pieces[5]));					
			//6afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("SZAKADEK ADDED");
			//else
			//	TO.AddResultRow("ADDING SZAKADEK FAILED");
			break;
		case "ZPM":
			//beforeAdd = list.size();
			addZPM(Integer.parseInt(pieces[2]),
					Integer.parseInt(pieces[3]),
					Integer.parseInt(pieces[4]),
					Integer.parseInt(pieces[5]));					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("ZPM ADDED");
			//else
			//	TO.AddResultRow("ADDING ZPM FAILED");
			break;					
		case "REPLIKATOR":
			//beforeAdd = list.size();
			addReplikator();					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("REPLIKATOR ADDED");	
			//else
			//	TO.AddResultRow("ADDING REPLIKATOR FAILED");
			break;
		case "DOBOZ":
			//beforeAdd = list.size();
			addDoboz(Integer.parseInt(pieces[2]),
					Integer.parseInt(pieces[3]),
					Integer.parseInt(pieces[4]),
					Integer.parseInt(pieces[5]),
					Integer.parseInt(pieces[6]));					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("DOBOZ ADDED");
			//else
			//	TO.AddResultRow("ADDING DOBOZ FAILED");
			break;
		case "MERLEG":
			//beforeAdd = list.size();
			addMerleg(Integer.parseInt(pieces[2]),
					Integer.parseInt(pieces[3]),
					Integer.parseInt(pieces[4]),
					Integer.parseInt(pieces[5]),
					Integer.parseInt(pieces[6]),
					Integer.parseInt(pieces[7]),
					Integer.parseInt(pieces[8]),
					Integer.parseInt(pieces[9]),
					Integer.parseInt(pieces[10]));					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("MERLEG ADDED");
			//else
			//	TO.AddResultRow("ADDING MERLEG FAILED");
			break;
		case "JAFFA":
			//beforeAdd = list.size();
			addJaffa();					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("JAFFA ADDED");	
			//else
			//	TO.AddResultRow("ADDING JAFFA FAILED");
			break;
		case "ONEIL":
			//beforeAdd = list.size();
			addOneil();					
			//afterAdd = list.size();
			//if(beforeAdd < afterAdd)
			//	TO.AddResultRow("ONEIL ADDED");	
			//else
			//	TO.AddResultRow("ADDING ONEIL FAILED");
			break;
		default:
			break;
		}
	default:
		break;
	
		
	}	
	}
	buffreader.close();
	}
	
	/**
	 * a kapott paraméterekkel meghívja a Fal 
	 * konstruktorát és hozzáadja a Labirintushoz.
	 * 
	 */
	private void addFal(int x1, int y1, int x2, int y2){
		Fal tmp = new Fal(new Vektor(x1,y1), new Vektor(x2,y2));
		lab.addElem(tmp);		
	}
		
	/**
	 * a kapott paraméterekkel meghívja a SpecFal konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 * 
	 */
	private void addSpecFal(int x1, int y1, int d1, int d2, int px, int py){
		SpecFal tmp = new SpecFal(new Vektor(x1,y1),
								new Vektor(d1,d2),
								new Vektor(px, py), //a portál ide fogja kitenni a karaktert
								pm);
		lab.addElem(tmp);
	}
	
	/**
	 * a kapott paraméterekkel meghívja a ZPM
	 *  konstruktorát és hozzáadja a Labirintushoz.
	 */
	private void addZPM(int x1, int y1, int d1, int d2){
		ZPM tmp = new ZPM(new Vektor(x1,y1), new Vektor(d1,d2));
		lab.addZPM(tmp);
	}
	
	/**
	 * a kapott paraméterekkel meghívja a VegeElem konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 */
	private void addEndElem(int x1, int y1, int d1, int d2){
		Fal tmp = new Fal(new Vektor(x1,y1), new Vektor(d1,d2));
		tmp.setReachable(true);
		lab.addEndElem(tmp);
	}
	
	/**
	 * a kapott paraméterekkel meghívja a Szakadek konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 */
	private void addSzakadek(int x1, int y1, int d1, int d2){
		Szakadek tmp = new Szakadek(new Vektor(x1,y1), new Vektor(d1,d2));
		lab.addElem(tmp);
	}
	
	/**
	 * a kapott paraméterekkel meghívja a Merleg konstruktorát és hozzáadja
	 * a Labirintushoz. 
	 * A Merleg konstruktora a kapott paraméterekkel a hozzá tartozó
	 *  ajtót is létrehozza, valamint beállítja annak súlyhatárát is.
	 */
	private void addMerleg(int mx1, int my1, int md1, int md2, int ax1, int ay1, int ad1, int ad2, int limit){
		Fal ajto = new Fal(new Vektor(ax1,ay1),
				new Vektor(ad1,ad2));
		ajto.setReachable(false);
		lab.addElem(new Merleg(new Terulet(
				new Vektor(mx1,my1),
				new Vektor(md1,md2)),
				ajto, limit));
		lab.addElem(ajto);
	}	
	
	/**
	 * a kapott paraméterekkel meghívja a Doboz konstruktorát és hozzáadja a Labirintushoz.
	 */
	private void addDoboz(int x, int y, int d1, int d2,int suly){
		Doboz tmp = new Doboz(lab, new Vektor(x,y),
				new Vektor(d1,d2),suly);
		lab.addMoveable(tmp);
	}
		
	/**
	 * a kapott paraméterekkel a Labirintushoz Startelem attribútumát
	 * állítja be.
	 */
	private void addStartElem(int x1, int y1, int d1, int d2){
		Fal tmp = new Fal(new Vektor(x1,y1), new Vektor(d1,d2));
		tmp.setReachable(true);
		lab.addStartElem(tmp);
	}

	/**
	 * Replikátort ad a labirintushoz. Paraméter nélkül megadva
	 * a kezdőpontra teszi le.
	 * Figyelem! A konstruktor hívása előtt a labirintus
	 * kezdőpontja inicializálva kell legyen, különben nullptr
	 * exception-t vált ki!
	 */
	private void addReplikator(){
		Replikator tmp = new Replikator(lab, lab.getstartElem().getPos().getKezd(),new Vektor(10,10));
		lab.addMoveable(tmp);
	}

	/**
	 * Beállítja Jaffát a modellben.
	 * FIGYELEM! Először a kezdőpontot kell
	 * beállítani a labirintusban!
	 */
	private void addJaffa(){
		Karakter jaffa = new Karakter(lab,
				lab.getstartElem().getPos().getKezd(),
				new Vektor(10,10));
		lab.addMoveable(jaffa);
		lab.addJaffa(jaffa);	
	}
	/**
	 * Beállítja Oneilt a modellben.
	 * FIGYELEM! Először a kezdőpontot kell
	 * beállítani a labirintusban!
	 */
	private void addOneil(){
		Karakter oneil = new Oneil(lab,
				lab.getstartElem().getPos().getKezd(),
				new Vektor(10,10));
		lab.addOneil(oneil);
	}
}
