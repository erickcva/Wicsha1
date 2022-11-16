package com.wicsha.entity;

import java.util.Calendar;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="ticket")
public class Ticket {
	
	public static final int CANTIDAD_PRODUCTOS = 10;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ticket")
	private Long ticketId;
	
	@Column(name = "fecha", insertable=false,  updatable=false , columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Productos productoId;
	
	@ManyToOne
	@JoinColumn(name="id_pago")
	private Pago pagoId;
	
	@Column(name="precio_unitario")
	private Double precioUnitario;

	
	@Column(name="cantidad_productos", length= CANTIDAD_PRODUCTOS)
	private String cantidadProductos;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente clienteId;
	
}
