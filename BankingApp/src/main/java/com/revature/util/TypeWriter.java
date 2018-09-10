package com.revature.util;

public class TypeWriter {
	
	 public static void write(String message, long delay)
	 {
	        for (int i = 0; i < message.length(); i++){
	            System.out.print(message.charAt(i));
	               try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	             }
	  }
}
