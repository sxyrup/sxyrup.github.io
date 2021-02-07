package io.github.sxyrup.sxyrup.models;

import java.io.Serializable;

public enum CellType implements Serializable {
  HESC("hESC"),
  HIPSC("hiPSC"),
  CM("CM");

  private final String type;


  CellType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
