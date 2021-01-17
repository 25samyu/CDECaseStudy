package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.SystemException;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;


@Controller
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		model.put("menuItemListAdmin", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-admin";

	}

	@GetMapping(value = "/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		model.put("menuItemListCustomer", menuItemListCustomer);
		LOGGER.info("End");
		return "menu-item-list-customer";
	}

	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam("menuItemId") long menuItemId, ModelMap model) {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		model.put("menuItem", menuItem);
		LOGGER.info("End");
		return "edit-menu-item";

	}
	@PostMapping("/edit-menu-item")
	public String editMenuItem(@Valid @ModelAttribute("menuItem") MenuItem editedMenuItem, BindingResult bindingResult) {
		LOGGER.info("Start");
		if(bindingResult.hasErrors())
			return "edit-menu-item";
		menuItemService.modifyMenuItem(editedMenuItem);
		LOGGER.info("End");
		return "edit-menu-item-status";
	}
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        sdf.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    }

}
