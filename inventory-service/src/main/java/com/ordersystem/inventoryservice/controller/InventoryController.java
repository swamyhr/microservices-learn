package com.ordersystem.inventoryservice.controller;

import com.ordersystem.inventoryservice.model.InventoryItem;
import com.ordersystem.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
  private InventoryService inventoryService;

  @Autowired
  public InventoryController(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @GetMapping
  public List<InventoryItem> getAllItems() {
    return inventoryService.getAllInventoryItems();
  }

  @GetMapping("/{id}")
  public InventoryItem getItemById(@PathVariable String id) {
    return inventoryService.getItemById(id);
  }

  @PostMapping
  public InventoryItem createItem(@RequestBody InventoryItem item) {
    return inventoryService.createItem(item);
  }

  @DeleteMapping("/{id}")
  public void deleteItem(@PathVariable String id) {
    inventoryService.deleteItem(id);
  }
}
