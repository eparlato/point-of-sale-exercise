package pointofsale;

public class ConsoleDisplay implements Display {

	private String price;

	public void show(String price) {
		this.price = price;
		System.out.println(price);
	}

	public String getLastTextDisplayed() {
		return price;
	}

}
