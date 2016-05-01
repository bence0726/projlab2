package model;

/**
 * Oneil modellbeli reprezentációja. Kibővíti a Karakter(Jaffa)
 * osztály tulajdonságait azzal, hogy ZPM felvételkor kicsit másképp
 * viselkedik. Erről bővebb információ a metódusnál található.
 */
public class Oneil extends Karakter {	

	/**
     * Létrehoz egy oneil(oneil) objektumot az elem 
     * közepére illesztve a moveable objektumot.
     * Default mérettel jön létre 10*10 pixel méretben.
     * @param lab
     * @param startElem
     */
    public Oneil(Labirintus lab,Vektor leftcorn, Vektor diagonal){
    	super(lab,leftcorn,diagonal);
    }

	/**
     *  Növeli az ezredes ZPM számlálóját, továbbá
     *  Valahol máshol generálódik egy új ZPM minden második
     *  ZPM-modul felvételekor.
     */
    public void addZPM() {
        ZPM++;
        if((ZPM % 2) != 0) //csak minden másodikra kell random ZPM-et generálni.
        	return;
        Terulet T = new Terulet();
        T.randomArea(new Vektor(6,6),100);
        //amíg nem sorsol olyan területet, 
        //ahol nincs semmi, addig hívogatjuk.
        while(lab.whatsThere(T) != null) 
        	T.randomArea(new Vektor(6,6),100);
        lab.addZPM(new ZPM(T)); //hozzáadjuk a labirintushoz
    }
}