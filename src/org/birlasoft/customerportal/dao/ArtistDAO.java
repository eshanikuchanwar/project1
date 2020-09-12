package org.birlasoft.customerportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.birlasoft.customerportal.model.ArtistVO;
import com.birlasoft.customerportal.util.ConnectionDB;
/*
 * DATA ACCESS LAYER
 * addArtist()
 * displayArtistList()
 * deleteArtistRecord
 * updateArtistDetails()
 */



public class ArtistDAO {
	public static int addArtist(ArtistVO artist)
	{    
		
		int result=0;
		Connection con =null;
		String QUERY="INSERT INTO ARTIST VALUES(?,?,?)";//insert values 
		try
		{
		ConnectionDB.loadDrivers();///throws CustomerDatabaseException
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
		                 pStat.setString(1, artist.getArtist_id());
		                 pStat.setString(2, artist.getArtist_name());
		                 pStat.setString(3, artist.getAddress());
		                 
		                result= pStat.executeUpdate();
		                
		                
		
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in customer database connection:"+e);
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
	
	
	
	
	public static List<ArtistVO>  displayArtistList()
	{
		String Query= "SELECT * FROM ARTIST";
		Connection con=null;
		List<ArtistVO> artistList= new ArrayList<ArtistVO>();
		try
		{
                    con =ConnectionDB.getDBConnection();//throws CustomerDatabaseException
                  //preparedStatement subInterface of Statement used to execute parameterized query
			PreparedStatement pStat= con.prepareStatement(Query);
			 
			 ResultSet  result=  pStat.executeQuery();
			 
			    while(result.next())
			    {
			    	 //result.getString("cid");
			    	String artist_id = result.getString(1);
			    	String artist_name = result.getString(2);
			    	String address = result.getString(3);
			    	
			    	ArtistVO artist=new ArtistVO(artist_id,artist_name,address);
			    	artistList.add(artist);
			    	
			    }
			
			
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in fetching customer:"+ e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in oracle query:"+e);
		}
		
		
		return artistList;
		
	}
	
	public static List<ArtistVO>  searchArtistById(String artist_id) 
	{
		ResultSet result = null;
        Connection con=null;
        
		String Query= "SELECT ARTIST_ID,ARTIST_NAME,ADDRESS FROM ARTIST WHERE ARTIST_ID=?";
		List<ArtistVO> artistList= new ArrayList<ArtistVO>();
		
		try {
			
			con= ConnectionDB.getDBConnection();//throws CustomerDatabaseException
			//preparedStatement subInterface of Statement used to execute parameterized query
				PreparedStatement pStat = con.prepareStatement(Query);
				
				  pStat.setString(1,artist_id);
				  result = pStat.executeQuery();
				  
				  while (result.next())
				  {
					  String artist_id1 = result.getString(1);
				    	String artist_name = result.getString(2);
				    	String address = result.getString(3);
				    	
				    	ArtistVO artist1=new ArtistVO(artist_id1,artist_name,address);
				    	artistList.add(artist1);
				    	
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
		return artistList;
		
	}
	
	
	
	
	
	public static int updateArtistDetails(String artist_id)
	{    
		
		int result=0;
		Connection con =null;
		String QUERY="UPDATE  ARTIST SET ADDRESS=? WHERE ARTIST_ID=?";
		
		try
		{
		con= ConnectionDB.getDBConnection();//throws CustomerDatabaseException
		
		ArtistVO artist=new ArtistVO();
		
		@SuppressWarnings("resource")
		Scanner scc=new Scanner(System.in);
		
		System.out.println("Enter new address");
		String address=scc.nextLine();
		
		
		artist.setAddress(address);
		artist.setArtist_id(artist_id);;
		//preparedStatement subInterface of Statement used to execute parameterized query
		PreparedStatement pStat = con.prepareStatement(QUERY);
									pStat.setString(1, artist.getAddress());
									pStat.setString(2, artist_id);
		                
		                result= pStat.executeUpdate();
		 }
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in updating customer:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in sql connection:"+e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
		return result;
	}
	
	
	
	

}
