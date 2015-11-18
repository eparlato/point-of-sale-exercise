package pointofsale;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PointOfSaleTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	private Display display;
	private PointOfSale pos;

	@Before
	public void setup() {
		display = context.mock(Display.class);
		pos = new PointOfSale(display);
	}

	@Test
	public void emptyBarcode() throws Exception {

		context.checking(new Expectations() {
			{
				oneOf(display).show("No code received");
			}
		});

		pos.onBarCode("");
	}

	@Test
	public void nullBarcode() throws Exception {

		context.checking(new Expectations() {
			{
				oneOf(display).show("No code received");
			}
		});

		pos.onBarCode(null);
	}

	@Test
	public void showItemPriceOnDisplay() throws Exception {

		context.checking(new Expectations() {
			{
				oneOf(display).show("$9.50");
			}
		});

		pos.onBarCode("12345");
	}
}
