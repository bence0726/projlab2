package test;



import java.util.*;

import projlab2.*;

public class Test {

	Labirintus lab;
	List<Moveable> mozgatandok; 			//ebben a listában tároljuk azokat az elemeket, amelyeket mozgatni kell. Ide tartoznak a golyók és a replikátorok, amelyek mozgatását a játék-logika végzi, valamint a karakterek is.
	//String ElvartKimenet;					// azt tárolja, hogy a parancsok végrehajtásával milyen kimenetnek kell keletkeznie
	//String ValosKimenet;					// azt tárolja, hogy a parancsok végrehajtása után miylen kimenet keletkezett.
	//List<String[]> parancsok;				//a kapott parancsokat itt tárolja.
	
	
	//Metódusok
	
	
	
	/*
	 * a parancsértelmezőtől kapott parancsokat fogadja és eltárolja 
	 * a parancsok attribútumban.
	 * 
	 */
	/*
	public void addParancs(String[] parancs)
	{
		
	}
	*/
	
	
	/*
	 * Ha vége a bemenetnek, meghívásával lefuttatjuk a
	 * kapott parancsokat. 
	 * A szövegesen beolvasott Stringek
	 * értelmezése és konkrét függvények meghívása itt fog történni
	 */
	/*
	public void run()
	{
		
	}
	*/
	
	
	/*
	 * betölti a kapott fájlból a térképet és a parancsok
	 * listához hozzáadja a benne foglalt parancsokat.
	 * 
	 *
	private void loadMap(String fajlnev)
	{
		
	}
	*/
	
	
	/*
	 * a kapott paraméterekkel meghívja a Fal 
	 * konstruktorát és hozzáadja a Labirintushoz.
	 * 
	 */
	public void addFal(int x1, int y1, int x2, int y2)
	{
		
		lab.addElem(new Fal(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2))));
		
	}
	
	
	/*
	 * a kapott paraméterekkel meghívja a SpecFal konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 * 
	 */
	public void addSpecFal(int x1, int y1, int x2, int y2)
	{
		lab.addElem(new SpecFal(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2)), lab.pm));
	}
	
	
	/*
	 * a kapott paraméterekkel meghívja a ZPM
	 *  konstruktorát és hozzáadja a Labirintushoz.
	 */
	public void addZPM(int x1, int y1, int x2, int y2)
	{
		lab.addElem(new ZPM(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2))));
	}
	
	
	
	/*
	 * a kapott paraméterekkel meghívja a VegeElem konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 */
	public void addVegeElem(int x1, int y1, int x2, int y2)
	{
		//lab.addElem(new ZPM(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2))));
	}
	
	
	
	/*
	 * a kapott paraméterekkel meghívja a Szakadek konstruktorát
	 *  és hozzáadja a Labirintushoz.
	 */
	public void addSzakadek(int x1, int y1, int x2, int y2)
	{
		lab.addElem(new Szakadek(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2))));
	}
	
	
	
	/*
	 * a kapott paraméterekkel meghívja a Merleg konstruktorát és hozzáadja
	 * a Labirintushoz. 
	 * A Merleg konstruktora a kapott paraméterekkel a hozzá tartozó ajtót is létrehozza.
	 */
	public void AddMerleg(int mx1, int my1, int mx2, int my2, int ax1, int ay1, int ax2, int ay2)
	{
		//lab.addElem(new Merleg(new Terulet(new Vektor(mx1,my1), new Vektor(mx2,my2))));
	}
	
	
	
	/*
	 * a kapott paraméterekkel meghívja a Doboz konstruktorát és hozzáadja a Labirintushoz.
	 */
	public void addDoboz(int x1, int y1, int x2, int y2, int suly)
	{
		//lab.addElem(new ZPM(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2))));
	}
	
	
	/*
	 * a kapott paraméterekkel meghívja a KezdoPont konstruktorát és hozzáadja a Labirintushoz.
	 */
	public void addKezdoPont(int x, int y)
	{
		//lab.addElem(new ZPM(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2))));
	}

	
	/*
	 *a kapott paraméterekkel meghívja a Replikator konstruktorát,
	 * hozzáadja a Labirintushoz és a mozgatandok listához is.
	 */
	public void addReplikator(int x1, int y1, int x2, int y2)
	{
		//lab.addElem(new ZPM(new Terulet(new Vektor(x1,y1), new Vektor(x2,y2))));
	}
	
	
	/*
	 * a karaktert kikeresi neve alapján majd a kapott vektorral
	 * eltolja azt, ha nem ütközik olyan pályaelembe, amelyre
	 * a rálépés nem megengedett.
	 * A parancs eredményét visszatérési értékként adja meg. (pl MOVED oneil right 42 42)
	 */
	private String move(String karakternev, Vektor irany)
	{
		return "Még nincs kész.";
	}
	
	
	/*
	 * a karaktert neve alapján kikeresi a mozgatandok
	 * listáról és az adott irányba adott színnel elindít egy golyót.
	 */
	private String fire(String karaternev, Vektor irany, Szin szin)
	{
		return "Még nincs kész";
	}
	
	
	/*
	 * visszaadja a labirintus elemeit egy String tömbben.
	 */
	private String[] listLab()
	{
		return null;
	}
	
	/*
	 * visszaadja a karakter attribtumainak nevét és értékét egy String tömbben.
	 */
	private String listKar(String kar)
	{
		return "Még nincs kész";
	}
	
	/*
	 * megadja, hogy az adott pozíción található-e valamilyen elem. Ha igen, kiírjuk.
	 */
	private String WhatsThere(Terulet ter)
	{
		return "Még nincs kész";
	}
	
	/*
	 * visszaadja, hogy hány db ZPM van a labirintusban.
	 */
	private String getZPMinLab()
	{
		return "Még nincs kész";
	}
	
	/*
	 * megvizsgálja, hogy az elvárt kimenet egyezik-e a ténylegessel.
	 * Ha igen, jelzi, ha nem, azt is.
	 */
	public String Hasonlit()
	{
		return "Még nincs kész";
	}

	
}
