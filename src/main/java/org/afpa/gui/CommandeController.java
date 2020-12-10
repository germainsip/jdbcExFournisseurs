package org.afpa.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import org.afpa.App;
import org.afpa.DAL.Commande;
import org.afpa.DAL.CommandeDAO;
import org.afpa.DAL.Fournisseur;
import org.afpa.DAL.FournisseurDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

import static org.afpa.App.changeFxml;

public class CommandeController implements Initializable {
    public TextArea affichageArea;
    public ComboBox<Fournisseur> listeFouCombo;
    public Button boutonMenu;
    public Button menuButton;

    ObservableList listFournis = FXCollections.observableArrayList("Tous");

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

    public void handleBoxSelectionFournis(ActionEvent actionEvent) {
        String dest = "jdbc:mysql://localhost:3306/papyrus";
        String nom = String.valueOf(listeFouCombo.getValue());
        String tmp = "";
        if (nom.equals("Tous")) {

            try {
                CommandeDAO commandeDAO = new CommandeDAO();
                List<Commande> listCommandes = commandeDAO.ListAll();
                for (Commande commande : listCommandes) {
                    tmp += commande.toString() + "\n";
                    System.out.println();
                }
                affichageArea.setText(tmp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            try {
                CommandeDAO commandeDAO = new CommandeDAO();
                List<Commande> listCommandes = commandeDAO.listCommandeByFournisseur(listeFouCombo.getSelectionModel().getSelectedItem().getNumfou());
                for (Commande commande : listCommandes) {
                    tmp += commande.toString() + "\n";
                    System.out.println();
                }
                affichageArea.setText(tmp);
            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e.getMessage());
            }
        }
    }

    public void handleButtonMenu(ActionEvent actionEvent) throws IOException {
        changeFxml("menu");
    }

}
