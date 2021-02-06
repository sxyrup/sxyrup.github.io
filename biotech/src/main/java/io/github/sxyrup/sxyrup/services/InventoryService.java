package io.github.sxyrup.sxyrup.services;

import io.github.sxyrup.sxyrup.models.Vial;
import io.github.sxyrup.sxyrup.repositories.CellRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

  @Autowired
  CellRepo cellRepo;

  public List<Vial> getAllVials() {
    return cellRepo.getStock();
  }

  public void addVial(Vial vial) {
    cellRepo.getStock().add(vial);
  }

}
