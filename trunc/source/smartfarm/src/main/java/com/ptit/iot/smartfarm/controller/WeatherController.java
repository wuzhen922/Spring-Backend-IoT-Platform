package com.ptit.iot.smartfarm.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import com.ptit.iot.smartfarm.entities.Constant;

@RestController
public class WeatherController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8324516078300271373L;
	
	@Autowired
	private RestOperations restOperations;
	
	@RequestMapping(value="/weather/{city}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String getWeather(@PathVariable("city") String city) {
		try {
			String url = "http://api.wunderground.com/api/" + Constant.WEATHER.WEATHER_UNDERGROUND_KEY
					+ "/geolookup/conditions/forecast/q/Vietnam/" + city + ".json";
			return restOperations.getForObject(url, String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
