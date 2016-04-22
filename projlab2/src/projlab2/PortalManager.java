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
    public void open(SpecFal sp,Szin color) {
    	switch (color) {
		case Kek: KekP=sp;
		return;
		case Sarga:SargaP=sp;
		return ;
		case Zold:ZoldP=sp;
		return ;
		case Piros:PirosP=sp;
		return ;
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