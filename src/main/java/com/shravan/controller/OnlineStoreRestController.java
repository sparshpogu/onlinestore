package com.shravan.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shravan.service.OnlineService;
import com.shravan.store.LineItem;

@RestController
public class OnlineStoreRestController {

	@Autowired
	OnlineService onlineService;
	
	@GetMapping("orderTotal")
	public double getOrderTotal() {
		return onlineService.getCartTotal();
	}
	
	@GetMapping("cart") 
	public List<LineItem> getOrders() {
		return Arrays.asList(onlineService.getCart());
	}
}
