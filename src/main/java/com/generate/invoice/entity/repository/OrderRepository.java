package com.generate.invoice.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generate.invoice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	//Order findByCustomerIdAndProductId(Long customerId,Long productId);
}
