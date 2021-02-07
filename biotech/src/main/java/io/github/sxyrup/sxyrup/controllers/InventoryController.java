package io.github.sxyrup.sxyrup.controllers;

import io.github.sxyrup.sxyrup.models.Cell;
import io.github.sxyrup.sxyrup.models.Vial;
import io.github.sxyrup.sxyrup.services.EntityService;
import io.github.sxyrup.sxyrup.services.InventoryService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InventoryController {

  InventoryService inventoryService;
  EntityService entityService;

  public InventoryController(  @Qualifier("inventoryService") InventoryService inventoryService, @Qualifier("entityService")
                             EntityService entityService) {
    this.inventoryService = inventoryService;
    this.entityService = entityService;
  }

  @GetMapping("/inventory")
  public String showInventory(Model model) {
    Vial vial = new Vial();
    model.addAttribute("inventory", inventoryService.getAllVials());
    model.addAttribute("cell", vial);
    return "inventory";
  }

  @PostMapping("/inventory")
  public String submitNewVial(Model model, @ModelAttribute(name = "cell") Vial vial)
      throws IOException {
    model.addAttribute("inventory", inventoryService.getAllVials());
    inventoryService.addVial(vial);
    System.out.println(vial);
    return "inventory";
  }


  @GetMapping("/entities")
  public String showEntities(Model model) {
    Cell cell = new Cell();
    model.addAttribute("entities", entityService.getAllCells());
    model.addAttribute("cell", cell);
    return "entity";
  }

  @PostMapping("/entities")
  public String submitNewVial(Model model, @ModelAttribute(name = "cell") Cell cell)
      throws IOException {
    model.addAttribute("entities", entityService.getAllCells());
    entityService.addCell(cell);
    return "entity";
  }

//  @GetMapping("/inventory/entities")
//  public String listEntities(Model model) {
//    model.addAttribute("entities", entityService.getAllCells());
//    return "entity";
//  }

}

