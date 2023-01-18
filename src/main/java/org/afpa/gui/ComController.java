package org.afpa.gui;

import javafx.scene.control.Label;
import org.afpa.DAL.Commande;

public class ComController {
    public Label numcomLabel;
    public Label datcomLabel;
    public Label obscomLabel;

    public void setCom(Commande commande){
        numcomLabel.setText(String.valueOf(commande.getNumcom()));
        datcomLabel.setText(commande.getDatcom());
        obscomLabel.setText(commande.getObscom());
    }
}
