package com.ptit.iot.smartfarm.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.iot.smartfarm.dao.cassandra.DemoCassandraDAOImpl;
import com.ptit.iot.smartfarm.entities.Greeting;

@RestController
@RequestMapping("/cass")
public class CassandraController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7107875753817446485L;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Greeting> getAll() {
		return DemoCassandraDAOImpl.getInstance().getAll();
	}

	@RequestMapping(value = "/addTable", method = RequestMethod.POST)
	public ResponseEntity<Greeting> addNewTb(@RequestBody String context) {
		DemoCassandraDAOImpl.getInstance().createTestTable(context);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void insertNewContext(@RequestBody String context) {
		DemoCassandraDAOImpl.getInstance().insertNewContext(context);
	}
	
	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteById(@PathVariable int id) {
		DemoCassandraDAOImpl.getInstance().deleteById(id);
	}
	
	@RequestMapping(value = "/updateContext/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateById(@PathVariable int id, @RequestBody String context) {
		DemoCassandraDAOImpl.getInstance().updateById(id, context);
	}
}
