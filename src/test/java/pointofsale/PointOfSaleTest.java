package pointofsale;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class PointOfSaleTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();

	@Test
	public void emptyBarcode() throws Exception {
		final Display display = context.mock(Display.class);
		PointOfSale pos = new PointOfSale(display);

		context.checking(new Expectations() {
			{
				oneOf(display).show("No code received");
			}
		});

		pos.onBarCode("");
	}

	@Test
	public void nullBarcode() throws Exception {
		final Display display = context.mock(Display.class);
		PointOfSale pos = new PointOfSale(display);

		context.checking(new Expectations() {
			{
				oneOf(display).show("No code received");
			}
		});

		pos.onBarCode(null);
	}

	@Test
	public void showItemPriceOnDisplay() throws Exception {
		final Display display = context.mock(Display.class);
		PointOfSale pos = new PointOfSale(display);
		
		context.checking(new Expectations(){
			{
				oneOf(display).show("$9.50");
			}
		});
		
		pos.onBarCode("12345");
	}
}
