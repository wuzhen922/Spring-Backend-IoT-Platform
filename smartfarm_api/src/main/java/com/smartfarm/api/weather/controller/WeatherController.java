package com.smartfarm.api.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartfarm.api.weather.service.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	@RequestMapping(value= "/weather" , method = RequestMethod.GET)
	public String getWeather() {
		// call weatherService here
        return "todo";
    }
}
