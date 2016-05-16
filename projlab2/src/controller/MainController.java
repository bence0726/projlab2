package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JComponent;

import gui.ElemFactory;
import gui.GameWindow;
import model.Elem;
import model.JatekMotor;

public class MainController {
	public static File mapsDirectory = new File("src/maps/");
	
	public static void main(String[] args){
		
		JatekMotor gameEngine = new JatekMotor();		
		GameWindow window = new GameWindow();		
		window.setVisible(true);
		
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
		
		int test = 0;
		while(true){
			//gameloop
			ElemIt = gameEngine.getLab().getObjectsOnMapList().iterator();
			while(ElemIt.hasNext()){											//végigmegyünk a labirintus elemein...
				Elem tempElem = ElemIt.next();
				if (tempElem.is_changed()){
					JComponent tempJcomp = ElemFactory.ComponentFactory(tempElem);
					connected.replace(tempElem, tempJcomp);
				}
			}
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
}
