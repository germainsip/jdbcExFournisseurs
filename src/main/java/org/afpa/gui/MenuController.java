package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.afpa.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MenuController {
    public Button commandeButton;
    public Button fournisButton;
    public AnchorPane menuPane;
    public Button fournisAddButton;

    public void initialize(){

    }

    public void handleButtonCommande(ActionEvent actionEvent) throws IOException {
        App.changeFxml("commandes");
    }

    public void handleButtonFournisseurs(ActionEvent actionEvent) throws IOException {
        App.changeFxml("searchFournisseur");

    }

    public void handleButtonAddFournisseurs(ActionEvent actionEvent) throws IOException {
        App.changeFxml("addFournisseurs");
    }
}
