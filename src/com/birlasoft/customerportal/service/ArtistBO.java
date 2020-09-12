package com.birlasoft.customerportal.service;

import com.birlasoft.customerportal.model.ArtistVO;

/*
 * Artist BusinessOject class
 * ValidateArtistID() returns boolean value
 * VaidateArtistName()returns boolean value
 * 
 */

//ValidateArtsitId()
// Artist id must begin with A-
public class ArtistBO {
	public static boolean ValidateArtistID(ArtistVO artist) 
	{
		
		boolean result=false;
		if(artist.getArtist_id().length()>0)
		{
			if(artist.getArtist_id().substring(0, 2).equals("A-") )
					{
						result=true;
					}
			else
			{
				System.out.println("Artist id should begin with A- ");
			}
				
		}
		return result;
		
	}

	//ValidateArtistName()
	//length less than 20
	//name must not contain digit
	public static boolean validateArtistName(ArtistVO artist) {
		boolean result=false;
		
		if(artist.getArtist_name().length()<=20)
		{
			result=true;
		}
		else
		{
			System.out.println("Length of artist name should be less than or equal to 20 characters");
		}
		if(true)
		{
			int count=0;
		
		if(artist.getArtist_name().matches("[0-9]"))
		{
			count=1;
		}
		if(count==0)
		{
			System.out.println("Artist name cannot contain digit");
            return false; 
		}
		
	}
		
		return result;
	}

}
