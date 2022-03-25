package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.afpa.App;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static org.afpa.App.*;

public class FournisseursController implements Initializable {
    public Button menuButton;
    public TextField nomField;
    public TextField rueField;
    public TextField cpField;
    public TextField villeField;
    public TextField contactField;
    public Button ajouter;
    public Button annuler;

    boolean nomOK = false, rueOK = false, cpOK = false, villeOK = false, contactOK = false;
    boolean fieldOK;

    public void handleButtonMenu(ActionEvent actionEvent) throws IOException {
        changeFxml("menu");
    }

    public void handleButtonAjouter(ActionEvent actionEvent) {
        int num = 0;



        //TODO librairie de vérifications
        fieldOK = true;
        //passage à l'enregistrement si les valeurs sont bonnes
        if (fieldOK) {
            try {
                String dest = "jdbc:mysql://localhost:3306/papyrus";
                Connection con = DriverManager.getConnection(dest, "root", "tiger");
                PreparedStatement stm = con.prepareStatement("SELECT nomfou FROM fournis where nomfou = ?");
                Statement stm1 = con.createStatement();

                PreparedStatement stm2 = con.prepareStatement("INSERT INTO fournis (numfou, nomfou, ruefou, vilfou, posfou, confou) VALUES (?, ?, ?, ?, ?, ?)");
                ResultSet result1 = stm1.executeQuery("select max(numfou) as 'dernier' from fournis");

                stm.setString(1, nomField.getText());
                ResultSet result = stm.executeQuery();
                if (!result.next()) {
                    while (result1.next()) {
                        num = result1.getInt("dernier");

                    }
                    stm2.setInt(1, num + 1);
                    stm2.setString(2, nomField.getText());
                    stm2.setString(3, rueField.getText());
                    stm2.setString(4, villeField.getText());
                    stm2.setString(5, cpField.getText());
                    stm2.setString(6, contactField.getText());

                    stm2.execute();

                    stm1.close();
                    stm1.close();
                    result1.close();
                    con.close();
                    //affiche une alerte pour valider l'action
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Validation");
                    alert.setHeaderText("Création du nouveau fournisseur");
                    alert.setContentText("le fournisseur a bien été ajouté.");

                    alert.showAndWait();

                    handleButtonAnnuler(actionEvent);
                    System.out.println("c'est fait!!!");
                } else {
                    // affiche une alerte car le fournisseur existe déjà
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Validation");
                    alert.setHeaderText("Le fournisseur existe déjà");
                    alert.setContentText("le fournisseur n'a pas été ajouté.");

                    alert.showAndWait();
                    handleButtonAnnuler(actionEvent);
                }
            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Méga problème");
                alert.setHeaderText("Problème de connection");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            System.out.println("j'ai rien fait!!!");

        }
    }

    public void handleButtonAnnuler(ActionEvent actionEvent) throws IOException {
        cpField.clear();
        cpField.setStyle("");
        nomField.clear();
        nomField.setStyle("");
        rueField.clear();
        rueField.setStyle("");
        contactField.clear();
        contactField.setStyle("");
        villeField.clear();
        villeField.setStyle("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
