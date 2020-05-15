package com.ventas.demo.test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ventas.demo.generics.dao.GenereicDaoAPI;
import com.ventas.demo.model.Compra;

import com.ventas.demo.service.api.CompraServiceAPI;

/**
 * Pruebas unitarias de la entidad compra
 * @author Pablo Hincapie 13/05/2020 08:52:01 p.m
 */
public class CompraRepositoryTest {

	@Autowired
	private GenereicDaoAPI genereicDaoAPI;

	@Autowired
	private CompraServiceAPI compraServiceAPI;

	@Test
	public void testSaveCompra() throws SQLException {

		float total = 80 * 1000;
		java.util.Date fecha = new Date();
		Compra compra = new Compra("SuperHeroe", "01", 80, 1000, total, fecha);
		compraServiceAPI.save(compra);
	}

	@Test
	public void findAllCompras() {
		float total = 80 * 1000;
		java.util.Date fecha = new Date();
		Compra compra = new Compra("SuperHeroe", "01", 80, 1000, total, fecha);
		compraServiceAPI.save(compra);
		assertNotNull(genereicDaoAPI.findAll());
	}

	@Test
	public void deletByCompraIdTest() {
		float total = 80 * 1000;
		java.util.Date fecha = new Date();
		Compra compra = new Compra("SuperHeroe", "01", 80, 1000, total, fecha);
		Compra compraDelete = compraServiceAPI.save(compra);
		genereicDaoAPI.deleteById(compraDelete.getId_compra());
	}
}
