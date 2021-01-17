package com.cognizant.truyum.dao;

import java.io.IOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.controller.MenuItemController;
import com.cognizant.truyum.model.MenuItem;

@Component("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException {
		LOGGER.info("Start");
		Connection con = null;
		List<MenuItem> menuItemsList = new ArrayList<MenuItem>();
		try {
			con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM MenuItems");
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				menuItemsList.add(new MenuItem(res.getLong("menu_item_id"), res.getString("menu_item_name"),
						res.getFloat("menu_item_price"), res.getString("menu_item_active").equals("Yes") ? true : false,
						res.getDate("menu_item_dateOfLaunch"), res.getString("menu_item_category"),
						res.getString("menu_item_freeDelivery").equals("Yes") ? true : false));
			}

			if (menuItemsList.size() < 1) {
				MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
				menuItemsList = menuItemDaoCollectionImpl.getMenuItemListAdmin();
				for (MenuItem item : menuItemsList) {
					PreparedStatement stmt2 = con.prepareStatement(
							"INSERT INTO MenuItems (menu_item_name, menu_item_price, menu_item_active, menu_item_dateOfLaunch, menu_item_category, menu_item_freeDelivery) VALUES( ? , ? , ? , ? , ? , ? )");
					stmt2.setString(1, item.getName());
					stmt2.setFloat(2, item.getPrice());
					stmt2.setString(3, item.isActive() ? "Yes" : "No");
					stmt2.setDate(4, new java.sql.Date(item.getDateOfLaunch().getTime()));
					stmt2.setString(5, item.getCategory());
					stmt2.setString(6, item.isFreeDelivery() ? "Yes" : "No");
					stmt2.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		LOGGER.info("End");

		return menuItemsList;
	}

	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException {
		LOGGER.info("Start");
		Connection con = null;
		List<MenuItem> menuItemsList = new ArrayList<MenuItem>();

		try {
			con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * FROM MenuItems WHERE menu_item_active = 'Yes' AND menu_item_dateOfLaunch <= DATE(NOW())");
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				menuItemsList.add(new MenuItem(res.getLong("menu_item_id"), res.getString("menu_item_name"),
						res.getFloat("menu_item_price"), res.getString("menu_item_active").equals("Yes") ? true : false,
						res.getDate("menu_item_dateOfLaunch"), res.getString("menu_item_category"),
						res.getString("menu_item_freeDelivery").equals("Yes") ? true : false));
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
		LOGGER.info("End");

		return menuItemsList;
	}

	public MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, IOException {
		LOGGER.info("Start");

		Connection con = null;
		MenuItem menuItem = null;
		try {
			con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM MenuItems WHERE menu_item_id = ?");
			stmt.setLong(1, menuItemId);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				menuItem = new MenuItem(res.getLong("menu_item_id"), res.getString("menu_item_name"),
						res.getFloat("menu_item_price"), res.getString("menu_item_active").equals("Yes") ? true : false,
						res.getDate("menu_item_dateOfLaunch"), res.getString("menu_item_category"),
						res.getString("menu_item_freeDelivery").equals("Yes") ? true : false);
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
		LOGGER.info("End");

		return menuItem;
	}

	public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException {
		LOGGER.info("Start");

		Connection con = null;
		try {
			con = ConnectionHandler.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"UPDATE MenuItems " + "SET menu_item_name = ?, menu_item_price = ?, menu_item_active = ?, "
							+ "menu_item_dateOfLaunch = ?, menu_item_category = ?, menu_item_freeDelivery = ? "
							+ "WHERE menu_item_id = ?");
			stmt.setString(1, menuItem.getName());
			stmt.setFloat(2, menuItem.getPrice());
			stmt.setString(3, menuItem.isActive() ? "Yes" : "No");
			stmt.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			stmt.setString(5, menuItem.getCategory());
			stmt.setString(6, menuItem.isFreeDelivery() ? "Yes" : "No");
			stmt.setLong(7, menuItem.getId());
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
		LOGGER.info("End");

	}

}
