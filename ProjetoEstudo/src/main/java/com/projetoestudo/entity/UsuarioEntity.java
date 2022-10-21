package com.projetoestudo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.projetoestudo.dto.UsuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario")
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50) //não pode ser nula e o tamanho é no maximo 50
	private String nome, cpf, dataNasc, endereco;
	
	public UsuarioDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		
		UsuarioDTO dto = mapper.map(this, UsuarioDTO.class);
		
		return dto;
	}
}
