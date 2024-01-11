package MainAndSystemClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import Comparator.ClothingComparator;
import Inheritance.Accessory;
import Inheritance.Clothing;
import Inheritance.MenClothing;
import Inheritance.WomenClothing;

public class ClothingSys {
	private static HashMap<Integer, Clothing> hmClothing=new HashMap();
	
	public static void readToSet() {
		String type;
		int barcode;
		String name;
		int price;
		String suitSize;
		String tieColor;
		String dressSize;
		String dressColor;
		ArrayList<Accessory> al=null;
		Accessory a=null;
		String[] all=new String[10];
		String[] accessory = new String[10];
		MenClothing m=null;
		WomenClothing w=null;
		try {
			Scanner sc=new Scanner(new File("clothings.txt"));
			while(sc.hasNext()) {
				all=sc.nextLine().split("%");
				type=all[0];
				barcode=Integer.parseInt(all[1]);
				price=Integer.parseInt(all[2]);
				name=all[3];
				if(type.equalsIgnoreCase("Men")) {
					suitSize=all[4];
					tieColor=all[5];
					m=new MenClothing(barcode, name, price, suitSize, tieColor);
					hmClothing.put(barcode, m);
				}
				else {
					dressSize=all[4];
					dressColor=all[5];
					accessory = all[6].split("\\*");
					al=new ArrayList();
					for(int i = 0; i< accessory.length ; i++) {
						a=new Accessory(accessory[i]);
						al.add(a);
					}
					w=new WomenClothing(barcode, name, price, dressColor, dressSize, al);
					hmClothing.put(barcode, w);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addClothing(String type, int barcode, String name, int price, String suitSize, String tieColor,String dressColor, String dressSize, ArrayList<Accessory> accessories) {
		WomenClothing w=null;
		MenClothing m=null;
		if(type.equalsIgnoreCase("Men")) {
			m=new MenClothing(barcode, name, price, suitSize, tieColor);
			hmClothing.put(barcode, m);
		}
		else {
			w=new WomenClothing(barcode, name, price, dressColor, dressSize, accessories);
			hmClothing.put(barcode, w);
		}
	}
	
	public static HashMap<Integer, Clothing> getClothing(){
		return hmClothing;
	}
	
	public static String displayByPrice() {
		String res="";
		TreeSet<Clothing> ts=new TreeSet<Clothing>();
		ts.addAll(hmClothing.values());
		for(Clothing c: ts) {
			res+=c.toString();
		}
		return res;
	}
	
	public static String displayByName() {
		String res="";
		ClothingComparator cc= new ClothingComparator();
		TreeSet<Clothing> ts=new TreeSet<Clothing>(cc);
		ts.addAll(hmClothing.values());
		for(Clothing c: ts) {
			res+=c.toString();
		}
		return res;
	}	
	
	public static Clothing search(int b) {
		Set<Integer> kSet = hmClothing.keySet();
		
		for(int i: kSet)
			if(i==b)
				return hmClothing.get(i);
		
		return null;
	}
	
	public static boolean deleteItem(int b) {
		Set<Integer> kSet = hmClothing.keySet();
		
		for(int i: kSet)
			if(i==b)
				if(hmClothing.remove(i, hmClothing.get(i)))
					return true;
	
		return false;
	}
	
	public static String discount() { 
		Set<Integer> kSet = hmClothing.keySet();
		Clothing c = null;
		String s = "Barcode    Old Price    New Price\n"
				+  "-----------------------------\n";
		
		for(int i: kSet) {
			s+=i+"           ";
			c = hmClothing.get(i);
			s+=c.getPrice()+" --> ";
			c.calcDisc();
			s+=c.getPrice()+"\n";
			hmClothing.put(i, c);
		}
		
		return s + "\n%60 discount to Women Clothes and \n%50 discount to Men Clothes!!";
	}
	
	public static String totalPrice() {
		Set<Integer> kSet = hmClothing.keySet();
		int total = 0;
		Clothing c = null;
		String s = "Barcode       Price    \n"
				+  "-------------------\n";
		
		for(int i: kSet) {
			s+=i+"           " + hmClothing.get(i).getPrice() + " TL\n";
			total += hmClothing.get(i).getPrice();
	
		}
		
		return s + "\nTotal: "+total +" TL\n";
	}
}
