package com.flag.explorer.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flag.explorer.app.model.Country;



public interface  CountryRepository   extends JpaRepository< Country, String> {
	
	public  Optional<Country> findByName(String name);

}
