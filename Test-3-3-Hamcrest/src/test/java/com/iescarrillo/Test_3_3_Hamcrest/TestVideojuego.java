package com.iescarrillo.Test_3_3_Hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestVideojuego {

	/**
	 * Comprueba que los tipos de datos son correctos
	 */
	@Test
	public void compruebaTipo() {
		Videojuego juego1 = new Videojuego();
		juego1.setTitulo("Elden Ring");
		juego1.setHorasEstimadas(32);
		juego1.setGenero("Soulslike");
		juego1.setcompañia("From Software");

		juego1.entregar();

		assertThat(String.valueOf(juego1.getTitulo()), instanceOf(String.class));
		assertThat(Integer.valueOf(juego1.getHorasEstimadas()), instanceOf(Integer.class));
		assertThat(String.valueOf(juego1.getGenero()), instanceOf(String.class));
		assertThat(String.valueOf(juego1.getHorasEstimadas()), instanceOf(String.class));
		assertThat(Boolean.valueOf(juego1.isEntregado()), instanceOf(Boolean.class));

	}

	/**
	 * Comprueba si existe un objeto igual en un array de Videojuegos
	 */
	@Test
	public void compruebaElementoEnArray() {
		Videojuego[] listaJuegos = new Videojuego[2];

		listaJuegos[0] = new Videojuego("Elden Ring", 32, "Soulslike", "From Software");
		listaJuegos[1] = new Videojuego("Dark Soul", 15, "Soulslike", "From Software");

		Videojuego juegoAComparar = listaJuegos[1];

		assertThat(listaJuegos, hasItemInArray(juegoAComparar));
	}

	/**
	 * Compara si el elemento es nulo
	 */
	@Test
	public void comprobarNulo() {
		Videojuego[] listaJuegos = new Videojuego[2];

		listaJuegos[0] = new Videojuego("Elden Ring", 32, "Soulslike", "From Software");
		listaJuegos[1] = null;

		assertThat(listaJuegos[1], nullValue(Videojuego.class));
	}

	/**
	 * Comprueba si la cantidad elementos del array es igual a la indicada
	 */
	@Test
	public void comprobarCantidadElementos() {
		Videojuego[] listaJuegos = new Videojuego[2];

		listaJuegos[0] = new Videojuego("Elden Ring", 32, "Soulslike", "From Software");
		listaJuegos[1] = new Videojuego("Dark Soul", 15, "Soulslike", "From Software");

		assertThat(Arrays.asList(listaJuegos), hasSize(2));
	}

	/**
	 * Comprueba las horas estimadas de dos objetos de la clase videojuegos e indica
	 * si el primero es mayor que el segundo.
	 */
	@Test
	public void compararHorasJugadas() {
		Videojuego[] listaJuegos = new Videojuego[2];

		listaJuegos[0] = new Videojuego("Elden Ring", 32, "Soulslike", "From Software");
		listaJuegos[1] = new Videojuego("Dark Soul", 15, "Soulslike", "From Software");

		assertThat(listaJuegos[1].getHorasEstimadas(), lessThan(listaJuegos[0].getHorasEstimadas()));
	}

	/**
	 * Comprueba el método compareTo el cual devuelve {1, 0, -1} dependiento de si
	 * un juego tiene menos horas estimadas que otro
	 */
	@Test
	public void testcompareTo() {
		Videojuego juego1 = new Videojuego("Elden Ring", 32, "Soulslike", "From Software");
		Videojuego juego2 = new Videojuego("Dark Soul", 15, "Soulslike", "From Software");
		Videojuego juego3 = new Videojuego("Elden Ring", 32, "Soulslike", "From Software");

		assertThat(juego1.compareTo(juego2), equalTo(Serie.MAYOR));
		assertThat(juego2.compareTo(juego1), equalTo(Serie.MENOR));
		assertThat(juego1.compareTo(juego3), equalTo(Serie.IGUAL));
	}

	/**
	 * Comprueba si un Videojuego ha sido entregado
	 */
	@Test
	public void testEntregar() {
		Videojuego videojuego = new Videojuego();
		videojuego.entregar();

		assertThat(videojuego.isEntregado(), is(true));
	}

	/**
	 * comprueba si un Videojuego ha sido devuelto
	 */
	@Test
	public void testDevolver() {
		Videojuego videojuego = new Videojuego();
		videojuego.entregar();
		videojuego.devolver();

		assertThat(videojuego.isEntregado(), is(false));
	}

	/**
	 * Test que comprueba método toString comparando el objeto que llama al toString con los valores de otro objeto
	 */
	@Test
	public void testToString() {
		Videojuego juego = new Videojuego("Elden Ring", 32, "Soulslike", "From Software");

		String expectedString = "Informacion del videojuego: \n" + "\tTitulo: " + juego.getTitulo() + "\n" + "\tHoras estimadas: "
				+ juego.getHorasEstimadas() + "\n" + "\tGenero: " + juego.getGenero() + "\n" + "\tcompañia: " + juego.getcompañia();
		assertThat(juego.toString(), equalTo(expectedString));
	}
}
