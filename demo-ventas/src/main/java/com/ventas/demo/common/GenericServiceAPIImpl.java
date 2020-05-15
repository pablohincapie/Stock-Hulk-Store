package com.ventas.demo.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa los metodos de la interfaz GenericServiceAPI
 * 
 * @author Pablo Hincapie Creado el 09/05/2020 a 11:01:25 am <br>
 * @param <T>
 * @param <ID>
 */
@Service
public abstract class GenericServiceAPIImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ventas.demo.common.GenericServiceAPI#save(java.lang.Object)
	 */
	@Override
	public T save(T entity) {

		return getDao().save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ventas.demo.common.GenericServiceAPI#delete(java.io.Serializable)
	 */
	@Override
	public void delete(ID id) {
		getDao().deleteById(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ventas.demo.common.GenericServiceAPI#get(java.io.Serializable)
	 */
	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ventas.demo.common.GenericServiceAPI#getAll()
	 */
	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	public abstract CrudRepository<T, ID> getDao();

}
