package chnu.edu.websecurity26.service;

/*
  @author   nzon
  @project   web-security26
  @class  ItemService
  @version  1.0.0 
  @since 31/10/2026 - 11.20
*/

import chnu.edu.websecurity26.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final List<Item> items = new ArrayList<>();

    {
        items.add(new Item("1", "Lasius niger colony", "Starter colony with workers and brood"));
        items.add(new Item("2", "Messor barbarus queen", "Founding queen, claustral"));
        items.add(new Item("3", "Gypsum formicarium", "Nest chamber with a hydration port"));
    }

    public List<Item> getAllItems() {
        return items;
    }

    public Item createItem(Item item) {
        items.add(item);
        return item;
    }

    public Item getItem(String id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Item updateItem(Item item) {
        Item oldItem = getItem(item.getId());
        items.remove(oldItem);
        items.add(item);
        return item;
    }

    public void deleteItem(String id) {
        Item item = getItem(id);
        items.remove(item);
    }
}
