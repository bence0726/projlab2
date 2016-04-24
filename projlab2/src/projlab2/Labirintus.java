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
    public void labirintus(Vektor startLocVec) {
        // TODO implement here
    	this.kezdoPont = startLocVec;
    	oneil = new Oneil(this,startLocVec);
    	jaffa = new Karakter(this,startLocVec);
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

    /**
     * @return
     */
    public int getZPM() {
        return osszZPM;
    }

    /**
     * @return
     */
    public Elem getEndElem() {
        return endElem;
    }

    /**
     * @return
     */
    public Elem getstartElem() {
        return startElem;
    }
    
    public void addMoveable(Moveable m) {
    	moveableList.add(m);
    }

    /**
     * @param param
     */
    public void addElem(Elem param) {
    	list.add(param);
    }
    
    public void addStartElem(Elem startElem){
    	this.startElem=startElem;
    }
    
    public void addEndElem(Elem endElem){
    	this.endElem=endElem;
    }
    
    public void addJaffa(Karakter jaffa){
    	this.jaffa=jaffa;
    	this.addMoveable(jaffa);
    }
    
    public void addOneil(Oneil oneil){
    	this.oneil=oneil;
    	this.addMoveable(oneil);
    }
    
    
}