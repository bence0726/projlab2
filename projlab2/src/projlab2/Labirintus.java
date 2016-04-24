package projlab2;
import java.io.File;
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
    private Elem startElem;

    /**
     * 
     */
    private Elem endElem;
    /**
     * 
     */
    
    private Karakter jaffa;
    /**
     * 
     */
    
    private Oneil oneil;

    /**
     * 
     */
    private ArrayList<Elem> list = new ArrayList<Elem>();
    
    /**
     * 
     */
    private ArrayList<Moveable> moveableList = new ArrayList<Moveable>();
    
    /**
     * 
     */
    public void labirintus() {
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


    
    public void addMoveable(Moveable m) {
    	moveableList.add(m);
    }

    /**
     * @param elem
     */
    public void addElem(Elem elem) {
    	list.add(elem);
    }
    /**
     * Hozzáadja a labirintushoz a kezdőelemet.
     * @param startElem
     */
    public void addStartElem(Elem startElem){
    	this.startElem=startElem;
    }
    /**
     * Hozzáadja a labirintushoz a végelemet.
     * @param endElem
     */
    
    public void addEndElem(Elem endElem){
    	this.endElem=endElem;
    }
    /**
     * Hozzáadja a labirintushoz a jaffát.
     * @param jaffa
     */
    public void addJaffa(Karakter jaffa){
    	this.jaffa=jaffa;
    	this.addMoveable(jaffa);
    }
    /**
     * Hozzáazdja a labirintushoz oneilt.
     * @param oneil
     */
    public void addOneil(Oneil oneil){
    	this.oneil=oneil;
    	this.addMoveable(oneil);
    }
    
    
    
    public ArrayList<Moveable>getMoveableList(){
    	return moveableList;
    }
    

	public int getOsszZPM() {
		return osszZPM;
	}

	public Elem getStartElem() {
		return startElem;
	}

	public Karakter getJaffa() {
		return jaffa;
	}

	public Oneil getOneil() {
		return oneil;
	}

	public ArrayList<Elem> getList() {
		return list;
	}
	
    public Elem getEndElem() {
        return endElem;
    }

    public Elem getstartElem() {
        return startElem;
    }
}