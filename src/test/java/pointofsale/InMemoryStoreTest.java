package pointofsale;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class InMemoryStoreTest {

	
	@Test
	public void itemFound() throws Exception {
		Map<String, Item> items = new HashMap<String, Item>();
		items.put("qwerty1", new Item("qwerty1", "$5.65"));
		
		Store store = new InMemoryStore(items);
		
		assertEquals(store.getItem("qwerty1").getPrice(), "$5.65");
	}
	
	@Test
	public void itemNotFound() throws Exception {
		Map<String, Item> items = new HashMap<String, Item>();

		Store store = new InMemoryStore(items);

		assertNull(store.getItem("zxcv987"));
	}
	
	
}
