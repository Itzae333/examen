package com.exman.seekop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.exman.seekop.entity.Usuario;
import com.exman.seekop.facade.UsuariosFacade;
import com.exman.seekop.model.ResponseModel;
import com.exman.seekop.model.UsuarioModel;
import com.exman.seekop.utils.ErrorMessage;
import com.exman.seekop.utils.SuccessMessage;
import com.exman.seekop.utils.Utils;

@Service
@Validated
public class UsuariosService {

    @Autowired
    UsuariosFacade usuariosFacade;

    @Autowired
    RolesService rolesService;

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuariosFacade.obtenerTodosLosUsuarios();
    }

    public ResponseModel<Usuario> obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuariosFacade.obtenerUsuarioPorId(id);
        if (usuario == null) {
            return Utils.arrmarModelResponseError(ErrorMessage.USUARIO_NO_ENCONTRADO);
        }
        return Utils.arrmarModelResponseExitoso(SuccessMessage.USUARIO_ENCONTRADO, usuario);
    }

    public ResponseModel<Usuario> crearUsuario(UsuarioModel usuarioModel) {
        Usuario usuario = new Usuario(usuarioModel, rolesService.ajusteRoles(usuarioModel));
        try {
            Usuario usuarioCreado = usuariosFacade.crearUsuario(usuario);
            return Utils.arrmarModelResponseExitoso(SuccessMessage.USUARIO_CREADO, usuarioCreado);
        } catch (DataIntegrityViolationException e) {
        	return Utils.arrmarModelResponseError(ErrorMessage.USUARIO_YA_EXISTE);
        }
    }

    public ResponseModel<Usuario> actualizarUsuario(Long id, UsuarioModel usuarioModel) {
        Usuario usuarioExistente = usuariosFacade.obtenerUsuarioPorId(id);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuarioModel.getNombre());
            usuarioExistente.setCorreoElectronico(usuarioModel.getCorreoElectronico());
            usuarioExistente.setContraseña(usuarioModel.getContraseña());
            usuarioExistente.setRoles(rolesService.ajusteRoles(usuarioModel));

            try {
                Usuario usuarioActualizado = usuariosFacade.actualizarUsuario(usuarioExistente);
                return Utils.arrmarModelResponseExitoso(SuccessMessage.USUARIO_ACTUALIZADO, usuarioActualizado);
            } catch (DataIntegrityViolationException e) {
            	return Utils.arrmarModelResponseError(ErrorMessage.USUARIO_YA_EXISTE);
            }
        } else {
        	return Utils.arrmarModelResponseError(ErrorMessage.USUARIO_NO_ENCONTRADO);
        }
    }

    public ResponseModel<Void> eliminarUsuario(Long id) {
        try {
            usuariosFacade.eliminarUsuario(id);
            return Utils.arrmarModelResponseExitoso(SuccessMessage.USUARIO_ELIMINADO, null);
        } catch (EmptyResultDataAccessException e) {
        	return Utils.arrmarModelResponseError(ErrorMessage.USUARIO_NO_ENCONTRADO);
        }
    }
}