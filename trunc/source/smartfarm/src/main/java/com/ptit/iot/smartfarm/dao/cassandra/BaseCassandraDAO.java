package com.ptit.iot.smartfarm.dao.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.ptit.iot.smartfarm.utilities.CassandraCommonUtils;

public class BaseCassandraDAO {

	private static String contactPoint;
	private static int port;
	private static String schema;
	
	public static void setupConnectionSource() {
		if(contactPoint == null) contactPoint = CassandraCommonUtils.getProperty("cassandra.contactpoints");
		if(port == 0) port = Integer.valueOf(CassandraCommonUtils.getProperty("cassandra.port"));
		if(schema == null) schema = CassandraCommonUtils.getProperty("cassandra.keyspace");
	}
	protected Cluster getConnection() {
		Cluster cluster = Cluster.builder().addContactPoint(contactPoint)
				.withPort(port)
				.withRetryPolicy(DefaultRetryPolicy.INSTANCE).build();
		return cluster;
	}
	
	protected void closeConnection(Cluster cluster, Session session, ResultSet resultSet) {
		if(session != null) {
			session.getCluster();
			session.close();
		}
		if(cluster != null) {
			cluster.close();
		}
	}
	
	protected Session getSessionConnection(String keySpace) {
		Cluster cluster = this.getConnection();
		return cluster.connect(keySpace);
	}
	
	protected Session getDefaultConnection() {
		Cluster cluster = this.getConnection();
		return cluster.connect(schema);
	}
	
	protected void closeConnection(Cluster cluster) {
		if(cluster != null) {
			cluster.close();
		}
	}
	
	protected void closeConnection(Session session) {
		if(session != null) {
			Cluster cluster = session.getCluster();
			session.close();
			cluster.close();
		}
	}
}
