package com.joel.tienda.clientes.mappers;

import org.springframework.stereotype.Component;

import com.joel.tienda.clientes.dto.ClientDTO;
import com.joel.tienda.clientes.repositories.IClientRepository;
import com.joel.tienda.commons.mappers.CommonMapper;
import com.joel.tienda.commons.models.entities.Client;
@Component
public class ClientMapper extends CommonMapper<ClientDTO, Client, IClientRepository> {

    @Override
    public ClientDTO toDto(Client entity) {
        if (entity == null) {
            return null;
        }
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        System.err.println("ClientMapper.toDto() " + dto);
        return dto;
    }

    @Override
    public Client toEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        Client entity = new Client();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        return entity;
    }
    
}
