package com.ManyToMany.apirest.services;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ManyToMany.apirest.dao.ClienteDao;
import com.ManyToMany.apirest.entity.Cliente;


@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}


	
	@Override
	@Transactional
	public Cliente findByNombre(String nombre) {
		Cliente clienteBusca=null;
		ArrayList<Cliente>clientes=(ArrayList<Cliente>) clienteDao.findAllClieentes();

		for (java.util.Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			
			if (cliente.getNombre().equals(nombre))clienteBusca=cliente;
		}	
		// return clienteDao.findByNoombre(nombre);
		return clienteBusca;
	}
	

}