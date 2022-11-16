package com.wicsha.service;

import com.wicsha.entity.Cliente;

public interface IClienteService {

	public Iterable<Cliente> findAllCliente();
	
	public Cliente findClienteById(Long id);
	
	public Cliente findClienteByCorreo(Cliente cliente);		
	
	public boolean existsClienteById(Long id);
	
	public boolean existsClienteByCorreo(String correo);
	
	public Cliente saveCliente(Cliente cliente) throws Exception;
	
	public Cliente updateCliente(Cliente cliente);
	
	public String deleteClienteById(Long id);

}
