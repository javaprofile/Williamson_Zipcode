/**
 * 
 */
package com.williamson.codingchallenge.zipcode.utils;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class is used to test StringHelperUtils
 * @author BONDUGULAV
 *
 */
public class StringHelperUtilsTest {

	/**
	 * 
	 */
	public StringHelperUtilsTest() {
		
	}
	@DataProvider
	public static final Object[][] substringBetweenDataProvider() 
	{
		String[] output = new String[1];
		output[0] = "95670,95678";
		String[] input = {"[95670,95678]"};
		return new Object[][]
				{
					
					{input,"[","]",output}
				};
	}
	
	/**
	 * This method tests StringHelperUtils.substringBetween method.
	 * @param input
	 * @param open
	 * @param close
	 * @param expected
	 */
	@Test(dataProvider="substringBetweenDataProvider")
	public void substringBetweenTest( String[] input,String open,String close,String[] expected ) {
		String[] actual = StringHelperUtils.substringBetween(input, open, close);
		Assert.assertArrayEquals(expected, actual);
	}
}
