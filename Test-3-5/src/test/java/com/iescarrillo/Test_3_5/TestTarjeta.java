package com.iescarrillo.Test_3_5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestTarjeta {

	@Test
	public void testTarjetaCaducada() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date fechaPrueba = formato.parse("30/06/2022");
		Tarjeta t1 = new Debito("1", "Cliente Genérico", fechaPrueba);
		
		boolean caducada = false;
		
		if(t1.mFechaDeCaducidad.before(new Date())){
			caducada = true;
		}
		
		assertTrue(caducada);
	}
}
