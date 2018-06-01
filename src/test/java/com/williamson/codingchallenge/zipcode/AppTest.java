package com.williamson.codingchallenge.zipcode;

import org.testng.annotations.Test;

import com.williamson.codingchallenge.zipcode.exception.ZipcodeException;


/**
 * Unit test for standalone single threaded Application.
 */
public class AppTest 
{
	@Test
    public void testMain() throws ZipcodeException {
    	String[] args = {};
    	App.main( args );
    }
}
