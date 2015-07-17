package com.panasonic.steaknshakecms.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class MenuPage {

	@Id
	private String id = "1";
	private List<Menu> menu;

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "MenuPage [menu=" + menu + "]";
	}

}
