package com.shravan.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shravan.beans.Item;
import com.shravan.beans.LineItemImpl;
import com.shravan.store.LineItem;
import com.shravan.store.StoreImpl;

@Component
public class OnlineService {

	@Autowired
	StoreImpl storeImpl;
	
	public void addItemStore(Item item) {
		storeImpl.addItemToStore(item.getName(), item.getPrice());
	}
	
	public void addItemToCart(LineItemImpl lineItemImpl) {
				 
		storeImpl.addItemToCart(lineItemImpl.getName(), lineItemImpl.getQuantity());	
		
	}
	
	public double getCartTotal() {
		return storeImpl.getCartTotal();
	}
	
	public String getCartItems() {
		String cartItems = Stream.of(storeImpl.getCartItems())
				.map(i -> "[Name:  "+i.getName()+"   quantity:  "+i.getQuantity()+"]")
				.collect(Collectors.joining(","));
		System.out.println("cart Items:"+ cartItems);
		return cartItems;
		
		
	}
	
	public LineItem[] getCart() {
		return storeImpl.getCartItems();
		
		
	}
	
}
