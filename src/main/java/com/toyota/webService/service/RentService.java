package com.toyota.webService.service;

import com.toyota.webService.dao.RentDao;
import com.toyota.webService.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class RentService {
    private final RentDao rentDao;

    @Autowired
    public RentService(@Qualifier("rents") RentDao rentDao) {
        this.rentDao = rentDao;
    }

    public List<Rent> getRents(){
        return rentDao.getRents();
    }

    public int rentItem(Rent rent){
        return rentDao.rentItem(rent);
    }

    public int returnItem(int itemID){
        return rentDao.returnItem(itemID);
    }
}
