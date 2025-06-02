package com.mx.ExamenACS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ExamenACS.Dao.IRolDao;
import com.mx.ExamenACS.Dominio.Rol;

@Service
public class RolService implements IRolService{
	
	@Autowired
	private IRolDao dao;

	@Override
	public void guardar(Rol r) {
		dao.save(r);
	}

	@Override
	public List<Rol> mostrar() {
		return dao.findAll();
	}

	@Override
	public void editar(Rol r) {
		dao.save(r);
		
	}

	@Override
	public void eliminar(Rol r) {
		dao.delete(r);
		
	}

	@Override
	public Rol buscar(Rol r) {
		return dao.findById(r.getId()).orElse(null);
	}

}
