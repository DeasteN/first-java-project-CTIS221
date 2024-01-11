package Inheritance;

import java.util.ArrayList;

public class WomenClothing extends Clothing{

	private String dressSize;
	private String dressColor;
	private ArrayList<Accessory> accessories = new ArrayList<Accessory>();
	
	
	public WomenClothing(int barcode, String name, int price, String dressColor, String dressSize, ArrayList<Accessory> accessories) {
		super(barcode, name, price);
		this.dressColor =dressColor;
		this.dressSize=dressSize;
		this.accessories= accessories;
	}

	@Override
	public int compareTo(Clothing o) {
		return this.price-o.price;
	}

	public String getDressSize() {
		return dressSize;
	}

	public String getDressColor() {
		return dressColor;
	}

	public ArrayList<Accessory> getAccessories() {
		return accessories;
	}

	@Override
	public String toString() {
		return	"Women Clothing\n------------\n" + super.toString() +
				"Dress Size: " + dressSize +
				"\nDress Color: " + dressColor +
				"\nAccessories:" + accessories.toString() + "\n\n";
	}

	@Override
	public void calcDisc() {
		this.price *=0.4;
	}
	
}
