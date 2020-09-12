package com.birlasoft.customerportal.service;
import com.birlasoft.customerportal.model.CustomerVO;
/*
 * Customer BussinessObject class
 * validateCustomerId()
 * ValidateCustomerConatct()
 * ValidateCautomerName()
 * ValidateAddress()
 */


/*
 * ValidateCutsomerId method
 * customer id must begin with C-
 */
public class CustomerBO {

	public static boolean ValidateCustomerID(CustomerVO customer) 
	{
		
		boolean result=false;
		
		
			if(customer.getCustomerId().substring(0, 2).equals("C-") )
					{
						result=true;
					}
			else
			{
				System.out.println("Customer ID should begin with C-");
			}
		
		return result;
		
	}
	
	/*
	 * validateCustomerContact()
	 * length of customer contact must be of 10 characters
	 * it should not contain any special character in it
	 * It should not contain capital or small case characters in it
	 */
	
	public static boolean validateCustomerContact(CustomerVO customer)
	{
		Boolean result1= false;
		
		//length must be of 10 characters
			if(customer.getCustomerPhoneNumber().length()==10)
			{
				
				result1=true;
			}	
			else {
				System.out.println("Length of phone number must be of 10 digits");
			}
			
			  // for special characters 
	        if ((customer.getCustomerPhoneNumber().contains("@") || customer.getCustomerPhoneNumber().contains("#") 
	              || customer.getCustomerPhoneNumber().contains("!") || customer.getCustomerPhoneNumber().contains("~") 
	              ||  customer.getCustomerPhoneNumber().contains("$") || customer.getCustomerPhoneNumber().contains("%") 
	              || customer.getCustomerPhoneNumber().contains("^") || customer.getCustomerPhoneNumber().contains("&") 
	              || customer.getCustomerPhoneNumber().contains("*") || customer.getCustomerPhoneNumber().contains("(") 
	              || customer.getCustomerPhoneNumber().contains(")") ||customer.getCustomerPhoneNumber().contains("-") 
	              || customer.getCustomerPhoneNumber().contains("+") || customer.getCustomerPhoneNumber().contains("/") 
	              || customer.getCustomerPhoneNumber().contains(":") || customer.getCustomerPhoneNumber().contains(".") 
	              || customer.getCustomerPhoneNumber().contains(", ") || customer.getCustomerPhoneNumber().contains("<") 
	              || customer.getCustomerPhoneNumber().contains(">") || customer.getCustomerPhoneNumber().contains("?") 
	              || customer.getCustomerPhoneNumber().contains("|")))
	        { 
	        	System.out.println("Phone number consists of a special character in it!!");
	            return false; 
	        } 
			
	        
			if (true) { 
	            int count = 0; 
	  
	            // check capital letters 
	            for (int i = 65; i <= 90; i++) { 
	  
	                // type casting 
	                char c = (char)i; 
	                String str1 = Character.toString(c); 
	                
	                if (customer.getCustomerPhoneNumber().contains(str1)) { 
	                    count = 1; 
	                } 
	            } 
	            if (count == 1) {
	            	System.out.println("Phone number contains  upper_case character in it ");
	                return false; 
	            } 
	            
	        } 
	        
	        if (true) { 
	            int count = 0; 
	  
	            //checking small letters 
	            for (int i = 90; i <= 122; i++) { 
	  
	                // type casting 
	                char c = (char)i; 
	                String str1 = Character.toString(c); 
	  
	                if (customer.getCustomerPhoneNumber().contains(str1)) { 
	                    count = 1; 
	                } 
	            } 
	            if (count == 1) { 
	            	
	            	System.out.println("Phone number contains lower_case character in it ");
	                return false; 
	                
	            } 
	        }
			
			
		
		return result1;
	}
	
	
	/*
	 * ValidateAddress()
	 * length should be of 20 characters
	 */
	public static boolean validateAddress(CustomerVO customer) {
		boolean result=false;
		
		if(customer.getCustomerAddress().length()<=20) {
			
			
			result=true;
			
		}
		else
		{
			
		System.out.println("Length of address must be less than 20 characters");
		}
		
		
		return result;
	}
	
	/*
	 * ValidateCustomerName()
	 * length should be of 20 characters
	 * it should not contain digits in it
	 */
	public static boolean ValidateCustomerName(CustomerVO customer) {
		
		boolean result2=false;
		//check length
		if(customer.getCustomer_F_Name().length()<=20 && customer.getCustomer_L_Name().length()<=20)
		{
			result2=true;
		}
		else 
		{
			System.out.println("Length of first name and last name should be less than or equal to 20 characters");
		}
		//check digits
		if(true)
		{
			int count=0;
		
		if(customer.getCustomer_F_Name().matches("[0-9]") && customer.getCustomer_L_Name().matches("[0-9]"))
		{
			count=1;
		}
		if(count==0) {
			System.out.println("name cannot have digit in it");
			return false;
		}
		} 
		
		 return result2;
	}
	
	

	
	
	
}