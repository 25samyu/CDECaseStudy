package com.cognizant.truyum.dao;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private List<MenuItem> menuItemList;

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public MenuItemDaoCollectionImpl() {

	}

	@Autowired
	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;

	}

	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> list = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemList) {
			if (((menuItem.getDateOfLaunch()).equals(new Date()))
					|| (menuItem.getDateOfLaunch()).before(new Date()) && menuItem.isActive()) {
				list.add(menuItem);
			}
		}
		return list;
	}

	public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException {
		for (MenuItem menuItemInList : menuItemList) {
			if (menuItem.equals(menuItemInList)) {
				menuItemList.remove(menuItemInList);
				menuItemList.add(menuItem);
				break;
			}
		}
	}

	public MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		for (MenuItem menuItemInList : menuItemList) {
			if (menuItemId == menuItemInList.getId())
				return menuItemInList;
		}
		return null;
	}

}
