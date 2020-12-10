package org.afpa.DAL;


public class Fournisseur {

  private int numfou;
  private String nomfou;
  private String ruefou;
  private String posfou;
  private String vilfou;
  private String confou;
  private int satisf;

  public Fournisseur(int numfou, String nomfou, String ruefou, String posfou, String vilfou, String confou, int satisf) {
    this.numfou = numfou;
    this.nomfou = nomfou;
    this.ruefou = ruefou;
    this.posfou = posfou;
    this.vilfou = vilfou;
    this.confou = confou;
    this.satisf = satisf;
  }

  public Fournisseur(int numfou, String nomfou) {
    this.numfou = numfou;
    this.nomfou = nomfou;
  }

  public int getNumfou() {
    return numfou;
  }

  public String getNomfou() {
    return nomfou;
  }

  public String getRuefou() {
    return ruefou;
  }

  public String getPosfou() {
    return posfou;
  }

  public String getVilfou() {
    return vilfou;
  }

  public String getConfou() {
    return confou;
  }

  public int getSatisf() {
    return satisf;
  }

  @Override
  public String toString() {
    return nomfou;
  }
}
