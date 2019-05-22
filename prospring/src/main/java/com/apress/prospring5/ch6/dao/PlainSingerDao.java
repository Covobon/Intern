package com.apress.prospring5.ch6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apress.prospring5.ch6.entities.Singer;

public class PlainSingerDao implements SingerDao{
    private static Logger logger = 
    		LoggerFactory.getLogger(PlainSingerDao.class);

    static {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException ex) {
    		logger.error("Prblem loading DB dDriver!", ex);
		}
	}

	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/musicdb?useSSL=true)", "prospring5" , "prospring5" );
	}

	private void closeConnection(Connection connection) {
    	if (connection == null){
    		return;
		}
    	try {
    		connection.close();
		}catch(SQLException ex) {
    		logger.error("Problem closing connection to the database!", ex);
		}
	}

	public List<Singer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Singer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findLastNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findFirstNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	public void update(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	public List<Singer> findAllWithDetial() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertWithDetail(String singer) {
		// TODO Auto-generated method stub
		
	}
}
