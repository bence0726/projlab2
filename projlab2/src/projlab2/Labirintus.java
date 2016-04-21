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
    private ArrayList<Elem> list = new ArrayList<>();
    
    /**
     * 
     */
    private ArrayList<Moveable> moveableList;
    
    /**
     * 
     */
    public void labirintus() {
        // TODO implement here
    }

    /**
     * @param kar
     */
    public void addKar(Karakter kar) {
        // TODO implement here
    }

    /**
     * @param param
     */
    public void addElem(Elem param) {
        // TODO implement here
    }

    /**
     * @param param
     */
    public void removeElem(Elem param) {
        // TODO implement here
    }

    /**
     * Ad egy halmazt azokról az elemekről, amelyek 
     * az adott területen találhatóak.
     * @param ter - a terület, amire kíváncsiak vagyunk.
     * @return - egy halmaz az ott levő elemekről
     */
    public Set<Elem> whatsThere(Terulet ter) {
        Set<Elem> items = new HashSet<Elem>();
        
        for(int i = 0; i < list.size(); i++){
        	Elem temp = list.get(i);
        	if(temp.getPos().isCoveredBy(ter))	//ha takarják egymást,
        		items.add(temp);				//hozzáadjuk a halmazhoz
        }
        return items;
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