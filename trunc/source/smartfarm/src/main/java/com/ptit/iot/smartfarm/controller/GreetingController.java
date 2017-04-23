package com.ptit.iot.smartfarm.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.iot.smartfarm.entities.Greeting;

@RestController
//@RequestMapping("/service")
public class GreetingController {

	@RequestMapping(value = "/greet/{name}", method = RequestMethod.GET, produces="application/json")
	public Greeting greeting(@PathVariable("name") String name) {
		System.out.println("Fetching data " + name);
		Greeting greet = new Greeting(1, "Service call in " + new SimpleDateFormat("DD-MMM-YYYY HH:MM:SS a").format(Calendar.getInstance().getTime()));
//		return new ResponseEntity<Greeting>(greet, HttpStatus.OK);
		return greet;
	}
}
