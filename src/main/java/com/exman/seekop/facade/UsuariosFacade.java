package com.exman.seekop.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exman.seekop.entity.Usuario;
import com.exman.seekop.repository.UsuariosRepository;

import jakarta.transaction.Transactional;

@Component
public class UsuariosFacade {

	@Autowired
	UsuariosRepository usuariosRepository;

	@Transactional
	public Usuario crearUsuario(Usuario usuario) {
		return usuariosRepository.save(usuario);
	}

	@Transactional
	public Usuario actualizarUsuario(Usuario usuario) {
		return usuariosRepository.save(usuario);
	}

	@Transactional
	public void eliminarUsuario(Long id) {
		usuariosRepository.deleteById(id);
	}

	public List<Usuario> obtenerTodosLosUsuarios() {
		return usuariosRepository.findAll();
	}

	public Usuario obtenerUsuarioPorId(Long id) {
		return usuariosRepository.findById(id).orElse(null);
	}

}
