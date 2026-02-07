package com.ordersystem.inventoryservice.service;

import com.ordersystem.inventoryservice.model.InventoryItem;
import com.ordersystem.inventoryservice.repository.InventoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

  private InventoryRespository inventoryRespository;

  @Autowired
  public InventoryService(InventoryRespository inventoryRespository) {
    this.inventoryRespository = inventoryRespository;
  }


  public List<InventoryItem> getAllInventoryItems(){
    return inventoryRespository.findAll();
  }

  public InventoryItem getItemById(String id) {
    return inventoryRespository.findById(id).orElse(null);
  }

  public InventoryItem createItem(InventoryItem item) {
    return inventoryRespository.save(item);
  }

  public void deleteItem(String id) {
    inventoryRespository.deleteById(id);
  }
}
