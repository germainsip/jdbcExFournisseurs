package org.afpa.DAL;


import java.sql.Timestamp;

public class Commande {

  private long numcom;
  private String obscom;
  private String datcom;
  private long numfou;

  public Commande() {
  }

  public Commande(long numcom, String obscom, String datcom, long numfou) {
    this.numcom = numcom;
    this.obscom = obscom;
    this.datcom = datcom;
    this.numfou = numfou;
  }

  @Override
  public String toString() {
    return
            "Commande numéro: " + numcom + "||"
                    + "date: " + datcom + "||"
                    + " observation: " + obscom;

  }
}
