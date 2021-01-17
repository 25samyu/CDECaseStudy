package com.cognizant.truyum.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class MenuItem {
	private long id;
	@NotBlank(message="Title is required")
    @Size(min = 2, max = 65, message="Title should have 2 to 65 characters")
	private String name;
	@NotNull(message="Price is required")
	@Range(min = 1, message= "Price is required")
	@Min(value=0,message="Price has to be a number")
	private float price;
	private boolean active;
	@NotNull(message="Launch Date required")
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery) {
		setId(id);
		setName(name);
		setPrice(price);
		setActive(active);
		setDateOfLaunch(dateOfLaunch);
		setCategory(category);
		setFreeDelivery(freeDelivery);
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	@Override
	public boolean equals(Object obj) {
		MenuItem other = (MenuItem) obj;
		return id == other.id;
	}

}
