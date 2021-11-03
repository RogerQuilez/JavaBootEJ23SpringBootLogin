package es.curso.babel.model.service;

import java.util.List;

import es.curso.babel.model.entity.Order;

public interface OrderService {

	void save(Order order);
	double calcularTotal(Order order);
	List<Order> findByUsuarioId(int id);
}
