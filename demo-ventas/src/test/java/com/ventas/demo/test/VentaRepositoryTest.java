package com.ventas.demo.test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ventas.demo.generics.dao.GenereicDaoAPI;
import com.ventas.demo.model.Venta;
import com.ventas.demo.service.api.VentaServiceAPI;

/**
 * Pruebas unitarias de la entidad venta
  * @author Pablo Hincapie 13/05/2020 09:22:04 p.m
 */

public class VentaRepositoryTest {
	@Autowired
	private GenereicDaoAPI genereicDaoAPI;

	@Autowired
	private VentaServiceAPI ventaServiceAPI;

	@Test
	public void testSaveVenta() throws SQLException {

		float total = 80 * 1000;
		java.util.Date fecha = new Date();
		Venta venta = new Venta("SuperHeroe", "01", 80, 1000, total, fecha);
		ventaServiceAPI.save(venta);
	}

	@Test
	public void findAllVentas() {
		float total = 80 * 1000;
		java.util.Date fecha = new Date();
		Venta venta = new Venta("SuperHeroe", "01", 80, 1000, total, fecha);
		ventaServiceAPI.save(venta);
		assertNotNull(genereicDaoAPI.findAll());
	}

	@Test
	public void deletByVentaIdTest() {
		float total = 80 * 1000;
		java.util.Date fecha = new Date();
		Venta venta = new Venta("SuperHeroe", "01", 80, 1000, total, fecha);
		Venta ventaDelete = ventaServiceAPI.save(venta);
		genereicDaoAPI.deleteById(ventaDelete.getId_venta());
	}
}
