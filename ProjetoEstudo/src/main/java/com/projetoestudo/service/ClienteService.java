package com.projetoestudo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoestudo.dto.ClienteDTO;
import com.projetoestudo.entity.ClienteEntity;
import com.projetoestudo.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRep;
	
	//Metodo para buscar todos os cliente do banco de dados
	public List<ClienteDTO> getAll(){
		List<ClienteEntity> lista = clienteRep.findAll();
		List<ClienteDTO> dto = new ArrayList<>();
		
		// ele continua acrescentando na lista quando o usuario for adicionado
		for(ClienteEntity cliente : lista) {
			dto.add(cliente.toDto());
		}
		
		return dto;
	}
	
	//pega apenas por ID
	public ClienteDTO getOne(int id) {
		return clienteRep.findById(id).orElse(new ClienteEntity()).toDto();
	}
	
	//metodo salvar
	public ClienteDTO save(ClienteEntity cliente) {
		return clienteRep.save(cliente).toDto();
	}
	
	//metodo delete
	public void delete(int id) {
		clienteRep.deleteById(id);
	}
	
	//metodo alterar dados do BD
	public ClienteDTO update(int id, ClienteEntity newClient) {
		//
		Optional<ClienteEntity> cliente = clienteRep.findById(id);
		
		//se o ID do cliente existir, faz a alteração
		//senão mostra um cliente em branco
		if(cliente.isPresent()) {
			ClienteEntity client = cliente.get();
			
			client.setNome(newClient.getNome());
			client.setCnpj(newClient.getCnpj());
			client.setEndereco(newClient.getEndereco());
			
			return clienteRep.save(client).toDto();
		}else {
			return new ClienteEntity().toDto();
		}
	}
}
