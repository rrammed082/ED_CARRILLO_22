package com.iescarrillo.PruebaUD03_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEmpleado {

	@Test
	public void testCrearEmpleadoVacío() {
		Empleado e = new Empleado();

		assertThat(e.getNombre(), is(""));
	}
	
	@Test
	public void testPruebaNombre() {
		Empleado e = new Empleado("Pepe", "Pérez");

		assertThat(e.getNombre(), is("Pepe"));
	}
	
	@Test
	public void testPruebaApellido() {
		Empleado e = new Empleado("Pepe", "Pérez");

		assertThat(e.getApellido(), is("Pérez"));
	}
	
	@Test
	public void testEdad() {
		Empleado e = new Empleado("Pepe", "Pérez", 43);

		assertThat(e.getEdad(), equalTo(43));
	}
	
	@Test
	public void testSalario() {
		Empleado e = new Empleado("Pepe", "Pérez", 43, 1800.0);

		assertThat(e.getSalario(), equalTo(1800.0));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {43, 27, 30}) 
	public void testPlus() {
		Empleado e = new Empleado("Pepe", "Pérez", 43, 1800.0);
		
		double salario = e.getSalario();

		if(e.plus(200)) {
			salario += 200;
		}
		
		
		assertThat(e.getSalario(), equalTo(salario));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Pepe", "Pérez"})
	public void testEquals(String nombre, String apellido) {
		Empleado e = new Empleado(nombre, apellido);
		Empleado e2 = new Empleado("Pepe", "Pérez");
	
		assertThat(e.equals(e2), is(true));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {20, 18, 30}) 
	public void testToString(int num) {
		Empleado e = new Empleado("Pepe", "Perez", num);
		Empleado e2 = new Empleado("Paco", "Rodriguez", 20);
		
		assertThat(e.compareTo(e2), equalTo(1));
	}
	
	@Test
	public void testToString() {
		Empleado e = new Empleado("Pepe", "Pérez", 43, 1800.0);
		String mensaje="El empleado se llama "+e.getNombre()+" "+e.getApellido()+" con "+e.getEdad()+" años " +
                "y un salario de "+e.getSalario();
		assertThat(e.toString(), equalTo(mensaje));
	}
}
