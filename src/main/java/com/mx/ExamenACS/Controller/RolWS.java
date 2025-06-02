package com.mx.ExamenACS.Controller;

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

import com.mx.ExamenACS.Dominio.Rol;
import com.mx.ExamenACS.Service.RolService;

@RestController
@RequestMapping(path="api/rol")
@CrossOrigin
public class RolWS {
	
	@Autowired
	private RolService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Rol> roles = service.mostrar();
		if(roles.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(roles);
	}
	
	//GUARDAR
		@PostMapping("/guardar")
		public ResponseEntity<?> guardar(@RequestBody Rol r){
			Rol nuevo = service.buscar(r);
			if(nuevo == null) {
				service.guardar(r);
				return ResponseEntity.status(HttpStatus.CREATED).body("{\"mensaje\":\"Se ha creado el Rol " + r.getPrivilegio() + " correctamente\"}");
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El Rol " + r.getPrivilegio() + " ya existe. intenta con un valor nuevo\"}"); 
		}
		
		
		//EDITAR
		@PutMapping("/editar")
		public ResponseEntity<?> editar(@RequestBody Rol r){
			Rol existe = service.buscar(r);
			if(existe == null) {
				return ResponseEntity.notFound().build();
			} else {
				service.editar(r);
				return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"Se ha actualizado el Rol " + r.getId()+"\"}");
			}
		}
		
		
		//ELIMINAR
		@DeleteMapping("/eliminar")
		public ResponseEntity<?> eliminar(@RequestBody Rol r){
			service.eliminar(r);
			return ResponseEntity.noContent().build();
		}
		
		
		//BUSCAR
		@PostMapping("buscar")
		public ResponseEntity<?> buscar(@RequestBody Rol r){
			Rol encontrado = service.buscar(r);
			if(encontrado == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"No existe el rol " + r.getId()+"\"}");
			}
			return ResponseEntity.ok(encontrado);
		}
		

}
