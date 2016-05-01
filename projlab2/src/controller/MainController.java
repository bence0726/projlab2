package controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;

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
		addActionListeners(menu,window,kc);		//
				
		while(true){
			//gameloop
			Iterator<Elem> ElemIt = gameEngine.getLab().getObjectsOnMapList().iterator();
			Iterator<Factory> FactoryIt = componentFactories.iterator();
			ArrayList<Component> CompList = new ArrayList<>();
			boolean done = false;
			
			while(ElemIt.hasNext()){
				Elem tempElem = ElemIt.next();
				while(FactoryIt.hasNext()){
					Factory tempfact = FactoryIt.next();
					Component tempComp =  tempfact.ComponentFactory(tempElem);	//elkészíttetjük a komponentst
					if (tempComp != null && !done){
						CompList.add(tempComp);									//ha ő nem készítette el, nem tesszük fel a listára
						done = true;											//idk, később jól jöhet!
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
