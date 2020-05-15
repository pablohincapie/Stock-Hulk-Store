package com.ventas.demo.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ventas.demo.common.GenericServiceAPIImpl;
import com.ventas.demo.dao.api.VentaDaoAPI;
import com.ventas.demo.model.Venta;
import com.ventas.demo.service.api.VentaServiceAPI;

/*Clase que hereda de la omplementacion de los servicios genericos
* @author Pablo Hincapie Creado el 12/05/2020 a 08:24:14 pm <br>*/
@Service
public class VentaServiceAPIImpl extends GenericServiceAPIImpl<Venta, Long> implements VentaServiceAPI {

	@Autowired
	private VentaDaoAPI ventaDaoAPI;

	/*
	 * (non-Javadoc)
	 * @see com.ventas.demo.common.GenericServiceAPIImpl#getDao()
	 */
	@Override
	public CrudRepository<Venta, Long> getDao() {

		return ventaDaoAPI;
	}
}
