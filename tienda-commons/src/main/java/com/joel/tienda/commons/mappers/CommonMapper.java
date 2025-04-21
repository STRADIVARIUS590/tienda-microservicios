package com.joel.tienda.commons.mappers;

import org.springframework.beans.factory.annotation.Autowired;

public class CommonMapper<D, E, R> {

	@Autowired
	protected R repository; 
	
	public D toDto(E entity) {
		return null;
	}
	
	public E toEntity(D dto) {
		return null;
	}
	
}
