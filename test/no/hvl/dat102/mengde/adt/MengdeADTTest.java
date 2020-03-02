package no.hvl.dat102.mengde.adt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class MengdeADTTest {

	private MengdeADT<Integer> begge = null;

	private MengdeADT<Integer> m1 = null;
	private MengdeADT<Integer> m2 = null;

	protected abstract MengdeADT<Integer> reset();

	@BeforeEach
	public void setup() {
		begge = reset();
		m1 = reset();
		m2 = reset();
	}

	@Test
	public void unionFellesTest() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);

		m2.leggTil(1);
		m2.leggTil(4);

		begge.leggTil(1);
		begge.leggTil(2);
		begge.leggTil(3);
		begge.leggTil(4);

		assertTrue(begge.equals(m1.union(m2)));
	}

	@Test
	public void unionIkkeFellesTest() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);

		m2.leggTil(4);
		m2.leggTil(5);
		
		begge.leggTil(1);
		begge.leggTil(2);
		begge.leggTil(3);
		begge.leggTil(4);
		begge.leggTil(5);
		
		assertTrue(begge.equals(m1.union(m2)));
	}
	
	@Test
	public void snittFellesTest() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(2);
		m2.leggTil(3);
		m2.leggTil(4);
		
		begge.leggTil(2);
		begge.leggTil(3);
		
		assertTrue(begge.equals(m1.snitt(m2)));
		
	}
	
	@Test
	public void snittIkkeFellesTest() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(4);
		m2.leggTil(5);
		
		assertTrue(begge.equals(m1.snitt(m2)));
	}
	
	@Test
	public void diffFellesTest() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m2.leggTil(2);
		m2.leggTil(3);
		m2.leggTil(4);
		
		assertTrue(begge.equals(m1.differens(m2)));
	}
	
	public void diffIkkeFellesTest() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		
		m1.leggTil(4);
		m1.leggTil(5);
		
		begge.leggTil(1);
		begge.leggTil(2);
		begge.leggTil(3);
		
		assertTrue(begge.equals(m1.differens(m2)));
	}

}
