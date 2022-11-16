package com.wicsha.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Productos {

	public static final int NOMBRE_PRENDA_LENGTH = 25;
	public static final int TALLA_LENGTH = 25;
	public static final int NUMERO_TARJETA_LENGTH = 16;
	public static final int STOCK_LENGTH = 20;
	public static final int PRECIO_LENGTH = 7;
	public static final int DESCRIPCION_LENGTH = 100;
	public static final int IMAGEN_LENGTH = 250;
	public static final int TARGET_LENGTH = 5;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long productoId;

	@Column(name="nombre_prenda", length=NOMBRE_PRENDA_LENGTH)
	private String nombrePrenda;
	
	@Column(name="talla", length=TALLA_LENGTH)
	private String talla;
	
	@Column(name="numero_tarjeta", length=NUMERO_TARJETA_LENGTH)
	private String numeroTarjeta;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="stock", length=STOCK_LENGTH)
	private String stock;
	
	@Column(name="color", length=PRECIO_LENGTH)
	private String color;
	
	@Column(name="descripcion", length=DESCRIPCION_LENGTH)
	private String descripcion;
	
	@Column(name="imagen", length=IMAGEN_LENGTH)
	private String imagen;
	
	@Column(name="target", length=TARGET_LENGTH)
	private String target;
}
