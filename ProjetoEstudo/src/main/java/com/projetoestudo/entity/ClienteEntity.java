package com.projetoestudo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.projetoestudo.dto.ClienteDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cliente")
public class ClienteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome, cnpj, endereco;
	
	public ClienteDTO toDto() {
		ModelMapper mapper = new ModelMapper();
		
		ClienteDTO dto = mapper.map(this, ClienteDTO.class);
		
		return dto;
	}
}
