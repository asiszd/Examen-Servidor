package com.mx.ExamenACS.Dominio;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ROL")
public class Rol {
	
	@Id
	@Column(name="ID_ROL")
	private int id;
	
	@Column(name="PRIVILEGIO")
	private String privilegio;
	
	@OneToMany(mappedBy = "rolId",  cascade = CascadeType.ALL)
	private List<Usuario> usuarios;
	
	public Rol() {
		
	}

	public Rol(int id, String privilegio) {
		super();
		this.id = id;
		this.privilegio = privilegio;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", privilegio=" + privilegio + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}
	
	
	

}
