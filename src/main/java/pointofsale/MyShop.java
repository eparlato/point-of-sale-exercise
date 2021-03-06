package pointofsale;

import java.util.HashMap;

public class MyShop {

	Store store;
	Display display;
	PointOfSale pos;

	public static void main(String[] args) {
		MyShop myShop = new MyShop();
		myShop.setup();
		myShop.scanAFewBarcodes();
	}

	private void scanAFewBarcodes() {
		pos.onBarcode("qwerty1");
		pos.onBarcode("zxcvbn3");
		pos.onBarcode("");
		pos.onBarcode(null);
		pos.onBarcode("lkjhgf");
	}

	private void setup() {

		HashMap<String, Item> items = new HashMap<String, Item>();
		items.put("qwerty1", new Item("qwerty1", "$10.0"));
		items.put("asdfgh2", new Item("asdfgh2", "$20.0"));
		items.put("zxcvbn3", new Item("zxcvbn3", "$30.0"));

		store = new InMemoryStore(items);
		display = new ConsoleDisplay();
		pos = new PointOfSale(display, store);
	}

}
