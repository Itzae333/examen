package com.exman.seekop.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    USUARIO_ENCONTRADO("Usuario encontrado con éxito."),
    USUARIO_CREADO("Usuario creado con éxito."),
    USUARIO_ACTUALIZADO("Usuario actualizado con éxito."),
    USUARIO_ELIMINADO("Usuario eliminado con éxito.");

    private final String message;

}
