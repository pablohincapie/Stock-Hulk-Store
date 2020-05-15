package com.ventas.demo.model;

/**
 * /*Clase que contiene los atributos de la entidad compra.
  * @author Pablo Hincapie Creado el 09/05/2020 a 07:23:17 am <br>
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compra;

	@NotNull
	@Column
	private String descripcion;
	@NotNull
	@Column
	private String referencia;
	@NotNull
	@Column
	private int cantidad;
	@NotNull
	@Column
	private float precio;

	@Column
	private float total;

	@Column
	private Date fecha_compra;

	public Compra() {

	}

	public Compra(String descripcion, String referencia, int cantidad, float precio, float total, Date fecha) {
		this.descripcion = descripcion;
		this.referencia = referencia;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.fecha_compra = fecha;
	}

	public Long getId_compra() {
		return id_compra;
	}

	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
}
