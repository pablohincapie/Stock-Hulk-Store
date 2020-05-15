package com.ventas.demo.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.ventas.demo.model.Compra;

/**
 * 
 * Interfaz que hereda de la clase crud, para realizar acciones sobre una
 * compra.
 * @author Pablo Hincapie Creado el 09/05/2020 a 04:22:14 am <br>
 *
 */
public interface CompraDaoAPI extends CrudRepository<Compra, Long> {

}
