package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

import gui.DobozFactory;
import gui.Factory;
import gui.GameWindow;
import gui.Menu;
import model.Elem;
import model.JatekMotor;

public class MainController {
	JatekMotor gameEngine;
	Menu menu;
	GameWindow window;
	static ArrayList<Factory> componentFactories;
	
	public static void main(String[] args){
		componentFactories = new ArrayList<>();
		componentFactories.add(new DobozFactory());
		//komponensgyártók hozzáadása ehhez a listához...
		
		JatekMotor gameEngine = new JatekMotor();
		Menu menu = new Menu();
		GameWindow window = new GameWindow();
		
		menu.setVisible(true);
		window.setVisible(false);
		
		MapBuilder mb = new MapBuilder(gameEngine);
		KarakterController kc = new KarakterController(gameEngine);
		
		buildMap(mb);							//pálya felépítése
		addActionListeners(menu,window,kc);		//listenerek beállítása
				
		while(true){
			//gameloop
			Iterator<Elem> ElemIt = gameEngine.getLab().getObjectsOnMapList().iterator();
			Iterator<Factory> FactoryIt = componentFactories.iterator();
			ArrayList<JComponent> CompList = new ArrayList<>();
			boolean done = false;
			
			while(ElemIt.hasNext()){											//végigmegyünk a labirintus elemein..
				Elem tempElem = ElemIt.next();	
				while(FactoryIt.hasNext()){										//végigmegyünk a Factory listán...
					Factory tempfact = FactoryIt.next();
					JComponent tempComp = tempfact.ComponentFactory(tempElem);	//az aktuális elemet odaadjuk az aktuális factory-nak, aki valamilyen komponenst gyárt belőle
					if (tempComp != null && !done){								//ha elkészítette a komponenst (nem null)...
						CompList.add(tempComp);									//...feltesszük a listára
						done = true;											//ha már rajta van, nem tesszük fel többször (idk, később jól jöhet!)
					}						
				}					
			}				
			window.map.refreshMap(CompList);									//map frissítése az új elemekkel
			
			window.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
			window.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOneil().getZPM()));
			window.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getJaffa().getZPM()));
			
			//Thread.sleep(500); - talán kell majd
			
			gameEngine.moveEverything(); //mozgó elemek megmozgatása
		}
	}
	
	/**
	 * A metódus fogja beolvasni fájlból a térképet és 
	 * hívogatni a MapBuilder metódusait
	 * @param mb
	 */
	private static void buildMap(MapBuilder mb){
		//...
		//...
		//...
	}
	
	/**
	 * Eseményfigyelők hozzáadása
	 */
	private static void addActionListeners(Menu menu, GameWindow window,KarakterController kc){
		menu.startGameButton.addActionListener(e->{
			menu.setVisible(false);
			window.setVisible(true);
		});
		
		//gombnyomásra alkalmazás bezárása
		window.btnEndGame.addActionListener(e->{
			System.exit(0);
		});
		
		//további eseményfigyelők hozzáadása...
	}
}
