package pl.sda.testing.cart;

import java.util.List;

public interface Persistence {
    List<Item> getItems(int cartId);

    void addItemToCart(int cartId, Item item);
}
