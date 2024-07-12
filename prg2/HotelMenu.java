package com.HotelIndraprastha.prg2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;



interface Hotelinterface {
    String passWord = "12345";
	void choice();
    LinkedHashMap<String, Double> menu = new LinkedHashMap<>();
    LinkedHashMap<String, Double> selectMenu = new LinkedHashMap<>();
    ArrayList<Integer> qty = new ArrayList<>();
    void dispBill(HotelIO io);
}
public class HotelMenu implements Hotelinterface{
	Scanner sc = new Scanner(System.in);
	public void addDefMenu()
	{
		menu.put("CHICKEN LOLLIPOP", 200.00);
		menu.put("CHICKEN TANDOORI", 280.00);
		menu.put("CHILLI CHICKEN", 150.00);
		menu.put("CHICKEN NUGGETS", 240.00);
		menu.put("CHICKEN 65", 300.00);
		menu.put("CHICKEN KEBAB", 320.00);
		menu.put("PANEER TIKKA", 210.00);
		menu.put("MATAR MUSHROOM", 140.00);
		menu.put("MUSHROOM PASTA", 190.00);
	}
	
	public void dispMenu() {
		int i = 1;
		System.out.println("*************START WITH STARTERS*************");

		// Print header
		System.out.printf("%-5s %-25s %10s%n", "No.", "Item", "Price");
		System.out.println("*********************************************");	
		
		System.out.printf("%-5s %-25s", 0+".", "If you are admin press zero to add items");		
		System.out.println();
		// Print items
		for (String key : menu.keySet()) {
			System.out.printf("%-5s %-25s %10.2f%n", i+".", key, menu.get(key));
			i++;
		}
		System.out.printf("%-5s %-25s", i+".", "TO PRINT THE BILL");
		System.out.println("\n*******************************************");
	}
	
	
	/*
	 * if (ch > 0 && ch <= menu.size()) { String selectedItem = (String)
	 * menu.keySet().toArray()[ch - 1]; Double price = menu.get(selectedItem);
	 * System.out.println("You selected: " + selectedItem + " - Price: " + price);
	 * return ch; }
	 */
	
	public void choice() {
		int ch = sc.nextInt();
		if(ch!=0 && ch <= menu.size()) {
			 String selectedItem = (String) menu.keySet().toArray()[ch - 1];
			 Double price = menu.get(selectedItem);
			 selectMenu.put(selectedItem, price);
			 System.out.println("Enter the number of plates");
			 int plates = sc.nextInt();
			 qty.add(plates);
		}
		else if(ch == 0) {
			validateAdmin();
		}
		else if(ch==(menu.size())+1) {
			processBill();
		}
		else {
			System.out.println("Invalid choice, try again");
		}
	}
	
	public void validateAdmin() {
		System.out.println("Enter the admin Password: ");
		String pw = sc.next();
		if(pw.equals(passWord)) {
			addMenu();
		}
		else
			System.out.println("Incorrect password");
		
	}
	
	public void addMenu() {
		System.out.print("Enter the name of the item: ");
		String item = sc.next();
		System.out.print("Enter the price of the item: ");
		Double price = sc.nextDouble();
		menu.put(item, price);
	}
	
	public void processBill() {
		int i = 1;
		HotelIO io = new HotelIO();
        double totalBill = 0;
        System.out.println("******************YOUR BILL******************");
        System.out.printf("%-3s %-25s %-10s %-10s%n", "No.", "Item", "Quantity", "Price");
        System.out.println("*********************************************");
        for (String item : selectMenu.keySet()) {
            double price = selectMenu.get(item);
            int quantity = qty.get(i - 1);
            double total = price * quantity;
            totalBill += total;
            System.out.printf("%-3s %-25s %-10d %-10.2f%n", i+".", item, quantity, total);
            i++;
        }
        io.setbill(totalBill);
        dispBill(io);
	}
	
	public void dispBill(HotelIO io) {
		double bill = io.getbill();
		double gst = bill * 0.18;
		double totalBill = bill + gst;
		System.out.println("*********************************************");
		System.out.printf("%-30s %-10.2f%n", "Total Amount:", bill);
		System.out.printf("%-30s %-10.2f%n", "GST Value(18%):", gst);
		System.out.printf("%-30s %-10.2f%n", "Total Bill is:", totalBill);
		System.out.println("---------------------------------------------");
		System.out.println("Total Payable bill is (Rounded off): "+Math.floor(totalBill));
		System.out.println("---------------------------------------------");
		System.out.println("Press any key to continue ... ");
		return;
	}
}
