package com.mx.ExamenACS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.ExamenACS.Dominio.Rol;

public interface IRolDao  extends JpaRepository<Rol, Integer>{
	
	public Rol findByPrivilegioIgnoreCase(String p);
	
	
	@Query(value = "SELECT R.* FROM ROL R INNER JOIN USUARIO U ON R.ID_ROL = U.ROL_ID WHERE R.ID_ROL = :id", nativeQuery = true)
	public List<Rol> verificarUsuarios(int id); 

}
