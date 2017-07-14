package controller3D;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;

import controller.FireKeysListener;
import controller.KarakterController;
import controller.MapBuilder;
import controller.MoveKeysListener;
import controller.PickandDropKeysListener;
import controller.RotateKeyListener;
import enums.PickAndDrop;
import enums.Szin;
import gui2d.ElemFactory;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Shape3D;
import model.Elem;
import model.JatekMotor;

public class MainController3D {
	
	private static Group group;	
	private static Scene scene;
	private static PerspectiveCamera camera;
	
	private static JatekMotor gameEngine;
	
	private static MapBuilder mb;
	
	private static KarakterController kc;
	
	private static MoveKeysListener mv;
	private static FireKeysListener fk;
	private static PickandDropKeysListener pdk; 
	private static RotateKeyListener rtk;

	public static void main(String[] args) {
		initializeGame();
		
		gameLoop();
		
		
		
	}

	private static void gameLoop() {
		int index = 0;
		
		while(true){
			moveCharacters(index);
			
			
			index++;
		}
		
	}

	/**
	 * inicializálja a játék futásához szükséges objektumokat,
	 * beolvassa fájlból a pályát és felépíti a 3D világot,
	 * valamint példányosítja az eventListener-eket.
	 */
	private static void initializeGame() {
		gameEngine = new JatekMotor();
		mb = new MapBuilder(gameEngine);
		kc = new KarakterController(gameEngine);
		
		buildMapFromFile(mb);
		
		create3DWorld(gameEngine);
		
		createListeners();
		
		
		
		
	}

	/**
	 * Példányosítja az EventListener-eket
	 */
	private static void createListeners() {
		mv = new MoveKeysListener();
		fk = new FireKeysListener();
		pdk = new PickandDropKeysListener(); 
		rtk = new RotateKeyListener();
	}

	/**
	 * Beolvassa fájlból a térképet és felépíti belőle a pálya modelljét
	 */
	private static void buildMapFromFile(MapBuilder mb) {
		try {
			mb.buildMap(new File("src/maps/Map2.txt"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Létrehozza a modell felhasználásával a 3D világot
	 */
	private static void create3DWorld(JatekMotor gameEngine) {
		List<Shape3D> objects3D = new LinkedList<>();
		
		Iterator<Elem> ElemIt = gameEngine.getLab().getObjectsOnMapList().iterator();
		
		while(ElemIt.hasNext()){											//végigmegyünk a labirintus elemein...
			Elem tempElem = ElemIt.next();
			
			Shape3D tempObject = null;
			//tempObject = Elemfactory.valamiFüggvényJönMajdIde(tempElem);
			
			objects3D.add(tempObject);
			
			//ez nem emlékszem, miért volt itt -tibor
			//connected.put(tempElem, tempJcomp);
		}
		
		group = new Group();		
		scene = new Scene(group);
		
		group.getChildren().addAll(objects3D);
	}
	
	private static void moveCharacters(int index){
		//billentyűlenyomások fogadása
		getMoveKeys();
		getPickAndDropKeys();
		if(index % 10 == 0) //csak minden 10. ciklusban nézzük meg, hogy van-e lövés
			getFireKeys();
		if(index % 5 == 0)
			getrotation();
	}

	private static void getrotation() {
		if(rtk.DoesOneilRotated())
			kc.rotateGun("ONEIL", 10.0);	
		
		if(rtk.DoesJaffaRotated())			
			kc.rotateGun("JAFFA", 10.0);	
	}

	private static void getFireKeys() {
		Szin oneilsLast = fk.getOneilsLastSzin();
		Szin jaffasLast = fk.getJaffasLastSzin();
		
		if(oneilsLast != null)
			kc.fire("ONEIL", oneilsLast);
		
		if(jaffasLast != null)
			kc.fire("JAFFA", jaffasLast);

		
	}

	private static void getPickAndDropKeys() {
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

	private static void getMoveKeys() {
		kc.setKarDir("ONEIL", mv.getOneilsLastDir());
		kc.setKarDir("JAFFA", mv.getJaffasLastDir());
		
	}
	
}
