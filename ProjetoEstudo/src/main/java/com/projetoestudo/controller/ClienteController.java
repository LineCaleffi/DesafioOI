package com.projetoestudo.controller;

import java.util.List;

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

import com.projetoestudo.dto.ClienteDTO;
import com.projetoestudo.service.ClienteService;


@RestController
@RequestMapping("api/cliente")
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	private ClienteService clienteServ;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll(){
		return ResponseEntity.ok().body(clienteServ.getAll());
	}// metodo que mostra a lista de todos os usuários cadastrados no BD
	
	@GetMapping("{id}")
	public ResponseEntity<ClienteDTO> getOne(@PathVariable int id) {
		return ResponseEntity.ok().body(clienteServ.getOne(id));
	}//por ID
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		clienteServ.delete(id);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO newClient){
		return ResponseEntity.ok().body(clienteServ.save(newClient.toEntity()));
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable int id, @RequestBody ClienteDTO cliente){
		return ResponseEntity.ok().body(clienteServ.update(id, cliente.toEntity()));
	} // alterar 
}
