package pointofsale;

import java.util.Map;

public class InMemoryStore implements Store {

	private Map<String, Item> items;

	public InMemoryStore(Map<String, Item> items) {
		this.items = items;
	}

	public Item getItem(String barcode) {
		Item item = items.get(barcode);
		return item;
	}

}
