package Comparator;

import java.util.Comparator;

import Inheritance.Clothing;

public class ClothingComparator implements Comparator<Clothing>{

	@Override
	public int compare(Clothing o1, Clothing o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
