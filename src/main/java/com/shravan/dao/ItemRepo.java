package com.shravan.dao;

import org.springframework.data.repository.CrudRepository;

import com.shravan.beans.Item;

public interface ItemRepo extends CrudRepository<Item, String> {

}
