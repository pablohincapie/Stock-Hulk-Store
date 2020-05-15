package com.ventas.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * /*Clase que contiene los atributos de la entidad venta.
 * @author Pablo Hincapie Creado el 11/05/2020 a 09:23:17 pm <br>
 */
@Entity
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta;

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

	@Column
	private float total;

	@Column
	private Date fecha_venta;

	public Venta() {

	}

	public Venta(String descripcion, String referencia, int cantidad, float precio, float total, Date fecha) {
		this.descripcion = descripcion;
		this.referencia = referencia;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.fecha_venta = fecha;
	}

	public Long getId_venta() {
		return id_venta;
	}

	public void setId_venta(Long id_venta) {
		this.id_venta = id_venta;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
}
