package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cognizant.truyum.util.DateUtil;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList = null;

	public MenuItemDaoCollectionImpl() throws ParseException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem(1, "Sandwich", (float) 99.0, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(2, "Burger", (float) 129.0, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(3, "Pizza", (float) 149.0, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", (float) 57.0, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(5, "Chocolate Brownie", (float) 32.0, true,
					DateUtil.convertToDate("02/11/2022"), "Dessert", true));

		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> list = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemList) {
			if (((menuItem.getDateOfLaunch()).equals(new Date()))
					|| (menuItem.getDateOfLaunch()).before(new Date()) && menuItem.isActive()) {
				list.add(menuItem);
			}
		}
		return list;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem menuItemInList : menuItemList) {
			if (menuItem.equals(menuItemInList)) {
				menuItemList.remove(menuItemInList);
				menuItemList.add(menuItem);
				break;
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem menuItemInList : menuItemList) {
			if (menuItemId == menuItemInList.getId())
				return menuItemInList;
		}
		return null;
	}

}
