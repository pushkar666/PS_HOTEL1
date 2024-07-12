package com.HotelIndraprastha.prg2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HotelMenu hm = new HotelMenu();
		HotelIO io = new HotelIO();
		hm.addDefMenu();
		
		while(true)
		{
			hm.dispMenu();
			hm.choice();
			
		}
	}
	
	
}
