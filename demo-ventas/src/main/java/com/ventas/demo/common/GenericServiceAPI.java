package com.ventas.demo.common;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz que contiene la definición de los metodos del crud.
 * @author Pablo Hincapie Creado el 09/05/2020 a 10:56:38 am <br>
 * @param <T>
 * @param <ID>
 */
public interface GenericServiceAPI<T, ID extends Serializable> {

	/**
	 * definición del metodo que guarda en una entidad
	 * @author Pablo Hincapie Creado el 09/05/2020 a 11:04:38 am <br>
	 * @param entity
	 * @return
	 */
	T save(T entity);

	/**
	 * definición del metodo que elimina una entidad en una entidad
	 * @author Pablo Hincapie Creado el 09/05/2020 a 11:06:05 am <br>
	 * @param id
	 */
	void delete(ID id);

	/**
	 * definición del metodo que busca un elemento por id.
	 * @author Pablo Hincapie Creado el 09/05/2020 a 11:07:12 am <br>
	 * 
	 * @param id
	 * @return
	 */
	T get(ID id);

	/**
	 * *definición del metodo que lista toda la informacion de una entidadid.
	 * @author Pablo Hincapie Creado el 09/05/2020 a 11:10:21 am <br>
	 * 
	 * @return
	 */
	List<T> getAll();
}
