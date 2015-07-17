package com.panasonic.steaknshakecms.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panasonic.steaknshakecms.constants.RouteConfig;
import com.panasonic.steaknshakecms.model.Menu;
import com.panasonic.steaknshakecms.model.MenuPage;
import com.panasonic.steaknshakecms.repository.MenuPageRepository;
import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping(value = RouteConfig.ROOT_MAPPING)
@Api(value = "CMSServices")
public class MenuPageController {

	@Autowired
	MenuPageRepository menuPageRepository;

	@RequestMapping(value = RouteConfig.ROOT_MAPPING_MENU_SAVETO_DATABASE, method = POST)
	public MenuPage save(@RequestBody MenuPage menuPage) throws IOException {
		return menuPageRepository.save(menuPage);
	}

	@RequestMapping(value = RouteConfig.ROOT_MAPPING_MENU_RETRIVEFROM_DATABASE, method = GET)
	public List<MenuPage> list() {
		return menuPageRepository.findAll();
	}

	@RequestMapping(value = "/update", method = PUT)
	public MenuPage Update(@RequestBody Menu menu) {
		//MenuPage menuPage = new MenuPage();
		List<MenuPage> listMenu = menuPageRepository.findAll();
		for(MenuPage menuPage : listMenu){
			
		}
       
	menuPageRepository.save(arg0);
	}
}
