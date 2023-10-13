package com.exman.seekop.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exman.seekop.entity.Rol;
import com.exman.seekop.facade.RolesFacade;
import com.exman.seekop.model.UsuarioModel;

@Service
public class RolesService {

	@Autowired
	RolesFacade rolesFacade;

	public Rol findByNombre(String nombre) {
		return rolesFacade.findByNombre(nombre);
	}

	public Set<Rol> ajusteRoles(UsuarioModel usuarioModel) {
        Set<Rol> roles = new HashSet<>();
        for (String rolNombre : usuarioModel.getRoles()) {
            Rol rol = rolesFacade.findByNombre(rolNombre.trim());
            if (rol != null) {
                roles.add(rol);
            } else {
                Rol nuevoRol = new Rol();
                nuevoRol.setNombre(rolNombre.trim());
                rolesFacade.crearRol(nuevoRol);
                roles.add(nuevoRol);
            }
        }
        return roles;
    }

}
