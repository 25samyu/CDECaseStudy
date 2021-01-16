package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args)
			throws ClassNotFoundException, ParseException, IOException, SQLException, CartEmptyException {

		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem()
			throws ClassNotFoundException, ParseException, IOException, SQLException, CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(1, 1);
		Cart cart = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : cart.getMenuItemList())
			System.out.println(menuItem.toString());
	}

	public static void testGetAllCartItems()
			throws ClassNotFoundException, CartEmptyException, IOException, SQLException {
		CartDao cartDao = new CartDaoSqlImpl();
		Cart cart = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : cart.getMenuItemList())
			System.out.println(menuItem.toString());
	}

	public static void testRemoveCartItem()
			throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(1, 1);
		Cart cart = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : cart.getMenuItemList())
			System.out.println(menuItem.toString());
	}

}
