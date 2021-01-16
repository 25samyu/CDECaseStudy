package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {
	private static CartService cartService;
	private static MenuItemService menuItemService;

	@BeforeClass
	public static void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		context.scan("com.cognizant.truyum");
		// context.refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");
		cartService = (CartService) context.getBean("cartService");

	}

	@Test(expected = CartEmptyException.class)
	public void testGetAllCartItemsExceptionIfEmpty() throws CartEmptyException {
		cartService.addCartItem(90, 1);
		cartService.removeCartItem(90, 1);
		cartService.getAllCartItems(90);
	}

	@Test
	public void testAddCartItem() throws CartEmptyException {

		cartService.addCartItem(1, 1);
		List<MenuItem> menuItemList = cartService.getAllCartItems(1).getMenuItemList();
		assertEquals("testAddCartItem", (long) 1, menuItemList.get(menuItemList.size() - 1).getId());
	}

	@Test
	public void testRemoveCartItem() throws CartEmptyException {

		cartService.addCartItem(1, 2);
		cartService.removeCartItem(1, 1);
		List<MenuItem> menuItemList = cartService.getAllCartItems(1).getMenuItemList();
		assertTrue("testRemoveCartItem",
				(menuItemList.size() == 0) || (((menuItemList.get(menuItemList.size() - 1)).getId()) != 1));
	}

}
