

import java.util.List;
import java.util.Scanner;

import org.birlasoft.customerportal.dao.ArtistDAO;
import org.birlasoft.customerportal.dao.CustomerDAO;
import org.birlasoft.customerportal.dao.LoginCheckException;

import org.birlasoft.customerportal.dao.PaintingsDAO;
import org.birlasoft.customerportal.dao.PurchaseDAO;
import org.birlasoft.customerportal.dao.adminLoginDAO;

import com.birlasoft.customerportal.model.ArtistVO;
import com.birlasoft.customerportal.model.CustomerVO;
import com.birlasoft.customerportal.model.adminLoginVO;
import com.birlasoft.customerportal.model.paintingVO;
import com.birlasoft.customerportal.model.purchaseVO;
import com.birlasoft.customerportal.service.ArtistBO;
import com.birlasoft.customerportal.service.CustomerBO;
import com.birlasoft.customerportal.service.PaintingBO;
import com.birlasoft.customerportal.service.adminLoginBO;
import com.birlasoft.customerportal.service.purchaseBO;


public class Tester {
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {//MAIN
	     
		
		     Scanner  input= new Scanner(System.in);
		   //Login Check for user authentication
		     
		     
	         String loginReq="yes";
	         int loginCheck=0;
	         
	         //entering valid admin username and password
	         
	         
		     while(loginReq.equalsIgnoreCase("yes"))//loginCheck success
		     {
		    	 
				System.out.println("\n            ADMIN LOGIN             ");	     
					     
				System.out.println("\nPlease Enter your Credientials ");	
				
				System.out.println("-------------------------------------------------------------------------------");
		        System.out.println("-------------------------------------------------------------------------------");	  
				System.out.println("\n  User_Name:");
			    String userName=input.nextLine();
				         
				System.out.println("\n  Password Name:");   
				String password=input.nextLine();
				System.out.println("\n-------------------------------------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------------");
		         
	     adminLoginVO login = new adminLoginVO(userName,password);  
	     
	     //validating password    
		 boolean  loginValidate= adminLoginBO.isValid_password(login);
		  
		 if(loginValidate) // business logic success then adminLoginBO
		 {
			 try
			 {
			 loginCheck = adminLoginDAO.loginCheck(login);
			 }
			 catch(LoginCheckException e)//catch custom login check exception
			 {
				 System.out.println(e);
			 }
			 if(loginCheck==1)//loginCheck success
			 {
				 System.out.println("Entered credentials are valid!!\n");
				 System.out.println("-------------------------------------------------------------------------------");
				 System.out.println("***************** WELCOME TO ART GALLERY MANAGEMENT SYSTEM ****************\n");
				 break;
			 }
		 }
		 
		   System.out.println("InValid User_name or Password. Please enter correct credentials ");
		   
		   }//end of while
		     
	         boolean ServicesMenu=true;
		     while (ServicesMenu)
		     {
		    //services menu	 
		     System.out.println("SERVICES AVAILABLE  :\n");
		     
		     System.out.println("1.MANAGE CUSTOMER INFORMATION");
		     System.out.println("2.MANAGE PAINTINGS INFORMATION");
		     System.out.println("3.MANAGE ARTIST INFORMATION");
		     System.out.println("4.MANAGE ORDERS");
		     System.out.println("5.GENERATE BILL");
		     System.out.println("6.EXIT");
		      
		    
	         int selectService=Integer.parseInt(input.nextLine());
		     switch(selectService)
		     {
		     //customer menu
		     case 1 :
		     {
		    	 
		    	 String CustomerMenu="yes";
			     while(CustomerMenu.equalsIgnoreCase("yes"))
			     {
		    	 System.out.println("CUSTOMER MENU \n");
		    	 
		     System.out.println("1.ADD CUSTOMER");
		     System.out.println("2.DISPLAY ALL CUSTOMER DETAILS");
		     System.out.println("3.DELETE CUSTOMER RECORD");
		     System.out.println("4.SEARCH CUSTOMER");
		     System.out.println("5.UPDATE CUSTOMER INFORMATION");
		     
		     int customerMenu =Integer.parseInt(input.nextLine());
	                  
	         			if(customerMenu==1)//customer menu success add customer
		               
		               {
	         			
	         						// enter customer_id,firstName,lastName,customer_address,contactNo
					         		System.out.println("ADD NEW CUSTOMER DETAILS");
					         		System.out.println("Enter Customer Id 'Begin with C-' ");
						    	   String cid= input.nextLine();
						    	   
						    	   System.out.println("Enter Customer First Name");
						    	   String cFName= input.nextLine();
						    	   
						    	   System.out.println("Enter Customer Last Name");
						    	   String cLName= input.nextLine();
						    	   
						    	   System.out.println("Enter Customer Address");
						    	   String cAddress= input.nextLine();
						    	   
						    	   System.out.println("Enter Customer Contact number");
						    	   String cContact= input.nextLine();
						    	   
						    	   //parametarised customer call
						    	   
							        CustomerVO customer = new CustomerVO(cid,cFName,cLName,cAddress,cContact);
							    	 //validating customer id must begin with"C-" and length should be of  8 characters  
							    	boolean result=CustomerBO.ValidateCustomerID(customer);
							    	//validating customer contact number
							    	boolean result2=CustomerBO.validateCustomerContact(customer);
							    	//validating customer name
							    	boolean result3=CustomerBO.ValidateCustomerName(customer);
							    	//validating customer address
							    	boolean result4=CustomerBO.validateAddress(customer);

		    	   
		    	   if(result && result2 && result3 && result4)//customer id and contact number success
		    	   {
		    		  
		    		   //sending details to database
		    		   int daoResult=CustomerDAO.addCustomer(customer);
		    		   
		    		   if(daoResult>=1)//sending data to database success
		    		   {
		    		   System.out.println("CUSTOMER ADDEDD SUCCESSFULLY");
		    		   }
		    		   else
		    		   {
		    			   System.out.println("PROBLEM IN ADDING CUSTOMER");
		    		   }
		    		   
		    	   }
		    	   else//problem occurred while validating
		    	   {
		    		   System.out.println("PROBLEM WHILE VALIDATING !!");
		    	   }
		               }
		    	   
		    	   
		               //end of addCustomerDetails
		               
	         	 if(customerMenu==2)
	         		 
	         	 {
		            	   //display customers details
		               
		            	   		   System.out.println("DISPLAY ALL CUSTOMER RECORDS");
		            	   		   //Retrieving customer records from database 
		            	   		   
				            	   List<CustomerVO> customerList1=  CustomerDAO.displayCustomerList();
				 		    	  				 		    	  
				 		    	  for(CustomerVO customer1 : customerList1)//displaying all record
				 		    	  {
				 		    		  System.out.println(customer1+"\n");
				 		    	  }
		                
	         	 }//end of display customer
		               
	         	 if(customerMenu==3) 
	         		 
	         		 //deleting customer records by entering customer_id
	         	 {
		         	  
		         		  	System.out.println("ENTER CUSTOMER ID TO DELETE IT FROM DATABASE");
		         		  	
		         		    String s2=input.nextLine();
		         		    //fetching customer_id to fetch its record from database and delete it
		         		    int daoresult3=CustomerDAO.deleteCustomerRecord(s2);
		         		    
		         		    
		         		    if(daoresult3>=1)//deletion from database success
		         		    {
		         		    	System.out.println("Customer record deleted successfully");
		         		    }
		         		  			
		         		    else
		         		    {
		         		    	System.out.println("Problem in deleting customer record");
		         		    }
		         		  	
		        						
	         	 }//end of delete customer
		         		  
	         	 if(customerMenu==4) 
	         	 //search customer record by entering its id
	         	 
	         	 {
	         		 
									System.out.println("ENTER CUSTOMER ID TO VIEW ITS DETAILS");
									String customer_id=input.nextLine();
									
									//searching record from database by entering its id
									List<CustomerVO> cust=  CustomerDAO.searchCustomerById(customer_id);
									
									if(cust.isEmpty())//record not found in the database
									{
									System.out.println("Customer record not found!!");
									}
									else//record found
									{
										System.out.println("Customer record found!!");
										System.out.println(cust);
									}
					         		
	         	 }//end of search customer
	         	  
	         	 //update customer details 
	         	if(customerMenu==5) 
	         		
	         			{		   		  
	         						System.out.println("UPDATE CUSTOMER DETAILS");
						    	  
						    	   //enter customer id on which updation is to be done
						    		System.out.println("Enter customer id which you want to update");
	         						String customer_id=input.nextLine();
	         						//getting that customer record from database
							    		   int daoResult=CustomerDAO.updateCustomerDetails(customer_id);
							    		   
							    		   if(daoResult>=1)
							    		   {
							    		   System.out.println("CUSTOMER INFORMATION UPDATED SUCCESSFULLY");
							    		   }
							    		   else
							    		   {
							    			   System.out.println("PROBLEM IN UPDATING CUSTOMER DETAILS");
							    		   }
							    		  	   
							}//end of update customer
							    	 
	         	System.out.println("\n Do you want to continue into Customer Menu:(yes/no)");
		    	   CustomerMenu = input.nextLine();
			     } 
		       break;     
		               
		     }//end of customer menu
		     
		     
		     //paintimgs menu
		     case 2:
		     {
		    	 
		    	 String PaintingMenu="yes";
			     while(PaintingMenu.equalsIgnoreCase("yes"))
			     {
		    	 System.out.println("PAINTINGS MENU \n");
			     
			     System.out.println("1.ADD A PAINTING");
			     System.out.println("2.DISPLAY PAINTING DETAILS");
			     System.out.println("3.SEARCH PAINTING BY ITS ID ");
			     System.out.println("4.DELETE PAINTINGS RECORD");
			     System.out.println("5.UPDATE PAINTING INFORMATION");
			     
			     int paintingMenu =Integer.parseInt(input.nextLine());
		                  
		         			if(paintingMenu==1)//customer menu success add customer
			               
			               {
		         			
		         						// enter customer_id,firstName,lastName,customer_address,contactNo
						         		System.out.println("ADD NEW PAINTING DETAILS INTO DATABASE");
						         		
						         		System.out.println("Enter painting Id 'Begin with P-' ");
							    	   String p_id= input.nextLine();
							    	   
							    	   System.out.println("Enter Painting title");
							    	   String p_Title= input.nextLine();
							    	   
							    	   System.out.println("Enter Painting type");
							    	   String p_Type= input.nextLine();
							    	   
							    	   System.out.println("Enter Artist id");
							    	   String a_Id= input.nextLine();
							    	   
							    	   System.out.println("Enter Painting Price");
							    	   int price= Integer.parseInt(input.nextLine());
							    	   
							    	   //parametarised customer call
							    	   
								        paintingVO painting = new paintingVO(p_id,p_Title,p_Type,a_Id,price);
								    	 //validating painting id must begin with"P-" and length should be of  8 characters  
								    	boolean result12=PaintingBO.ValidatePaintingID(painting);
								    	

			    	   
			    	   if(result12)//painting id success
			    	   {
			    		  
			    		   //sending data to database
			    		   int daoResult1=0;
						   daoResult1 = PaintingsDAO.addpaintingDetails(painting);
			    		   
			    		   if(daoResult1>=1)//sending data to database success
			    		   {
			    		   System.out.println("PAINTING ADDEDD SUCCESSFULLY");
			    		   
			    		   }
			    		   else
			    		   {
			    			   System.out.println("PROBLEM IN ADDING PAINTING");
			    		   }
			    		   
			    	}
			    	   else
			    	   {
			    		   System.out.println("PROBLEM WHILE VALIDATING PAINTING DETAILS");
			    	   }
			              
		     
			               //end of addCustomerDetails
			            
			        }
		    	 if(paintingMenu==2)
		    		 
		         		 
		         	 {
			            	   //display paintings details
			               
			            	   		   System.out.println("DISPLAY ALL PAINTING RECORDS");
			            	   		   //Retrieving paintings records from database 
			            	   		   
					            	   List<paintingVO> paintingList1=  PaintingsDAO.displayPaintingList();
					 		    	  				 		    	  
					 		    	  for(paintingVO painting1 : paintingList1)
					 		    	  {
					 		    		  System.out.println(painting1+"\n");
					 		    	  }
			                
		         	 }//end of display paintings
		    	 
		    	 
		    	 if(paintingMenu==3) 
		         	 //search customer record by entering its id
		         	 
		         	 {
		         		 
										System.out.println("ENTER PAINTING ID TO VIEW ITS DETAILS");
										String painting_id=input.nextLine();
										//searching record from database by entering its id
										List<paintingVO> painting=  PaintingsDAO.searchPaintingById(painting_id);
										if(painting.isEmpty())//record not found in the database
										{
										System.out.println("painting dosent exists!!");
										}
										else//record found
										{
											System.out.println("Painting found!!");
											System.out.println(painting);
										}
						         		
		         	 }//end of search painting
		    	 
		    	 
		    	 if(paintingMenu==4) 
	         		 
	         		 //deleting painting records by entering customer_id
	         	 {
		         	  
		         		  	System.out.println("ENTER PAINTING ID TO DELETE IT FROM DATABASE");
		         		  	
		         		    String p_id=input.nextLine();
		         		    //fetching customer_id to fetch its record from database and delete it
		         		    int daoresult4=PaintingsDAO.deletePaintingRecord(p_id);
		         		    
		         		    
		         		    if(daoresult4>=1)//deletion from database success
		         		    {
		         		    	System.out.println("painting record deleted successfully");
		         		    }
		         		  			
		         		    else
		         		    {
		         		    	System.out.println("Problem in deleting painting !!");
		         		    }
		         		  	
		        						
	         	 }//end of delete painting
		    	 
		    	 System.out.println("\n Do you want to continue in Painting Menu:(yes/no)");
		    	   PaintingMenu = input.nextLine();
			     }
			               
		     break;
		     }
		     //end of case 2
		     
		     case 3:
		     {
		    	 
		    	 String ArtistMenu="yes";
			     while(ArtistMenu.equalsIgnoreCase("yes"))
			     {
		    	 System.out.println("ARTIST MENU \n");
			   
			     System.out.println("1.ADD NEW ARTIST");
			     System.out.println("2.DISPLAY ARTIST DETAILS");
			     System.out.println("3.SEARCH ARTIST BY ITS ID ");
			     System.out.println("4.UPDATE ARTIST INFORMATION");
			     
			     int artistMenu =Integer.parseInt(input.nextLine());
		                  
		         			if(artistMenu==1)//artist menu success add artist
			               
			               {
		         			
		         						// enter artist_id,artist_name,address
						         		System.out.println("ADD NEW ARTIST DETAILS INTO DATABASE");
						         		
						         		System.out.println("Enter artist Id 'Begin with A-' ");
							    	   String artist_id= input.nextLine();
							    	   
							    	   System.out.println("Enter Artist Name");
							    	   String artist_name= input.nextLine();
							    	   
							    	   System.out.println("Enter Artist address");
							    	   String address= input.nextLine();
							    	   
							    	   
							    	   //parametarised customer call
							    	   
								        ArtistVO artist = new ArtistVO(artist_id,artist_name,address);
								    	 //validating painting id must begin with"A-" and length should be of  8 characters  
								    	boolean result13=ArtistBO.ValidateArtistID(artist);
								    	//validating artist name
								    	boolean result2=ArtistBO.validateArtistName(artist);
								    	

								    	  
								    	   if(result13 && result2)//order id  success
								    	   {
								    		  
								    		   //sending data to database
								    		   int daoResult=ArtistDAO.addArtist(artist);
								    		   
								    		   if(daoResult>=1)//sending data to database success
								    		   {
								    		   System.out.println("ARTIST ADDEDD SUCCESSFULLY!!");
								    		   }
								    		   else
								    		   {
								    			   System.out.println("PROBLEM IN ADDING ARTIST DETAILS!!");
								    		   }
								    		   
								    	   }
								    	   else
								    	   {
								    		   System.out.println("PROBLEM IN VALIDATING ARTIST DETAILS");
								    	   }
		     
			               //end of addArtistDetails
			            
			        }
		         			
		         			
		    	 if(artistMenu==2)
		    		 
		         		 
		         	 {
			            	   //display artist details
			               
			            	   		   System.out.println("DISPLAY ALL ARTIST RECORDS");
			            	   		   //Retrieving paintings records from database 
			            	   		   
					            	   List<ArtistVO> artistList1=  ArtistDAO.displayArtistList();
					 		    	  				 		    	  
					 		    	  for(ArtistVO artist1 : artistList1)
					 		    	  {
					 		    		  System.out.println(artist1+"\n");
					 		    	  }
			                
		         	 }//end of display paintings
		    	 
		    	 
		    	 if(artistMenu==3) 
		         	 //search artist record by entering its id
		         	 
		         	 {
		         		 
										System.out.println("ENTER ARTIST ID TO VIEW ITS DETAILS");
										String artist_id1=input.nextLine();
										//searching record from database by entering its id
										List<ArtistVO> artist=  ArtistDAO.searchArtistById(artist_id1);
										if(artist.isEmpty())//record not found in the database
										{
										System.out.println("artist dosent exists!!");
										}
										else//record found
										{
											System.out.println("Artist found!!");
											System.out.println(artist);
										}
						         		
		         	 }//end of search artist
		    	 
		    	 
		    	
		    	 
		    	 if(artistMenu==4) 
		         		
      			{		   		  
      						System.out.println("UPDATE ARTIST DETAILS");
					    	  
					    	   
					    		System.out.println("Enter artist id to update its address");
      						String artist_id=input.nextLine();
      						
						    		   int daoResult= ArtistDAO.updateArtistDetails(artist_id);
						    		   
						    		   if(daoResult>=1)
						    		   {
						    		   System.out.println("ARTIST INFORMATION UPDATED SUCCESSFULLY");
						    		   }
						    		   else
						    		   {
						    			   System.out.println("PROBLEM IN UPDATING ARTIST DETAILS");
						    		   }
						    		  	   
						}//end of update artist
		    	 
		    	 System.out.println("\n Do you want to continue in Artist Menu:(yes/no)");
		    	   ArtistMenu = input.nextLine();
			     }
			               
		     break;
		     }
		     
		     //purchase menu
		     case 4:
		     	{
		    	 
		    	 String PurchaseMenu="yes";
			     while(PurchaseMenu.equalsIgnoreCase("yes"))
			     {
		    	 System.out.println("PURCHASE MENU \n");
			     
			     //System.out.println("1.GENERTAE ORDER");
			     System.out.println("1.DISPLAY ALL ORDERS");
			     System.out.println("2.SEARCH ORDER BY ITS ID ");
			     System.out.println("3.DELETE ORDER RECORD");
			     
			     
			     int purchaseMenu =Integer.parseInt(input.nextLine());
		                  
		         			
		    	 if(purchaseMenu==1)
		    		 
		         		 
		         	 {
			            	   //display all orders
			               
			            	   		   System.out.println("DISPLAY ALL PAST ORDERS");
			            	   		   //Retrieving order records from database 
			            	   		   
					            	   List<purchaseVO> orderList=  PurchaseDAO.displayAllOrders();
					 		    	  				 		    	  
					 		    	  for(purchaseVO order1 : orderList)
					 		    	  {
					 		    		  System.out.println(order1+"\n");
					 		    	  }
			                
		         	 }//end of display paintings
		    	 
		    	 
		    	 if(purchaseMenu==2) 
		         	 //search order record by entering its id
		         	 
		         	 {
		         		 
										System.out.println("ENTER ORDER ID BEGIN WITH 'O-' TO VIEW THAT ORDER RECORD");
										String order_id=input.nextLine();
										//searching record from database by entering its id
										List<purchaseVO> order=  PurchaseDAO.searchOrderById(order_id);
										
										if(order.isEmpty())//record not found in the database
										{
										System.out.println("No such order exists!!");
										}
										else//record found
										{
											System.out.println("Order record found!!");
											System.out.println(order);
										}
						         		
		         	 }//end of search 
		    	 
		    	 
		    	 if(purchaseMenu==3) 
	         		 
	         		 //deleting order records by entering order_id
	         	 {
		         	  
		         		  	System.out.println("ENTER ORDER ID TO DELETE IT FROM DATABASE");
		         		  	
		         		    String order_id=input.nextLine();
		         		    //fetching order_id to fetch its record from database and delete it
		         		    
		         		    int daoresult=PurchaseDAO.deleteOrderRecord(order_id);
		         		    
		         		    
		         		    if(daoresult>=1)//deletion from database success
		         		    {
		         		    	System.out.println("Order record deleted successfully");
		         		    }
		         		  			
		         		    else
		         		    {
		         		    	System.out.println("Problem in deleting Order record!!");
		         		    }
		         		  	
		        						
	         	 }//end of delete 
		    	 
		    	 System.out.println("\n Do you want to continue in Purchase Menu:(yes/no)");
		    	   PurchaseMenu = input.nextLine();
			     }
			               
		     break;
		     }
		     	
		     case 5:{
		    	 
		    	 System.out.println("1.GENERTAE BILL ");
		    	 
		    	 int billMenu =Integer.parseInt(input.nextLine());
		    	 if(billMenu==1)//BILL MENU success generate order
		               
	               {
       			
       						// enter order_id,customer_id,painting_id,bill_amount
				         		System.out.println("GENERATE A ORDER");
				         		
				         		System.out.println("Enter order Id 'Begin with O-' ");
					    	   String order_id= input.nextLine();
					    	   
					    	   System.out.println("Enter customer id 'Begin with C-'");
					    	   String customer_id= input.nextLine();
					    	   
					    	   System.out.println("Enter painting id 'Begin with P-'");
					    	   String painting_id= input.nextLine();
					    	   
					    	   System.out.println("Enter Bill Ammount");
					    	   int billAmmount= Integer.parseInt(input.nextLine());
					    	 
					    	   
					    	   //parametarised customer call
					    	   
						        purchaseVO purchase = new purchaseVO(order_id,customer_id,painting_id,billAmmount);
						        
						        
						    	
						   //validating order id must begin with"O-" and length should be of  8 characters  
						    	boolean result7=purchaseBO.ValidateOrderID(purchase);
						    
	    	   
	    	   if(result7)//order id success
	    	   {
	    		  
	    		   //sending data to database
	    		   int daoResult1=0;
				   daoResult1 = PurchaseDAO.GenerateOrder(purchase);
	    		   
	    		   if(daoResult1>=1)//sending data to database success
	    		   {
	    		   System.out.println("ORDER ACCEPTED");
	    		   
	    		   System.out.println(purchase+"\n");
	    		   
	    		   }
	    		   else
	    		   {
	    			   System.out.println("PROBLEM IN GENERATING ORDER");
	    		   }
	    		   
	    	}
	    	   else//problem occurred while sending data to database
	    	   {
	    		   System.out.println("PROBLEM WHILE ADDING ORDER DETAILS INTO THE DATABASE");
	    	   }
	            
	               
	               //end of addOrderDetails
	            
	        }
		    	 
		    	 
		    	 break;
		     }
		    	 
		     case 6:
		     {
		    	 System.out.println("exited from SERVICES");
		    	 
		         ServicesMenu=false;
		    break;
		    
		     
		     } //end of services available
		     
		     } //end of switch
		     
		     }// end of while loop
	}
	

}
