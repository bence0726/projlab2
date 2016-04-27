package junittest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Terulet;
import model.Vektor;

public class teruletosztalyteszt {

	@Test
	public void testIsCoveredBy() {
		Terulet tmain = new Terulet(new Vektor(10,10),new Vektor(20,20));
		Terulet t1 = new Terulet(new Vektor(15,15),new Vektor(25,25));
		Terulet t2 = new Terulet(new Vektor(15,5),new Vektor(25,15));
		Terulet t3 = new Terulet(new Vektor(5,15),new Vektor(15,25));
		Terulet t4 = new Terulet(new Vektor(5,5),new Vektor(15,15));
		Terulet t5 = new Terulet(new Vektor(100,100),new Vektor(110,110));
		assertEquals(true, tmain.isCoveredBy(t1));
		assertEquals(true, tmain.isCoveredBy(t2));
		assertEquals(true, tmain.isCoveredBy(t3));
		assertEquals(true, tmain.isCoveredBy(t4));
		assertEquals(false, tmain.isCoveredBy(t5));
	}
	
	@Test
	public void testGetDiagonal(){
		Terulet tmain = new Terulet(new Vektor(10,10),new Vektor(20,20));
		Vektor diagonal = tmain.getDiagonal();
		assertEquals(10.0, diagonal.getVx(),0.001);
		assertEquals(10.0, diagonal.getVy(),0.001);
	}
	@Test
	public void testGetMiddleOfArea(){
		Terulet tmain = new Terulet(new Vektor(10,10),new Vektor(20,20));
		Vektor middle = tmain.getMiddleOfArea();
		assertEquals(15.0, middle.getVx(),0.001);
		assertEquals(15.0, middle.getVy(),0.001);
	}
	@Test
	public void testAddDirToArea(){
		Terulet tmain = new Terulet(new Vektor(10,10),new Vektor(20,20));
		Vektor addvec = new Vektor(5.0,5.0);
		tmain.addDirToArea(addvec);
		assertEquals(15.0, tmain.getKezd().getVx(),0.001);
		assertEquals(15.0, tmain.getKezd().getVy(),0.001);
		assertEquals(25.0, tmain.getVeg().getVx(),0.001);
		assertEquals(25.0, tmain.getVeg().getVy(),0.001);
	}
	@Test
	public void testSetNewCornerLocation(){
		Terulet tmain = new Terulet(new Vektor(10,10),new Vektor(20,20));
		Vektor newLoc = new Vektor(100.0,100.0);
		tmain.setNewCornerLocation(newLoc);
		assertEquals(100.0, tmain.getKezd().getVx(),0.001);
		assertEquals(100.0, tmain.getKezd().getVy(),0.001);
		assertEquals(110.0, tmain.getVeg().getVx(),0.001);
		assertEquals(110.0, tmain.getVeg().getVy(),0.001);
	}
	@Test
	public void testIsEqualTo() {
		Terulet tmain = new Terulet(new Vektor(10,10),new Vektor(20,20));
		Terulet tmain2 = new Terulet(new Vektor(10,10),new Vektor(20,20));
		Terulet tmain3 = new Terulet(new Vektor(12,10),new Vektor(20,20));
		Terulet tmain4 = new Terulet(new Vektor(10,12),new Vektor(20,20));
		Terulet tmain5 = new Terulet(new Vektor(10,10),new Vektor(22,20));
		Terulet tmain6 = new Terulet(new Vektor(10,10),new Vektor(20,22));
		assertEquals(true, tmain.isEqualTo(tmain2));
		assertEquals(false, tmain.isEqualTo(tmain3));
		assertEquals(false, tmain.isEqualTo(tmain4));
		assertEquals(false, tmain.isEqualTo(tmain5));
		assertEquals(false, tmain.isEqualTo(tmain6));
	}
	
	@Test
	public void testSetNewMiddleLocation(){
		Terulet tmain = new Terulet(new Vektor(10,10),new Vektor(20,20));
		Vektor newLoc = new Vektor(100.0,100.0);
		tmain.setNewMiddleLocation(newLoc);
		assertEquals(95.0, tmain.getKezd().getVx(),0.001);
		assertEquals(95.0, tmain.getKezd().getVy(),0.001);
		assertEquals(105.0, tmain.getVeg().getVx(),0.001);
		assertEquals(105.0, tmain.getVeg().getVy(),0.001);
	}
}
