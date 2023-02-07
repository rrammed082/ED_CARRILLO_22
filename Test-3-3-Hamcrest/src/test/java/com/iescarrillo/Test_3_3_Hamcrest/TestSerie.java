package com.iescarrillo.Test_3_3_Hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestSerie {

	/**
	 * Comprueba que los tipos de datos son correctos
	 */
	@Test
	public void testcompruebaTipo() {
		Serie juego1 = new Serie();
		juego1.setTitulo("Juego de Tronos");
		juego1.setNumeroTemporadas(8);
		juego1.setGenero("Fantasía");
		juego1.setCreador("R.R.Martin");

		juego1.entregar();

		assertThat(String.valueOf(juego1.getTitulo()), instanceOf(String.class));
		assertThat(Integer.valueOf(juego1.getNumeroTemporadas()), instanceOf(Integer.class));
		assertThat(String.valueOf(juego1.getGenero()), instanceOf(String.class));
		assertThat(String.valueOf(juego1.getNumeroTemporadas()), instanceOf(String.class));
		assertThat(Boolean.valueOf(juego1.isEntregado()), instanceOf(Boolean.class));

	}

	/**
	 * Comprueba si existe un objeto igual en un array de Serie
	 */
	@Test
	public void testcompruebaElementoEnArray() {
		Serie[] listaSeries = new Serie[2];

		listaSeries[0] = new Serie("Juego de Tronos", 8, "Fantasía", "R.R.Martin");
		listaSeries[1] = new Serie("Breaking Bad", 5, "Acción", "Vince Gilligan");

		Serie juegoAComparar = listaSeries[1];

		assertThat(listaSeries, hasItemInArray(juegoAComparar));
	}

	/**
	 * Compara si el elemento es nulo
	 */
	@Test
	public void testcomprobarNulo() {
		Serie[] listaSeries = new Serie[2];

		listaSeries[0] = new Serie("Juego de Tronos", 8, "Fantasía", "R.R.Martin");
		listaSeries[1] = null;

		assertThat(listaSeries[1], nullValue(Serie.class));
	}

	/**
	 * Comprueba si la cantidad elementos del array es igual a la indicada
	 */
	@Test
	public void testcomprobarCantidadElementos() {
		Serie[] listaSeries = new Serie[2];

		listaSeries[0] = new Serie("Juego de Tronos", 8, "Fantasía", "R.R.Martin");
		listaSeries[1] = new Serie("Breaking Bad", 5, "Acción", "Vince Gilligan");

		assertThat(Arrays.asList(listaSeries), hasSize(2));
	}

	/**
	 * Comprueba las horas estimadas de dos objetos de la clase Serie e indica si el
	 * primero es mayor que el segundo.
	 */
	@Test
	public void testcompararHorasJugadas() {
		Serie[] listaSeries = new Serie[2];

		listaSeries[0] = new Serie("Juego de Tronos", 8, "Fantasía", "R.R.Martin");
		listaSeries[1] = new Serie("Breaking Bad", 5, "Acción", "Vince Gilligan");

		assertThat(listaSeries[1].getNumeroTemporadas(), lessThan(listaSeries[0].getNumeroTemporadas()));
	}

	@Test
	public void testToString() {
		Serie serie = new Serie("Juego de Tronos", 8, "Fantasia", "R.R.Martin");
		String seriaComprobar = "Informacion de la Serie: \n" + "\tTitulo: Juego de Tronos\n"
				+ "\tNumero de temporadas: 8\n" + "\tGenero: Fantasia\n" + "\tCreador: R.R.Martin";
		assertThat(serie.toString(), is(seriaComprobar));
	}

	@Test
	public void testcompareTo() {
		Serie serie1 = new Serie("Juego de Tronos", 8, "Fantasía", "R.R.Martin");
		Serie serie2 = new Serie("Breaking Bad", 5, "Acción", "Vince Gilligan");
		Serie serie3 = new Serie("Cómo conocí a vuestra madre", 8, "Sitcom", "Carter Bays");

		assertThat(serie1.compareTo(serie2), equalTo(Serie.MAYOR));
		assertThat(serie2.compareTo(serie1), equalTo(Serie.MENOR));
		assertThat(serie1.compareTo(serie3), equalTo(Serie.IGUAL));
	}

	@Test
	public void testEntregar() {
		Serie serie = new Serie();
		serie.entregar();

		assertThat(serie.isEntregado(), is(true));
	}

	@Test
	public void testDevolver() {
		Serie serie = new Serie();
		serie.entregar();
		serie.devolver();

		assertThat(serie.isEntregado(), is(false));
	}
}
