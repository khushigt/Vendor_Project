package com.generate.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generate.invoice.constant.UrlConstant;
import com.generate.invoice.entity.Order;
import com.generate.invoice.entity.request.OrderRequest;
import com.generate.invoice.entity.service.OrderService;
import com.generate.invoice.helper.OrderHelper;
import com.generate.invoice.response.OrderResponse;

@RestController
@RequestMapping("/rest/order")
public class OrderRestController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderHelper orderHelper;

//	@PostMapping(UrlConstant.CREATE)

//	@PostMapping("/create")
//	public ResponseEntity<Object> create(@RequestBody OrderRequest orderRequest) {
//		try {
//			Order order = orderService.create(orderHelper.getEntity(orderRequest));
//			return new ResponseEntity<>(order.getId(), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@PostMapping(UrlConstant.CREATE)
	public ResponseEntity<Object> save(@RequestBody OrderRequest orderRequest) {
		try {
			Order order = orderService.create(orderHelper.getEntity(orderRequest));
			return new ResponseEntity<>(order.getId(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(orderRequest.getId(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(UrlConstant.FIND_BY_ID)
	public ResponseEntity<Object> getById(@RequestParam Long id) {
		try {
			Order order = orderService.findById(id);
			OrderResponse orderResponse = orderHelper.getOrder(order);
			return new ResponseEntity<Object>(orderResponse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(UrlConstant.LIST)
	public ResponseEntity<Object> getAll() {
		try {
			List<Object> list = orderService.findAll();
			// List<OrderListResponse> orderListResponses =
			// orderHelper.getOrderListResponse(list);
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(UrlConstant.DELETE)
	public ResponseEntity<Object> deleted(@RequestParam Long id) {
		try {
			orderService.softDeleted(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
