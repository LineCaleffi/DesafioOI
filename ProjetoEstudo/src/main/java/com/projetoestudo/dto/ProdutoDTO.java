package com.projetoestudo.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import com.projetoestudo.entity.ClienteEntity;
import com.projetoestudo.entity.ProdutoEntity;
import com.projetoestudo.entity.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nomeProduto;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private ClienteEntity cliente;
	
	public ProdutoEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(this, ProdutoEntity.class);
	}
}
