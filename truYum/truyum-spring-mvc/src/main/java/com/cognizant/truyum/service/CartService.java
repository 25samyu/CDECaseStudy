package com.cognizant.truyum.service;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;

@Service("cartService")
public class CartService {
	@Autowired
	@Qualifier("cartDao")
	private CartDao cartDao;

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void addCartItem(long userId, long menuItemId) {
		try {
			cartDao.addCartItem(userId, menuItemId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		try {
			return cartDao.getAllCartItems(userId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void removeCartItem(long userId, long menuItemId) {
		try {
			cartDao.removeCartItem(userId, menuItemId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
