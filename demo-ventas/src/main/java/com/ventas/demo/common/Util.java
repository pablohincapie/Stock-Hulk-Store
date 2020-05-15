package com.ventas.demo.common;

import org.springframework.stereotype.Service;

/**
 * Clase utilitaria que contiene metodos comunes.
 * 
 * @author Pablo Hincapie Creado el 11/05/2020 a 10:13:38 am <br>
 * @param <T>
 * @param <ID>
 */
@Service
public class Util {

	/**
	 * Metodo que calcula el valor de una compra y/o producto
	 * 
	 * @param cantidad
	 * @param precio
	 * @return
	 */
	public float calcularTotal(int cantidad, float precio) {
		float total = cantidad * precio;
		return total;
	}
}
