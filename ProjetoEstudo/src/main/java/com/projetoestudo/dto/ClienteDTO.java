package com.projetoestudo.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.projetoestudo.entity.ClienteEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome, cnpj, endereco;
	
	public ClienteEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(this, ClienteEntity.class);
	}
}
