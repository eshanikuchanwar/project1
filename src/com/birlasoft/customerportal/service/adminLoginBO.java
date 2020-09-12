package com.birlasoft.customerportal.service;

import com.birlasoft.customerportal.model.adminLoginVO;
/*
 
*/



// for checking if password length 
// is less than 20
//pass word must contain at least one upper_case and at least one lower_case character in it
//it should contain one special case character in it
public class adminLoginBO {

	 
	    public static boolean isValid_password (adminLoginVO login) 
	    { 
	  
	    	
	    	if(login.getPassword().length()>0)
	    	{
	        if ( login.getPassword().length() <= 20) { 
	            return true; 
	        } 
	        else
	        {
	        	System.out.println("Length of password must be less than 20");
	        }
	  
	        // to check space 
	        if (login.getPassword().contains(" ")) { 
	            return false; 
	        } 
	        
	        if (true) { 
	            int count = 0; 
	  
	            // check digits from 0 to 9 
	            for (int i = 0; i <= 9; i++) { 
	  
	                // to convert integer to string 
	                String str1 = Integer.toString(i); 
	  
	                if (login.getPassword().contains(str1)) { 
	                    count = 1; 
	                } 
	            } 
	            
	            if (count == 0) { 
	                return false; 
	            } 
	        } 
	  
	        
	  
	        if (true) { 
	            int count = 0; 
	  
	            // checking capital letters 
	            for (int i = 65; i <= 90; i++) { 
	  
	                // type casting 
	                char c = (char)i; 
	                String str1 = Character.toString(c); 
	                
	                if (login.getPassword().contains(str1)) { 
	                    count = 1; 
	                } 
	            } 
	            if (count == 0) {
	            	System.out.println("Password must  contain atleast one  upper_case character in it ");
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
	  
	                if (login.getPassword().contains(str1)) { 
	                    count = 1; 
	                } 
	            } 
	            if (count == 0) { 
	            	
	            	System.out.println("Password must contain atleast one lower_case character in it ");
	                return false; 
	                
	            } 
	        }
			
	        // if all conditions fails 
	       
	    } 
	    	 
	    	
			return false;
	    	
	    }
 }

	

