package es.curso.babel.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.babel.model.entity.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
}
