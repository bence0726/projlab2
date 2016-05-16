package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
				
		GameWindow window = new GameWindow();	//elég itt létrehozni	
		window.setVisible(true);
		window.addKeyListener(new MoveKeysListener(kc));
		
		int test = 0;
		while(true){
			//gameloop
			Iterator<Elem> ElemIt = gameEngine.getLab().getObjectsOnMapList().iterator();
			ArrayList<JComponent> CompList = new ArrayList<>();
			
			while(ElemIt.hasNext()){											//végigmegyünk a labirintus elemein...
				Elem tempElem = ElemIt.next();	
				CompList.add(ElemFactory.ComponentFactory(tempElem));
			}				
			window.gp.map.refreshMap(CompList); //map frissítése az új elemekkel
			window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
			
			window.gp.LabNumberOfZPMS.setText(String.valueOf(test++));
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOneil().getZPM()));
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getJaffa().getZPM()));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			gameEngine.moveEverything(); //mozgó elemek megmozgatása
//			window.repaint();
		}
	}
}
