package io.github.sxyrup.sxyrup.repositories;

import io.github.sxyrup.sxyrup.models.Vial;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ObjectStreamCellRepo extends AbstractFileRepo implements ICellRepo {
  public static final String DB_PATH = "src/main/resources/db/db.ser";

  private ArrayList<Vial> database = new ArrayList<>();

  @Override
  public List<Vial> list() {
    return database;
  }

  @Override
  public Optional<Vial> get(String UID) {
    return database.stream().filter(item -> item.getUID().equals(UID)).findFirst();
  }

  @Override
  public void add(Vial vial) throws IOException {
    Objects.requireNonNull(vial);

    database.add(vial);
    persist();
  }

  @Override
  public Vial update(Vial vial) throws IOException {
    Objects.requireNonNull(vial);
    Optional<Vial> vialOptional = get(vial.getUID());
    if (!vialOptional.isPresent()) {
      throw new UnsupportedOperationException("No such vial!");
    }
    vialOptional.ifPresent(value -> database.remove(value));
    add(vial);
    return vialOptional.get();
  }

  @Override
  public void delete(String id) throws IOException {
    Optional<Vial> vial = get(id);
    vial.ifPresent(value -> database.remove(value));
    persist();
  }

  @Override
  protected void persist() throws IOException {
    FileOutputStream fileOut = new FileOutputStream(DB_PATH);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(database);
    out.close();
    fileOut.close();
  }

  @Override
  protected void loadDB() throws IOException {
    if (!Files.exists(Paths.get(DB_PATH))) {
      database = new ArrayList<>();
      return;
    }
    FileInputStream fileIn = null;
    ObjectInputStream in = null;
    try {
      fileIn = new FileInputStream(DB_PATH);
      in = new ObjectInputStream(fileIn);
      database = (ArrayList<Vial>) in.readObject();
    } catch (ClassNotFoundException e) {
      throw new UnsupportedOperationException("Should never happen");
    } finally {
      if (in != null) {
        in.close();
      }
      if (fileIn != null) {
        fileIn.close();
      }
    }
  }

  @Override
  protected void init() throws IOException {
    if (database == null) {
      database = new ArrayList<>();
    }
    loadDB();
  }
}
