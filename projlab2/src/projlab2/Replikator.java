package projlab2;
import java.util.*;

/**
 * 
 */
public class Replikator extends Moveable {

    /**
     * Default constructor
     */
    public Replikator(Labirintus lab,Vektor kezdLocVec) {
    	super(lab,kezdLocVec);
    	image = "replikator.jpg";
    }

    /**
     * 
     */
    public void shot(Golyo bullet) {
    	bullet.kill();
        this.alive=false;
        lab.refreshList();
    }

    /**
     * A replikátor ebben a moveban egy random iránnyal halad tovább, így nem érdekli
     * mi a jelenlegi moveDir-je.
     * @param dir
     */
    public void move() {
//        this.moveDir= new Vektor();
//        this.moveDir= Vektor.randomDir(true); ehelyett a következő kéne:
    	this.moveDir =  Vektor.randomDir(true);
        Terulet t = new Terulet(this.pos.getKezd(),this.pos.getVeg());
        t.addDirToArea(moveDir);
        Set<Elem> items = lab.whatsThere(t);
        Iterator<Elem> iterator = items.iterator();
        if(items.size() == 0){						//ha nincs ott semmi...
    		step();					
        while(iterator.hasNext()){
        	Elem temp = iterator.next();
        	temp.steppedon(this);
        	}
        }
        //szerintem itt kéne új moveDir-t beállítani a további mozgáshoz:
        setDir(Vektor.randomDir(false)); //így a következő lépésnél random irányba megy tovább
    }

    /**
     * Ha megölik a replikátort, akkor csak szakadékba
     * léphetett. Ekkor megkeressük a mapon a rá mutató
     * referenciát és kinyírjuk őt is.
     * 
     * NEM MERT HA A GOLYÓ TALÁLJA EL AKKOR IS MEGHAL !!!!!
     * íGY HA PONT AKKOR TALÁLJUK EL AMIKOR VALAMIN ÁLL AKKOR KINYIR BÁRMIT !!!!!
     * A problémát feloldottam a shot fv olyasféle megírásával hogy nem a killt hivja
     * hanem egy default kill fv-t.
     */
    public void kill() {
        alive = false;
        Set<Elem> items = lab.whatsThere(pos);
        Iterator<Elem> iterator = items.iterator();
        while(iterator.hasNext()){
        	Elem temp = iterator.next();
        	if(temp != this){
        		temp.kill();
        		lab.refreshList();
        		return;
        	}
        		
        }
    }
}