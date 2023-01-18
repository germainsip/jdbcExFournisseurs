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

  public long getNumcom() {
    return numcom;
  }

  public void setNumcom(long numcom) {
    this.numcom = numcom;
  }

  public String getObscom() {
    return obscom;
  }

  public void setObscom(String obscom) {
    this.obscom = obscom;
  }

  public String getDatcom() {
    return datcom;
  }

  public void setDatcom(String datcom) {
    this.datcom = datcom;
  }

  public long getNumfou() {
    return numfou;
  }

  public void setNumfou(long numfou) {
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
