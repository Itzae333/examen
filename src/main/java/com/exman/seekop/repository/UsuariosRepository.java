package com.exman.seekop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exman.seekop.entity.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long>{

}
