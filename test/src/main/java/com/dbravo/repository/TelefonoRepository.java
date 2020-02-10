package com.dbravo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbravo.Entity.UsuarioTelefono;

@Repository
public interface TelefonoRepository extends JpaRepository<UsuarioTelefono, Long>{
	Page<UsuarioTelefono> findByUsuarioId(Long UsuarioId, Pageable pageable);
	 Optional<UsuarioTelefono> findByIdAndUsuarioId(Long id, Long UsuarioId);

}
