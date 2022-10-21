package com.projetoestudo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.projetoestudo.dto.ProdutoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="produto")
public class ProdutoEntity {
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
	
	public ProdutoDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		
		ProdutoDTO dto = mapper.map(this, ProdutoDTO.class);
		 
		return dto;
	}
}
