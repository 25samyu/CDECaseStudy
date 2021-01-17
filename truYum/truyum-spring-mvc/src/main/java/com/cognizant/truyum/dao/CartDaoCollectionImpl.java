package com.cognizant.truyum.dao;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component()
public class CartDaoCollectionImpl implements CartDao {
	private LinkedHashMap<Long, Cart> userCarts;
	@Autowired
	@Qualifier("menuItems")
	private MenuItemDao menuItemDao;

	@Autowired
	public CartDaoCollectionImpl(LinkedHashMap<Long, Cart> userCarts) {
		super();
		this.userCarts = userCarts;
	}

	public CartDaoCollectionImpl() {

	}

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public LinkedHashMap<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(LinkedHashMap<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}

	public void addCartItem(long userId, long menuItemId)
			throws ParseException, ClassNotFoundException, IOException, SQLException {
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			List<MenuItem> list = cart.getMenuItemList();
			list.add(menuItem);
			cart.setMenuItemList(list);
			userCarts.put(userId, cart);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0);
			List<MenuItem> list = cart.getMenuItemList();
			list.add(menuItem);
			cart.setMenuItemList(list);
			userCarts.put(userId, cart);
		}

	}

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = userCarts.get(userId);
		List<MenuItem> list = cart.getMenuItemList();
		if (list == null || list.size() < 1)
			throw new CartEmptyException();
		else {
			double total = 0;
			for (MenuItem menuItem : list) {
				total += menuItem.getPrice();
			}
			cart.setTotal(total);
		}
		return cart;
	}

	public void removeCartItem(long userId, long menuItemId) {
		Cart cart = userCarts.get(userId);
		List<MenuItem> list = cart.getMenuItemList();
		for (MenuItem menuItem : list) {
			if (menuItem.getId() == menuItemId) {
				list.remove(menuItem);
				break;
			}
			cart.setMenuItemList(list);
			userCarts.put(userId, cart);
		}
	}

}
