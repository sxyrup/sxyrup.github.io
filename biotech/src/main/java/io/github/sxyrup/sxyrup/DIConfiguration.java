package io.github.sxyrup.sxyrup;

import io.github.sxyrup.sxyrup.repositories.AbstractFileRepo;
import io.github.sxyrup.sxyrup.repositories.ICellRepo;
import io.github.sxyrup.sxyrup.repositories.JSONCellRepo;
import java.io.IOException;

public class DIConfiguration {

  public ICellRepo buildRecipeRepo () throws IOException {
    JSONCellRepo repo = new JSONCellRepo();
    repo.init();
    return repo;
  }
}
