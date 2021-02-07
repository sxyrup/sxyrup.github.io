package io.github.sxyrup.sxyrup.repositories;

import java.io.IOException;

public abstract class AbstractFileRepo {
  abstract protected void persist() throws IOException;
  abstract protected void loadDB() throws IOException;
  abstract protected void init() throws IOException;
}
