package com.ventas.demo.generics.dao;

import org.springframework.data.repository.CrudRepository;

import com.ventas.demo.model.Producto;

/**
 * Interfaz que hereda de la clase crud, para realizar acciones
 * @author Pablo Hincapie Creado el 09/05/2020 a 04:36:18 am <br>
 */
public interface GenereicDaoAPI extends CrudRepository<Producto, Long> {

}
