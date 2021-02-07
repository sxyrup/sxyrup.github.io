package io.github.sxyrup.sxyrup.services;

import io.github.sxyrup.sxyrup.DIConfiguration;
import io.github.sxyrup.sxyrup.models.Vial;
import io.github.sxyrup.sxyrup.repositories.IVialRepo;
import io.github.sxyrup.sxyrup.repositories.VialRepo;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("inventoryService")
public class InventoryService {
  IVialRepo vialRepo;

  public InventoryService(@Qualifier("InventoryRepo")VialRepo vialRepo) {
    try {
      DIConfiguration diConfiguration = new DIConfiguration();
      this.vialRepo = diConfiguration.buildRecipeRepo();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Vial> getAllVials() {
    return vialRepo.list();
  }

  public void addVial(Vial vial) throws IOException {
    vialRepo.add(vial);
  }

}
