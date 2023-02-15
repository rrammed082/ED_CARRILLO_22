package com.iescarrillo.Test_3_4;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.jupiter.api.Test;

public class TestShoppingCard {

	@Test
	public void testCarroSinElementos() {
		ShoppingCart carroCompra = new ShoppingCart();

		assertTrue(carroCompra.getItemCount() == 0, "Está vacío");
	}

	@Test
	public void testCarroVacio() {
		ShoppingCart carroCompra = new ShoppingCart();
		carroCompra.empty();
		assertTrue(carroCompra.getItemCount() == 0, "Está vacío");
	}

	@Test
	public void testAnnadirProducto() {
		ShoppingCart carroCompra = new ShoppingCart();
		Product producto1 = new Product("Refresco", 1.20);
		carroCompra.addItem(producto1);
		assertTrue(carroCompra.getItemCount() > 0, "Tiene productos");
	}

	@Test
	public void testBalance() {
		ShoppingCart carroCompra = new ShoppingCart();
		Product producto1 = new Product("Refresco", 1.20);

		carroCompra.addItem(producto1);
		double balance = carroCompra.getBalance();
		Product producto2 = new Product("Harina", 0.8);
		carroCompra.addItem(producto2);

		balance += producto2.getPrice();
		double balanceT = carroCompra.getBalance();

		assertTrue(balance == balanceT, "Es igual");
	}

	@Test
	public void testBalanceHamcrest() {
		ShoppingCart carroCompra = new ShoppingCart();
		Product producto1 = new Product("Refresco", 1.20);

		carroCompra.addItem(producto1);
		double balance = carroCompra.getBalance();
		Product producto2 = new Product("Harina", 0.8);
		carroCompra.addItem(producto2);

		balance += producto2.getPrice();
		double balanceT = carroCompra.getBalance();

		assertThat(balanceT, equalTo(balance));
	}

	@Test
	public void testEliminarProducto() throws ProductNotFoundException {
		ShoppingCart carroCompra = new ShoppingCart();
		Product producto1 = new Product("Refresco", 1.20);
		Product producto2 = new Product("Harina", 0.8);
		
		carroCompra.addItem(producto1);
		carroCompra.addItem(producto2);
		
		carroCompra.removeItem(producto1);
		
		assertThat(carroCompra.getItemCount(), equalTo(1));
		
	}
	
	@Test
	public void testProductNotFoundException() {
        try {
            throw new ProductNotFoundException();
        } catch (ProductNotFoundException e) {
            assertThat(e, is(instanceOf(Exception.class)));
            assertThat(e, is(instanceOf(ProductNotFoundException.class)));
        }
    }
	
	
}
