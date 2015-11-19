package pointofsale;

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
				allowing(store).getItem("12345");
				will(returnValue(new Item("12345", "$9.50")));
				oneOf(display).show("$9.50");
			}
		});

		pos.onBarCode("12345");
	}

	@Test
	public void showAnotherItemPriceOnDisplay() throws Exception {

		context.checking(new Expectations() {
			{
				allowing(store).getItem("ASD123");
				will(returnValue(new Item("ASD123", "$13.75")));
				oneOf(display).show("$13.75");
			}
		});

		pos.onBarCode("ASD123");
	}
	
	@Test
	public void itemNotFound() throws Exception {
		
		context.checking(new Expectations() {
			{
				allowing(store).getItem("98765A");
				will(returnValue(null));
				oneOf(display).show("Not found in store");
			}
		});
		
		pos.onBarCode("98765A");
	}
}
