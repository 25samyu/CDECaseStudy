package com.cognizant.truyum.service;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
public class MenuItemService {
	@Autowired
	@Qualifier("menuItemDao")
	private MenuItemDao menuItemDao;

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		try {
			return menuItemDao.getMenuItemListAdmin();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		try {
			return menuItemDao.getMenuItemListCustomer();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void modifyMenuItem(MenuItem menuItem) {
		try {
			menuItemDao.modifyMenuItem(menuItem);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MenuItem getMenuItem(long menuItemId) {
		try {
			return menuItemDao.getMenuItem(menuItemId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
