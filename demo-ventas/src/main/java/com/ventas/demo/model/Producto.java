package com.ventas.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * /*Clase que contiene los atributos de la entidad producto.
 * @author Pablo Hincapie Creado el 09/05/2020 a 09:23:17 am <br>
 */
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;

	@NotNull
	@Column
	private String descripcion;

	@NotNull
	@Column
	private int cantidad;

	@NotNull
	@Column
	private String referencia;

	@NotNull
	@Column
	private float precio;

	public Producto() {

	}

	public Producto(String descripcion, int cantidad, String referencia, float precio) {
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.referencia = referencia;
		this.precio = precio;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
