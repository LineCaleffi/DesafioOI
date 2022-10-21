package com.projetoestudo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoestudo.dto.ProdutoDTO;
import com.projetoestudo.entity.ProdutoEntity;
import com.projetoestudo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository prodRep;
	
	public List<ProdutoDTO> getAll(){
		List<ProdutoEntity> produto = prodRep.findAll();
		List<ProdutoDTO> dto = new ArrayList<>();
		
		for(ProdutoEntity prod : produto) {
			dto.add(prod.toDTO());
		}
		
		return dto;
	}
	
	public ProdutoDTO getOne(int id) {
		return prodRep.findById(id).orElse(new ProdutoEntity()).toDTO(); //busca por id
	}
	
	public void delete(int id) {
		prodRep.deleteById(id);
	}
	
	public ProdutoDTO save(ProdutoEntity produto) {
		return prodRep.save(produto).toDTO();
	} //salvar
	
	
}
