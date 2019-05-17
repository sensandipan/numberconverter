package com.sandipan.converter;

public class Driver {

	static public Placevalue processor;
	public static void main(String[] args) {
		processor = new Default();
		
		long[] values = new long[] {
	           
	            0,
	            2040,
	            45213,
	            100000,
	            10000007,
	            999999999,
	            -7834,
	            -89999
	           
	            
	        };

	        String[] strValues = new String[] {
	            "0001.2",
	            "3.141"
	        };
	        
	        for (long val : values) {
	            System.out.println(val + " = " + processor.getName(val) );
	        }
	        
	        for (String strVal : strValues) {
	            System.out.println(strVal + " = " + processor.getName(strVal) );
	        }

	}
	

}
