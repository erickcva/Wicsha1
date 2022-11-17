package com.wicsha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wicsha.entity.*;
import com.wicsha.repository.*;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	//Encuentra todos los clientes sin especificar id
	@Override
	public Iterable<Cliente> findAllCliente() {
		return clienteRepository.findAll();
	}

	//Encuentra cliente por ID
	@Override
	public Cliente findClienteById(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> 
				new IllegalStateException
				("El usuario con el id " + id + " no existe"));
	}

	//Encuentra cliente por correo
	@Override
	public Cliente findClienteByCorreo(Cliente cliente) {
		return clienteRepository.findByCorreo(cliente.getCorreo());
	}

	
	//Verifica si existe el cliente
	@Override
	public boolean existsClienteById(Long id) {
		return clienteRepository.existsById(id);
	}
	
	
	//Verifica si existe el correo
	@Override
	public boolean existsClienteByCorreo(String correo) {
		return clienteRepository.existsByCorreo(correo);
	}

	//Guarda nuevo cliente
	@Override
	public Cliente saveCliente(Cliente cliente) throws Exception {
		if (!(cliente.getNombre().length() < Cliente.NOMBRE_LENGTH))			
			throw new IllegalStateException("Name length is greater than "+ Cliente.NOMBRE_LENGTH);
		else if(!(cliente.getApellido().length() < Cliente.APELLIDO_LENGTH))			
			throw new IllegalStateException("Lastname length is greater than "+ Cliente.APELLIDO_LENGTH);
		return clienteRepository.save(cliente);
	}

	//Actualiza datos del cliente
	@Override
	public Cliente updateCliente(Cliente cliente) {
		Cliente clienteInDatabase = findClienteById(cliente.getClienteId());		
		clienteInDatabase.setNombre(cliente.getNombre());
		clienteInDatabase.setApellido(cliente.getApellido());
		clienteInDatabase.setDireccion(cliente.getDireccion());
		clienteInDatabase.setCelular(cliente.getCelular());
		clienteInDatabase.setCP(cliente.getCP());
		clienteInDatabase.setUsuario(cliente.getUsuario());		
		return clienteRepository.save(clienteInDatabase);		
	}
	
	//Borra un cliente por ID
	@Override
	public String deleteClienteById(Long id) throws IllegalStateException {
		Cliente clienteInDatabase = findClienteById(id);		
		clienteRepository.save(clienteInDatabase);
		return "El cliente ha sido borrado";						
	}
}
