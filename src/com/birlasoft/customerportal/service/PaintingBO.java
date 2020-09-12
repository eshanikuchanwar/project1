package com.birlasoft.customerportal.service;
import com.birlasoft.customerportal.model.paintingVO;
/*
 * Painting BusinessOject class
 * ValidatePaintingID() returns boolean value
 * painting id must begin with P-
 */

public class PaintingBO {
	
	public static boolean ValidatePaintingID(paintingVO painting) 
	{
		
		boolean result=false;
		
			if(painting.getPaintingId().substring(0, 2).equals("P-") )
			{
				result=true;
			}
			else 
			{
				System.out.println("Painting id must begin with 'P-' and length less than 20 characters !!");
			}
		
		return result;
		
	}
	

}
