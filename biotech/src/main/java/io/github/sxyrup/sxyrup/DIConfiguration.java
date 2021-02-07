package io.github.sxyrup.sxyrup;

import io.github.sxyrup.sxyrup.repositories.IVialRepo;
import io.github.sxyrup.sxyrup.repositories.JSONVialRepo;
import java.io.IOException;

public class DIConfiguration {

  public IVialRepo buildRecipeRepo () throws IOException {
    JSONVialRepo repo = new JSONVialRepo();
    repo.init();
    return repo;
  }
}
