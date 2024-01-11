package Inheritance;

public class MenClothing extends Clothing{
	
	private String suitSize;
	private String tieColor;
	
	
	public MenClothing(int barcode, String name, int price, String suitSize, String tieColor) {
		super(barcode, name, price);
		this.suitSize=suitSize;
		this.tieColor=tieColor;
		
	}
	
	public String getSuitSize() {
		return suitSize;
	}

	public String getTieColor() {
		return tieColor;
	}

	@Override
	public int compareTo(Clothing o) {
		return this.price-o.price;
	}

	@Override
	public String toString() {
		return	"Men Clothing\n------------\n" + super.toString() +
				"Suit Size: " + suitSize + 
				"\nTie Color: " + tieColor + "\n\n";
	}

	@Override
	public void calcDisc() {
		this.price *=0.5;
	}

	
}
