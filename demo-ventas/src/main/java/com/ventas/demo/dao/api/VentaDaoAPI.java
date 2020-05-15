package com.ventas.demo.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.ventas.demo.model.Venta;

/**
 * Interfaz que hereda de la clase crud, para realizar acciones sobre un a
 * venta.
  * @author Pablo Hincapie Creado el 09/05/2020 a 04:28:19 am <br>
 * 
 */
public interface VentaDaoAPI extends CrudRepository<Venta, Long> {

}
