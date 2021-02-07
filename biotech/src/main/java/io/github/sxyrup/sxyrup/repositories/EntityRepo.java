package io.github.sxyrup.sxyrup.repositories;

import io.github.sxyrup.sxyrup.models.Cell;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("EntityRepo")
public class EntityRepo {
  List<Cell> cells;

  public EntityRepo() {
    this.cells = new ArrayList<>();
  }

  public List<Cell> listAll() {
    return cells;
  }

  public void addEntity(Cell cell) {
    cells.add(cell);
  }

}
