package junittest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Vektor;

public class vektorosztalyteszt {

	@Test
	public void testAddVec() {
		Vektor vec =new Vektor(10.0,10.0);
		Vektor vec2 = new Vektor(2.0,2.0);
		vec.addVec(vec2);
		assertEquals(12.0, vec.getVx(),0.001);
		assertEquals(12.0, vec.getVy(),0.001);
	}
	@Test
	public void testHalfofVec() {
		Vektor vec =new Vektor(10.0,10.0);
		Vektor vec2 = Vektor.getHalfOf(vec);
		assertEquals(5.0, vec2.getVx(),0.001);
		assertEquals(5.0, vec2.getVy(),0.001);
		
	}
	
	@Test
	public void testBeEqualWith() {
		Vektor vec =new Vektor(10.0,10.0);
		Vektor vec2 =new Vektor (5.0,5.0);
		vec2.beEqualWith(vec);
		assertEquals(10.0, vec2.getVx(),0.001);
		assertEquals(10.0, vec2.getVy(),0.001);
	}
	
	@Test
	public void testGetInverseVec() {
		Vektor vec =new Vektor(10.0,10.0);
		Vektor vec2 = null;
		vec2=vec.getInverseVec();
		assertEquals(-10.0, vec2.getVx(),0.001);
		assertEquals(-10.0, vec2.getVy(),0.001);
		
	}
	
	@Test
	public void testInvertVec() {
		Vektor vec =new Vektor(10.0,10.0);
		vec.invertThisVec();
		assertEquals(-10.0, vec.getVx(),0.001);
		assertEquals(-10.0, vec.getVy(),0.001);
		
	}
	
	public void testAddVecToVec() {
		Vektor vec =new Vektor(10.0,10.0);
		Vektor vec2 = new Vektor(10.0,10.0);
		assertEquals(true, vec.isEqualTo(vec2));
		vec2.addVec(new Vektor(2.0,2.0));
		assertEquals(false,vec.isEqualTo(vec2));
	}

}
