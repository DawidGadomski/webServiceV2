package com.toyota.webService.api;


import com.toyota.webService.model.Item;
import com.toyota.webService.model.Rent;
import com.toyota.webService.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentController {
    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/rents")
    public List<Rent> getRents(){
        return rentService.getRents();
    }

    @PostMapping("/rents/rent")
    public void rentItem(@RequestBody Rent rent){
        rentService.rentItem(rent);
    }

    @DeleteMapping("/rents/return")
    public void returnItem(@RequestBody Item item){
        rentService.returnItem(item.getId());
    }
}
