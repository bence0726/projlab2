package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JLabel;

import enums.MoveDirections;
import enums.PickAndDrop;
import enums.Szin;
import gui2d.ElemFactory;
import gui2d.GameWindow;
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
		RotateKeyListener rtk = new RotateKeyListener();
		window.addKeyListener(mv);//KeyListenerek beregisztrálása
		window.addKeyListener(fk);
		window.addKeyListener(pdk);
		window.addKeyListener(rtk);
		
		int ciklusszamlalo = 0;
		while(!gameEngine.isEndGame() && (gameEngine.getLab().getOneil().isAlive() || gameEngine.getLab().getJaffa().isAlive())){
			try{
			//gameloop
			
			//billentyűlenyomások fogadása
			getMoveKeys(mv, kc);
			getPickAndDropKeys(pdk, kc);
			if(ciklusszamlalo % 10 == 0) //csak minden 10. ciklusban nézzük meg, hogy van-e lövés
				getFireKeys(fk, kc);
			if(ciklusszamlalo % 5 == 0)
				getrotation(rtk, kc);
			
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
			window.gp.oneilgundirlabel.setText(String.valueOf(gameEngine.getLab().getOneil().getgundirAngle()));
			window.gp.jaffagundirvalue.setText(String.valueOf(gameEngine.getLab().getJaffa().getgundirAngle()));
			window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
			window.gp.OneilNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOneil().getZPM()));
			window.gp.JaffaNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getJaffa().getZPM()));
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			gameEngine.moveEverything(); //mozgó elemek megmozgatása
//			window.repaint();
			}catch(ClassCastException cs){
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		try {
			window.gp.jatekvegelabel.setVisible(true);
			Thread.sleep(800);
			
			JLabel temp = window.gp.nyerteslabel;
			temp.setVisible(true);
			Thread.sleep(800);
			String nyertesszoveg = temp.getText();
			temp.setText(nyertesszoveg + "3");
			Thread.sleep(800);
			temp.setText(nyertesszoveg + "2");//hatásszünet :DD
			Thread.sleep(800);
			temp.setText(nyertesszoveg + "1");
			Thread.sleep(800);
			temp.setText(nyertesszoveg + gameEngine.nyertes);			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private static void getMoveKeys(MoveKeysListener mv, KarakterController kc){
		//oneil lépése
		kc.setKarDir("ONEIL", mv.getOneilsLastDir());
		//jaffa lépése
		kc.setKarDir("JAFFA", mv.getJaffasLastDir());
	}
	
	private static void getFireKeys(FireKeysListener fk, KarakterController kc){
		Szin oneilsLast = fk.getOneilsLastSzin();
		Szin jaffasLast = fk.getJaffasLastSzin();
		
		if(oneilsLast != null)
			kc.fire("ONEIL", oneilsLast);
		
		if(jaffasLast != null)
			kc.fire("JAFFA", jaffasLast);
	}
	
	private static void getPickAndDropKeys(PickandDropKeysListener pdk, KarakterController kc){
		PickAndDrop oneilsLast = pdk.getOneilsLast();
		PickAndDrop jaffasLast = pdk.getJaffasLast();
		
		switch (oneilsLast) {
		case PICKED:
			kc.pick("ONEIL");
			break;
		case DROPPED:
			kc.drop("ONEIL");
			break;
		default:
			break;
		}
		switch (jaffasLast) {
		case PICKED:
			kc.pick("JAFFA");
			break;
		case DROPPED:
			kc.drop("JAFFA");
			break;
		default:
			break;
		}
	}
	
	private static void getrotation(RotateKeyListener rk, KarakterController kc){
		int oneil = rk.oneilangle;
		int jaffa = rk.jaffaangle;
		
		if(oneil == KeyEvent.VK_L){			
				kc.rotateGun("ONEIL", 10.0);	
		}
		if(jaffa == KeyEvent.VK_CAPS_LOCK){			
			kc.rotateGun("JAFFA", 10.0);	
		}
	}
	
	
}