package com.ordersystem.inventoryservice.repository;

import com.ordersystem.inventoryservice.model.InventoryItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRespository extends MongoRepository<InventoryItem, String> {

}
