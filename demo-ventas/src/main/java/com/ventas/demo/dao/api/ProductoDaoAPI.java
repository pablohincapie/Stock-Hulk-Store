package com.ventas.demo.dao.api;

import java.sql.SQLException;

import com.ventas.demo.model.Producto;

/**
 * 
 * Interfaz que hereda de la clase crud, para realizar acciones sobre un
 * producto.
 * @author Pablo Hincapie Creado el 09/05/2020 a 04:24:14 am <br>
 *
 */
public interface ProductoDaoAPI {
	/**
	 *  Metodo que consulta por id_referencia
	 * @param id_persona
	 * @return
	 * @throws SQLException
	 */
	Producto findProductoByReferencia(String referencia) throws SQLException;

	/**
	 * Metodo que actualiza caqntidades de un producto.
	 * @author Pablo Hincapie Creado el 09/05/2020 a 04:28:14 am <br>
	 * @param producto
	 */
	void UpdateQuantity(Producto producto);
}
