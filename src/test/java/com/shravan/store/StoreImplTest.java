package com.shravan.store;

import org.junit.Test;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;

import com.shravan.dao.ItemRepo;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StoreImpl.class})
public class StoreImplTest {
	
	@Mock
	private ItemRepo itemRepo;
	
	@InjectMocks
	Store store = new StoreImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddItemToCart() {
		
		when(itemRepo.existsById(any())).thenReturn(true);
		
		store.addItemToCart("phone", 1);
		LineItem[] line = store.getCartItems();
		
		assertSame(1, line.length);
		
	}
	
	
}
