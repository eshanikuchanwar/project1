package org.birlasoft.customerportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
import com.birlasoft.customerportal.model.adminLoginVO;
import com.birlasoft.customerportal.util.ConnectionDB;
/*
 * Data access layer
 * adminLogin dao class
 * loginCheck()return int
 * display admin login details
 */


public class adminLoginDAO {
	
	public static int loginCheck(adminLoginVO login) throws LoginCheckException
	{    int result=0;
		Connection con =null;
		String QUERY="select user_name, password  from adminLogin where user_name=? and password=? ";
		try
		{
		ConnectionDB.loadDrivers();//loading drivers
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in loading connection"+e);
		}
		
		try
		{
		con= ConnectionDB.getDBConnection();//connection with database
		
		//preparedStatement subInterface of Statement used to execute parameterized query
		PreparedStatement pStat = con.prepareStatement(QUERY);
		
		//setString sets the String value to the given parameter index.
		//trim eliminates leading and trailing spaces 
		                 pStat.setString(1, login.getUserName().trim());
		                 pStat.setString(2, login.getPassword().trim());
		                
		////resultSet represents a database result set                 
		                ResultSet loginResult= pStat.executeQuery();
		                
		       if(loginResult.next())//resultSet object loginResult maintains a cursor pointing to its current row.
		    	   					 //initially its is positioned before first row
		                	
		                	
		                {
		                	result=1;
		                }
		                else
		                {
		                	System.out.println("no such record present");
		                }
		                 
		
		}
		catch(CustomerDatabaseException e)//handling exception
		{
			
			 throw new LoginCheckException(e);
		}
		catch(SQLException e)//sql exception
		{
			System.out.println("problem in connection:"+e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);//closing connection 
		}
		
		
		return result;
	}
	

}
