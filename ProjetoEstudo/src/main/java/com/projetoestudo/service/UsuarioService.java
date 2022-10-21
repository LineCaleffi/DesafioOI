package com.projetoestudo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoestudo.dto.UsuarioDTO;
import com.projetoestudo.entity.UsuarioEntity;
import com.projetoestudo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRep;
	
	public List<UsuarioDTO> getAll(){
		List<UsuarioEntity> lista = usuarioRep.findAll(); //retorna os dados do BD
		List<UsuarioDTO> listaDTO = new ArrayList<>();
		
		// ele continua acrescentando na lista quando o usuario for adicionado
		for(UsuarioEntity usuario : lista) {
			listaDTO.add(usuario.toDTO());
		}
		
		return listaDTO;
	}
	
	public UsuarioDTO getOne(int id) {
		// retorna o usuario referente o ID informado, caso não, retorna um novo usuario em branco 
		return usuarioRep.findById(id).orElse(new UsuarioEntity()).toDTO();
	}
	
	public UsuarioDTO save(UsuarioEntity user) {
		return usuarioRep.save(user).toDTO();
	}
	
	public UsuarioDTO update(int id, UsuarioEntity novoUser)  {
		//pesquisa pelo id primeiro
		Optional<UsuarioEntity> usuario = usuarioRep.findById(id); 
		
		//se o usuario existir ele atualiza os dados, senão ele retonar um novo usuario
		if(usuario.isPresent()) {
			UsuarioEntity user = usuario.get();
			
			user.setCpf(novoUser.getCpf());
			user.setDataNasc(novoUser.getDataNasc());
			user.setEndereco(novoUser.getEndereco());
			user.setNome(novoUser.getNome());
			
			return usuarioRep.save(user).toDTO();
		}else {
			return new UsuarioEntity().toDTO();
		}
	}
	
	public void delete(int id) {
		usuarioRep.deleteById(id);
	}
}
