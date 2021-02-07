package io.github.sxyrup.sxyrup.services;

import io.github.sxyrup.sxyrup.models.Cell;
import io.github.sxyrup.sxyrup.models.CellType;
import io.github.sxyrup.sxyrup.repositories.EntityRepo;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("entityService")
public class CellService {
  EntityRepo entityRepo;

  public CellService(@Qualifier("EntityRepo") EntityRepo entityRepo) {
    initRepo(entityRepo);
    this.entityRepo = entityRepo;
  }

  public List<Cell> getAllCells() {
    return entityRepo.listAll();
  }

  public void addCell(Cell cell) throws IOException {
    entityRepo.addEntity(cell);
  }

  public void initRepo(EntityRepo entityRepo) {
    Cell cell = new Cell();
    cell.setType(CellType.HESC);
    cell.setLine("HUES9");
    cell.setAlias("BELA");
    cell.setNote("DEMO NOTE");
    cell.setP1(12);
    cell.setP2(20);
    cell.setHasGFP(true);
    cell.setHasResistance(true);

    entityRepo.addEntity(cell);
  }
}
