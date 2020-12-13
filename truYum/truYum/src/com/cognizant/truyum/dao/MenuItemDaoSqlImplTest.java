package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuItem();
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem.toString());
		}
	}

	public static void testGetMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem.toString());
		}
	}

	public static void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(1);
		System.out.println(menuItem.toString());

	}

	public static void testModifyMenuItem() throws ClassNotFoundException, IOException, SQLException, ParseException {
		MenuItem menuItem = new MenuItem(1, "Big Sandwich", (float) 120.0, true, DateUtil.convertToDate("15/04/2019"),
				"Main Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(menuItem);
		MenuItem modifiedMenuItem = menuItemDao.getMenuItem(1);
		System.out.println(modifiedMenuItem.toString());

	}

}
