package com.ManyToMany.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "articulos")
public class Articulo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CodArticulo;
	
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private int precio;
	@Column(nullable = false)
	private int stock;
	@Column(nullable = false)
	private int stockSeguridad;
	@Column(nullable = false)
	private String imagen;
	public Long getCodArticulo() {
		return CodArticulo;
	}
	public void setCodArticulo(Long codArticulo) {
		CodArticulo = codArticulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStockSeguridad() {
		return stockSeguridad;
	}
	public void setStockSeguridad(int stockSeguridad) {
		this.stockSeguridad = stockSeguridad;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "CodCliente")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Cliente cliente;*/
	
	
}
