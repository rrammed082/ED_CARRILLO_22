package es.iescarrillo.daw.endes.Persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PersonaTest {
	
	// Creación de objetos
	
	// Comprobar Mayor de Edad
	Persona personaTestMayorEdad = new Persona("Pepe", 20, 'H', 98.0, 1.8);
	Persona personaTestMenorEdad = new Persona("Juan", 17, 'H', 60.0, 1.7);
	
	// Comprobar IMC
	Persona personaTestSobrepeso = new Persona("Eusebio", 80, 'H', 98.0, 1.8);
	Persona personaTestIdeal = new Persona("Aurelio", 75, 'H', 80.0, 1.8);
	Persona personaTestInfrapeso = new Persona("Feliciano", 67, 'H', 50.0, 1.8);

	/**
	 * 
	 * Test compronar la edad
	 */
	@Test
    public void testMayorEdad() {
		assertTrue(personaTestMayorEdad.esMayorDeEdad());
	}
	
	@Test
    public void testMenorEdad() {
		assertTrue(!personaTestMenorEdad.esMayorDeEdad());	
	}
	
	/**
	 * Test comprobar el peso
	 */
	@Test
	public void testIMCSobrepeso() {
		assertEquals(1, personaTestSobrepeso.calcularIMC());
	}
	
	@Test
	public void testIMCPesoIdeal() {
		assertEquals(0, personaTestIdeal.calcularIMC());
	}
	
	@Test
	public void testIMCInfrapeso() {
		assertEquals(-1, personaTestInfrapeso.calcularIMC());
	}
}
