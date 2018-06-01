/**
 * 
 */
package com.williamson.codingchallenge.zipcode.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

import com.williamson.codingchallenge.zipcode.exception.ZipcodeException;


/**
 * This method computes zip code overlaps and reduces the input if any overlapping and returns output.
 * @author BONDUGULAV
 *
 */
public class Output {

	private final List<int[]> rangesList;
	/**
	 * 
	 */
	public Output( List<int[]> rangesList ) {
		this.rangesList = rangesList;
	}

	/**
	 * 
	 * @throws ZipcodeException
	 */
	public void computeList() throws ZipcodeException {
		//sort the list of integer array.
			sortListAsc( this.rangesList );
			compute();
	}
	
	/**
	 * 
	 * @param valuesList
	 * @throws ZipcodeException
	 */
	public void sortListAsc( List<int[]> valuesList ) throws ZipcodeException{
		try {
			Comparator<int[]> intArrayComparator = (int[] a1,int[] a2) ->Integer.compare(a1[0], a2[0]);
			Collections.sort(valuesList, intArrayComparator);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ZipcodeException("Cannot sort due to exception");
		}
	}
	
	/**
	 * This method computes any overlaps in the input.
	 * @throws ZipcodeException
	 */
	public void compute() throws ZipcodeException {
		List<int[]> deleteRangeList = new ArrayList<>();
		
		try {
			for( int i = 0;i<rangesList.size();i++) {
				
				int[] a = rangesList.get(i);
				if(deleteRangeList.contains(a)){
					continue;
				}
				for( int j = i+1;j<rangesList.size();j++) {
					int[] b = rangesList.get(j);
					if( b[0] <= a[1]) {
						if(b[1]<=a[1]) {
							deleteRangeList.add(b);
						}else if(b[1]>a[1]) {
							//set a[1] = b[1]
							a[1] = b[1];
							deleteRangeList.add(b);
						}
					}
				}
			}
			rangesList.removeAll(deleteRangeList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ZipcodeException("cannot compute due to exception.");
		}
	}
	
	/**
	 * This method prints final output of the list of arrays using StringJoiner java API.
	 * @param collection
	 */
	public static void print( List<int[]> collection ) {
   	 Iterator<int[]> iterator = collection.iterator();
   	 while( iterator.hasNext() ) {
   		 int[] intArr = iterator.next();
   		 StringJoiner joiner = new StringJoiner(",","[","]");
   		for( int arr : intArr ) {
   			 String a = Integer.toString(arr);
				 joiner.add(a);
   		}
   		System.out.println(joiner.toString());
   	 } 
  }
}
