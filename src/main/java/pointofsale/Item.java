package pointofsale;

public class Item {

	private String barcode;
	private String price;

	public Item(String barcode, String price) {
		this.barcode = barcode;
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

}
