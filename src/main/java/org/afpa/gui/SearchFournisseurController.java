package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.afpa.App;

import java.io.IOException;
import java.sql.*;

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
        String dest = "jdbc:mysql://localhost:3306/papyrus";
        try {
            Connection con = DriverManager.getConnection(dest, "root", "Gm1");
            PreparedStatement stm = con.prepareStatement("SELECT * FROM fournis where numfou = ?");
            stm.setString(1,numField.getText());

            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()){
                nomField.setText(resultSet.getString("nomfou"));
                rueField.setText(resultSet.getString("RUEFOU"));
                cpField.setText(resultSet.getString("posfou"));
                villeField.setText(resultSet.getString("vilfou"));
                contactField.setText(resultSet.getString("confou"));
                avertissement.setText("");
            } else avertissement.setText("pas de résultat");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("la recherche n'à pas pu aboutir");
            alert.showAndWait();
        }
    }
}
