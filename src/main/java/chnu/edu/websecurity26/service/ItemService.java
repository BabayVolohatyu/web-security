package chnu.edu.websecurity26.service;

/*
  @author   nzon
  @project   web-security26
  @class  ItemService
  @version  1.0.0 
  @since 31/10/2026 - 11.20
*/

import chnu.edu.websecurity26.model.Item;
import chnu.edu.websecurity26.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final List<Item> items = new ArrayList<>();

    {
        items.add(new Item("1", "Lasius niger colony", "Starter colony with workers and brood"));
        items.add(new Item("2", "Messor barbarus queen", "Founding queen, claustral"));
        items.add(new Item("3", "Gypsum formicarium", "Nest chamber with a hydration port"));
    }

    @PostConstruct
    void init() {
        itemRepository.deleteAll();
        items.forEach(this::createItem);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItem(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item updateItem(Item item) {
        Item existing = itemRepository.findById(item.getId()).orElse(null);
        if (existing != null) {
            existing.setName(item.getName());
            existing.setDescription(item.getDescription());
            return itemRepository.save(existing);
        }
        return null;
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
