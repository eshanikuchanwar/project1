package org.birlasoft.customerportal.dao;
/*
 * custom exception class
 * CustomerDatabaseexception class
 * to have our own exception and message
 */
public class CustomerDatabaseException extends Exception {
	
	

	public CustomerDatabaseException(String msg)
	{
		super(msg);//initialize exceptions error msg
	}
	public CustomerDatabaseException(Throwable error)
	{
		super(error);
	}
	 	

}
