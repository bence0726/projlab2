package projlab2;
import java.util.*;

/**
 * 
 */
public class Labirintus {

    /**
     * Default constructor
     */
    public Labirintus() {
    }

    /**
     * 
     */
    private int osszZPM;

    /**
     * 
     */
    private Vektor KezdoPont;

    /**
     * 
     */
    private Elem VegeElem;



    /**
     * 
     */
    private ArrayList<Elem> list;
    
    /**
     * 
     */
    private ArrayList<Moveable> moveableList;
    
    /**
     * 
     */
    public void Labirintus() {
        // TODO implement here
    }

    /**
     * @param kar
     */
    public void AddKar(Karakter kar) {
        // TODO implement here
    }

    /**
     * @param param
     */
    public void AddElem(Elem param) {
        // TODO implement here
    }

    /**
     * @param param
     */
    public void RemoveElem(Elem param) {
        // TODO implement here
    }

    /**
     * @param ter 
     * @return
     */
    public Elem WhatsThere(Terulet ter) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getZPM() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Elem getVegeElem() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Vektor getKezdoPont() {
        // TODO implement here
        return null;
    }
    
    public void addMoveable(Moveable x) {
    	moveableList.add(x);
    }

}