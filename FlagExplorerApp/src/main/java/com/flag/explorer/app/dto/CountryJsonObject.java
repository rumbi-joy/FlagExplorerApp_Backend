package com.flag.explorer.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CountryJsonObject 
	(
	     String name,
	     String unicode,
	    @JsonProperty("emoji") 
	     String flag,
	     String alpha2,
	     String dialCode,
	     String alpha3,
	     String region,
	     String capital,
	     Geo geo,
	     List<String> timezones) {

}
