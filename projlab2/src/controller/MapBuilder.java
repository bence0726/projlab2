package controller;

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
 * A pálya fájlból való felépítéséhez csináltam ezt az osztályt. 
 * Az ehhez szükséges függvényeket gyűjti egy csokorba ez az osztály.
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
	 * a kapott paraméterekkel meghívja a Fal 
	 * konstruktorát és hozzáadja a Labirintushoz.
	 * 
	 */
	public void addFal(int x1, int y1, int x2, int y2){
		Fal tmp = new Fal(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2)));
		lab.addElem(tmp);		
	}
		
	/**
	 * a kapott paraméterekkel meghívja a SpecFal konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 * 
	 */
	public void addSpecFal(int x1, int y1, int d1, int d2, int px, int py){
		SpecFal tmp = new SpecFal(new Terulet(new Vektor(x1,y1),
				new Vektor(d1,d2)),
				new Vektor(px, py), //a portál ide fogja kitenni a karaktert
				pm);
		lab.addElem(tmp);
	}
	
	/**
	 * a kapott paraméterekkel meghívja a ZPM
	 *  konstruktorát és hozzáadja a Labirintushoz.
	 */
	public void addZPM(int x1, int y1, int d1, int d2){
		ZPM tmp = new ZPM(new Terulet(new Vektor(x1,y1), new Vektor(d1,d2)));
		lab.addElem(tmp);
	}
	
	/**
	 * a kapott paraméterekkel meghívja a VegeElem konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 */
	public void addEndElem(int x1, int y1, int d1, int d2){
		Fal tmp = new Fal(new Vektor(x1,y1), new Vektor(d1,d2));
		tmp.setReachable(true);
		lab.addEndElem(tmp);
	}
	
	/**
	 * a kapott paraméterekkel meghívja a Szakadek konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 */
	public void addSzakadek(int x1, int y1, int d1, int d2){
		Szakadek tmp = new Szakadek(new Terulet(new Vektor(x1,y1), new Vektor(d1,d2)));
		lab.addElem(tmp);
	}
	
	/**
	 * a kapott paraméterekkel meghívja a Merleg konstruktorát és hozzáadja
	 * a Labirintushoz. 
	 * A Merleg konstruktora a kapott paraméterekkel a hozzá tartozó
	 *  ajtót is létrehozza, valamint beállítja annak súlyhatárát is.
	 */
	public void addMerleg(int mx1, int my1, int md1, int md2, int ax1, int ay1, int ad1, int ad2, int limit){
		Fal ajto = new Fal(new Terulet(
				new Vektor(ax1,ay1),
				new Vektor(ad1,ad2)));
		ajto.setReachable(false);
		lab.addElem(new Merleg(new Terulet(
				new Vektor(mx1,my1),
				new Vektor(md1,md2)),
				ajto, limit));
	}	
	
	/**
	 * a kapott paraméterekkel meghívja a Doboz konstruktorát és hozzáadja a Labirintushoz.
	 */
	public void addDoboz(int x, int y, int d1, int d2,int suly){
		Doboz tmp = new Doboz(lab, new Vektor(x,y),
				new Vektor(d1,d2),suly);
		lab.addMoveable(tmp);
	}
	
	
	/**
	 * a kapott paraméterekkel a Labirintushoz Startelem attribútumát
	 * állítja be.
	 */
	public void addStartElem(int x1, int y1, int d1, int d2){
		Fal tmp = new Fal(new Vektor(x1,y1), new Vektor(d1,d2));
		tmp.setReachable(true);
		lab.addStartElem(tmp);
	}

	
//	/**
//	 *a kapott paraméterekkel meghívja a Replikator konstruktorát,
//	 * hozzáadja a Labirintushoz és a mozgatandok listához is.
//	 */
//	public void addReplikator(int x, int y){
//		Replikator tmp = new Replikator(lab, new Vektor(x,y));
//		lab.addMoveable(tmp);
//	}
	/**
	 * Replikátort ad a labirintushoz. Paraméter nélkül megadva
	 * a kezdőpontra teszi le.
	 * Figyelem! A konstruktor hívása előtt a labirintus
	 * kezdőpontja inicializálva kell legyen, különben nullptr
	 * exception-t vált ki!
	 */
	public void addReplikator(){
		Replikator tmp = new Replikator(lab, lab.getstartElem().getPos().getKezd(),new Vektor(3,3));
		lab.addMoveable(tmp);
	}

	/**
	 * Beállítja Jaffát a modellben.
	 * FIGYELEM! Először a kezdőpontot kell
	 * beállítani a labirintusban!
	 */
	public void addJaffa(){
		Karakter jaffa = new Karakter(lab,
				lab.getstartElem().getPos().getKezd(),
				new Vektor(5,5));
		lab.addMoveable(jaffa);
		lab.addJaffa(jaffa);	
	}
	/**
	 * Beállítja Oneilt a modellben.
	 * FIGYELEM! Először a kezdőpontot kell
	 * beállítani a labirintusban!
	 */
	public void addOneil(){
		Karakter oneil = new Oneil(lab,
				lab.getstartElem().getPos().getKezd(),
				new Vektor(5,5));
		lab.addMoveable(oneil);
		lab.addOneil(oneil);	
	}
}
