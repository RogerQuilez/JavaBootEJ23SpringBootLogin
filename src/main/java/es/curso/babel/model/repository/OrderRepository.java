package es.curso.babel.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.babel.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

	List<Order> findByUsuarioId(int id);
}
