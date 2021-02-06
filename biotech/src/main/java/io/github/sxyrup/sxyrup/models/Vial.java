package io.github.sxyrup.sxyrup.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Vial extends Cell {
  private static int nextId = 0;

  private CellType type;
  private String cellLine;
  private String alias;
  private List<Integer> passageNumber = new ArrayList<>();
  private boolean expressingGFP;
  private boolean clonal;
  private String clonalNote;
  //first part is the cell
  private int id;
  private boolean isPresent = true;
  private boolean puro;
  private LocalDate frozenDate;
  private LocalDate thawedDate;
  private List<Integer> location = new ArrayList<>();
  private String note;

  private int p1;
  private int p2;

  private int tank;
  private int canister;
  private int cane;


  public Vial() {
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

  public void setPassageNumber() {
    this.passageNumber.add(p1);
    this.passageNumber.add(p2);
  }

  public void setLocation() {
    this.passageNumber.add(tank);
    this.passageNumber.add(canister);
    this.passageNumber.add(cane);
  }


  @Override
  public String toString() {
    return "Vial{" +
        "type=" + type +
        ", cellLine='" + cellLine + '\'' +
        ", alias='" + alias + '\'' +
        ", passageNumber=" + passageNumber +
        ", expressingGFP=" + expressingGFP +
        ", clonal=" + clonal +
        ", clonalNote='" + clonalNote + '\'' +
        ", id=" + id +
        ", isPresent=" + isPresent +
        ", puro=" + puro +
        ", frozenDate=" + frozenDate +
        ", thawedDate=" + thawedDate +
        ", location=" + location +
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

  public List<Integer> getPassageNumber() {
    return passageNumber;
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

  public LocalDate getFrozenDate() {
    return frozenDate;
  }

  public void setFrozenDate(LocalDate frozenDate) {
    this.frozenDate = frozenDate;
  }

  public LocalDate getThawedDate() {
    return thawedDate;
  }

  public void setThawedDate(int dd, int mm, int yyyy) {
    this.thawedDate = LocalDate.of(dd, mm, yyyy);
  }

  public List<Integer> getLocation() {
    return location;
  }

  public void setLocation(List<Integer> location) {
    this.location = location;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


}
