package es.curso.babel.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.babel.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	Usuario findByUsername(String username);
}
