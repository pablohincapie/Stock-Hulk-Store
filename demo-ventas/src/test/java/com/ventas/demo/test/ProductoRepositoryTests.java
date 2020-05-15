package com.ventas.demo.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ventas.demo.dao.api.ProductoDaoAPI;
import com.ventas.demo.generics.dao.GenereicDaoAPI;
import com.ventas.demo.model.Producto;

/**
 * Pruebas unitarias de la entidad producto
 * @author Pablo Hincapie 13/05/2020 07:52:01 p.m
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductoRepositoryTests {

	@Autowired
	private GenereicDaoAPI genereicDaoAPI;
	@Autowired
	private ProductoDaoAPI productoDaoAPI;

	@Test
	public void testSaveProducto() throws SQLException {

		Producto producto = new Producto("SuperHeroe", 80, "01", 1000);
		genereicDaoAPI.save(producto);
		Producto producto2 = productoDaoAPI.findProductoByReferencia("01");
		assertNotNull(producto2);
		assertEquals(producto2.getReferencia(), producto.getReferencia());
		assertEquals(producto2.getCantidad(), producto.getCantidad());

	}

	@Test
	public void testGetProducto() throws SQLException {

		Producto producto = new Producto("SuperHeroe", 80, "01", 1000);
		genereicDaoAPI.save(producto);
		Producto producto2 = productoDaoAPI.findProductoByReferencia("01");
		assertNotNull(producto2);
		assertEquals(producto2.getReferencia(), producto.getReferencia());
		assertEquals(producto2.getCantidad(), producto.getCantidad());
	}

	@Test
	public void testDeleteProducto() {
		Producto producto = new Producto("SuperHeroe", 80, "01", 1000);
		genereicDaoAPI.save(producto);
		genereicDaoAPI.delete(producto);
	}

	@Test
	public void findAllProducto() {
		Producto producto = new Producto("SuperHeroe", 80, "01", 1000);
		genereicDaoAPI.save(producto);
		assertNotNull(genereicDaoAPI.findAll());
	}

	@Test
	public void deletByProductoIdTest() {
		Producto producto = new Producto("SuperHeroe", 80, "01", 1000);
		Producto prodDelete = genereicDaoAPI.save(producto);
		genereicDaoAPI.deleteById(prodDelete.getId_producto());
	}

	@Test
	public void UpdateCantidadByProductoReferenciaTest() throws SQLException {
		Producto producto2 = productoDaoAPI.findProductoByReferencia("01");
		productoDaoAPI.UpdateQuantity(producto2);
	}
}
