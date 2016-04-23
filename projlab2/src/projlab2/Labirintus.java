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
     * NEM TUDOM MIÉRT ÍGY IRTAD MEG HA ALPBÓL MEGKAPJA PARAMÉTERKÉNT HOGY MELYIK
     * ELEMET KELL TÖRÖLNI.
     * 
     * SZERINTEM MÁSHOGY KELL HASZNÁLNI
     * @param param
     */
    private void removeElem(Elem param) {
    	Iterator<Elem> iterator = list.iterator();
		while(iterator.hasNext()){
			Elem temp = iterator.next();
			if(!temp.isAlive()){
				list.remove(temp);
			}
		}
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
     * A mozgó elemek listájáról leszedi
     *  a kapott moveable objektumot.
     * @param moveable - a törlendő objektum referenciája
     */
	private void removeMoveable(Moveable moveable) {
		Iterator<Moveable> iterator = moveableList.iterator();
		while(iterator.hasNext()){
			Moveable temp =  iterator.next();
			if(!temp.isAlive()){
				moveableList.remove(temp);
			}
		}			
	}

}