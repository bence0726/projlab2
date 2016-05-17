package controller;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JComponent;

import gui.ElemFactory;
import gui.GameWindow;
import model.Elem;
import model.JatekMotor;

public class MainController {
	public static File mapsDirectory = new File("src/maps/");
	
	public static void main(String[] args){		
		JatekMotor gameEngine = new JatekMotor();
		MapBuilder mb = new MapBuilder(gameEngine);
		KarakterController kc = new KarakterController(gameEngine);
		
		try {
			mb.buildMap(new File("src/maps/Map2.txt"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//pálya felépítése TODO még nincs kész, nem jó így, csak beírtam vmit..
		
		//Igazából ez felesleges
		//ArrayList<JComponent> CompList = new ArrayList<>();
		
		//Map amiben naprakészen tartjuk a változásokat
		HashMap<Elem, JComponent> connected = new HashMap<>(); 
		
		Iterator<Elem> ElemIt = gameEngine.getLab().getObjectsOnMapList().iterator();
		while(ElemIt.hasNext()){											//végigmegyünk a labirintus elemein...
			Elem tempElem = ElemIt.next();
			JComponent tempJcomp = ElemFactory.ComponentFactory(tempElem);
			//CompList.add(tempJcomp); //igazából ez felesleges
			connected.put(tempElem, tempJcomp);
		}
		
		GameWindow window = new GameWindow();	//elég itt létrehozni	
		window.setVisible(true);
		window.setFocusable(true);
		MoveKeysListener mv = new MoveKeysListener();
		FireKeysListener fk = new FireKeysListener();
		PickandDropKeysListener pdk = new PickandDropKeysListener(); 
		window.addKeyListener(mv);//KeyListenerek beregisztrálása
		window.addKeyListener(fk);
		window.addKeyListener(pdk);
		
		int ciklusszamlalo = 0;
		while(true){
			//gameloop
			
			//billentyűlenyomások fogadása
			getMoveKeys(mv, kc);
			getPickAndDropKeys(pdk, kc);
			if(ciklusszamlalo % 1 == 0) //csak minden 10. ciklusban nézzük meg, hogy van-e lövés
				getFireKeys(fk, kc);
			
			ElemIt = gameEngine.getLab().getObjectsOnMapList().iterator();
			if(!connected.keySet().containsAll(gameEngine.getLab().getObjectsOnMapList())){
				while(ElemIt.hasNext()){
					Elem tempElem0 = ElemIt.next();
					if (!connected.keySet().contains(tempElem0))
						connected.put(tempElem0, ElemFactory.ComponentFactory(tempElem0));
				}
			}
			while(ElemIt.hasNext()){											//végigmegyünk a labirintus elemein...
				Elem tempElem = ElemIt.next();
				if (tempElem.is_changed()){
					JComponent tempJcomp = ElemFactory.ComponentFactory(tempElem);
					connected.replace(tempElem, tempJcomp);
				}
			}
			if (!gameEngine.getLab().getObjectsOnMapList().containsAll(connected.keySet()))
				connected.keySet().retainAll(gameEngine.getLab().getObjectsOnMapList());
			
			window.gp.map.refreshMap(new HashSet(connected.values())); //map frissítése az új elemekkel
			window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
			
			window.gp.CiklusszamlaloErtek.setText(String.valueOf(ciklusszamlalo++));
			window.gp.oneilgundirlabel.setText(String.valueOf(gameEngine.getLab().getOneil().getrotategundir()));			
			window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
			window.gp.OneilNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOneil().getZPM()));
			//window.gp.JaffaNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getJaffa().getZPM()));
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			gameEngine.moveEverything(); //mozgó elemek megmozgatása
//			window.repaint();
		}
	}
	
	private static void getMoveKeys(MoveKeysListener mv, KarakterController kc){
		int oneil = mv.oneilslastkey;
		int jaffa = mv.jaffaslastkey;
		
		//Oneil lépése:
		if(oneil != -1){
			switch (oneil) {
			case KeyEvent.VK_UP:
				kc.setKarDir("ONEIL", "UP");
				break;
			case KeyEvent.VK_DOWN:
				kc.setKarDir("ONEIL", "DOWN");
				break;
			case KeyEvent.VK_LEFT:
				kc.setKarDir("ONEIL", "LEFT");
				break;
			case KeyEvent.VK_RIGHT:
				kc.setKarDir("ONEIL", "RIGHT");
				break;			
			
			default:
				break;
			}
		}
		//jaffa lépése
		if(jaffa != -1){
			switch (jaffa) {
			case KeyEvent.VK_W:
				kc.setKarDir("JAFFA", "UP");
				break;
			case KeyEvent.VK_S:
				kc.setKarDir("JAFFA", "DOWN");
				break;
			case KeyEvent.VK_A:
				kc.setKarDir("JAFFA", "LEFT");
				break;
			case KeyEvent.VK_D:
				kc.setKarDir("JAFFA", "RIGHT");
				break;			
			default:
				break;
			}
		}
	}
	
	private static void getFireKeys(FireKeysListener fk, KarakterController kc){
		int oneil = fk.oneilslastkey;
		int jaffa = fk.jaffaslastkey;
		
		if(oneil != -1){
			switch(oneil){
			case KeyEvent.VK_O:    //ez itt egy 'o' betű (o mint Olga)
				kc.fire("ONEIL", "BLUE");
				break;
			case KeyEvent.VK_P:
				kc.fire("ONEIL", "YELLOW");
				break;
			case KeyEvent.VK_L:
				kc.rotateGun("ONEIL", 15.0);	
				return;
			}			
		}
		if(jaffa != -1){
			switch(jaffa){
			case KeyEvent.VK_Q:
				kc.fire("JAFFA", "BLUE");
				break;
			case KeyEvent.VK_E:
				kc.fire("JAFFA", "YELLOW");
				break;
			case KeyEvent.VK_CAPS_LOCK:
				kc.rotateGun("JAFFA", 15.0);	
				return;
			}		
			
		}
	}
	private static void getPickAndDropKeys(PickandDropKeysListener pdk, KarakterController kc){
		int oneil = pdk.oneilslastkey;
		int jaffa = pdk.jaffaslastkey;
		
		if(oneil != -1){
			switch (oneil) {
			case KeyEvent.VK_U:
				kc.pick("ONEIL");
				break;
			case KeyEvent.VK_I:
				kc.drop("ONEIL");
				break;
			default:
				break;
			}
		}
		if(jaffa != -1){
			switch (oneil) {
			case KeyEvent.VK_0://ez itt egy nulla
				kc.pick("JAFFA");
				break;
			case KeyEvent.VK_1:
				kc.drop("JAFFA");
				break;
			default:
				break;
			}
		}
	}
}