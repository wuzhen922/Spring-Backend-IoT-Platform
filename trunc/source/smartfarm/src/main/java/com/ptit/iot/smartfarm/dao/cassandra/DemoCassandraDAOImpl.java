package com.ptit.iot.smartfarm.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.ptit.iot.smartfarm.entities.Greeting;

public class DemoCassandraDAOImpl extends BaseCassandraDAO {
	
	private static DemoCassandraDAOImpl instance;
	public static DemoCassandraDAOImpl getInstance() {
		if(instance == null) instance = new DemoCassandraDAOImpl();
		return instance;
	}

	private DemoCassandraDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Greeting> getAll() {
		Session session = null;
		ResultSet rs = null;
		List<Greeting> lst = new ArrayList<>();
		Greeting greet = null;
		
		String cql = "SELECT * FROM TB1";
		try {
			session = getDefaultConnection();
			rs = session.execute(cql);
			for(Row row : rs) {
				greet = new Greeting();
				greet.setId(row.getInt("id"));
				greet.setContext(row.getString("context"));
				lst.add(greet);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(session);
		}
		
		return lst;
	}
	
	public void createTestTable(String tableName) {
		Session session = null;
		PreparedStatement pre = null;
		try {
			String cql = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n"
					+ "id int primary key, \n"
					+ "context text);";
			
			session = getDefaultConnection();
			pre = session.prepare(cql);
			BoundStatement bound = pre.bind();
			session.execute(bound);
			System.out.println("Create table complete");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(session);
		}
	}
	
	public void insertNewContext(String context) {
		Session session = null;
		PreparedStatement pre = null;
		try {
			String cql = "INSERT INTO TB1 (id, context) values(?, ?);";
			session = getDefaultConnection();
			pre = session.prepare(cql);
			BoundStatement bound = pre.bind();
			bound.setInt(0, Greeting.getNextId());
			bound.setString(1, context);
			session.execute(bound);
			System.out.println("Insert into table TB1 complete");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(session);
		}
	}
	
	public void deleteById(int id) {
		Session session = null;
		PreparedStatement pre = null;
		try {
			String cql = "DELETE FROM TB1 WHERE ID = ?;";
			session = getDefaultConnection();
			pre = session.prepare(cql);
			BoundStatement bound = pre.bind();
			bound.setInt(0, id);
			session.execute(bound);
			System.out.println("Delete from table TB1 complete");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(session);
		}
	}
	
	public void updateById(int id, String context) {
		Session session = null;
		PreparedStatement pre = null;
		try {
			String cql = "UPDATE TB1 SET CONTEXT = ? WHERE ID = ?;";
			session = getDefaultConnection();
			pre = session.prepare(cql);
			BoundStatement bound = pre.bind();
			bound.setString(0, context);
			bound.setInt(1, id);
			session.execute(bound);
			System.out.println("Update from table TB1 complete");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(session);
		}
	}
}
