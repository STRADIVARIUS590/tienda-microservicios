package com.joel.tienda.commons.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joel.tienda.commons.mappers.CommonMapper;

public class CommonService<D, E, M extends 
CommonMapper<D, E, R>, R extends JpaRepository<E, Long>>implements ICommonService<D> {

	@Autowired
	protected R repository;
	
	@Autowired
	protected M mapper;
	@Override
	
	public List<D> listar() {
		return null;
	}

	@Override
	public Optional<D> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public D editar(D dto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public D insertar(D dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public D eliminar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}