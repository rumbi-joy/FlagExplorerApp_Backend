package com.flag.explorer.app.service;

import java.util.List;

import com.flag.explorer.app.dto.Country;
import com.flag.explorer.app.dto.CountryDetails;

public interface CountryService {
	
	
	public  List<Country> retrieveAllCountries () ;
	
	public CountryDetails retrieveCountryDetails (String name);
	

}
