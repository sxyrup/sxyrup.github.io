package io.github.sxyrup.sxyrup.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Vial implements Serializable { //todo save to json
  private CellType cellType;
  private String cellLine; //TODO ENUM!!
  private String cellAlias;
  private String cellNote;
  private boolean cellIsTransgenic;
  private boolean cellHasGFP;
  private boolean cellHasResistance;
  private boolean cellIsClonal;
  private boolean cellExpressingGFP;

  private String UVID;
  private String UCID;


  private boolean vialIsPresent = true;
  private boolean puroInMedia;
  private LocalDate frozenDate; //TODO handle LocalDate in Thymeleaf form
  private LocalDate thawedDate;
  private String vialNote;

  private int p1;
  private int p2;

  private int tank;
  private int canister;
  private int cane;

  public Vial() {
    this.UVID = UUID.randomUUID().toString();
  }

  public Vial(String cellLine, String cellAlias, int p1, int p2, boolean puroInMedia, int tank, int canister,
              int cane, String vialNote) {
    this.cellLine = cellLine;
    this.cellAlias = cellAlias;
    this.p1 = p1;
    this.p2 = p2;
    this.puroInMedia = puroInMedia;
    this.tank = tank;
    this.canister = canister;
    this.cane = cane;
    this.vialNote = vialNote;
  }


  public String getUVID() {
    return UVID;
  }

  public String getUCID() {
    return UCID;
  }

  public boolean isCellIsTransgenic() {
    return cellIsTransgenic;
  }

  public void setCellIsTransgenic(boolean cellIsTransgenic) {
    this.cellIsTransgenic = cellIsTransgenic;
  }

  public boolean isCellHasGFP() {
    return cellHasGFP;
  }

  public void setCellHasGFP(boolean cellHasGFP) {
    this.cellHasGFP = cellHasGFP;
  }

  public boolean isCellHasResistance() {
    return cellHasResistance;
  }

  public void setCellHasResistance(boolean cellHasResistance) {
    this.cellHasResistance = cellHasResistance;
  }

  public void setP1(int p1) {
    this.p1 = p1;
  }

  public void setP2(int p2) {
    this.p2 = p2;
  }

  public void setUCID(String UCID) {
    this.UCID = UCID;
  }

  public void setUVID(String UVID) {
    this.UVID = UVID;
  }

  public void setPuroInMedia(boolean puroInMedia) {
    this.puroInMedia = puroInMedia;
  }


  public int getTank() {
    return tank;
  }

  public void setTank(int tank) {
    this.tank = tank;
  }

  public int getCanister() {
    return canister;
  }

  public void setCanister(int canister) {
    this.canister = canister;
  }

  public int getCane() {
    return cane;
  }

  public void setCane(int cane) {
    this.cane = cane;
  }

  public CellType getCellType() {
    return cellType;
  }

  public void setCellType(CellType cellType) {
    this.cellType = cellType;
  }

  public String getCellLine() {
    return cellLine;
  }

  public void setCellLine(String cellLine) {
    this.cellLine = cellLine;
  }

  public String getCellAlias() {
    return cellAlias;
  }

  public void setCellAlias(String cellAlias) {
    this.cellAlias = cellAlias;
  }

  public boolean isCellExpressingGFP() {
    return cellExpressingGFP;
  }

  public void setCellExpressingGFP(boolean cellExpressingGFP) {
    this.cellExpressingGFP = cellExpressingGFP;
  }

  public boolean isCellIsClonal() {
    return cellIsClonal;
  }

  public void setCellIsClonal(boolean cellIsClonal) {
    this.cellIsClonal = cellIsClonal;
  }

  public String getCellNote() {
    return cellNote;
  }

  public void setCellNote(String cellNote) {
    this.cellNote = cellNote;
  }

  public boolean isVialIsPresent() {
    return vialIsPresent;
  }

  public void setVialIsPresent(boolean vialIsPresent) {
    this.vialIsPresent = vialIsPresent;
  }

  public boolean isPuroInMedia() {
    return puroInMedia;
  }

  public Integer getP1() {
    return p1;
  }

  public void setP1(Integer p1) {
    this.p1 = p1;
  }

  public Integer getP2() {
    return p2;
  }

  public void setP2(Integer p2) {
    this.p2 = p2;
  }

  public void setPuro() {
    this.puroInMedia = true;
  }


  public String getVialNote() {
    return vialNote;
  }

  public void setVialNote(String vialNote) {
    this.vialNote = vialNote;
  }


}
