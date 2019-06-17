package com.database

import java.sql.DriverManager
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Driver
import java.sql.PreparedStatement
import org.postgresql.*;

import com.kms.katalon.core.annotation.Keyword
//import com.mysql.jdbc.Connection

public class DemoSQLPro {

	private static Connection connection = null;

	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */

	//Establishing a connection to the DataBase

	@Keyword

	def connectDB(String url, String dbname, String port, String username, String password){

		//Load driver class for your specific database type

		String conn = "jdbc:postgresql://" + url + ":" + port + "/" + dbname

//		if(connection != null && !connection.isClosed()){
//
//			connection.close()
//
//		}

		connection = DriverManager.getConnection(conn, username, password)
		if(connection != null){
			println(" ######   Database Connection is made successfully")
		}
		return connection

	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */

	//Executing the constructed Query and Saving results in resultset

	@Keyword

	def executeQuery(String queryString) {

		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		return rs

	}

	//Closing the connection

	@Keyword

	def closeDatabaseConnection() {

		if(connection != null && !connection.isClosed()){

			connection.close()

		}

		connection = null

	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */

	@Keyword

	def execute(String queryString) {

		Statement stm = connection.createStatement()

		boolean result = stm.execute(queryString)

		return result

	}

}


