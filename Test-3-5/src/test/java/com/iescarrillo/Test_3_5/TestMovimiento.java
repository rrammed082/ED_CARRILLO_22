package com.iescarrillo.Test_3_5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestMovimiento {

	@Test
	public void TestConcepto() {
		Movimiento m1 = new Movimiento();
		m1.setConcepto("Concepto Genérico");

		assertThat(m1.getConcepto(), is("Concepto Genérico"));
	}

	@Test
	public void TestFecha() throws ParseException {
		Movimiento m1 = new Movimiento();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		m1.setFecha(fechaPrueba);

		assertThat(m1.getFecha(), equalTo(fechaPrueba));
	}
	
	@Test
	public void TestImporte() throws ParseException {
		Movimiento m1 = new Movimiento();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		m1.setFecha(fechaPrueba);

		assertThat(m1.getFecha(), equalTo(fechaPrueba));
	}

	@Test
	public void TestMovimientos() throws ParseException {
		Movimiento m1 = new Movimiento();
		m1.setImporte(30);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		m1.setFecha(fechaPrueba);

		Movimiento m2 = new Movimiento();
		m2.setImporte(30);
		Date fechaPrueba2 = formato.parse("30/07/2022");
		m2.setFecha(fechaPrueba2);

		assertThat(m1.getImporte(), is(m2.getImporte()));
		assertThat(m1.getFecha(), lessThan(m2.getFecha()));
	}
}
