package com.exman.seekop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exman.seekop.entity.Rol;

@Repository
public interface RolesRepository extends JpaRepository<Rol, Long>{
	
	Rol findByNombre(String nombre);

}
