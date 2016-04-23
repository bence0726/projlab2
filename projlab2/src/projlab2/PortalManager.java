package projlab2;
import java.util.*;

/**
 * 
 */
public class PortalManager {
    /**
     * 
     */
    private SpecFal KekP=null;

    /**
     * 
     */
    private SpecFal SargaP =null;

    /**
     * 
     */
    private SpecFal PirosP=null;

    /**
     * 
     */
    private SpecFal ZoldP=null;



	/**
	 * A paraméterben kapott specfalból kiolvassa a színét és
	 * a megfelelő kapuhoz rendeli a specfalat.
     * @param sp
     */
    public void open(SpecFal sp,Szin colour) {
    	switch (colour) {
			case Kek: KekP=sp;
					  sp.kinyit(colour);
						break;
			case Sarga:SargaP=sp;
						sp.kinyit(colour);
						break ;
			case Zold:ZoldP=sp;
						sp.kinyit(colour);
						break ;
			case Piros:PirosP=sp;
						sp.kinyit(colour);
						break ;
			default: return;	
    	}
    }
    /**
     * A paraméterben kapott specfalból kiolvassa a színét és
     * nullba állítja a hozzá tartozó portált.
     * @param sp
     */
    public void close(Szin color){
    	switch (color){
    		case Kek: KekP.bezar(); 
    				  KekP=null;
    				  break;
    		case Sarga: SargaP.bezar();
    					SargaP=null;
    					break ;
    		case Zold: ZoldP.bezar();
    				   ZoldP=null;
    				   break ;
    		case Piros: PirosP.bezar();
    					PirosP=null;
    					break;
    		default: return;
    	}
    }

    /**
     * @param sp - megadjuk, hogy melyik portálnak keressük a másik felét.
     * @return - a paraméterül kapott portál másik végét adja vissza
     */ 
    public SpecFal getOtherSide(SpecFal sp) {
       Szin colour = sp.getSzin();
       switch (colour) {
       	case Kek:
       		return SargaP;
       	case Sarga:
       		return KekP;
       	case Zold:
       		return PirosP;
       	case Piros:
       		return ZoldP;
   		default:return null;
       }
    }
    
    public SpecFal getPortalOfThisColor(Szin colour){
    	switch (colour) {
       	case Kek:
       		return KekP;
       	case Sarga:
       		return SargaP;
       	case Zold:
       		return ZoldP;
       	case Piros:
       		return PirosP;
   		default:return null;
       }
    }
    


    public SpecFal getKekP() {
		return KekP;
	}

	public void setKekP(SpecFal kekP) {
		KekP = kekP;
	}

	public SpecFal getSargaP() {
		return SargaP;
	}

	public void setSargaP(SpecFal sargaP) {
		SargaP = sargaP;
	}

	public SpecFal getPirosP() {
		return PirosP;
	}

	public void setPirosP(SpecFal pirosP) {
		PirosP = pirosP;
	}

	public SpecFal getZoldP() {
		return ZoldP;
	}

	public void setZoldP(SpecFal zoldP) {
		ZoldP = zoldP;
	}

}