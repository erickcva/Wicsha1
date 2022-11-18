package com.wicsha.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Productos {

	public static final int NOMBRE_PRENDA_LENGTH = 25;
	public static final int TALLA_LENGTH = 25;
	public static final int STOCK_LENGTH = 20;
	public static final int PRECIO_LENGTH = 7;
	public static final int DESCRIPCION_LENGTH = 100;
	public static final int IMG_LENGTH = 250;
	public static final int TARGET_LENGTH = 5;
	public static final int DIVISA_LENGTH = 5;
	public static final int DETALLE_LENGTH = 100;
	public static final int CATEGO_LENGTH = 15;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long productoId;

	@Column(name="nombre_prenda", length=NOMBRE_PRENDA_LENGTH)
	private String nombrePrenda;
	
	@Column(name="talla", length=TALLA_LENGTH)
	private String talla;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="stock", length=STOCK_LENGTH)
	private String stock;
	
	@Column(name="color", length=PRECIO_LENGTH)
	private String color;
	
	@Column(name="descripcion", length=DESCRIPCION_LENGTH)
	private String descripcion;
	
	@Column(name="img_principal", length=IMG_LENGTH)
	private String imgPrincipal;
	
	@Column(name="imag0", length=IMG_LENGTH)
	private String img0;
	
	@Column(name="imag1", length=IMG_LENGTH)
	private String img1;
	
	@Column(name="imag2", length=IMG_LENGTH)
	private String img2;;
	
	@Column(name="target", length=TARGET_LENGTH)
	private String target;
	
	@Column(name="divisa", length=DIVISA_LENGTH)
	private String divisa;
	
	@Column(name="detalle", length=DETALLE_LENGTH)
	private String detalle;
	
	@Column(name="catego", length=CATEGO_LENGTH)
	private String catego;
}
