package com.ManyToMany.apirest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;
//hola
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CodCliente;

	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@Column(nullable = false)
	private String empresa;
	@Column(nullable = false)
	private String puesto;
	@Column(name = "codigo_postal", nullable = false)
	private int cp;
	@Column(nullable = false)
	private String provincia;
	@Column(nullable = false)
	private int telefono;
	@Column(nullable = false)
	private Date fechaNacimiento;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "CodArticulo")
	 * 
	 * @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) private
	 * Articulo articulo;
	 */
	
	/*@JoinTable(
			name = "compras",
			joinColumns = @JoinColumn(name = "CodCliente", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "CodArticulo", nullable = false)
			)
	
	@ManyToMany(cascade = CascadeType.ALL)*/
	
	
	public Long getCodCliente() {
		return CodCliente;
	}

	public void setCodCliente(Long codCliente) {
		CodCliente = codCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
