package com.ptit.iot.smartfarm.dao.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ptit.iot.smartfarm.entities.Greeting;

@Repository
public class DemoMongoDAOImpl {

	private static final String COLLECTION_NAME = Greeting.class.getSimpleName().toLowerCase();
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Greeting> getAllDemoContext() {
		List<Greeting> lst = mongoTemplate.findAll(Greeting.class);
		return lst;
	}
	
	public void addNewDemoContext(Greeting greet) {
		if(!mongoTemplate.collectionExists(COLLECTION_NAME)) {
			mongoTemplate.createCollection(COLLECTION_NAME);
		}
		
		try {
			mongoTemplate.insert(greet, COLLECTION_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Insert object: " + greet);
	}
}
