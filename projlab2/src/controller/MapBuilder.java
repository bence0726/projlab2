package controller;

import model.Doboz;
import model.Fal;
import model.JatekMotor;
import model.Labirintus;
import model.Merleg;
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
	public void addFal(int x1, int y1, int x2, int y2)
	{
		Fal tmp=new Fal(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2)));
		tmp.setReachable(false);		
		lab.addElem(tmp);		
	}
	
	
	/**
	 * a kapott paraméterekkel meghívja a SpecFal konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 * 
	 */
	public void addSpecFal(int x1, int y1, int x2, int y2)
	{
		SpecFal tmp=new SpecFal(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2)), pm);
		tmp.setReachable(false);
		lab.addElem(tmp);
	}
	
	
	/**
	 * a kapott paraméterekkel meghívja a ZPM
	 *  konstruktorát és hozzáadja a Labirintushoz.
	 */
	public void addZPM(int x1, int y1, int x2, int y2)
	{
		ZPM tmp = new ZPM(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2)));
		lab.addElem(tmp);
	}
	
	
	
	/**
	 * a kapott paraméterekkel meghívja a VegeElem konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 */
	public void addVegeElem(int x1, int y1, int x2, int y2)
	{
		Fal tmp=new Fal(new Vektor(x1,y1), new Vektor(x2,y2));
		tmp.setReachable(true);
		lab.addEndElem(tmp);
	}
	
	
	
	/**
	 * a kapott paraméterekkel meghívja a Szakadek konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 */
	public void addSzakadek(int x1, int y1, int x2, int y2)
	{
		Szakadek tmp = new Szakadek(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2)));
		lab.addElem(tmp);
	}
	
	
	
	/**
	 * a kapott paraméterekkel meghívja a Merleg konstruktorát és hozzáadja
	 * a Labirintushoz. 
	 * A Merleg konstruktora a kapott paraméterekkel a hozzá tartozó ajtót is létrehozza.
	 */
	public void addMerleg(int mx1, int my1, int mx2, int my2, int ax1, int ay1, int ax2, int ay2)
	{
		Fal tmp=new Fal(new Terulet(new Vektor(ax1,ay1), new Vektor(ax2,ay2)));
		tmp.setReachable(false);
		lab.addElem(new Merleg(new Terulet(new Vektor(mx1,my1), new Vektor(mx2,my2)), tmp));
	}
	
	
	/**
	 * a kapott paraméterekkel meghívja a Doboz konstruktorát és hozzáadja a Labirintushoz.
	 */
	public void addDoboz(int x, int y, int suly)
	{
		Doboz tmp=new Doboz(lab, new Vektor(x,y),suly);
		lab.addMoveable(tmp);
	}
	
	
	/**
	 * a kapott paraméterekkel a Labirintushoz Startelem attribútumát
	 * állítja be.
	 */
	public void addKezdoPont(int x, int y)
	{
		Fal tmp=new Fal(new Vektor(x,y), new Vektor(2,2));
		tmp.setReachable(true);
		lab.addStartElem(tmp);
	}

	
	/**
	 *a kapott paraméterekkel meghívja a Replikator konstruktorát,
	 * hozzáadja a Labirintushoz és a mozgatandok listához is.
	 */
	public void addReplikator(int x, int y)
	{
		Replikator tmp = new Replikator(lab, new Vektor(x,y));
		lab.addMoveable(tmp);
	}
}