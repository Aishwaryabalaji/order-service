package com.order.management.orderservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.order.management.orderservice.model.OrderDetails;
import com.order.management.orderservice.model.ResponseData;
import com.order.management.orderservice.service.OrderService;

@RestController
@RequestMapping("/order-details")
public class OrderController {
	
	@Autowired
	public OrderService orderService;

	
	@PostMapping("/place/orderDetails")
	public ResponseEntity<ResponseData> placeOrder(@RequestBody @Valid OrderDetails orderDetails) {
		
		ResponseData response = new ResponseData();
		try {
			response = orderService.placeOrder(orderDetails);
			if(response.getOrderDetails().getOrderId()!=0) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			response.setMessage("Place Order Failed !!"+e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PutMapping("/modify/orderDetails")
	public ResponseEntity<ResponseData> modifyOrder(@RequestBody @Valid OrderDetails orderDetails) {
		
		ResponseData response = new ResponseData();
		try {
			response = orderService.modifyOrder(orderDetails);
			if(response.getOrderDetails().getOrderId()!=0) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			response.setMessage("Modify Order Failed !!"+e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@DeleteMapping("/delete/orderDetails")
	public ResponseEntity<ResponseData> deleteOrder(@RequestBody @Valid OrderDetails orderDetails) {
		
		ResponseData response = new ResponseData();
		try {
			response = orderService.deleteOrder(orderDetails);
			if(response.getOrderDetails().getOrderId()!=0) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			response.setMessage("Delete Order Failed !!"+e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
