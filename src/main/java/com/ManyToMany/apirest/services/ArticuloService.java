package com.ManyToMany.apirest.services;

import java.util.List;

import com.ManyToMany.apirest.entity.Articulo;
import com.ManyToMany.apirest.entity.Cliente;



public interface ArticuloService {

public List<Articulo> findAll();
	
	public Articulo findById(Long id);
	
	public Articulo save(Articulo articulo);
	
	public void delete(Long id);
	
	public Articulo findByNombre(String nombre);
}
