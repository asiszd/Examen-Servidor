package com.mx.ExamenACS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ExamenACS.Dominio.Usuario;
import java.util.List;


public interface IUsuarioDao  extends JpaRepository<Usuario, Integer>{

	public Usuario findByNombreAndAppAndApmAllIgnoreCase(String nombre, String app, String apm);
	
	public Usuario findByCorreo(String correo);
	
}
