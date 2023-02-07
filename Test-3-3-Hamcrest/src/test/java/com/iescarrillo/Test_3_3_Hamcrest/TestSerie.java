package com.iescarrillo.Test_3_3_Hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.nullValue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestSerie {
	
	/**
	 * Comprueba que los tipos de datos son correctos
	 */
	@Test
	public void compruebaTipo() {
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
	public void compruebaElementoEnArray() {
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
	public void comprobarNulo() {
		Serie[] listaSeries = new Serie[2];

		listaSeries[0] = new Serie("Juego de Tronos", 8, "Fantasía", "R.R.Martin");
		listaSeries[1] = null;

		assertThat(listaSeries[1], nullValue(Serie.class));
	}
	
	/**
	 * Comprueba si la cantidad elementos del array es igual a la indicada
	 */
	@Test
	public void comprobarCantidadElementos() {
		Serie[] listaSeries = new Serie[2];

		listaSeries[0] = new Serie("Juego de Tronos", 8, "Fantasía", "R.R.Martin");
		listaSeries[1] = new Serie("Breaking Bad", 5, "Acción", "Vince Gilligan");
		
		assertThat(Arrays.asList(listaSeries), hasSize(2));
	}
	
	/**
	 * Comprueba las horas estimadas de dos objetos de la clase Serie e indica si el primero es mayor
	 * que el segundo.
	 */
	@Test
	public void compararHorasJugadas() {
		Serie[] listaSeries = new Serie[2];

		listaSeries[0] = new Serie("Juego de Tronos", 8, "Fantasía", "R.R.Martin");
		listaSeries[1] = new Serie("Breaking Bad", 5, "Acción", "Vince Gilligan");
		
		assertThat(listaSeries[1].getNumeroTemporadas(), lessThan(listaSeries[0].getNumeroTemporadas()));
	}
}
