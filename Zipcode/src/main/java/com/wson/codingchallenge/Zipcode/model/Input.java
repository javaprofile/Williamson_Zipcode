/**
 * 
 */
package com.wson.codingchallenge.Zipcode.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.wson.codingchallenge.Zipcode.exception.ZipcodeException;
import com.wson.codingchallenge.Zipcode.utils.StringHelperUtils;

/**
 * This class takes command-line arguments as input, processes ranges between square brackets to 
 * a list of integer array.
 * @author BONDUGULAV
 *
 */
public class Input {

	private final String[] input;
	/**
	 * 
	 */
	public Input( String[] input ) {
		this.input = input;
	}

	/**
	 * This method removes square brackets and stores data in list of integer array.
	 * @return
	 * @throws ZipcodeException 
	 */
	public List<int[]> processInputArgsToList() throws ZipcodeException {
		String[] ranges = StringHelperUtils.substringBetween( input, "[", "]");
		//iterate ranges, split by comma separated , convert the string array to integer array and add it to a list.
		List<int[]> rangesList = splitStringToArray( ranges );
		return rangesList;
	}
	
	/**
	 * This method splits string to integer array
	 * @param ranges
	 * @return
	 * @throws ZipcodeException 
	 */
	public List<int[]> splitStringToArray( String[] ranges ) throws ZipcodeException {
		if( ranges == null )
			throw new ZipcodeException("array of ranges empty");
		List<int[]> rangeList = new ArrayList<>();
		for( String str : ranges ) {
			String temp[] = str.split(",");
			rangeList.add( streamStringToIntArray( temp ) );
		}
		return rangeList;
	}

	/**
	 * This method streams integer array to a stream and convers string array to an integer array.
	 * @param values
	 * @return
	 * @throws ZipcodeException 
	 */
	public int[] streamStringToIntArray( String[] values ) throws ZipcodeException {
		int[] ranges = new int[values.length];
		try {
			ranges = Stream.of(values).mapToInt(
							num -> Integer.parseInt(num)).toArray();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new ZipcodeException("can't process due to invalid input.");
		}	
		return ranges;
	}
}
