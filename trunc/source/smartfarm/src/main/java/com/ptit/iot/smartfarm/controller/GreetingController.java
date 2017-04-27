package com.ptit.iot.smartfarm.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.iot.smartfarm.dao.mongo.DemoMongoDAOImpl;
import com.ptit.iot.smartfarm.entities.Greeting;

@RestController
@RequestMapping("/greet")
public class GreetingController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1283641522974529957L;
	
	@Autowired
	private DemoMongoDAOImpl demoMongoDAOImpl;

	@RequestMapping(value = "/show/{name}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Greeting greeting(@PathVariable("name") String name) {
		System.out.println("Fetching data " + name);
		Greeting greet = new Greeting(1, "Service call param '" + name + "' in " + new SimpleDateFormat("DD-MMM-YYYY HH:MM:SS a").format(Calendar.getInstance().getTime()));
//		return new ResponseEntity<Greeting>(greet, HttpStatus.OK);
		return greet;
	}
	
	@RequestMapping(value = "/show/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Greeting> retreiveAllGreet() {
		return demoMongoDAOImpl.getAllDemoContext();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Greeting> addNewGreet(@RequestBody Greeting greet) {
		demoMongoDAOImpl.addNewDemoContext(greet);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addContext", method = RequestMethod.POST)
	public ResponseEntity<Greeting> addNewContext(@RequestBody String context) {
		Greeting greet = new Greeting(new Random().nextLong(), context);
		demoMongoDAOImpl.addNewDemoContext(greet);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
