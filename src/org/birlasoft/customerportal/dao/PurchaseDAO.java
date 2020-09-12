package org.birlasoft.customerportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.birlasoft.customerportal.model.purchaseVO;
import com.birlasoft.customerportal.util.ConnectionDB;
/*
 * DATA ACCESS LAYER
 * GenerateOrdder()()
 * displayOrderList()
 * deleteOrderRecord
 * searchOrderById()
 */



public class PurchaseDAO {

		
		public static int GenerateOrder(purchaseVO purchase) 
		{    
			
			int result=0;
			Connection con =null;
			String QUERY="INSERT INTO PURCHASE VALUES(?,?,?,?)";//insert order details
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
			
			//set string set string value to given parameter index
			                 pStat.setString(1, purchase.getOrderId());
			                 pStat.setString(2, purchase.getCustomerId());
			                 pStat.setString(3, purchase.getPaintingId());
			                 pStat.setInt(4, purchase.getBillAmount());
			                 
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
		

		public static List<purchaseVO>  displayAllOrders()
		{
			String Query= "SELECT * FROM PURCHASE";
			Connection con=null;
			List<purchaseVO> orderList= new ArrayList<purchaseVO>();
			try
			{
	                    con =ConnectionDB.getDBConnection();
	                  //preparedStatement subInterface of Statement used to execute parameterized query
				PreparedStatement pStat= con.prepareStatement(Query);
				//prepareStatement() method of Connection interface is used to return the object of PreparedStatement
				 
				 ResultSet  result=  pStat.executeQuery();
				 
				    while(result.next())//positions pointer at the beginning
				    {
				    	 
				    	String order_id = result.getString(1);
				    	String customer_id = result.getString(2);
				    	String painting_id = result.getString(3);
				    	int bill_amount=result.getInt(4);
				    	
				    	purchaseVO purchase=new purchaseVO(order_id,customer_id,painting_id,bill_amount);
				    	orderList.add(purchase);
				    	
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
			
			
			return orderList;
			
		}
		
		
		public static List<purchaseVO>  searchOrderById(String order_id) 
		{
			ResultSet result = null;
	        Connection con=null;
	        
			String Query= "SELECT ORDER_ID,C_ID,P_ID,BILL_AMOUNT FROM PURCHASE WHERE ORDER_ID=?";
			List<purchaseVO> orderList= new ArrayList<purchaseVO>();
			
			try {
				
				con= ConnectionDB.getDBConnection();
				//preparedStatement subInterface of Statement used to execute parameterized query
					PreparedStatement pStat = con.prepareStatement(Query);
					//prepareStatement() method of Connection interface is used to return the object of PreparedStatement
					
					  pStat.setString(1,order_id);
					  result = pStat.executeQuery();
					  
					  while (result.next())
					  {
						  String order_id1 = result.getString(1);
					    	String customer_id = result.getString(2);
					    	String painting_id= result.getString(3);
					    	int bill_ammount=result.getInt(4);
					    	
					    	purchaseVO purchase=new purchaseVO(order_id1,customer_id,painting_id,bill_ammount);
					    	orderList.add(purchase);
					    	
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
			return orderList;
			
		}
		
		//delete order record
		public static int deleteOrderRecord(String order_id)
		{    
			
			int row=0;
			Connection con =null;
			PreparedStatement pStat=null;
			
			
			try
			{
			con= ConnectionDB.getDBConnection();//getConnection
			
			String 	QUERY=	"DELETE FROM PURCHASE WHERE ORDER_ID=?";
			
			//preparedStatement subInterface of Statement used to execute parameterized query
			pStat = con.prepareStatement(QUERY);
			pStat.setString(1, order_id);
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
