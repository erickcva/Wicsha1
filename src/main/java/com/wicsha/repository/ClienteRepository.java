package com.wicsha.repository;

import org.springframework.data.repository.CrudRepository;
import com.wicsha.entity.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	Cliente findByCorreo(String correo);
	boolean existsByCorreo(String correo);
	
	
}
