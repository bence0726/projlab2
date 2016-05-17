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
		
		int test = 0;
		while(true){
			//gameloop
			
			//billentyűlenyomások fogadása
			getMoveKeys(mv, kc);
			getFireKeys(fk, kc);
			getPickAndDropKeys(pdk, kc);
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
			window.gp.LabNumberOfZPMS.setText(String.valueOf(test++));
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOneil().getZPM()));
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getJaffa().getZPM()));
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
		Set<Integer> oneil = mv.oneilslastkey;
		Set<Integer> jaffa = mv.jaffaslastkey;
		
		//Oneil lépése:
		if(!oneil.isEmpty()){
			if(oneil.contains(KeyEvent.VK_UP)){
				kc.setKarDir("ONEIL", "UP");
			}
			else if(oneil.contains(KeyEvent.VK_DOWN)){
				kc.setKarDir("ONEIL", "DOWN");
			}
			else if(oneil.contains(KeyEvent.VK_LEFT)){
				if(oneil.contains(KeyEvent.VK_SHIFT))
					kc.rotateGun("ONEIL", 30);
				else
					kc.setKarDir("ONEIL", "LEFT");
			}
			else if(oneil.contains(KeyEvent.VK_RIGHT)){
				if(oneil.contains(KeyEvent.VK_SHIFT))
					kc.rotateGun("ONEIL", -30);
				else
					kc.setKarDir("ONEIL", "RIGHT");
			}
		}
		//Jaffa lépése:
		if(!jaffa.isEmpty()){
			if(jaffa.contains(KeyEvent.VK_UP)){
				kc.setKarDir("JAFFA", "UP");
			}
			if(jaffa.contains(KeyEvent.VK_DOWN)){
				kc.setKarDir("JAFFA", "DOWN");
			}
			if(jaffa.contains(KeyEvent.VK_LEFT)){
				if(jaffa.contains(KeyEvent.VK_CAPS_LOCK))
					kc.rotateGun("JAFFA", 30);
				else
					kc.setKarDir("JAFFA", "LEFT");
			}
			if(jaffa.contains(KeyEvent.VK_RIGHT)){
				if(jaffa.contains(KeyEvent.VK_CAPS_LOCK))
					kc.rotateGun("JAFFA", -30);
				else
					kc.setKarDir("JAFFA", "RIGHT");
			}
		}
	}
	
	private static void getFireKeys(FireKeysListener fk, KarakterController kc){
		Set<Integer> oneil = fk.oneilslastkey;
		Set<Integer> jaffa = fk.jaffaslastkey;
		
		if(!oneil.isEmpty()){
			if(oneil.contains(KeyEvent.VK_O)){//ez itt egy 'o' betű (o mint Olga)
				kc.fire("ONEIL", "BLUE");
			}
			else if(oneil.contains(KeyEvent.VK_P)){
				kc.fire("ONEIL", "YELLOW");
			}
		}
		if(!jaffa.isEmpty()){
			if(jaffa.contains(KeyEvent.VK_Q)){
				kc.fire("ONEIL", "RED");
			}
			else if(jaffa.contains(KeyEvent.VK_E)){
				kc.fire("ONEIL", "GREEN");
			}
		}
	}
	private static void getPickAndDropKeys(PickandDropKeysListener pdk, KarakterController kc){
		Set<Integer> oneil = pdk.oneilslastkey;
		Set<Integer> jaffa = pdk.jaffaslastkey;
		
		if(!oneil.isEmpty()){
			if(oneil.contains(KeyEvent.VK_U)){//ez itt egy 'o' betű (o mint Olga)
				kc.pick("ONEIL");
			}
			else if(oneil.contains(KeyEvent.VK_I)){
				kc.drop("ONEIL");
			}
		}
		if(!jaffa.isEmpty()){
			if(jaffa.contains(KeyEvent.VK_0)){//ez itt egy nulla
				kc.pick("JAFFA");
			}
			else if(jaffa.contains(KeyEvent.VK_1)){
				kc.drop("JAFFA");
			}
		}
	}
}