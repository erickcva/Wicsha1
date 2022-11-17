package com.wicsha.repository;

import org.springframework.data.repository.CrudRepository;

import com.wicsha.entity.Productos;

public interface ProductosRepository extends CrudRepository<Productos, Long>{

	Productos findByTarget(String target);
	boolean existsByTarget(String target);
}
