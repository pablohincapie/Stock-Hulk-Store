package com.ventas.demo.service.api;

import org.springframework.stereotype.Service;

import com.ventas.demo.common.GenericServiceAPI;
import com.ventas.demo.model.Compra;

/**
 * 
 * /*Interfaz que hereda de la clase generica.
 * 
 * @author Pablo Hincapie Creado el 12/05/2020 a 11:53:17 pm <br>
 */
@Service
public interface CompraServiceAPI extends GenericServiceAPI<Compra, Long> {

}
