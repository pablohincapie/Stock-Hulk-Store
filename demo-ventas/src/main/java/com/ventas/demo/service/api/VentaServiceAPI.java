package com.ventas.demo.service.api;

import org.springframework.stereotype.Service;
/*Interfaz que hereda de la clase generica.
* @author Pablo Hincapie Creado el 12/05/2020 a 10:05:17 pm <br>*/

import com.ventas.demo.common.GenericServiceAPI;
import com.ventas.demo.model.Venta;

/**
 * /*Interfaz que hereda de la clase generica.
 * @author Pablo Hincapie Creado el 12/05/2020 a 12:23:17 pm <br>
 * 
 */
@Service
public interface VentaServiceAPI extends GenericServiceAPI<Venta, Long> {

}
