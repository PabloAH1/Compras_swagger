package com.ManyToMany.apirest.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ManyToMany.apirest.entity.Articulo;
import com.ManyToMany.apirest.entity.Cliente;
import com.ManyToMany.apirest.services.ArticuloService;

@RestController
@RequestMapping("/api")
public class ArticuloController {

	@Autowired
	private ArticuloService servicio;
	
	@GetMapping("/articulos")
	public List<Articulo> index(){
		
		return servicio.findAll();
		
	}	
	
	@GetMapping("/articulos/{id}")
	public Articulo findArticuloById(@PathVariable Long id) {
		
		return servicio.findById(id);
	}

	@GetMapping({ "/articulos/buscar/{nombre}"})
	public ResponseEntity<?> findArticuloByNombre(@PathVariable String nombre){
		Articulo articulo=null;		
		Map<String, Object> response =new HashMap<>();
		try {
			articulo=servicio.findByNombre(nombre);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		if (articulo == null) {
			response.put("mensaje","El artículo con nombre: "+ nombre.toString()+(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Articulo>(articulo,HttpStatus.OK);
	}
	
	@GetMapping("/articulos/excepciones/{id}")
	public ResponseEntity<?> findArticuloByIdExcepciones(@PathVariable Long id){
		
		Articulo articulo=null;
		Map<String,Object> response= new HashMap<>();
		
		try {
			
			articulo=servicio.findById(id);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(articulo==null) {
			
			response.put("mensaje", "El articulo ID: ".concat(id.toString().concat("no existe en la base de datos")));
			
			return 	new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Articulo>(articulo,HttpStatus.OK);
	}
	
	
	@PostMapping("/articulo/excepciones")
	public ResponseEntity<?> saveClienteExcepciones(@RequestBody Articulo articulo){
		
		Articulo articuloNew=null;
		Map<String,Object> response= new HashMap<>();
		
		
		try {
			
			articulo=servicio.save(articulo);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar un insert a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "El cliente ha sido creado con éxito");
		response.put("articulo", articuloNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}

	@PutMapping("/articulo/excepciones/{id}")
	public ResponseEntity<?> updateClienteExcepciones(@RequestBody Articulo articulo, @PathVariable Long id) {
		
		Map<String,Object> 	response = new HashMap<>();
		Articulo articuloActual=servicio.findById(id);
		
		if(articuloActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el articulo con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		

	try {	
		articuloActual.setDescripcion(articulo.getDescripcion());
		articuloActual.setImagen(articulo.getImagen());
		articuloActual.setNombre(articulo.getNombre());
		articuloActual.setPrecio(articulo.getPrecio());
		articuloActual.setStock(articulo.getStock());
		articuloActual.setStockSeguridad(articulo.getStockSeguridad());

		
		servicio.save(articuloActual);
		
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		response.put("mensaje", "Error al realizar un update a la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	response.put("mensaje", "El articulo ha sido actualizado con éxito");
	response.put("articulo", articuloActual);
	
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
	}

	@DeleteMapping("/articulo/excepciones/{id}")
	public ResponseEntity<?> deleteClienteExcepciones(@PathVariable Long id) {
		Map<String,Object> 	response = new HashMap<>();
		Articulo articuloActual=servicio.findById(id);
		
		if(articuloActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el articulo con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		
		try {	
		servicio.delete(id);
		
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar un delete a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("articulo", articuloActual);
		response.put("mensaje", "Se ha borrado con exito el articulo");
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
