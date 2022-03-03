package com.ManyToMany.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ManyToMany.apirest.entity.Articulo;
import com.ManyToMany.apirest.entity.Compra;

@Repository
public interface ComprasDao extends CrudRepository<Compra, Long>{

	//@Query("from Cliente")
	//public List<Cliente> findAllClientes();
	
	@Query("from Articulo")
	public List<Compra> findAllComprass();
	
}
