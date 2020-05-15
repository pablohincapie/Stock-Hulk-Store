package com.ventas.demo.service.api;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ventas.demo.common.GenericServiceAPI;
import com.ventas.demo.model.Producto;

/*Interfaz que hereda de la clase generica.
* @author Pablo Hincapie Creado el 13/05/2020 a 11:23:17 pm <br>*/
@Service
public interface ProductoServiceAPI extends GenericServiceAPI<Producto, Long> {

	/**
	 * Metodo que busca por referencia /*@author Pablo Hincapie Creado el
	 * 13/05/2020 a 10:38:17 pm <br>
	 * @param referencia
	 * @return
	 * @throws SQLException
	 */
	Producto findProductoByReferencia(String referencia) throws SQLException;

	/**
	 * Metodo que valida la actulización de cantidades. /*@author Pablo Hincapie
	 * Creado el 13/05/2020 a 10:38:17 pm <br>
	 * @param producto
	 * @throws SQLException
	 * @throws Exception
	 */
	void updateProducto(Producto producto) throws SQLException, Exception;
}
