package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	void addCartItem(long userId, long menuItemId)
			throws ParseException, ClassNotFoundException, IOException, SQLException;

	Cart getAllCartItems(long userId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

	void removeCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException;

}
