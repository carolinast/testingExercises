package pl.sda.testing.cart;

import java.util.List;

public class Cart {
    private int id;
    private Persistence persistence;

    public Cart(int id, Persistence persistence) {
        this.id = id;
        this.persistence = persistence;
    }

    public List<Item> getItems() {
        return persistence.getItems(id);
    }

    public void addItem(Item item) {
        persistence.addItemToCart(id, item);
    }

    public boolean isEmpty() {
        return getItems().isEmpty();
    }
}
