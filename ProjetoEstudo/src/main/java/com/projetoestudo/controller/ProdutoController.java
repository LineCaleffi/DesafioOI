package com.projetoestudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoestudo.dto.ProdutoDTO;
import com.projetoestudo.service.ProdutoService;

@RestController
@RequestMapping("api/produto")
@CrossOrigin("*")

public class ProdutoController {
	@Autowired
	private ProdutoService prodServ;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> getAll(){
		return ResponseEntity.ok().body(prodServ.getAll());
	} // funcionando
	
	@GetMapping("{id}")
	public ResponseEntity<ProdutoDTO> getOne(@PathVariable int id){
		return ResponseEntity.ok().body(prodServ.getOne(id));
	} // funcionando
	
	@DeleteMapping
	public void delete(@PathVariable int id){
		prodServ.delete(id);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produto){
		return ResponseEntity.ok().body(prodServ.save(produto.toEntity()));
	}
}
