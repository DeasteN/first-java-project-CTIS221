 package Inheritance;

import Interface.Discount;

public abstract class Clothing implements Comparable<Clothing>, Discount{
	protected int barcode;
	protected String name;
	protected int price;
	
	public Clothing(int barcode, String name, int price) {
		this.barcode=barcode;
		this.name=name;
		this.price=price;
	}

	public int getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23* hash+this.price;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clothing other = (Clothing) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		return "Barcode: "+ this.barcode+ "\nName: " + name + "\nPrice: " + price + "\n";
	}
	
	public abstract void calcDisc();
}
