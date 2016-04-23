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
        
    }

    /**
     * @param param
     */
    public void addElem(Elem param) {
    	list.add(param);
    }

    /**
     * A paraméterként kapott objektumot letörli a listáról.
     * @param param
     */
    private void removeElem(Elem param) {
				list.remove(param);
    }

    /**
     * Ad egy halmazt azokról az elemekről, amelyek 
     * az adott területen találhatóak.
     * @param ter - a terület, amire kíváncsiak vagyunk.
     * @return - egy halmaz az ott levő elemekről
     */
    //NEM VESZI FIGYELEMBE HOGY AZ ADOTT ELEM ÉL-E MÉG
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
        return osszZPM;
    }

    /**
     * @return
     */
    public Elem getVegeElem() {
        return VegeElem;
    }

    /**
     * @return
     */
    public Vektor getKezdoPont() {
        return KezdoPont;
    }
    
    public void addMoveable(Moveable m) {
    	moveableList.add(m);
    }

    /**
     * A paraméterként kapott objektumot letörli a moveable elemek és 
     * a "sima" elemek listájáról is.
     * @param moveable - a törlendő objektum referenciája
     */
	private void removeMoveable(Moveable moveable) {
		moveableList.remove(moveable);
		removeElem(moveable);
	}

}