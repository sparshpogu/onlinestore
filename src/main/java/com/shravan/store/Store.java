package com.shravan.store;

public interface Store {
	
	void addItemToCart(String name, int quantity);
	
	void addItemToStore(String name, double price);
	
	LineItem[] getCartItems();
	
	double getCartTotal();

}
