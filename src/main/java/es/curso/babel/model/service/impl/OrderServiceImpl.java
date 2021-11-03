package es.curso.babel.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.babel.model.entity.Order;
import es.curso.babel.model.repository.OrderRepository;
import es.curso.babel.model.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	@Transactional
	public void save(Order order) {
		orderRepository.save(order);
	}

	@Override
	public double calcularTotal(Order order) {
		return order.calcularTotal();
	}

	@Override
	public List<Order> findByUsuarioId(int id) {
		return orderRepository.findByUsuarioId(id);
	}	
	
}
