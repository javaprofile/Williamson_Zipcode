package com.williamson.codingchallenge.zipcode;

import java.util.List;
import java.util.stream.Stream;

import com.williamson.codingchallenge.zipcode.exception.ZipcodeException;
import com.williamson.codingchallenge.zipcode.model.Input;
import com.williamson.codingchallenge.zipcode.model.Output;
import com.williamson.codingchallenge.zipcode.utils.StringHelperUtils;

import static com.williamson.codingchallenge.zipcode.model.Output.print;

/**
 * This standalone application reads input from command prompt , parses it , removes overlaps and prints output.
 *
 *This application assumes the given input is in below format
 *[95670,95872][95687,95632]
 *Assuming there are no validations, this application is written.
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			 StringHelperUtils.isEmpty( args );
			 Input input = new Input(args);
	        List<int[]> rangesList = input.processInputArgsToList();
	       
	        Output output = new Output(rangesList);
	        output.compute();
	        System.out.println("input from command prompt:: ");
	        Stream.of(args).forEach(System.out::println);
	        System.out.println("output from command prompt:: ");
	        print(rangesList);
		} catch (ZipcodeException e) {
			e.printStackTrace();
		}catch( Exception e ) {
			e.printStackTrace();
		}
    }
    
}
