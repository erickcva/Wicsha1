package com.wicsha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wicsha.entity.Productos;
import com.wicsha.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins="*")
public class ProductoController {
	
	@Autowired
	ProductoService productosService;
	
	@GetMapping //localhost:8080/api/cliente
	@ResponseBody
	//ResponseEntity configura la respuesta http
	public ResponseEntity<Iterable<Productos>> getAllProductos() {		
		return new ResponseEntity<Iterable<Productos>>
			(productosService.findAllProductos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}") //localhost:8080/api/cliente/id
	@ResponseBody
	public ResponseEntity<?> getProductosById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<Productos>(productosService.findProductosById(id), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping //localhost:8080/api/customer
	@ResponseBody
	public ResponseEntity<?> addNewProductos(@RequestBody Productos productos) {
		try {
			//Se guarda el cliente y lo retorna con el id asignado.
			return new ResponseEntity<Productos>(productosService.saveProductos(productos), HttpStatus.CREATED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateProductos(@RequestBody Productos productos) {	
		try {
			
			return new ResponseEntity<Productos>(productosService.updateProductos(productos), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}			
	}
	
	@DeleteMapping("/{id}") //localhost:8080/api/customer/id
	@ResponseBody
	public ResponseEntity<?> deleteProductos(@PathVariable("id") Long id) {
		try {			
			return new ResponseEntity<String>(productosService.deleteProductosById(id), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	
	}
}
