package com.iescarrillo.Test_3_5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestDebito {

	@Test
	public void testContructor() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		Tarjeta t1 = new Debito("1", "Cliente Genérico", fechaPrueba);

		assertThat(t1, isA(Debito.class));
	}

	@Test
	public void testRetirar() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		Tarjeta t1 = new Debito("1", "Cliente Genérico", fechaPrueba);
		Cuenta cuenta1 = new Cuenta("1", "Usuario Genérico");
		cuenta1.ingresar(1000);

		t1.setCuenta(cuenta1);

		t1.retirar(200);

		assertThat(t1.getSaldo(), equalTo(800.0));
	}

	@Test
	public void testIngresar() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		Tarjeta t1 = new Debito("1", "Cliente Genérico", fechaPrueba);
		Cuenta cuenta1 = new Cuenta("1", "Usuario Genérico");
		cuenta1.ingresar(1000);

		t1.setCuenta(cuenta1);

		t1.ingresar(300);

		assertThat(t1.getSaldo(), equalTo(700.0));
	}

	@Test
	public void testPagoEnEstablecimiento() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		Tarjeta t1 = new Debito("1", "Cliente Genérico", fechaPrueba);
		Cuenta cuenta1 = new Cuenta("1", "Usuario Genérico");
				
		cuenta1.ingresar(1000);

		t1.setCuenta(cuenta1);
		
		
		t1.pagoEnEstablecimiento("Venta El Cigarral", 45.0);
				
		assertThat(t1.getSaldo(), equalTo(1000 - 45.0));
	}
	
	@Test
	public void testGetSaldo() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");

		Tarjeta t1 = new Credito("1", "Usuario Genérico", fechaPrueba, 1000);
		Cuenta cuenta1 = new Cuenta("1", "Usuario Genérico");

		t1.mCuentaAsociada = cuenta1;
		t1.ingresar(20);

		assertThat(t1.getSaldo(), equalTo(20.0));
	}
}
