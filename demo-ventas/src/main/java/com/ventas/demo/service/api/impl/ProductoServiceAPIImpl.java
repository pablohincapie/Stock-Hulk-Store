package com.ventas.demo.service.api.impl;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.ventas.demo.common.GenericServiceAPIImpl;
import com.ventas.demo.dao.api.ProductoDaoAPI;
import com.ventas.demo.generics.dao.GenereicDaoAPI;
import com.ventas.demo.model.Producto;
import com.ventas.demo.service.api.ProductoServiceAPI;
/*
* Clase que extiende de lso servicios genericos
* producto.
* @author Pablo Hincapie Creado el 12/05/2020 a 08:24:14 pm <br>*/

@Service
public class ProductoServiceAPIImpl extends GenericServiceAPIImpl<Producto, Long> implements ProductoServiceAPI {
	@Autowired
	private GenereicDaoAPI genereciDaoAPI;

	@Autowired
	private ProductoDaoAPI productoDaoAPI;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ventas.demo.common.GenericServiceAPIImpl#getDao()
	 */
	@Autowired
	public CrudRepository<Producto, Long> getDao() {

		return genereciDaoAPI;
	}

	NamedParameterJdbcTemplate template;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ventas.demo.service.api.ProductoServiceAPI#updateProducto(com.ventas.
	 * demo.model.Producto)
	 */
	@Transactional
	public void updateProducto(Producto producto) throws SQLException, Exception {
		Producto productoActualizar = new Producto();
		productoActualizar.setCantidad(producto.getCantidad());
		productoActualizar.setReferencia(producto.getReferencia());
		productoDaoAPI.UpdateQuantity(productoActualizar);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ventas.demo.service.api.ProductoServiceAPI#findProductoByReferencia(
	 * java.lang.String)
	 */
	@Transactional
	public Producto findProductoByReferencia(String referencia) throws SQLException {

		Producto productoResult = productoDaoAPI.findProductoByReferencia(referencia);
		return productoResult;
	}

}
