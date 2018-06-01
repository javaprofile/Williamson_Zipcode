package com.wson.codingchallenge.Zipcode;

import org.testng.annotations.Test;

import com.wson.codingchallenge.Zipcode.exception.ZipcodeException;

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
