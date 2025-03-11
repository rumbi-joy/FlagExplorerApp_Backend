package com.flag.explorer.app.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flag.explorer.app.dto.Countries;
import com.flag.explorer.app.dto.CountryJsonObject;
import com.flag.explorer.app.repository.CountryRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("app/v1/setup/")
@Tag(name = "Setup")
@AllArgsConstructor
@Slf4j
public class SetupController {
	
	public final CountryRepository countryRepository ;
	
	
	
	
	@GetMapping("/countries")
	public ResponseEntity<?> setupcountries  () {
		
		
		
		Countries countries = null ;
		try {
		File file = new File(
		        this.getClass().getClassLoader().getResource("countries.json").getFile()
		    );
		ObjectMapper mapper = new ObjectMapper();
		countries = mapper.readValue(file, Countries.class);
		countries.list().stream().parallel().forEach(country->{
			
			
			com.flag.explorer.app.model.Country	 countryModel = new  com.flag.explorer.app.model.Country ();
			countryModel.setAlpha2(country.alpha2()) ;
			countryModel.setAlpha3(country.alpha3());
			countryModel.setCapital(country.capital());
			countryModel.setDialCode(country.dialCode());
			countryModel.setFlag(country.flag()) ;
			countryModel.setGeo(country.geo().toString()) ;
			countryModel.setName(country.name()) ;
			countryModel.setRegion(country.region().toString()) ;
//		countryModel.setTimezones(country.timezones().toString());
			countryModel.setUnicode(country.unicode()) ;
			countryRepository.save(countryModel) ;
			log.info(countryRepository.save(countryModel).toString()) ;
			
		});
			return ResponseEntity.ok("Saved") ;
			
		} catch (StreamReadException e) {
			
			e.printStackTrace();
		} catch (DatabindException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
