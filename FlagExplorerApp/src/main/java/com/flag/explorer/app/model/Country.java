package com.flag.explorer.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "country")
public class Country {
	
	@Id
	public  String alpha2;
	public  String name;
	public  String unicode;
	public  String flag;
	public  String dialCode;
	public  String alpha3;
	public  String region;
	public  String capital;
	public  String geo;
	public  String timezones ;
	
	
	

}
