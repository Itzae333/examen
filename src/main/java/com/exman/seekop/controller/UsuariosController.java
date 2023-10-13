package com.exman.seekop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exman.seekop.entity.Usuario;
import com.exman.seekop.model.ResponseModel;
import com.exman.seekop.model.UsuarioModel;
import com.exman.seekop.service.UsuariosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	UsuariosService usuariosService;

	@Operation(summary = "Obtener todos los usuarios", description = "Obtiene una lista de todos los usuarios registrados.")
	@ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida con éxito")
	@GetMapping
	public List<Usuario> obtenerTodosLosUsuarios() {
		return usuariosService.obtenerTodosLosUsuarios();
		
	}

	@Operation(summary = "Obtener un usuario por ID", description = "Obtiene un usuario por su ID.")
	@ApiResponse(responseCode = "200", description = "Usuario encontrado")
	@ApiResponse(responseCode = "404", description = "Usuario no encontrado")
	@GetMapping("/{id}")
	public ResponseModel<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
		return usuariosService.obtenerUsuarioPorId(id);
	}

	@Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario con los datos proporcionados.")
	@ApiResponse(responseCode = "201", description = "Usuario creado con éxito")
	@PostMapping
	public ResponseModel<Usuario> crearUsuario(@RequestBody UsuarioModel usuarioModel) {
		return usuariosService.crearUsuario(usuarioModel);
	}

	@Operation(summary = "Actualizar un usuario por ID", description = "Actualiza un usuario existente por su ID.")
	@ApiResponse(responseCode = "200", description = "Usuario actualizado")
	@ApiResponse(responseCode = "404", description = "Usuario no encontrado")
	@PutMapping("/{id}")
	public ResponseModel<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
		return usuariosService.actualizarUsuario(id, usuarioModel);
	}

	@Operation(summary = "Eliminar un usuario por ID", description = "Elimina un usuario por su ID.")
	@ApiResponse(responseCode = "204", description = "Usuario eliminado con éxito")
	@ApiResponse(responseCode = "404", description = "Usuario no encontrado")
	@DeleteMapping("/{id}")
	public ResponseModel<Void> eliminarUsuario(@PathVariable Long id) {
		return usuariosService.eliminarUsuario(id);
	}
}