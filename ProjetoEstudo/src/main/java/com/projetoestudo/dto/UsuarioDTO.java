package com.projetoestudo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.projetoestudo.entity.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {
	/*
	 * A classe DTO serve para mostrar apenas os dados que você quer,
	 * por exemplo se você não quiser mostrar o CPF é só não colocar aqui
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50) //não pode ser nulo e o tamanho é no maximo 50
	private String nome, cpf, dataNasc, endereco;
	
	public UsuarioEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(this, UsuarioEntity.class);
	}
}
