package io.github.sxyrup.sxyrup.controllers;

import io.github.sxyrup.sxyrup.models.Vial;
import io.github.sxyrup.sxyrup.services.VialInventoryService;
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
  VialInventoryService vialInventoryService;

  @GetMapping("/inventory")
  public String showInventory(Model model) {
    Vial vial = new Vial();
    model.addAttribute("inventory", vialInventoryService.getAllVials());
    model.addAttribute("cell", vial);
    return "inventory";
  }

  @PostMapping("/inventory")
  public String submitNewVial(Model model, @ModelAttribute(name = "cell") Vial vial)
      throws IOException {
    model.addAttribute("inventory", vialInventoryService.getAllVials());
        vialInventoryService.addVial(vial);
    System.out.println(vial);
    return "inventory";
  }

}

