package com.iescarrillo.Test_3_5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestCredito {

	@Test
	public void testRetirar1() throws Exception {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");

		Tarjeta t1 = new Credito("1", "Usuario Genérico", fechaPrueba, 1000);

		// Si intentamos retirar menos de 2 euros retira obligatoriamente 3.
		t1.retirar(2);

		assertThat(t1.getSaldo(), equalTo(3.0));
	}

	@Test
	public void testRetirar2() throws Exception {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		boolean except = false;

		Tarjeta t1 = new Credito("1", "Usuario Genérico", fechaPrueba, 1000);
		// Si intentamos retirar más dinero del disponible devuelve que el saldo es
		// insuficiente
		try {
			t1.retirar(100000);
		} catch (Exception e) {
			except = true;
		}
		assertTrue(except, "Saldo Insuficiente");

	}

	@Test
	public void testRetirar3() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");

		Tarjeta t1 = new Credito("1", "Usuario Genérico", fechaPrueba, 1000);

		/**
		 * Si retiramos una cantidad disponible se multiplicará por 0.05 lo que queramos
		 * sacar y se añadirá dicha comisión como saldo de la tarjeta.
		 * 
		 */

		t1.retirar(900);
		System.out.println(t1.getSaldo());

		assertThat(t1.getSaldo(), lessThan(100.0));
	}

	@Test
	public void testIngresar() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");

		Tarjeta t1 = new Credito("1", "Usuario Genérico", fechaPrueba, 1000);
		Cuenta cuenta1 = new Cuenta("1", "Usuario Genérico");
		double valorAIngresar = 120.0;
		double saldoOriginal = t1.getSaldo();

		t1.mCuentaAsociada = cuenta1;

		t1.ingresar(valorAIngresar);

		assertThat(valorAIngresar, greaterThan(saldoOriginal));

	}

	@Test
	public void testPagoEstablecimiento() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");

		Tarjeta t1 = new Credito("1", "Usuario Genérico", fechaPrueba, 1000);

		t1.pagoEnEstablecimiento("Big Corner", 20.0);

		assertThat(t1.getSaldo(), greaterThanOrEqualTo(20.0));
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

	@Test
	public void testLiquidar() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");

		Credito t1 = new Credito("1", "Usuario Genérico", fechaPrueba, 1000);
		Cuenta cuenta1 = new Cuenta("1", "Usuario Genérico");

		t1.mCuentaAsociada = cuenta1;
		
		double cantidadAIngresarTarjeta = 200;
		double cantidadIngresadaCuenta = 700;
		t1.ingresar(cantidadAIngresarTarjeta);
		cuenta1.ingresar(cantidadIngresadaCuenta);
		
		System.out.println(t1.getSaldo());
		
		t1.liquidar(7, 2022);
		
		assertThat(cantidadAIngresarTarjeta + cantidadIngresadaCuenta, equalTo(cuenta1.getSaldo()));
		
	}
	
	@Test
	public void testLiquidar2() throws Exception{
		Cuenta c = new Cuenta("123456789", "Pepe");
		Credito tCredito = new Credito("123456", "Pepe", new Date(), 5000);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		
		tCredito.mCuentaAsociada = c;
		
		tCredito.ingresar(100);
		
		Movimiento mov = (Movimiento) tCredito.mMovimientos.firstElement();
		mov.setFecha(fechaPrueba);
		
		tCredito.liquidar(06, 2022);
	}

}
