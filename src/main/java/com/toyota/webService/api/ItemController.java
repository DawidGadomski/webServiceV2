package com.toyota.webService.api;

import com.toyota.webService.dto.ItemDTO;
import com.toyota.webService.model.Item;
import com.toyota.webService.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ItemController {
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/items")
    public List<Item> getItems(){
        return itemService.getItems();
    }

    @GetMapping("/item")
    public Item scanItem(@RequestBody Item item){
        return itemService.scanItem(item.getCode()).orElse(null);
    }

    @PostMapping("/items/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void addItem(@RequestBody Item item){
//        Item item = modelMapper.map(itemDto, Item.class);

        itemService.addItem(item);
    }

    @DeleteMapping("/deleteItem")
    public void deleteUser(@RequestBody Item item){
        itemService.deleteItem(item.getCode());
    }


}
