package com.panasonic.steaknshakecms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.panasonic.steaknshakecms.model.MenuPage;

public interface MenuPageRepository extends MongoRepository<MenuPage, String> {

}
