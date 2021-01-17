package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/add-to-cart")
	public String addToCart(@RequestParam("menuItemId") long menuItemId, ModelMap model) {
		LOGGER.info("Start");

		cartService.addCartItem(1, menuItemId);
		model.put("addCartStatus", true);
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		model.put("menuItemListCustomer", menuItemListCustomer);
		LOGGER.info("End");

		return "menu-item-list-customer";
	}

	@GetMapping(value = "/show-cart")
	public String showCart(ModelMap model) {
		LOGGER.info("Start");

		long userId = 1;
		try {
			Cart cart = cartService.getAllCartItems(userId);
			model.put("cart", cart);
			LOGGER.info("End");

			return "cart";
		} catch (CartEmptyException e) {
			LOGGER.info("End");

			return "cart-empty";
		}
	}

	@GetMapping(value = "/remove-cart-item")
	public String removeCart(@RequestParam("menuItemId") Long menuItemId, ModelMap model) {
		LOGGER.info("Start");

		cartService.removeCartItem(1, menuItemId);
		try {
			Cart cart = cartService.getAllCartItems(1);
			model.put("cart", cart);
			model.put("removeCartItemStatus", true);
			LOGGER.info("End");

			return "cart";
		} catch (CartEmptyException e) {
			LOGGER.info("End");

			return "cart-empty";
		}
	}
}
