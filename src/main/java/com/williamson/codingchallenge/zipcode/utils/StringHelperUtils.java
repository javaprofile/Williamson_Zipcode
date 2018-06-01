/**
 * 
 */
package com.williamson.codingchallenge.zipcode.utils;

import java.util.ArrayList;
import java.util.List;

import com.williamson.codingchallenge.zipcode.exception.ZipcodeException;




/**
 * @author BONDUGULAV
 *
 */
public class StringHelperUtils {

	/**
	 * 
	 */
	public StringHelperUtils() {
		//constructor
	}
	
	/**
	 * This method removes start and end square brackets for input and returns ranges in an array.
	 * @param str
	 * @param open
	 * @param close
	 * @return
	 */
	public static String[] substringBetween( final String[] input,
										final String open, 
										final String close ) {
		List<String> values = new ArrayList<String>( input.length );
		for( String str : input ) {
			final int start = str.indexOf( open );
	        if ( start != -1 ) {
	            final int end = str.indexOf( close );
	            if ( end != -1 ) {
	                values.add( str.substring( start + 1, end ) );
	            }
	        }
		}
        return values.toArray( new String[values.size()]);
    }
	
	/**
	 * This method check for empty array.
	 * @param input
	 * @throws ZipcodeException
	 */
	public static void isEmpty( final String[] input ) throws ZipcodeException {
		if( input == null || input.length == 0) 
			throw new IllegalArgumentException("No Input Found.");
	}
}
