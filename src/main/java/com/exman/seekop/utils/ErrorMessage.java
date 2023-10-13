package com.exman.seekop.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    USUARIO_NO_ENCONTRADO("El usuario no se encuentra en la base de datos."),
    USUARIO_YA_EXISTE("El usuario ya existe en la base de datos."),
    ERROR_DE_VALIDACION("Los datos del usuario no son válidos.");

    private final String message;

}
