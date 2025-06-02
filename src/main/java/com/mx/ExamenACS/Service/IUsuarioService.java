package com.mx.ExamenACS.Service;

import java.util.List;

import com.mx.ExamenACS.Dominio.Usuario;

public interface IUsuarioService {
	
public void guardar(Usuario u);
	
	public List<Usuario> mostrar();
	
	public void editar(Usuario u);
	
	public void eliminar(Usuario u);
	
	public Usuario buscar(Usuario u);

}
