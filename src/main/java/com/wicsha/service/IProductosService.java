package com.wicsha.service;

import com.wicsha.entity.Productos;

public interface IProductosService {

	public Iterable<Productos> findAllProductos();
	
	public Productos findProductosById(Long id);	
	
	public Productos findProductosByTarget(String target);	

	public boolean existsProductosById(Long id);
	
	public boolean existsProductosByTarget(String target);
	
	public Productos saveProductos(Productos productos) throws Exception;
	
	public Productos updateProductos(Productos productos);
	
	public String deleteProductosById(Long id);
	
}
