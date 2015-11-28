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
}
