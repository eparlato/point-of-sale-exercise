package pointofsale;

public class InMemoryStore implements Store {

	public Item getItem(String string) {
		return new Item("qwerty", "$5.65");
	}

}
