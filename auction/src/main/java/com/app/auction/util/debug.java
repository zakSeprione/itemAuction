package com.app.auction.util;

public class debug {
	public static void print(String msg){
		System.out.println("Debug: " + new java.util.Date()+" : " + msg);
		
		
	}
	
	public static void print(Object object, String msg){
		System.out.println("Debug: " + new java.util.Date()+" : "+object+ " " + msg);
	}
}
