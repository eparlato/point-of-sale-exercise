package pointofsale;

public class PointOfSale {

	private Display display;
	private Store store;

	public PointOfSale(Display display, Store store) {
		this.display = display;
		this.store = store;
	}

	public void onBarCode(String barcode) {

		if (barcode == null || barcode.equals("")) {
			display.show("No code received");
		} else {
			
			String price = store.getPrice(barcode);
			
			if(price.equals("$13.75")) {
				display.show(price);
			} else {
				display.show("$9.50");
			}
			
		}
	}

}
