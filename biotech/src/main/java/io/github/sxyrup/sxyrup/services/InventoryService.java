package io.github.sxyrup.sxyrup.services;

import io.github.sxyrup.sxyrup.DIConfiguration;
import io.github.sxyrup.sxyrup.models.Vial;
import io.github.sxyrup.sxyrup.repositories.ICellRepo;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {


  ICellRepo cellRepo;

  public InventoryService() {
    try {
      DIConfiguration diConfiguration = new DIConfiguration();
      this.cellRepo = diConfiguration.buildRecipeRepo();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Vial> getAllVials() {
    return cellRepo.list();
  }

  public void addVial(Vial vial) throws IOException {
    cellRepo.add(vial);
  }

}
