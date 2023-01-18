package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.afpa.DAL.Fournisseur;
import org.afpa.DAL.FournisseurDAO;

import java.io.IOException;
import java.sql.SQLException;

import static org.afpa.App.changeFxml;

public class SearchFournisseurController {
    public Button menuButton;
    public TextField numField;
    public Button searchBtn;
    public Label avertissement;
    public TextField contactField;
    public TextField villeField;
    public TextField cpField;
    public TextField rueField;
    public TextField nomField;

    public void handleButtonMenu(ActionEvent actionEvent) throws IOException {
        changeFxml("menu");
    }

    public void searchMethode(ActionEvent actionEvent) {

        
        int numfou = Integer.parseInt(numField.getText());
        try {
            FournisseurDAO fournisseurDAO = new FournisseurDAO();
            Fournisseur fournisseur = fournisseurDAO.find(numfou);
            if(fournisseur !=null){
                nomField.setText(fournisseur.getNomfou());
                rueField.setText(fournisseur.getRuefou());
                cpField.setText(fournisseur.getPosfou());
                villeField.setText(fournisseur.getVilfou());
                contactField.setText(fournisseur.getConfou());
                avertissement.setText("");
            } else {
                nomField.setText("");
                rueField.setText("");
                cpField.setText("");
                villeField.setText("");
                contactField.setText("");
                avertissement.setText("pas de résultat");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
