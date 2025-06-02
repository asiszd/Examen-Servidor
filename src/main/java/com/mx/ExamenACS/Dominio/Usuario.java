package com.mx.ExamenACS.Dominio;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {

	@Id
    @Column(name = "ID_USUARIO")
    private int id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APP")
    private String app;

    @Column(name = "APM")
    private String apm;

    @Column(name = "SEXO")
    private String sexo;

    @Column(name = "CORREO", unique = true, nullable = false)
    private String correo;

    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROL_ID")
    private Rol rolId;

	public Usuario() {
	}

	public Usuario(int id, String nombre, String app, String apm, String sexo, String correo, Date fechaNacimiento,
			Date fechaCreacion, Rol rolId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.sexo = sexo;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCreacion = fechaCreacion;
		this.rolId = rolId;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", sexo=" + sexo
				+ ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", fechaCreacion=" + fechaCreacion
				+ ", rolId=" + rolId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Rol getRolId() {
		return rolId;
	}

	public void setRolId(Rol rolId) {
		this.rolId = rolId;
	}
    
    
	
}
