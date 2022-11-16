package com.wicsha.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="cliente")
public class Cliente {
	public static final int NOMBRE_LENGTH = 25;
	public static final int APELLIDO_LENGTH = 50;
	public static final int CORREO_LENGTH = 40;
	public static final int CELULAR_LENGTH = 10;
	public static final int DIRECCION_LENGTH = 150;
	public static final int CP_LENGTH = 5;
	public static final int USUARIO_LENGTH = 25;
	public static final int CONTRASENA_LENGTH = 50;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long clienteId;
	@Column(name="nombre", length=NOMBRE_LENGTH)
	private String nombre;
	@Column(name="apellido", length=APELLIDO_LENGTH)
	private String apellido;
	@NotNull 
	@Column(name="correo", updatable=false, length=CORREO_LENGTH)	
	private String correo;
	@Column(name="celular", updatable=false, length=CELULAR_LENGTH)	
	private String celular;
	@Column(name="direccion", updatable=false, length=DIRECCION_LENGTH)	
	private String direccion;
	@Column(name="CP", updatable=false, length=CP_LENGTH)	
	private String CP;
	@Column(name="usuario", updatable=false, length=USUARIO_LENGTH)	
	private String usuario;
	@NotNull 
	@Column(name="contrasena", updatable=false, length=CONTRASENA_LENGTH)	
	private String contrasena;
}