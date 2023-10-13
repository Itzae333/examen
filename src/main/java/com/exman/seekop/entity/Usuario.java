package com.exman.seekop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


import com.exman.seekop.model.UsuarioModel;


import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contraseña;

    @ManyToMany
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    
    public Usuario(UsuarioModel usuarioModel,Set<Rol> roles) {
        this.nombre = usuarioModel.getNombre();
        this.correoElectronico = usuarioModel.getCorreoElectronico();
        this.contraseña = usuarioModel.getContraseña();
        this.roles = roles;
    }

   
}
