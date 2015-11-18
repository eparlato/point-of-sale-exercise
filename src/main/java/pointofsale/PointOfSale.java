package pointofsale;

public class PointOfSale {

	private Display display;

	public PointOfSale(Display display) {
		this.display = display;
	}

	public void onBarCode(String string) {
		// TODO Auto-generated method stub
		display.show("No code received");
	}

}
