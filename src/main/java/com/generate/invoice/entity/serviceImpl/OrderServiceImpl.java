package com.generate.invoice.entity.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generate.invoice.entity.Order;
import com.generate.invoice.entity.repository.OrderRepository;
import com.generate.invoice.entity.service.OrderService;
import com.generate.invoice.helper.OrderHelper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	@Autowired
	OrderHelper orderHelper;

	@Override
	public Order findById(Long id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public void softDeleted(Long id) {
		Order order = this.orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		order.setDeleted(true);
		orderRepository.save(order);
	}

	@Override
	public List<Object> findAll() {
		List<Order> findAll = orderRepository.findAll();
		return findAll.stream().map(orderHelper::getOrder).collect(Collectors.toList());
	}

	@Override
	public Order create(Order order) {
		return orderRepository.save(order);
	}

}
