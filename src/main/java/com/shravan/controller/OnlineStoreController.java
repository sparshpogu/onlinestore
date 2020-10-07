package com.shravan.controller;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shravan.beans.Item;
import com.shravan.beans.LineItemImpl;
import com.shravan.service.OnlineService;

@Controller
public class OnlineStoreController {
	@Autowired
	OnlineService onlineService;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("addtoCart")
	public ModelAndView addToCart(LineItemImpl lineItemImpl) {
		ModelAndView model = new ModelAndView("index");
		onlineService.addItemToCart(lineItemImpl);
		return model;
	}
	
	@RequestMapping("addtostore")
	public String addToStore(Item item) {
		onlineService.addItemStore(item);
		return "index";
	}
	
	@RequestMapping("getTotal")
	public ModelAndView getTotal() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("total", onlineService.getCartTotal());
		return model;
	}
	
	@RequestMapping("getCartItems")
	public ModelAndView getCartItems() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("items", onlineService.getCartItems());
		
		return model;
	}
	

}
