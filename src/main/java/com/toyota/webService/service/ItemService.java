package com.toyota.webService.service;

import com.toyota.webService.dao.ItemDao;
import com.toyota.webService.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class ItemService {

    private final ItemDao itemDao;

    @Autowired
    public ItemService(@Qualifier("items") ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Item> getItems(){
        return itemDao.getItems();
    }

    public Optional<List<Item>> getItemsByType(String type, String data){
        return itemDao.getItemsByType(type, data);
    }

    public Optional<Item> scanItem(String itemCode){
        return itemDao.scanItem(itemCode);
    }

    public int addItem(Item item){
        return itemDao.addItem(item);
    }

    public int deleteItem(String itemCode){
        return itemDao.deleteItem(itemCode);
    }
}
