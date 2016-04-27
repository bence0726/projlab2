package test;



import java.util.*;

import model.*;

public class Test {

	Labirintus lab=new Labirintus();
	JatekMotor motor=new JatekMotor();
	List<Moveable> mozgatandok=new ArrayList<>(); 			//ebben a listában tároljuk azokat az elemeket, amelyeket mozgatni kell. Ide tartoznak a golyók és a replikátorok, amelyek mozgatását a játék-logika végzi, valamint a karakterek is.
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
	 * visszaadja a labirintus elemeit egy String tömbben.
	 *
	protected String[] listLab()
	{

		List<String> tmp=new ArrayList<String>();
		int i=0;
		while(i!=lab.size())				 
		{
			tmp.add(lab.objectsOnMap.)
		}
		return null;
		
		
	}/*
	
	/*
	 * visszaadja a karakter attribtumainak nevét és értékét egy String tömbben.
	 */
	protected String listKar(String kar)
	{
		
		if(kar.equalsIgnoreCase("oneill"))
		{
			
		}
		else if(kar.equalsIgnoreCase("jaffa"))
		{
			return lab.getOneil().name+" ZPM: "+lab.getOneil().getZPM()+" Súly: "+lab.getOneil().getSuly();
		}
		return "Hiba";
	}
	
	/*
	 * megadja, hogy az adott pozíción található-e valamilyen elem. Ha igen, kiírjuk.
	 */
	protected String WhatsThere(int x1, int y1, int x2, int y2)
	{
		int i=0;
		List<Elem> tmp=new ArrayList<Elem>(lab.whatsThere(new Terulet(new Vektor(x1,y1), new Vektor(x2, y2))));
		
		if(!tmp.isEmpty())
			while(i!=tmp.size())
			{
				return tmp.get(i++).name;
			}
		return "Hiba"; //ha nincs ott semmi az nyilvánvaló hiba? WUT? FIXME
		
	}
	
	/*
	 * visszaadja, hogy hány db ZPM van a labirintusban.
	 */
	protected int getZPMinLab()
	{
		
		return lab.getOsszZPM();
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
