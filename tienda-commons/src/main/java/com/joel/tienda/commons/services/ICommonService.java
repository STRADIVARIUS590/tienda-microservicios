package com.joel.tienda.commons.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface ICommonService<D> {

	List<D> listar();

	Optional<D> obtenerPorId(Long id);
	
	D editar(D dto, Long id);
	
	D insertar(D dto);
	
	D eliminar(Long id);
}
