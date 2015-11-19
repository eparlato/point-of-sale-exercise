package pointofsale;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PointOfSaleTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	private Store store;
	private Display display;
	private PointOfSale pos;

	@Before
	public void setup() {
		display = context.mock(Display.class);
		store = context.mock(Store.class);
		pos = new PointOfSale(display, store);
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
				allowing(store).getPrice("12345");
				oneOf(display).show("$9.50");
			}
		});

		pos.onBarCode("12345");
	}
	
	@Test
	public void showAnotherItemPriceOnDisplay() throws Exception {
		
		
		context.checking(new Expectations() {
			{
				allowing(store).getPrice("ASD123"); 
				will(returnValue("$13.75"));
				oneOf(display).show("$13.75");
			}
		});
		 
		pos.onBarCode("ASD123");
	}
}
