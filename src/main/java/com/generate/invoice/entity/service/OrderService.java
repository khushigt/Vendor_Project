package com.generate.invoice.entity.service;

import java.util.List;

import com.generate.invoice.entity.Order;

public interface OrderService {

	Order create(Order order);

	Order findById(Long id);

	void softDeleted(Long id);

	List<Object> findAll();
}
