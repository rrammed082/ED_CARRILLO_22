package com.iescarrillo.Test_3_5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public class TestCuenta {

	@Test
	public void testIngresarConConcepto() throws Exception {
		Cuenta cuenta1 = new Cuenta("0", "Felipe Juan Froilan De Todos Los Santos");
		cuenta1.ingresar("Dinero del chacho Juan Carlos I", 15000);

		assertThat(cuenta1.getSaldo(), equalTo(15000.0));

	}

	@Test
	public void testIngresar() throws Exception {
		Cuenta cuenta1 = new Cuenta("0", "Felipe Juan Froilan De Todos Los Santos");
		cuenta1.ingresar(18000);

		assertThat(cuenta1.getSaldo(), lessThan(18001.0));

	}

	@Test
	public void testRetirarConConcepto() throws Exception {
		Cuenta cuenta1 = new Cuenta("0", "Felipe Juan Froilan De Todos Los Santos");
		cuenta1.ingresar(12000);
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
	public void testRetirarDineroInsuficiente() throws Exception {
		Cuenta cuenta1 = new Cuenta("0", "Felipe Juan Froilan De Todos Los Santos");
		cuenta1.ingresar(12000);
		boolean retirado = true;
		try {
			cuenta1.retirar(15000);

		} catch (Exception e) {
			retirado = false;
		}
		
		assertThat(retirado, is(false));
		
	}
	
	@Test
	public void testIngresarCantidadNegativa() throws Exception {
		Cuenta cuenta1 = new Cuenta("0", "Felipe Juan Froilan De Todos Los Santos");
		try {
			cuenta1.ingresar(-3);
		} catch (Exception e) {
		}
		
	}
	
	
	
	@Test
	public void testAddMovimiento() {
		Movimiento m = new Movimiento();
	}
	
}
