package io.github.sxyrup.sxyrup.models;

public enum CellType {
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
