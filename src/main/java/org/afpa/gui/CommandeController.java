package org.afpa.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import org.afpa.DAL.Commande;
import org.afpa.DAL.CommandeDAO;
import org.afpa.DAL.Fournisseur;
import org.afpa.DAL.FournisseurDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import static org.afpa.App.changeFxml;

public class CommandeController implements Initializable {
    public TextArea affichageArea;
    public ComboBox<Fournisseur> listeFouCombo;
    public Button menuButton;

    ObservableList<Fournisseur> listFournis = FXCollections.observableArrayList(new Fournisseur(0,"Tous"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FournisseurDAO fournisseurDAO = new FournisseurDAO();
            listFournis.addAll(fournisseurDAO.ListAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("La base de donnée n'est pas joignable.");
        }

        listeFouCombo.setItems(listFournis);
    }

    public void handleButtonMenu() throws IOException {
        changeFxml("menu");
    }
    public void handleBoxSelectionFournis() {
        String nom = String.valueOf(listeFouCombo.getValue());
        StringBuilder tmp = new StringBuilder();
        if (nom.equals("Tous")) {

            try {
                CommandeDAO commandeDAO = new CommandeDAO();
                List<Commande> listCommandes = commandeDAO.ListAll();
                for (Commande commande : listCommandes) {
                    tmp.append(commande.toString()).append("\n");
                    System.out.println();
                }
                affichageArea.setText(tmp.toString());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            try {
                CommandeDAO commandeDAO = new CommandeDAO();
                List<Commande> listCommandes = commandeDAO
                        .listCommandeByFournisseur(listeFouCombo.getSelectionModel().getSelectedItem().getNumfou());
                for (Commande commande : listCommandes) {
                    tmp.append(commande.toString()).append("\n");
                    System.out.println();
                }
                affichageArea.setText(tmp.toString());
            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e.getMessage());
            }
        }
    }


}
