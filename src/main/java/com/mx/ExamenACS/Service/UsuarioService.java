package com.mx.ExamenACS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ExamenACS.Dao.IUsuarioDao;
import com.mx.ExamenACS.Dominio.Usuario;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioDao dao;

	@Override
	public void guardar(Usuario u) {
		dao.save(u);
		
	}

	@Override
	public List<Usuario> mostrar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void editar(Usuario u) {
		dao.save(u);
		
	}

	@Override
	public void eliminar(Usuario u) {
		dao.delete(u);
		
	}

	@Override
	public Usuario buscar(Usuario u) {
		return dao.findById(u.getId()).orElse(null);
	}
}
