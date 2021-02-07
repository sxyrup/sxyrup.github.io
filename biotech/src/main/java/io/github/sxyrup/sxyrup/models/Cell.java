package io.github.sxyrup.sxyrup.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cell implements Serializable {
  private String originUCID; //if cloning etc happens
  private String UCID; //OK, ONE PER ENTITY
  private CellType type;
  private String line; //TODO ENUM!
  private String alias;
  private List<Integer> passageNumber = new ArrayList<>();
  private List<String> vialsFromCell = new ArrayList<>();  //for FREEZE method
  private String note;

  private boolean transgenic = false;
  private boolean hasGFP = false;
  private boolean hasResistance = false;
  private boolean clonal = false;

  int p1, p2;

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

  public int getP1() {
    return passageNumber.get(0);
  }

  public int getP2() {
    return passageNumber.get(1);
  }

  public void setP1(int p1) {
    passageNumber.set(0, p1);
  }

  public void setP2(int p2) {
    passageNumber.set(1, p2);
  }


  public String getUCID() {
    return UCID;
  }

  public void setUCID(String UCID) {
    this.UCID = UCID;
  }

  public CellType getType() {
    return type;
  }

  public void setType(CellType type) {
    this.type = type;
  }

  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public List<Integer> getPassageNumber() {
    return passageNumber;
  }

  public void setPassageNumber(List<Integer> passageNumber) {
    this.passageNumber = passageNumber;
  }

  public List<String> getVialsFromCell() {
    return vialsFromCell;
  }

  public void setVialsFromCell(List<String> vialsFromCell) {
    this.vialsFromCell = vialsFromCell;
  }

  public String getNote() {
    return note;
  }

  @Override
  public String toString() {
    return "Cell{" +
        "originUCID='" + originUCID + '\'' +
        ", UCID='" + UCID + '\'' +
        ", type=" + type +
        ", line='" + line + '\'' +
        ", alias='" + alias + '\'' +
        ", passageNumber=" + passageNumber +
        ", vialsFromCell=" + vialsFromCell +
        ", note='" + note + '\'' +
        ", transgenic=" + transgenic +
        ", hasGFP=" + hasGFP +
        ", hasResistance=" + hasResistance +
        ", clonal=" + clonal +
        ", p1=" + p1 +
        ", p2=" + p2 +
        ", vial=" + vial +
        '}';
  }

  public void setNote(String note) {
    this.note = note;
  }

  public boolean isTransgenic() {
    return transgenic;
  }

  public void setTransgenic(boolean transgenic) {
    this.transgenic = transgenic;
  }

  public boolean isHasGFP() {
    return hasGFP;
  }

  public void setHasGFP(boolean hasGFP) {
    this.hasGFP = hasGFP;
  }

  public boolean isHasResistance() {
    return hasResistance;
  }

  public void setHasResistance(boolean hasResistance) {
    this.hasResistance = hasResistance;
  }

  public boolean isClonal() {
    return clonal;
  }

  public void setClonal(boolean clonal) {
    this.clonal = clonal;
  }

  public Vial getVial() {
    return vial;
  }

  public void setVial(Vial vial) {
    this.vial = vial;
  }
}

