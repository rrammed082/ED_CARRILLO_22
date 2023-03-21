package com.iescarrillo.PruebaUD03_1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCuentaMovimiento {

	// Test Clase Movimiento
	@Test
	public void TestConcepto() {
		Movimiento m1 = new Movimiento();
		m1.setConcepto("Concepto Genérico");

		assertThat(m1.getConcepto(), is("Concepto Genérico"));
	}

	@Test
	public void TestImporte() throws Exception {
		Movimiento m1 = new Movimiento();

		m1.setImporte(1000);

		assertThat(m1.getImporte(), equalTo(1000.0));
	}

	// Test Clase Cuenta

	@Test
	public void testIngresarConConcepto() throws Exception {
		Cuenta cuenta1 = new Cuenta("0", "Generico 1");
		cuenta1.ingresar("Dinero a ingresar", 15000);

		assertThat(cuenta1.getSaldo(), equalTo(15000.0));

	}

	@Test
	public void testIngresar() throws Exception {
		Cuenta cuenta1 = new Cuenta("0", "Genérico 1");
		cuenta1.ingresar("Prueba ingresar", 18000);

		assertThat(cuenta1.getSaldo(), lessThan(18001.0));

	}

	@Test
	public void testRetirar() throws Exception {
		Cuenta cuenta1 = new Cuenta("0", "Genérico 1");
		cuenta1.ingresar("Prueba a ingresar", 12000);
		cuenta1.retirar("Operación por disparo del pie", 11000);

		Movimiento m1 = new Movimiento();

		m1 = (Movimiento) cuenta1.mMovimientos.lastElement();

		boolean encontrado = false;

		if (cuenta1.mMovimientos.lastElement().equals(m1)) {
			encontrado = true;
		}
		assertTrue(encontrado);

	}

	@Test
	public void testRetirarDineroInsuficiente() throws SaldoInsuficienteException, IngresoNegativoException {
		Cuenta cuenta1 = new Cuenta("0", "Genérico 1");
		cuenta1.ingresar("Ingreso para comprobar dinero insuficiente", 12000);
		boolean retirado = true;
		try {
			cuenta1.retirar("Retiro más de lo que hay en la cuenta", 15000);

		} catch (Exception e) {
			retirado = false;
		}

		assertThat(retirado, is(false));

	}

	@Test
	public void testIngresarCantidadNegativa() throws IngresoNegativoException {
		Cuenta cuenta1 = new Cuenta("0", "Genérico 1");
		try {
			cuenta1.ingresar("Ingresar cantidad negativa", -3);
		} catch (Exception e) {
			e.getMessage().equals("No se puede retirar una cantidad negativa");
		}

	}

	@Test
	public void testAddMovimiento() {
		Movimiento m = new Movimiento();
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {100.0, 0.0, -100})
	public void testIngresarConParametros(double ingreso) throws IngresoNegativoException{
		Cuenta cuenta1 = new Cuenta("0", "Genérico 1");

		cuenta1.ingresar("Ingreso en efectivo", ingreso);
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {100.0, 7.0, -100})
	public void testRetirarConParametros(double retiro) throws SaldoInsuficienteException, IngresoNegativoException{
		Cuenta cuenta1 = new Cuenta("0", "Genérico 1");
		Movimiento m = new Movimiento();
		m.setConcepto("Ingreso");
		m.setImporte(99);
		cuenta1.addMovimiento(m);
		
		cuenta1.retirar("Retiro de dinero en cajero", retiro);;
	}
}
