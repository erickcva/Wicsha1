package com.wicsha.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wicsha.entity.Productos;
import com.wicsha.repository.ProductosRepository;

@Service
public class ProductoService implements IProductosService {

	@Autowired
	ProductosRepository productosRepository;
	
	@Override
	public Iterable<Productos> findAllProductos() {
		return productosRepository.findAll();
	}

	@Override
	public Productos findProductosById(Long id) {
		return productosRepository.findById(id)
				.orElseThrow(() -> 
				new IllegalStateException
				("El usuario con el id " + id + " no existe"));
	}

	@Override
	public Productos findProductosByTarget(String target) {
		return productosRepository.findByTarget(target);
	}

	@Override
	public boolean existsProductosById(Long id) {
		return productosRepository.existsById(id);
	}

	@Override
	public boolean existsProductosByTarget(String target) {
		return productosRepository.existsByTarget(target);
	}

	@Override
	public Productos saveProductos(Productos productos) throws Exception {
		if (!(productos.getNombrePrenda().length() < Productos.NOMBRE_PRENDA_LENGTH))			
			throw new IllegalStateException("El nombre de la prenda es mayor a "+ Productos.NOMBRE_PRENDA_LENGTH);
		else if(!(productos.getPrecio() < Productos.PRECIO_LENGTH))			
			throw new IllegalStateException("El precio excede a "+ Productos.PRECIO_LENGTH);
		return productosRepository.save(productos);
	}

	@Override
	public Productos updateProductos(Productos productos) {
		Productos productosInDatabase = findProductosById(productos.getProductoId());		
		productosInDatabase.setNombrePrenda(productos.getNombrePrenda());
		productosInDatabase.setTalla(productos.getTalla());
		productosInDatabase.setPrecio(productos.getPrecio());
		productosInDatabase.setDescripcion(productos.getDescripcion());
		productosInDatabase.setImgPrincipal(productos.getImgPrincipal());
		productosInDatabase.setTarget(productos.getTarget());		
		return productosRepository.save(productosInDatabase);	
	}

	@Override
	public String deleteProductosById(Long id) {
		Productos productosInDatabase = findProductosById(id);		
		productosRepository.save(productosInDatabase);
		return "El productos ha sido borrado";
	}


	

}
