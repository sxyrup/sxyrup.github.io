package io.github.sxyrup.sxyrup.controllers;

import io.github.sxyrup.sxyrup.models.Vial;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InventoryController {
  public List<Vial> stock = new ArrayList<>();

  public InventoryController() {
    initStock();
  }

  @GetMapping("/inventory")
  public String showInventory(Model model) {
    Vial vial = new Vial();
    model.addAttribute("inventory", stock);
    model.addAttribute("cell", vial);
    return "inventory";
  }

  @PostMapping("/inventory")
  public String submitNewVial(Model model, @ModelAttribute(name = "cell") Vial vial) {
    model.addAttribute("inventory", stock);
    vial.initId();
    stock.add(vial);
    return "inventory";
  }


  private void initStock() {

    stock.add(new Vial("Hues9", "wt", 2, 13, true, 3, 3, 4,
        "NOTE GOES HERE"));
    stock.add(new Vial("Hues9", "wt", 2, 13, false, 3, 3, 4,
        "NOTE GOES HERE"));
    stock.add(new Vial("Hues9", "wt", 2, 13, true, 3, 3, 4,
        "NOTE GOES HERE"));
    stock.add(new Vial("Hues9", "wt", 2, 13, false, 3, 3, 4,
        "NOTE GOES HERE"));
    stock.add(new Vial("Hues9", "wt", 2, 13, true, 3, 3, 4,
        "NOTE GOES HERE"));
    stock.add(new Vial("Hues9", "wt", 2, 13, false, 3, 3, 4,
        "NOTE GOES HERE"));
    stock.add(new Vial("Hues9", "wt", 2, 13, true, 3, 3, 4,
        "NOTE GOES HERE"));
    stock.add(new Vial("Hues9", "wt", 2, 13, false, 3, 3, 4,
        "NOTE GOES HERE"));

    stock.get(0).setPresent(false);

  }

}

