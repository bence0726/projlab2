package projlab2;
import java.util.*;

/**
 * 
 */
public class PortalManager {
    /**
     * 
     */
    private SpecFal KekP;

    /**
     * 
     */
    private SpecFal SargaP;

    /**
     * 
     */
    public SpecFal PirosP;

    /**
     * 
     */
    public SpecFal ZoldP;



    /**
     * @param sp
     */
    public void open(SpecFal sp) {
        // TODO implement here
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

}