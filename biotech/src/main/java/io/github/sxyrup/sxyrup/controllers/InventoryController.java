package io.github.sxyrup.sxyrup.controllers;

import io.github.sxyrup.sxyrup.models.Vial;
import io.github.sxyrup.sxyrup.services.InventoryService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InventoryController {

  @Autowired
  InventoryService inventoryService;

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

}

