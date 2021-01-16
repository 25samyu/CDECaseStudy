package com.cognizant.truyum.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemServiceTest {
	private static MenuItemService menuItemService;

	@BeforeClass
	public static void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		// context.scan("com.cognizant.truyum");
		// context.refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");
	}

	@Test
	public void testGetMenuItemListAdminSize() {
		assertEquals("testGetMenuItemListAdminSize", 5, menuItemService.getMenuItemListAdmin().size());
	}

	@Test
	public void testGetMenuItemListAdminContainsSandwich() throws ParseException {
		MenuItem menuItem = new MenuItem((long) 1, "Sandwich", (float) 99.0, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		for (MenuItem menuItemInList : menuItemService.getMenuItemListAdmin()) {
			if (menuItemInList.equals(menuItem)) {
				assertEquals("testGetMenuItemListAdminContainsSandwich1", menuItem.getName(), menuItemInList.getName());
				assertEquals("testGetMenuItemListAdminContainsSandwich2", menuItem.getPrice(),
						menuItemInList.getPrice());
				assertEquals("testGetMenuItemListAdminContainsSandwich3", menuItem.isActive(),
						menuItemInList.isActive());
				assertEquals("testGetMenuItemListAdminContainsSandwich4", menuItem.getDateOfLaunch(),
						menuItemInList.getDateOfLaunch());
				assertEquals("testGetMenuItemListAdminContainsSandwich5", menuItem.getCategory(),
						menuItemInList.getCategory());
				assertEquals("testGetMenuItemListAdminContainsSandwich6", menuItem.isFreeDelivery(),
						menuItemInList.isFreeDelivery());

			}
		}
	}

	@Test
	public void testGetMenuItemListCustomerSize() {
		assertEquals("testGetMenuItemListCustomerSize", 3, menuItemService.getMenuItemListCustomer().size());

	}

	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() throws ParseException {
		MenuItem menuItem = new MenuItem((long) 4, "French Fries", (float) 57.0, false,
				DateUtil.convertToDate("02/07/2017"), "Starters", true);
		for (MenuItem menuItemInList : menuItemService.getMenuItemListCustomer()) {
			assertFalse("testGetMenuItemListCustomerNotContainsFrenchFries", menuItemInList.equals(menuItem));
		}
	}

	@Test
	public void testGetMenuItem() {
		assertEquals("testGetMenuItem", (long) 1, menuItemService.getMenuItem(1).getId());
	}

	@Test
	public void testModifyMenuItem() throws ParseException {
		MenuItem menuItem = new MenuItem((long) 1, "Big Sandwich", (float) 199.0, true,
				DateUtil.convertToDate("15/03/2019"), "Main Course", true);
		menuItemService.modifyMenuItem(menuItem);
		assertEquals("testModifyMenuItem1", menuItem.getName(), menuItemService.getMenuItem(1).getName());
		assertEquals("testModifyMenuItem2", menuItem.getPrice(), menuItemService.getMenuItem(1).getPrice());
		assertEquals("testModifyMenuItem3", menuItem.getDateOfLaunch(),
				menuItemService.getMenuItem(1).getDateOfLaunch());
		MenuItem menuItem1 = new MenuItem((long) 1, "Sandwich", (float) 99.0, true,
				DateUtil.convertToDate("15/03/2017"), "Main Course", true);
		menuItemService.modifyMenuItem(menuItem1);

	}

}