package pointofsale;

public class PointOfSale {

	private Display display;

	public PointOfSale(Display display) {
		this.display = display;
	}

	public void onBarCode(String barcode) {

		if(barcode == null || barcode.equals("")) {
			display.show("No code received");
		} else {
			display.show("$9.50");
		}
	}

}
