package com.iescarrillo.Test_3_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VideojuegoTest {
	
	@Test
	public void testSetTitulo() {
		Videojuego juego1 = new Videojuego();
		juego1.setTitulo("Elden Ring");
		
		assertEquals("Elden Ring", juego1.getTitulo());
		
	}
	@Test
	public void testSetHorasEstimadas() {
		Videojuego juego1 = new Videojuego();
		juego1.setHorasEstimadas(200);
		
		assertEquals(200, juego1.getHorasEstimadas());
		
	}
	@Test
	public void testSetGenero() {
		Videojuego juego1 = new Videojuego();
		juego1.setGenero("Soulslike");
		
		assertEquals("Soulslike", juego1.getGenero());
		
	}
	@Test
	public void testSetCompania() {
		Videojuego juego1 = new Videojuego();
		juego1.setcompañia("From Software");
		
		assertEquals("From Software", juego1.getcompañia());
		
	}
	@Test
	public void testEstaEntregado() {
		Videojuego juego1 = new Videojuego();
		
		juego1.entregar();
		
		assertTrue(juego1.isEntregado());
	}
	
	@Test
	public void testNoEstaEntregado() {
		Videojuego juego1 = new Videojuego();
		
		juego1.entregar();
		juego1.devolver();
		
		assertFalse(juego1.isEntregado());
	}
	
	@Test
	public void testSonIguales() {
		Videojuego juego1 = new Videojuego();
		Videojuego juego2 = new Videojuego();

		juego1.setHorasEstimadas(80);

		juego2.setHorasEstimadas(80);
		
		assertEquals(0, juego1.compareTo(juego2));
	}
	
	@Test
	public void testJuego1MayorJuego2() {
		Videojuego juego1 = new Videojuego();
		Videojuego juego2 = new Videojuego();
		
		juego1.setHorasEstimadas(80);

		juego2.setHorasEstimadas(50);
		
		assertEquals(1, juego1.compareTo(juego2));
	}
	
	@Test
	public void testJuego2MayorJuego1() {
		Videojuego juego1 = new Videojuego();
		Videojuego juego2 = new Videojuego();
		
		juego1.setHorasEstimadas(50);

		juego2.setHorasEstimadas(80);
		
		assertEquals(-1, juego1.compareTo(juego2));
	}
}
