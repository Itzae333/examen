package com.exman.seekop.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exman.seekop.entity.Rol;
import com.exman.seekop.repository.RolesRepository;

import jakarta.transaction.Transactional;


@Component
public class RolesFacade {

	@Autowired
	RolesRepository rolesRepository;

	public Rol findByNombre(String nombre) {
		return rolesRepository.findByNombre(nombre);
	}
	
	@Transactional
	public Rol crearRol(Rol rol) {
		return rolesRepository.save(rol);
	}

}
