package pl.sda.testing.cart;

import java.util.Collections;
import java.util.List;

public class DbPersistence implements Persistence {
    @Override
    public List<Item> getItems(int id) {
        //querying db
        return Collections.emptyList();
    }

    @Override
    public void addItemToCart(int id, Item item) {
        //saving to db
    }
}
