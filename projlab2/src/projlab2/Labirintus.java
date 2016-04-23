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
     * Végigmegy a labirintus listáin és megvizsgálja, hogy az elemek élnek-e.
     * Amelyik nem él, törli a listáról.
     */
    public void refreshList(){
    	Iterator<Moveable> itMoveable = moveableList.iterator();
    	while(itMoveable.hasNext()){
    		Moveable temp = itMoveable.next();
    		if(!temp.isAlive())
    			moveableList.remove(temp);	//töröljük a moveable listáról
    			list.remove(temp);			//és az elemek listájáról is.
    	}
    	
    	Iterator<Elem> iteratorElemek = list.iterator(); //végigmegyünk az elemek listáján is
    	while(iteratorElemek.hasNext()){
    		Elem temp = iteratorElemek.next();
    		if(!temp.isAlive())
    			list.remove(temp);
    	}
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
    
}