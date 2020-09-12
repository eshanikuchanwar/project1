package com.birlasoft.customerportal.service;
import com.birlasoft.customerportal.model.purchaseVO;
/*
 * Purchase BusinessOject class
 * ValidatePurchaseID() returns boolean value
 * painting id must begin with O-
 */

public class purchaseBO {
	
	public static boolean ValidateOrderID(purchaseVO purchase) 
	{
		
		boolean result=false;
		if(purchase.getOrderId().length()>0)
		{
			if(purchase.getOrderId().substring(0,2).equals("O-"))
					{
						result=true;
					}
			else
			{
				System.out.println("Order Id must begin with O- !! and length less than 20 characters");
			}
				
		}
		return result;
		
	}
	

}
