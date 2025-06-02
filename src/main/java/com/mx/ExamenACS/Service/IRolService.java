package com.mx.ExamenACS.Service;

import java.util.List;

import com.mx.ExamenACS.Dominio.Rol;

public interface IRolService {

public void guardar(Rol r);
	
	public List<Rol> mostrar();
	
	public void editar(Rol r);
	
	public void eliminar(Rol r);
	
	public Rol buscar(Rol r);
	
}
