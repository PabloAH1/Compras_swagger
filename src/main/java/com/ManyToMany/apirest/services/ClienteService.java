package com.ManyToMany.apirest.services;

import java.util.List;

import com.ManyToMany.apirest.entity.Cliente;


public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
		
	public void delete(Long id);	
	
	public Cliente findByNombre(String nombre);

}
