package org.birlasoft.customerportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.birlasoft.customerportal.model.paintingVO;
import com.birlasoft.customerportal.util.ConnectionDB;

/*
 * DATA ACCESS LAYER
 * addPaintingDetials()
 * displayPaintingList()
 * deletePaintingRecord
 * searchPaintingById()
 */


public class PaintingsDAO {
	
	//private static  Connection con;
	
	public static int addpaintingDetails(paintingVO painting) 
	{    
		
		int result=0;
		Connection con =null;
		String QUERY="INSERT INTO PAINTINGS VALUES(?,?,?,?,?)";//insert painting details
		try
		{
		ConnectionDB.loadDrivers();//throws CustomerDatabaseException
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in loading connection"+e);
		}
		
		try
		{
		con= ConnectionDB.getDBConnection();
		
		//preparedStatement subInterface of Statement used to execute parameterized query
		PreparedStatement pStat = con.prepareStatement(QUERY);
		//prepareStatement() method of Connection interface is used to return the object of PreparedStatement
		
		//setString sets the String value to the given parameter index.
		                 pStat.setString(1, painting.getPaintingId());
		                 pStat.setString(2, painting.getPaintingTitle());
		                 pStat.setString(3, painting.getPaintingType());
		                 pStat.setString(4, painting.getArtistId());
		                 pStat.setInt(5, painting.getPrice());
		                result= pStat.executeUpdate();
		                
		                
		
		}
		catch(CustomerDatabaseException e)
		{
			
			System.out.println("problem in connection:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in oracle query:"+e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
		
		return result;
	}
	
	
	public static List<paintingVO>  displayPaintingList()
	{
		String Query= "SELECT * FROM PAINTINGS";
		Connection con=null;
		List<paintingVO> paintingList= new ArrayList<paintingVO>();
		try
		{
                    con =ConnectionDB.getDBConnection();
            //preparedStatement subInterface of Statement used to execute parameterized query
			PreparedStatement pStat= con.prepareStatement(Query);
			//prepareStatement() method of Connection interface is used to return the object of PreparedStatement
			 ResultSet  result=  pStat.executeQuery();
			 
			    while(result.next())//positions pointer to starting index
			    {
			    	 //fetching details from database
			    	String p_Id = result.getString(1);
			    	String p_title = result.getString(2);
			    	String p_type = result.getString(3);
			    	String artist_id=result.getString(4);
			    	int p_price = result.getInt(5);
			    	paintingVO painting=new paintingVO(p_Id,p_title,p_type,artist_id,p_price);
			    	paintingList.add(painting);//adding current painting into list
			    	
			    }
			
			
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in fetching customer:"+ e);
		}
		catch(SQLException e)//catch sql query
		{
			System.out.println("problem in oracle query:"+e);
		}
		
		
		return paintingList;
		
	}
	
	
	// search painting by entering its id
	public static List<paintingVO>  searchPaintingById(String painting_id) 
	{
		ResultSet result = null;
        Connection con=null;
        
		String Query= "SELECT P_ID,P_TITLE,P_TYPE,ARTIST_ID,P_PRICE FROM PAINTINGS WHERE P_ID=?";
		List<paintingVO> paintingList= new ArrayList<paintingVO>();
		
		try {
			
			con= ConnectionDB.getDBConnection();
			//preparedStatement subInterface of Statement used to execute parameterized query
				PreparedStatement pStat = con.prepareStatement(Query);
		    //prepareStatement() method of Connection interface is used to return the object of PreparedStatement
				
				//setString sets the String value to the given parameter index.
				  pStat.setString(1,painting_id);
				  result = pStat.executeQuery();
				  
				  while (result.next())//positions poinnter to starting index
				  {
					  //fetching paintings details from database
					  String p_Id = result.getString(1);
				    	String p_title = result.getString(2);
				    	String p_type = result.getString(3);
				    	String artist_id=result.getString(4);
				    	int p_price = result.getInt(5);
				    	paintingVO painting1=new paintingVO(p_Id,p_title,p_type,artist_id,p_price);
				    	paintingList.add(painting1);
				    	
				  }
		} 
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in connection:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in connection:"+e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
		return paintingList;
		
	}
	
	public static int deletePaintingRecord(String p_id)
	{    
		
		int row=0;
		Connection con =null;
		PreparedStatement pStat=null;
		
		
		try
		{
		con= ConnectionDB.getDBConnection();
		
		String 	QUERY=	"DELETE FROM PAINTINGS WHERE P_ID=?";
		//preparedStatement subInterface of Statement used to execute parameterized query
		pStat = con.prepareStatement(QUERY);
		//prepareStatement() method of Connection interface is used to return the object of PreparedStatement
		pStat.setString(1, p_id);
		row= pStat.executeUpdate();
		
		                
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in deleting customer:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in sql query:"+e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
		
		return row;
	}
	
	
	
	

}
