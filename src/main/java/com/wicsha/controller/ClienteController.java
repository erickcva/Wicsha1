package com.wicsha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.wicsha.entity.*;
import com.wicsha.service.*;


@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins="*")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping //localhost:8080/api/cliente
	@ResponseBody
	//ResponseEntity configura la respuesta http
	public ResponseEntity<Iterable<Cliente>> getAllCliente() {		
		return new ResponseEntity<Iterable<Cliente>>
			(clienteService.findAllCliente(), HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}") //localhost:8080/api/cliente/id
	@ResponseBody
	public ResponseEntity<?> getClienteById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<Cliente>(clienteService.findClienteById(id), HttpStatus.OK);
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
	public ResponseEntity<?> addNewCliente(@RequestBody Cliente cliente) {
		try {
			//Se guarda el cliente y lo retorna con el id asignado.
			return new ResponseEntity<Cliente>(clienteService.saveCliente(cliente), HttpStatus.CREATED);
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
	public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente) {	
		try {
			
			return new ResponseEntity<Cliente>(clienteService.updateCliente(cliente), HttpStatus.OK);
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
	public ResponseEntity<?> deleteCliente(@PathVariable("id") Long id) {
		try {			
			return new ResponseEntity<String>(clienteService.deleteClienteById(id), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	
	}
}
