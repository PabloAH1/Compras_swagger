package com.ManyToMany.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ManyToMany.apirest.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{
	@Query("from Cliente")
	public List<Cliente> findAllClieentes();
	
//	@Query("select e from Clientes e where e.nombreBusca = ?1")   	
//	public Cliente findByNoombre( String nombreBusca) ;
}
