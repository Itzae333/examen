package com.exman.seekop;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.exman.seekop.entity.Usuario;
import com.exman.seekop.facade.UsuariosFacade;
import com.exman.seekop.model.ResponseModel;
import com.exman.seekop.model.UsuarioModel;
import com.exman.seekop.service.RolesService;
import com.exman.seekop.service.UsuariosService;
import com.exman.seekop.utils.SuccessMessage;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UsuariosServiceTest {

    @InjectMocks
    private UsuariosService usuariosService;

    @Mock
    private UsuariosFacade usuariosFacade;

    @Mock
    private RolesService rolesService;

    @SuppressWarnings("deprecation")
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testObtenerTodosLosUsuarios() {
       
        when(usuariosFacade.obtenerTodosLosUsuarios()).thenReturn(Collections.emptyList());

        List<Usuario> usuarios = usuariosService.obtenerTodosLosUsuarios();
        assertEquals(0, usuarios.size());
    }

    @Test
    public void testObtenerUsuarioPorId() {
        Long userId = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(userId);
        when(usuariosFacade.obtenerUsuarioPorId(userId)).thenReturn(usuario);

        ResponseModel<Usuario> response = usuariosService.obtenerUsuarioPorId(userId);

        assertEquals(SuccessMessage.USUARIO_ENCONTRADO, response.getStatusmessage());
        assertEquals(usuario, response.getResultset());
    }

    @Test
    public void testCrearUsuario() {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNombre("Itzae Leonel");

        Usuario usuarioCreado = new Usuario();
        usuarioCreado.setId(1L);
        usuarioCreado.setNombre(usuarioModel.getNombre());

        when(usuariosFacade.crearUsuario(any(Usuario.class))).thenReturn(usuarioCreado);

        ResponseModel<Usuario> response = usuariosService.crearUsuario(usuarioModel);

        assertEquals(SuccessMessage.USUARIO_CREADO, response.getStatusmessage());
        assertEquals(usuarioCreado, response.getResultset());
    }

}
