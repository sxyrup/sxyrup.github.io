package io.github.sxyrup.sxyrup.repositories;

import io.github.sxyrup.sxyrup.models.Vial;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IVialRepo {


  public List<Vial> list();


  Optional<Vial> get(String UID);


  public void add(Vial vial) throws IOException;

  public Vial update(Vial vial) throws IOException;


  public void delete(String id) throws IOException;

}
