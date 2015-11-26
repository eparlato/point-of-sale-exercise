package pointofsale;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InMemoryStoreTest {

	@Test
	public void itemFound() throws Exception {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("qwerty1", "$5.65"));
		
		Store store = new InMemoryStore();
		
		assertEquals(store.getItem("qwerty").getPrice(), "$5.65");
	}
}
