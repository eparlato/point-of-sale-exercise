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
			Item item = store.getItem(barcode);
			
			if(item != null) {
				display.show(item.getPrice());
			} else {
				display.show("Not found in store");
			}
		}
	}

}
