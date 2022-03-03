package com.ManyToMany.apirest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ManyToMany.apirest.entity.Cliente;
import com.ManyToMany.apirest.entity.Compra;
import com.ManyToMany.apirest.services.CompraService;

@RestController
@RequestMapping("/api")
public class CompraRestController {

	@Autowired
	private CompraService servicio;

	@GetMapping("/compras")
	public List<Compra> findAllCompras() {
		return servicio.findAll();
	}

	@GetMapping("/compras/{id}")
	public ResponseEntity<?> findComprasById(@PathVariable Long id) {
		Compra compra = null;
		Map<String, Object> response = new HashMap<>();

		try {
			compra = servicio.findById(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (compra == null) {
			response.put("mensaje", "La compra ID: " + id.toString() + " no existe en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Compra>(compra, HttpStatus.OK);
	}
	@GetMapping({ "/compras/buscar/{fecha}"})
	public ResponseEntity<?> findCompraByFecha(@PathVariable Date fecha){
		Compra compra=null;		
		Map<String, Object> response =new HashMap<>();
		try {
			compra=servicio.findByFecha(fecha);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		if (fecha == null) {
			response.put("mensaje","En la fecha: "+ fecha.toString()+(" no se encuentra ningún registro en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Compra>(compra,HttpStatus.OK);
	}
	
	@PostMapping("/compra")
	public ResponseEntity<?> saveCompra(@RequestBody Compra compra) {
		Compra compraNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			compraNew = servicio.save(compra);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Ha sido creada con éxito.");
		response.put("compra", compraNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/compra/{id}")
	public ResponseEntity<?> updateCompra(@RequestBody Compra compra, @PathVariable Long id) {
		Compra compraActual = servicio.findById(id);
		Map<String, Object> response = new HashMap<>();

		if (compraActual == null) {
			response.put("mensaje", "La compra ID: " + id.toString() + " no existe en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			compraActual.setFecha(compra.getFecha());
			compraActual.setUnidades(compra.getUnidades());
			compraActual.setCliente(compra.getCliente());
			compraActual.setArticulo(compra.getArticulo());
			servicio.save(compraActual);

		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Ha sido actualizada con éxito.");
		response.put("compra", compraActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
