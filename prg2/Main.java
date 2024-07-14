/*
 * AUTHOR ID: PS14APRILOF24JFS#012
 * Author: PUSHKAR D
 * Email: pushkardwarkanath@gmail.com
 * GitHub: https://github.com/pushkar666
 * 
 * Project Synopsis:
 * This project is a simple hotel management system where users can view a menu,
 * select items, and get a bill that includes GST calculations. It supports an
 * admin mode to add new items to the menu. The program continuously displays the
 * menu and processes user choices until terminated.
 * 
 * Classes and Interfaces:
 * - HotelIO: Handles the billing information.
 * - HotelInterface: Defines the structure for the hotel menu and billing system.
 * - HotelMenu: Implements HotelInterface, manages menu operations, item selection, 
 *              and bill processing.
 * - Main: Contains the main method to run the application.
 */
package com.HotelIndraprastha.prg2;

//import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		
		HotelMenu hm = new HotelMenu();
//		HotelIO io = new HotelIO();
		hm.addDefMenu();
		
		while(true)
		{
			hm.dispMenu();
			hm.choice();
			
		}
	}
}
