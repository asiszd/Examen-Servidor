package com.mx.ExamenACS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ExamenACS.Dominio.Usuario;

public interface IUsuarioDao  extends JpaRepository<Usuario, Integer>{

}
