package com.ventas.demo.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.ventas.demo.common.GenericServiceAPIImpl;
import com.ventas.demo.dao.api.CompraDaoAPI;
import com.ventas.demo.model.Compra;
import com.ventas.demo.service.api.CompraServiceAPI;

/**
 * Clase que hereda de la omplementacion de los servicios genericos producto.
 * 
 * @author Pablo Hincapie Creado el 10/05/2020 a 08:49:14 pm <br>
 *
 */
@Service
public class CompraServiceAPIImpl extends GenericServiceAPIImpl<Compra, Long> implements CompraServiceAPI {
	@Autowired
	private CompraDaoAPI compraDaoAPI;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ventas.demo.common.GenericServiceAPIImpl#getDao()
	 */
	@Override
	public CrudRepository<Compra, Long> getDao() {

		return compraDaoAPI;
	}
}
