package org.birlasoft.customerportal.dao;
/*
 * custom exception class
 * LoginCheckException class
 * to have our own exception and message
 */
public class LoginCheckException extends Exception {

				
				public	LoginCheckException(String msg)
				{
					super(msg);
					
				}
				public	LoginCheckException(Throwable e)
				{
					super(e);
				}
				
}
