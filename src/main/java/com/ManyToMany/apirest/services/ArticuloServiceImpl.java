package com.ManyToMany.apirest.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ManyToMany.apirest.dao.ArticulosDao;
import com.ManyToMany.apirest.entity.Articulo;
import com.ManyToMany.apirest.entity.Cliente;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	ArticulosDao articuloDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Articulo> findAll() {
		return (List<Articulo>) articuloDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Articulo findById(Long id) {
		// TODO Auto-generated method stub
		return articuloDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public Articulo save(Articulo articulo) {
		// TODO Auto-generated method stub
		
		return articuloDao.save(articulo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		articuloDao.deleteById(id);
	}
	

	@Override
	@Transactional
	public Articulo findByNombre(String nombre) {
		Articulo articuloBusca=null;
		ArrayList<Articulo>articulos=(ArrayList<Articulo>) articuloDao.findAllArticuloss();

		for (java.util.Iterator<Articulo> iterator = articulos.iterator(); iterator.hasNext();) {
			Articulo articulo = (Articulo) iterator.next();
			
			if (articulo.getNombre().equals(nombre))articuloBusca=articulo;
		}	
		// return articuloDao.findByNoombre(nombre);
		return articuloBusca;
	}
	
}
