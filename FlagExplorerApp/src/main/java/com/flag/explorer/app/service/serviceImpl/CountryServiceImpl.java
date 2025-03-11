package com.flag.explorer.app.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.flag.explorer.app.dto.Country;
import com.flag.explorer.app.dto.CountryDetails;
import com.flag.explorer.app.repository.CountryRepository;
import com.flag.explorer.app.service.CountryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CountryServiceImpl  implements CountryService{
	
	public final CountryRepository countryRepository ;

	

	/**
	 * retrieveAllCountries and returns a list of countries by name and flag
	 */
	@Override
	public List<Country> retrieveAllCountries() {
		List<Country> countryListResp = new ArrayList<>();
		countryRepository.findAll().stream().parallel().forEach(country->{
			Country countryResponse = new Country(country.getName(), country.getFlag()) ; 
			countryListResp.add(countryResponse);
		});
		return countryListResp;
	}



	@Override
	public CountryDetails retrieveCountryDetails(String name) {
		Optional<com.flag.explorer.app.model.Country> countryDetailOptional= Optional.empty();
		countryDetailOptional=countryRepository.findByName(name) ;
		CountryDetails cd =	countryDetailOptional.isPresent()? processCountryDetails(countryDetailOptional):null;
		return cd;
	}



	private CountryDetails processCountryDetails(Optional<com.flag.explorer.app.model.Country> countryDetailOptional) {
		com.flag.explorer.app.model.Country cd =countryDetailOptional.get() ;
		Integer randomNum = ThreadLocalRandom.current().nextInt(6000000, 30000000);
		return new CountryDetails(cd.name, randomNum, cd.capital, cd.flag);
	}

}
