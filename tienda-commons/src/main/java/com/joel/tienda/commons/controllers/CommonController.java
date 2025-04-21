package com.joel.tienda.commons.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.joel.tienda.commons.services.ICommonService;

import jakarta.validation.Valid;

public class CommonController<D, S extends ICommonService<D>> {
	
	@Autowired
	protected S service;

	public CommonController(S service) {
		this.service = service;
	}
	
	@GetMapping
	@Transactional(readOnly = true)
	public ResponseEntity<List<D>> getAll(){
		return ResponseEntity.ok(this.service.listar());
	}
	
	@GetMapping("/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<D> getById(@PathVariable Long id){
		Optional<D> dto = this.service.obtenerPorId(id);		
		
		if(dto.isPresent()) {			
			return ResponseEntity.ok(dto.get());
		}
		
		return ResponseEntity.notFound().build();
	
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> post(@Valid @RequestBody D dto, BindingResult result){
		if(result.hasErrors()) {

			return this.validate(result);
		}
		return ResponseEntity.ok(this.service.insertar(dto));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> put(@Valid @RequestBody D dto, @PathVariable Long id ,BindingResult result){
		if(result.hasErrors()) {

			return this.validate(result);
		}
		
		D entity = this.service.editar(dto, id);
		
		if(entity != null) {
			return ResponseEntity.ok(entity);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<D> delete(@PathVariable Long id){
		D dto = this.service.eliminar(id);
		if(dto != null) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();
	}
	
	protected ResponseEntity<?> validate(BindingResult result){
		
		Map<String, Object> errores = new HashMap<>();
		
		result.getFieldErrors().forEach(error -> {
			errores.put(error.getField(), "campo " +  error.getField() + " : " + error.getDefaultMessage());
		});
	System.out.println(errores);	
		return ResponseEntity.badRequest().body(errores);
	}
	
	
}