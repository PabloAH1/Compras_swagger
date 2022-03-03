package com.ManyToMany.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ManyToMany.apirest.entity.Articulo;
import com.ManyToMany.apirest.entity.Cliente;


@Repository
public interface ArticulosDao extends CrudRepository<Articulo,Long> {
	@Query("from Articulo")
	public List<Articulo> findAllArticuloss();
}
