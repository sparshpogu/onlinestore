package com.shravan.beans;

import com.shravan.store.LineItem;

public class LineItemImpl implements LineItem {
	
	String name;
	int quantity;

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	public LineItemImpl(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "LineItemImpl [name=" + name + ", quantity=" + quantity + ", getName()=" + getName() + ", getQuantity()="
				+ getQuantity() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
