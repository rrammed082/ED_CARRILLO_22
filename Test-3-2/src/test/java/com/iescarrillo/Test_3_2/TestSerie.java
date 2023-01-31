package com.iescarrillo.Test_3_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestSerie {
	@Test
	public void testSetTitulo() {
		Serie serie1 = new Serie();
		serie1.setTitulo("Breaking Bad");
		
		assertEquals("Breaking Bad", serie1.getTitulo());
		
	}
	@Test
	public void testSetnumeroTemporadas() {
		Serie serie1 = new Serie();
		serie1.setnumeroTemporadas(40);
		
		assertEquals(40, serie1.getnumeroTemporadas());
		
	}
	@Test
	public void testSetGenero() {
		Serie serie1 = new Serie();
		serie1.setGenero("Acción");
		
		assertEquals("Acción", serie1.getGenero());
		
	}
	@Test
	public void testSetCreador() {
		Serie serie1 = new Serie();
		serie1.setcreador("Vince Gilligan");
		
		assertEquals("Vince Gilligan", serie1.getCreador());
		
	}
	@Test
	public void testEstaEntregado() {
		Serie serie1 = new Serie();
		
		serie1.entregar();
		
		assertTrue(serie1.isEntregado());
	}
	@Test	
	public void testNoEstaEntregado() {
		Serie serie1 = new Serie();
		
		serie1.devolver();
		
		assertFalse(serie1.isEntregado());
	}
	@Test
	public void testCompruebaEntregado() {
		Serie serie1 = new Serie();
		
		serie1.entregar();
		serie1.devolver();
		
		assertFalse(serie1.isEntregado());
	}
	
	@Test
	public void testSonIguales() {
		Serie serie1 = new Serie();
		Serie serie2 = new Serie();

		serie1.setnumeroTemporadas(80);

		serie2.setnumeroTemporadas(80);
		
		assertEquals(0, serie1.compareTo(serie2));
	}
	
	@Test
	public void testserie1Mayorserie2() {
		Serie serie1 = new Serie();
		Serie serie2 = new Serie();
		
		serie1.setnumeroTemporadas(80);

		serie2.setnumeroTemporadas(50);
		
		assertEquals(1, serie1.compareTo(serie2));
	}
	
	@Test
	public void testserie2Mayorserie1() {
		Serie serie1 = new Serie();
		Serie serie2 = new Serie();
		
		serie1.setnumeroTemporadas(50);

		serie2.setnumeroTemporadas(80);
		
		assertEquals(-1, serie1.compareTo(serie2));
	}
}
