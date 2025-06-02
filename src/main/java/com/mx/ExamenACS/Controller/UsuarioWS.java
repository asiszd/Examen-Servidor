package com.mx.ExamenACS.Controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ExamenACS.Dominio.Usuario;
import com.mx.ExamenACS.Service.UsuarioService;

@RestController
@RequestMapping(path="api/usuario")
@CrossOrigin
public class UsuarioWS {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Usuario> usuarios = service.mostrar();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	//GUARDAR
		@PostMapping("/guardar")
		public ResponseEntity<?> guardar(@RequestBody Usuario u){
			Usuario nuevo = service.buscar(u);
			
			if(nuevo == null) {
				LocalDate hoy = LocalDate.now();
				LocalDate nacimiento = LocalDate.ofInstant(u.getFechaNacimiento().toInstant(), ZoneId.systemDefault());
				Period edad = Period.between(nacimiento, hoy);
				if(edad.getYears() >= 18) {
					if(validarLetras(u.getNombre()) && validarLetras(u.getApp()) && validarLetras(u.getApm())) {
						service.guardar(u);
						return ResponseEntity.status(HttpStatus.CREATED).body("{\"mensaje\":\"Se ha creado el Usuario " + u.getId() + " correctamente\"}");
					} else {
						return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El NOMBRE y los APELLIDOS deben contener solo letras sin acentos\"}"); 
					}
				} else {
					return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El usuario debe ser mayor a 18 años\"}"); 
				}
				
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El ID " + u.getId() + " ya existe. intenta con un valor nuevo\"}"); 
		}
		
		
		//EDITAR
		@PutMapping("/editar")
		public ResponseEntity<?> editar(@RequestBody Usuario u){
			Usuario existe = service.buscar(u);
			if(existe == null) {
				return ResponseEntity.notFound().build();
			} else {
				LocalDate hoy = LocalDate.now();
				LocalDate nacimiento = LocalDate.ofInstant(u.getFechaNacimiento().toInstant(), ZoneId.systemDefault());
				Period edad = Period.between(nacimiento, hoy);
				if(edad.getYears() >= 18) {
					if(validarLetras(u.getNombre()) && validarLetras(u.getApp()) && validarLetras(u.getApm())) {
						service.guardar(u);
						return ResponseEntity.status(HttpStatus.CREATED).body("{\"mensaje\":\"Se ha creado el Usuario " + u.getId() + " correctamente\"}");
					} else {
						return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El NOMBRE y los APELLIDOS deben contener solo letras sin acentos\"}"); 
					}
				} else {
					return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El usuario debe ser mayor a 18 años\"}"); 
				}
			}
		}
		
		
		//ELIMINAR
		@DeleteMapping("/eliminar")
		public ResponseEntity<?> eliminar(@RequestBody Usuario u){
			service.eliminar(u);
			return ResponseEntity.noContent().build();
		}
		
		
		//BUSCAR
		@PostMapping("buscar")
		public ResponseEntity<?> buscar(@RequestBody Usuario u){
			Usuario encontrado = service.buscar(u);
			if(encontrado == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"No existe el usuario " + u.getId()+"\"}");
			}
			return ResponseEntity.ok(encontrado);
		}
		
		public static boolean validarLetras(String texto) {
		    return texto.matches("^[a-zA-Z ]+$");
		}
		

}
