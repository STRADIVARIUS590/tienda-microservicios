package com.joel.tienda.clientes.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joel.tienda.clientes.repositories.IClientRepository;
import com.joel.tienda.clientes.dto.ClientDTO;
import com.joel.tienda.clientes.mappers.ClientMapper;
import com.joel.tienda.commons.models.entities.Client;
import com.joel.tienda.commons.services.CommonService;

@Service
public class ClientService extends CommonService<ClientDTO, Client, ClientMapper, IClientRepository>
implements IClientService{

    @Override
	public List<ClientDTO> listar() {
		List<ClientDTO> dtos = new ArrayList<>();
		this.repository.findAllByDeletedAtIsNull() .forEach(aerolinea -> {	
			dtos.add(this.mapper.toDto(aerolinea));
		});
		
		return dtos;
	}
	
	

	@Override
	public Optional<ClientDTO> obtenerPorId(Long id) {

		Optional<Client> opt = this.repository.findById(id);
		if(opt.isPresent()) {
			return Optional.of(this.mapper.toDto(opt.get()));
		}

		return Optional.empty();
	}
	

	@Override
	public ClientDTO editar(ClientDTO dto, Long id ) {
		Optional<Client> opt =  this.repository.findById(id);
		if(opt.isPresent()) {
			dto.setId(id);
			return this.mapper.toDto(this.repository.save(this.mapper.toEntity(dto)));
		}
		
		return null;
	}	
	
	@Override
	public ClientDTO insertar(ClientDTO dto) {
		return this.mapper.toDto(this.repository.save(this.mapper.toEntity(dto)));
	}

	@Override
	public ClientDTO eliminar(Long id) {
		Optional<Client> a = this.repository.findById(id);
		
		if(a.isPresent()) {
			Client client = a.get();
			client.setDeletetAt(java.time.LocalDate.now());
		    this.repository.save(client);
		    // Optional<Client> a = this.repository.findById(id);
			// 	this.repository.deleteById(id);
		    return  this.mapper.toDto(a.get());
		}
		return null;
	}

}
