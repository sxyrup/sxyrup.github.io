package io.github.sxyrup.sxyrup.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.sxyrup.sxyrup.models.Cell;
import io.github.sxyrup.sxyrup.models.Vial;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class JSONCellRepo extends AbstractFileRepo {
  public static final Gson GSON = new Gson();
  public static final String DB_PATH = "src/main/resources/db/cell_db.json";

  private HashMap<String, Cell> database;

  public List<Cell> list() {
    return new ArrayList<>(database.values());
  }

  public Optional<Cell> get(String UID) {
    return Optional.ofNullable(database.get(UID));
  }

  public void add(Cell cell) throws IOException {
    Objects.requireNonNull(cell);
    database.put(cell.getUCID(), cell);
    persist();
  }

  public Cell update(Cell cell) throws IOException {
    Objects.requireNonNull(cell);
    if (!database.containsKey(cell.getUCID())) {
      throw new UnsupportedOperationException("No such vial!");
    }
    Cell prev = database.put(cell.getUCID(), cell);
    persist();
    return prev;
  }

  public void delete(String id) throws IOException {
    database.remove(id);
    persist();
  }

  @PostConstruct
  public void init() throws IOException {
    if (database == null) {
      database = new HashMap<>();
    }
    loadDB();
  }

  @Override
  protected void loadDB() throws IOException {
    Path path = Paths.get(DB_PATH);
    if (!Files.exists(path)) {
      database = new HashMap<>();
      return;
    }
    byte[] jsonBytes = Files.readAllBytes(path);
    String jasonString = new String(jsonBytes, StandardCharsets.UTF_8);
    Type type = new TypeToken<HashMap<String, Vial>>() {
    }.getType();
    database = GSON.fromJson(jasonString, type);
  }

  @Override
  protected void persist() throws IOException {
    String json = GSON.toJson(database);
    Path path = Paths.get(DB_PATH);
    Files.write(path, json.getBytes(StandardCharsets.UTF_8));
  }

  public static HashMap<String, Vial> loadJSON(Path path) throws IOException {
    byte[] jsonBytes = Files.readAllBytes(path);
    String jsonStr = new String(jsonBytes, StandardCharsets.UTF_8);
    Type type = new TypeToken<HashMap<String, Vial>>() {
    }.getType();
    return GSON.fromJson(jsonStr, type);
  }

}
