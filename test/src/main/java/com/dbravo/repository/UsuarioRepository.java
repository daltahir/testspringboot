package com.dbravo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbravo.Entity.Usuario;
@Repository
public interface UsuarioRepository extends  JpaRepository<Usuario,Long> {
	Optional<Usuario> findByEmail(String email);
}
