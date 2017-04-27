package com.ptit.iot.smartfarm.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8031616230239703367L;
	private long id;
	private String context;
	
	public Greeting() {
		// TODO Auto-generated constructor stub
	}

	public Greeting(long id, String context) {
		super();
		this.id = id;
		this.context = context;
	}

	@JsonProperty("id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("context")
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Context with {id:" + this.id + "; context : " + this.context + "}";
	}
}
