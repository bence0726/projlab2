package model;

/**
 * Interfész az alap interakciókra. Az implementáló osztálynak
 * ezeket kell megvalósítania. A játékban a különböző eseményeket
 * (ráléptek, leléptek róla, stb) ezeken keresztül valósítjuk meg.
 */
public interface Interakcio {

    /**
     * Ha egy objektumot meglövünk, ez a függvénye hívódik meg.
     * Minden Elem maga implementálhatja ezt a függvényt, 
     * és lerendezi, hogy ő hogyan reagál egy ilyen eseményre.
     * @param bullet - a golyó, ami eltalálta az elemet
     */
    public void shot(Golyo bullet);

    /**
     * Ha rálépünk egy elemre, ez a függvény hívódik meg.
     * Minden Elem maga implementálhatja ezt a függvényt, 
     * és lerendezi, hogy ő hogyan reagál egy ilyen eseményre.
     * @param x - a mozgó objektum, ami rálépett
     */
    public boolean steppedon(Moveable x);

    /**
     * Ha felveszünk egy objektumot, ez a függvény hívódik meg.
     * Minden Elem maga implementálhatja ezt a függvényt, 
     * és lerendezi, hogy ő hogyan reagál egy ilyen eseményre.
     * @param k - a karakter, aki felveszi
     * @return true -  ha valamit felvettünk (doboz, ZPM)
     * @return false - ha nem történt felvétel (pl Fal, másik Karakter)
     */
    public boolean picked(Karakter k); 

    /**
     * Ha lelépünk egy objektumról, ez a függvény hívódik meg.
     * Minden Elem maga implementálhatja ezt a függvényt, 
     * és lerendezi, hogy ő hogyan reagál egy ilyen eseményre.
     * @param x - a mozgó objektum, ami lelépett róla
     */
    public void steppedoff(Moveable x);

    /**
     * Az objektum törlése a térképről.
     * @param e - átadjuk a hívót is. Így pl
     * replikátor szakadékba lépésekor a replikátor
     * pontosan tudja, hogy kit kell megölnie.
     */
    public void kill(Elem e);
    
    /**
	 * Megadja, hogy az elemre kerülhet-e másik elem.
	 */
    public boolean isAccessable();
}