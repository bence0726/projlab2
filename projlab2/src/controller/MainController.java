package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

import gui.DobozFactory;
import gui.Factory;
import gui.FalFactory;
import gui.GameWindow;
import gui.MerlegFactory;
import gui.SpecFalFactory;
import gui.StartElemFactory;
import gui.SzakadekFactory;
import model.Elem;
import model.JatekMotor;

public class MainController {
	public static File mapsDirectory = new File("src/maps/");
	
	
	public static void main(String[] args){
		
		ArrayList<Factory> componentFactories = new ArrayList<>();
		componentFactories.add(new DobozFactory());
		componentFactories.add(new FalFactory());
		componentFactories.add(new SpecFalFactory());
		componentFactories.add(new MerlegFactory());
		componentFactories.add(new StartElemFactory());
		componentFactories.add(new SzakadekFactory());
		//komponensgyártók hozzáadása ehhez a listához...
		
		JatekMotor gameEngine = new JatekMotor();		
		GameWindow window = new GameWindow();		
		window.setVisible(true);
		
		MapBuilder mb = new MapBuilder(gameEngine);
		KarakterController kc = new KarakterController(gameEngine);
		
		try {
			mb.buildMap(new File("src/maps/demo.txt"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//pálya felépítése TODO még nincs kész, nem jó így, csak beírtam vmit..
				
		while(true){
			//gameloop
			Iterator<Elem> ElemIt = gameEngine.getLab().getObjectsOnMapList().iterator();
			Iterator<Factory> FactoryIt = componentFactories.iterator();
			ArrayList<JComponent> CompList = new ArrayList<>();
			
			
			while(ElemIt.hasNext()){											//végigmegyünk a labirintus elemein..
				Elem tempElem = ElemIt.next();	
				while(FactoryIt.hasNext()){										//végigmegyünk a Factory listán...
					boolean done = false;					
					Factory tempfact = FactoryIt.next();
					JComponent tempComp = tempfact.ComponentFactory(tempElem);	//az aktuális elemet odaadjuk az aktuális factory-nak, aki valamilyen komponenst gyárt belőle
					if (tempComp != null && !done){								//ha elkészítette a komponenst (nem null)...
						CompList.add(tempComp);									//...feltesszük a listára
						done = true;											//ha már rajta van, nem tesszük fel többször (idk, később jól jöhet!)
					}						
				}
				FactoryIt = componentFactories.iterator();
			}				
			window.gp.map.refreshMap(CompList); //map frissítése az új elemekkel
			window.gp.repaint();
			window.repaint();
			
<<<<<<< HEAD
//			window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
//			window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOneil().getZPM()));
//			window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getJaffa().getZPM()));
			//Thread.sleep(500); - talán kell majd
=======
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOsszZPM()));			//ZPM számlálók frissítése
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getOneil().getZPM()));
			//window.gp.LabNumberOfZPMS.setText(String.valueOf(gameEngine.getLab().getJaffa().getZPM()));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
>>>>>>> refs/heads/master
			
			gameEngine.moveEverything(); //mozgó elemek megmozgatása
//			window.repaint();
		}
	}
}
