package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException, ClassNotFoundException, IOException, SQLException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();

	}

	public static void testGetMenuItemListAdmin()
			throws ParseException, ClassNotFoundException, IOException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem.toString());

		}
	}

	public static void testGetMenuItemListCustomer()
			throws ParseException, ClassNotFoundException, IOException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem.toString());

		}
	}

	public static void testModifyMenuItem() throws ParseException, ClassNotFoundException, IOException, SQLException {
		MenuItem menuItem = new MenuItem(1, "Big Sandwich", (float) 120.0, true, DateUtil.convertToDate("15/04/2019"),
				"Main Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println(menuItemDao.getMenuItem(1).toString());
	}

	public static void testGetMenuItem() {

	}

}
