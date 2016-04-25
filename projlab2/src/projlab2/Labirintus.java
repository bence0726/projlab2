package projlab2;
import java.util.*;

/**
 * 
 */
public class Labirintus {

    /**
     * Default constructor. Csak inicializál, értékeket később 
     * kapnak az attribútumai.
     */
    public Labirintus() {
    	objectsOnMap = new ArrayList<Elem>();
    	moveableList = new ArrayList<Moveable>();
    	osszZPM = 0;
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
    
    private Karakter oneil;

    /**
     * Ebben a listában vannak azok az elemek, amelyek
     * megjelennek a pályán. Szóval a karakterek, replikátorok,
     * stb-k is bekerülnek ide.
     */
    private ArrayList<Elem> objectsOnMap;	
    
    /**
     * Ebben a listában vannak azok az elemek, amelyek mozgásra képesek
     * (karakterek, golyók, replikátorok, dobozok)
     */
    private ArrayList<Moveable> moveableList;
    
    /**
     * Ad egy halmazt azokról az elemekről, amelyek 
     * az adott területen találhatóak.
     * @param area - a terület, amire kíváncsiak vagyunk.
     * @return - egy halmaz az ott levő elemekről
     */
    public Set<Elem> whatsThere(Terulet area) {
        Set<Elem> items = new HashSet<Elem>();
        for(int i = 0; i < objectsOnMap.size(); i++){
        	Elem temp = objectsOnMap.get(i);
        	if(temp.getPos().isCoveredBy(area))	//ha takarják egymást,
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
    			objectsOnMap.remove(temp);			//és az elemek listájáról is.
    	}
    	
    	Iterator<Elem> iteratorElemek = objectsOnMap.iterator(); //végigmegyünk az elemek listáján is
    	while(iteratorElemek.hasNext()){
    		Elem temp = iteratorElemek.next();
    		if(!temp.isAlive())
    			objectsOnMap.remove(temp);
    	}
    }


    /**
     * Mozgó elemet ad a labirintus mindkét listájához.
     * @param m
     */
    public void addMoveable(Moveable m) {
    	moveableList.add(m);
    	addElem(m);
    }

    /**
     * Elemet ad a labirintus objectsonmap listájához.
     * @param elem
     */
    public void addElem(Elem elem) {
    	objectsOnMap.add(elem);
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
    public void addOneil(Karakter oneil){
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

	public Karakter getOneil() {
		return oneil;
	}

	public ArrayList<Elem> getList() {
		return objectsOnMap;
	}
	
    public Elem getEndElem() {
        return endElem;
    }

    public Elem getstartElem() {
        return startElem;
    }
    public int size()
    {
    	return objectsOnMap.size();
    }
}