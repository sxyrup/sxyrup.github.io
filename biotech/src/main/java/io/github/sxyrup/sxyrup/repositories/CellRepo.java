package io.github.sxyrup.sxyrup.repositories;

import io.github.sxyrup.sxyrup.models.Vial;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CellRepo {
  private List<Vial> stock;

  public CellRepo() {
    stock = new ArrayList<>();
    initStock();
  }

  public List<Vial> getStock() {
    return stock;
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
