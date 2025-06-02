package com.mx.ExamenACS.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mx.ExamenACS.Controller.UsuarioWS;
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
		return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
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
	
	public boolean buscarNombreCompleto(Usuario u) {
		Usuario aux = dao.findByNombreAndAppAndApmAllIgnoreCase(u.getNombre(), u.getApp(), u.getApm());
		if (aux == null) {
			return false;
		}
		return true;
	}
	
	public String generaCorreo(Usuario u) {
		String correo = u.getNombre().toUpperCase() + "." + u.getApp().toUpperCase() + "@ENUCOM.COM.MX".replaceAll("\\s+","");
		Usuario aux = dao.findByCorreo(correo);
		System.out.println(aux);
		if (aux == null) {
			return u.getNombre().toUpperCase() + "." + u.getApp().toUpperCase() + "@ENUCOM.COM.MX".replaceAll("\\s+","");
		} else {
			return u.getNombre().toUpperCase() + "." + u.getApp().toUpperCase() + "." + u.getApm() + "@ENUCOM.COM.MX".replaceAll("\\s+","");
		}
	}
	
	public boolean validarLetras(String texto) {
	    return texto.matches("^[a-zA-Z ]+$");
	}
	
	public int calculaEdad(Usuario u) {
		LocalDate hoy = LocalDate.now();
		LocalDate nacimiento = LocalDate.ofInstant(u.getFechaNacimiento().toInstant(), ZoneId.systemDefault());
		Period edad = Period.between(nacimiento, hoy);
		return edad.getYears();
	}
}
