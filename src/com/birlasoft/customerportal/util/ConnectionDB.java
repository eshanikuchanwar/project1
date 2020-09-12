package com.birlasoft.customerportal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.birlasoft.customerportal.dao.CustomerDatabaseException;

public class ConnectionDB {
	
	//loading all the drivers
	private static Connection  con;
	public static void loadDrivers() throws CustomerDatabaseException
	{
			   try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");//loading drivers
				}
				catch(ClassNotFoundException e)//forName throws ClassNotFound exception
				{
					//custom exception CustomerDatabaseException
					throw new CustomerDatabaseException("Problem encountered while loading drivers");
				}
	}
	
  //establishing connection to database	
  //is used to establish the connection with the specified url, username and password.
  public static  Connection  getDBConnection() throws CustomerDatabaseException {
			  
			  try{
				  		
					  String url="jdbc:oracle:thin:@localhost:1521:orcl" ;
					  
					  //enter valid url ,user_name and password
					  //driver manager class acting as interface between user and driver
					  con = DriverManager.getConnection(url,"System","9146086813e"); 
				 }
				 catch(SQLException e)//get connection throws this exception
			     {
						  throw new CustomerDatabaseException("Problem encountered while establishing connection");
				 }
					  return con;
  }
  
  //close database connection
  public static void closeDBConnection(Connection con)  {
				  try
				  {
				   if(con!=null)
				   {
					   con.close();
				   }
				  }
				  catch(SQLException e)
				  {
					  System.out.println("problem in closing connection"+e);
				  }
  }
  	
}
