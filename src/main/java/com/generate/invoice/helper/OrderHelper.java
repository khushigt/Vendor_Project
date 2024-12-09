package com.generate.invoice.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.generate.invoice.entity.Order;
import com.generate.invoice.entity.constants.OrderStatus;
import com.generate.invoice.entity.request.OrderRequest;
import com.generate.invoice.entity.service.CustomerService;
import com.generate.invoice.entity.service.OrderService;
import com.generate.invoice.entity.service.ProductService;
import com.generate.invoice.response.OrderListResponse;
import com.generate.invoice.response.OrderResponse;
import com.generate.invoice.util.CommonUtil;

@Component
public class OrderHelper {

	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;

	public Order getEntity(OrderRequest orderRequest) {
		Order order;
		if (CommonUtil.isValid(orderRequest.getId())) {
			order = this.orderService.findById(orderRequest.getId());
		} else {
			order = new Order();
		}
		order.setOrderStatus(OrderStatus.ORDERED_SUCCESSFUL);
		order.setOrderdPlacedOnDate(orderRequest.getOrderdPlacedOnDate());
		order.setOrderProductQuantity(orderRequest.getOrderProductQuantity());
		order.setProductPrice(orderRequest.getProductPrice());
		BigDecimal productPrice = orderRequest.getProductPrice();
		BigDecimal orderProductQuantity = orderRequest.getOrderProductQuantity();
		BigDecimal totalAmount = productPrice.multiply(orderProductQuantity);
		order.setTotalAmount(totalAmount);
		order.setProduct(productService.findById(orderRequest.getProductId()));
		order.setCustomer(customerService.findById(orderRequest.getCustomerId()));
		return order;

	}

	public OrderResponse getOrder(Order order) {
		return OrderResponse.builder().id(order.getId()).orderdPlacedOnDate(order.getOrderdPlacedOnDate())
				.orderProductQuantity(order.getOrderProductQuantity()).productPrice(order.getProductPrice())
				.productId(order.getProduct().getId()).customerId(order.getCustomer().getId()).build();

	}

	public List<OrderListResponse> getOrderListResponse(List<Order> orders) {
		List<OrderListResponse> orderListResponses = new ArrayList<>();
		orders.forEach(order -> {
			orderListResponses.add(OrderListResponse.builder().id(order.getId()).customerId(order.getCustomer().getId())
					.productId(order.getProduct().getId()).orderdPlacedOnDate(order.getOrderdPlacedOnDate())
					.orderProductQuantity(order.getOrderProductQuantity()).productPrice(order.getProductPrice())
					.totalAmount(order.getTotalAmount()).build());
		});
		return orderListResponses;
	}
}
