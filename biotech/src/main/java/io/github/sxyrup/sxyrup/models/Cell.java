package io.github.sxyrup.sxyrup.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cell implements Serializable {
  private String UCID; //OK, ONE PER ENTITY
  private CellType type;
  private String line; //TODO ENUM!
  private String alias;
  private List<Integer> passageNumber = new ArrayList<>();
  private List<String> vialsFromCell = new ArrayList<>();
  private String note;

  private boolean transgenic;
  private boolean hasGFP;
  private boolean hasResistance;
  private boolean clonal;

  private Vial vial;

  public Cell() { //CONSTRUCTOR FOR NEW ENTITY
    this.UCID = UUID.randomUUID().toString();
  }

  public Cell(Vial vial) { //FOR THAWING
    copyDataFromVial(vial);
  }

  private void copyDataFromVial(Vial vial) {
    this.UCID = vial.getUCID();
    this.type = vial.getCellType();
    this.line = vial.getCellLine();
    this.alias = vial.getCellAlias();
    this.passageNumber.set(0, 1);
    this.passageNumber.set(1, vial.getP1() + vial.getP2());
    this.note = vial.getCellNote();
    this.vialsFromCell.add(vial.getUVID());
    this.transgenic = vial.isCellIsTransgenic();
    this.hasGFP = vial.isCellHasGFP();
    this.hasResistance = vial.isCellHasResistance();
    this.clonal = vial.isCellIsClonal();
  }
}

