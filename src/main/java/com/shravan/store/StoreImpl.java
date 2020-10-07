package com.shravan.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shravan.beans.Item;
import com.shravan.beans.LineItemImpl;
import com.shravan.dao.ItemRepo;

@Component
public class StoreImpl implements Store {
	
	//Repository object to get the details from the H2 DB 
	@Autowired
	ItemRepo itemRepo;
	
	//Collection to store the Cart details. Keys are Names and Values are quantities
	Map<String, Integer> cart = new HashMap<String, Integer>();
	/*
	*	Method to Add the items to the Cart. Initially I am verifying if the item is in the store, and then the item is added to the cart only if it is available in the store.
	*/
	@Override
	public void addItemToCart(String name, int quantity) {
		// TODO Auto-generated method stub
		if (itemRepo.existsById(name)) {
			addToCart(name, quantity);
		} 
		
	}
	
	private void addToCart(String name, int quantity) {
		
		if(cart.get(name)!=null) {
			int quant = cart.get(name);
			quant = quant+quantity;
			cart.put(name, quant);
		} else {
			cart.put(name, quantity);
		}
	}

	/*
	*	Method to Add the items to the Store. These are the Items added to the Database 
	*/
	@Override
	public void addItemToStore(String name, double price) {
		// TODO Auto-generated method stub
		
		itemRepo.save(new Item(name, price));
		
	}
	
	/*
	*	Method to get the items from the Cart. I defined the Map as Cart, and converting the map to LineItems and returning it as an Array.
	*/
	@Override
	public LineItem[] getCartItems() {
		// TODO Auto-generated method stub
		
		LineItem[] lineItem = new LineItem[cart.size()];
		List<LineItem> list = cart.entrySet().stream()
				.map(i -> new LineItemImpl(i.getKey(), i.getValue()))
				.sorted((i,j) -> i.getName().compareTo(j.getName()))
				.collect(Collectors.toList());
		return list.toArray(lineItem);
	}
	
	/*
	*	Method to get the totat amount of the cart and returning the value as double
	*/

	@Override
	public double getCartTotal() {
		// TODO Auto-generated method stub
		
      Iterable<Item> iterable = itemRepo.findAllById(cart.keySet());
      return StreamSupport.stream(iterable.spliterator(), false)
      .map(i-> cart.get(i.getName())*i.getPrice())
      .mapToDouble(Double::valueOf)
      .sum();
      
		
	}

}
