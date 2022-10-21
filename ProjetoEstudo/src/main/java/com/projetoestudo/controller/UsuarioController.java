package com.projetoestudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoestudo.dto.UsuarioDTO;
import com.projetoestudo.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioServ;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getAll() {
		return ResponseEntity.ok().body(usuarioServ.getAll());
	} // metodo que mostra a lista de todos os usuários cadastrados no BD

	@GetMapping("{id}")
	public ResponseEntity<UsuarioDTO> getOne(@PathVariable int id){
		return ResponseEntity.ok().body(usuarioServ.getOne(id));
	} // metodo que pega por ID
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuario){
		return ResponseEntity.ok().body(usuarioServ.save(usuario.toEntity()));
	}//salva um novo usuario
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable int id, @RequestBody UsuarioDTO usuario){
		return ResponseEntity.ok().body(usuarioServ.update(id,usuario.toEntity()));
	} // metodo para atualizar o dado de um ID especifico
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id){
		usuarioServ.delete(id);
	}
}
