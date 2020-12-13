package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException {
		Connection con = null;
		try {
			con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users WHERE user_id = ? ");
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			if(!rs.next())
			{
				stmt = con.prepareStatement("INSERT INTO Users (user_first_name, user_last_name) values('Jack','Smith')");
				stmt.executeUpdate();
			}
			stmt = con.prepareStatement("INSERT INTO Cart values(?,?)");
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException, ClassNotFoundException, IOException {
		Connection con = null;
		Cart cart = new Cart(new ArrayList(), 0);
		try {
			con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * FROM MenuItems JOIN Cart ON MenuItems.menu_item_id = Cart.cart_item_id AND cart_user_id = ? ");
			stmt.setLong(1, userId);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				cart.getMenuItemList().add(new MenuItem(res.getLong("menu_item_id"), res.getString("menu_item_name"),
						res.getFloat("menu_item_price"), res.getString("menu_item_active").equals("Yes") ? true : false,
						res.getDate("menu_item_dateOfLaunch"), res.getString("menu_item_category"),
						res.getString("menu_item_freeDelivery").equals("Yes") ? true : false));
			}
			stmt = con.prepareStatement(
					"SELECT SUM(menu_item_price) AS total FROM MenuItems JOIN Cart ON MenuItems.menu_item_id = Cart.cart_item_id AND cart_user_id = ? ");
			stmt.setLong(1, userId);
			res = stmt.executeQuery();
			while (res.next()) {
				cart.setTotal(res.getFloat("total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException {
		Connection con = null;
		try {
			con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con
					.prepareStatement("DELETE FROM Cart where cart_user_id = ? AND cart_item_id = ? ");
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
