package com.ptit.iot.smartfarm.listener;

import java.io.Serializable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ptit.iot.smartfarm.dao.cassandra.BaseCassandraDAO;

public class CustomContextListener implements ServletContextListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 951455261267030219L;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Setup cassandra connection's information...");
		BaseCassandraDAO.setupConnectionSource();
	}

}
