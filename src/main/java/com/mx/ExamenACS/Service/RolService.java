package com.mx.ExamenACS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
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
	
	public boolean verificaPrivilegio(Rol r) {
		Rol aux = dao.findByPrivilegioIgnoreCase(r.getPrivilegio());
		if (aux == null) {
			return false;
		}
		return true;
	}

	public boolean verificaUsuarios(Rol r){
		List<Rol> listAux = dao.verificarUsuarios(r.getId());
		if (listAux.isEmpty()) {
			return false;
		}
		return true;
	}
}
