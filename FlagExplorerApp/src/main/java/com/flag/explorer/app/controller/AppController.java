package com.flag.explorer.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flag.explorer.app.dto.Country;
import com.flag.explorer.app.dto.CountryDetails;
import com.flag.explorer.app.repository.CountryRepository;
import com.flag.explorer.app.service.CountryService;

import io.swagger.v3.oas.annotations.* ;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@Tag(name = "Country API", description = "")
@RequiredArgsConstructor
public class AppController {
	
	public final CountryRepository countryRepository ;
	
	public final CountryService countryService ;
	
	@GetMapping("/countries")
	@Operation(summary = "Retrieve all countries", 
    description= "A list of countries")
	public List<Country> countries () {
		return 	countryService.retrieveAllCountries() ;
	}
	
	@GetMapping("/countries/{name}")
	@Operation(summary = "Retrieve details about a specific country", 
    description= "Details about the country")
	public ResponseEntity<CountryDetails> countriesByName (@PathVariable(required = true) String name) {
		return ResponseEntity.ok(	countryService.retrieveCountryDetails(name) );
	}
	
	
//	
	

}
