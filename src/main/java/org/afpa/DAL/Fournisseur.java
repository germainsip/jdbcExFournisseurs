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

  @Override
  public String toString() {
    return nomfou;
  }
}
