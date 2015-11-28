package pointofsale;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConsoleDisplayTest {
	
	@Test
	public void lastDisplayedTextWasAPrice() throws Exception {
		ConsoleDisplay consoleDisplay = new ConsoleDisplay();
		
		consoleDisplay.show("$100.01");
		
		assertEquals("$100.01", consoleDisplay.getLastTextDisplayed());
	}
	
	@Test
	public void lastTextDisplayedWasNotFound() throws Exception {
		ConsoleDisplay consoleDisplay = new ConsoleDisplay();
		
		consoleDisplay.show("$1000000");
		consoleDisplay.show("Not found in store");
		
		assertEquals("Not found in store", consoleDisplay.getLastTextDisplayed());
	}
}
