package com.wicsha.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pago")
public class Pago {
	public static final int NOMBRE_TITULAR_LENGTH = 25;
	public static final int NUMERO_TARJETA_LENGTH = 16;
	public static final int FECHA_VENCIMIENTO_LENGTH = 5;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago")
	private Long pagoId;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente clienteId;
	
	@Column(name="nombre_titular", length=NOMBRE_TITULAR_LENGTH)
	private String nombreTitular;
	
	@Column(name="numero_tarjeta", length=NUMERO_TARJETA_LENGTH)
	private String numeroTarjeta;
	
	@Column(name="fecha_venciomiento", length=FECHA_VENCIMIENTO_LENGTH)
	private String fechaVenciomiento;
	
}
