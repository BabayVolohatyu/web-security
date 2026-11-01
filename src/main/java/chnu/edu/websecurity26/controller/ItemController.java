package chnu.edu.websecurity26.controller;

/*
  @author   nzon
  @project   web-security26
  @class  ItemController
  @version  1.0.0 
  @since 31/10/2026 - 11.20
*/

import chnu.edu.websecurity26.model.Item;
import chnu.edu.websecurity26.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<Item> getAll(String id) {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable String id) {
        return itemService.getItem(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }

    @GetMapping("hello/admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }

    @GetMapping("hello/unknown")
    public String helloUnknown() {
        return "Hello Unknown!";
    }

    @GetMapping("/hello/user")
    public String hello() {
        return "Hello!, user";
    }

    @GetMapping("/hello/man")
    public String helloMan() {
        return "Hello, man!";
    }
}
