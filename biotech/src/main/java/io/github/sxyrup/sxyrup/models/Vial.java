package io.github.sxyrup.sxyrup.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Vial implements Serializable { //todo save to json
  private static int nextId = 1;

  private CellType type;
  private String cellLine; //TODO ENUM?
  private String alias;
  private List<Integer> passageNumber = new ArrayList<>();
  //init : from form; thaw: set(0, 1) set(1, vial.p1 + vial.p2)
  private boolean expressingGFP;
  private boolean clonal;
  private String clonalNote;
  //TODO add cell
  private int id;
  private String UID;
  private boolean isPresent = true;
  private boolean puro;
  private LocalDate frozenDate; //TODO handle LocalDate in Thymeleaf form
  private LocalDate thawedDate;
  private String note;

  private int p1;
  private int p2;

  private int tank; //TODO container class?
  private int canister;
  private int cane;

  public String getUID() {
    return UID;
  }

  public Vial() {
    this.UID = UUID.randomUUID().toString();
  }


  public Vial(String cellLine, String alias, int p1, int p2, boolean puro, int tank, int canister,
              int cane, String note) {
    initId();
    this.cellLine = cellLine;
    this.alias = alias;
    this.p1 = p1;
    this.p2 = p2;
    this.puro = puro;
    this.tank = tank;
    this.canister = canister;
    this.cane = cane;
    this.note = note;
  }

  public void initId() {
    this.id = nextId++;
  }

  @Override
  public String toString() {
    return "Vial{" +
        "type=" + type +
        ", cellLine='" + cellLine + '\'' +
        ", alias='" + alias + '\'' +
        ", expressingGFP=" + expressingGFP +
        ", clonal=" + clonal +
        ", clonalNote='" + clonalNote + '\'' +
        ", id=" + id +
        ", isPresent=" + isPresent +
        ", puro=" + puro +
        ", frozenDate=" + frozenDate +
        ", thawedDate=" + thawedDate +
        ", note='" + note + '\'' +
        '}';
  }

  public void setPuro(boolean puro) {
    this.puro = puro;
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

  public static int getNextId() {
    return nextId;
  }

  public static void setNextId(int nextId) {
    Vial.nextId = nextId;
  }

  public CellType getType() {
    return type;
  }

  public void setType(CellType type) {
    this.type = type;
  }

  public String getCellLine() {
    return cellLine;
  }

  public void setCellLine(String cellLine) {
    this.cellLine = cellLine;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public boolean isExpressingGFP() {
    return expressingGFP;
  }

  public void setExpressingGFP(boolean expressingGFP) {
    this.expressingGFP = expressingGFP;
  }

  public boolean isClonal() {
    return clonal;
  }

  public void setClonal(boolean clonal) {
    this.clonal = clonal;
  }

  public String getClonalNote() {
    return clonalNote;
  }

  public void setClonalNote(String clonalNote) {
    this.clonalNote = clonalNote;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isPresent() {
    return isPresent;
  }

  public void setPresent(boolean present) {
    isPresent = present;
  }

  public boolean isPuro() {
    return puro;
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
    this.puro = true;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


}
