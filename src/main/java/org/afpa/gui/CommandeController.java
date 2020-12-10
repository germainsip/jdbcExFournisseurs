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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static org.afpa.App.changeFxml;

public class CommandeController implements Initializable {
    public TextArea affichageArea;
    public ComboBox listeFouCombo;
    public Button boutonMenu;
    public Button menuButton;

    ObservableList<String> listFournis = FXCollections.observableArrayList("Tous");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            String dest = "jdbc:mysql://localhost:3306/papyrus";
            Connection con = DriverManager.getConnection(dest, "root", "");
            PreparedStatement stm = con.prepareStatement("SELECT nomfou FROM fournis");

            ResultSet result = stm.executeQuery();
            while (result.next()) {
                listFournis.add(result.getString("nomfou"));

            }

            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("La base de donnée n'est pas joignable.");

        }
        listeFouCombo.setItems(listFournis);
    }

    public void handleBoxSelectionFournis(ActionEvent actionEvent) {
        String dest = "jdbc:mysql://localhost:3306/papyrus";
        String nom = (String) listeFouCombo.getValue();
        int num=0;
        String tmp ="";
        if (nom.equals("Tous")){
            try{
                Connection con = DriverManager.getConnection(dest,"root","");
                Statement stm = con.createStatement();
                ResultSet resultDef = stm.executeQuery("SELECT * FROM entcom");

                while (resultDef.next()){
                    tmp += resultDef.getString("numcom")+"| "+resultDef.getString("datcom")+"| "+resultDef.getString("obscom")+"\n";

                }
                affichageArea.setText(tmp);
            }catch (Exception e){
                System.out.println("error");
                System.out.println(e.getMessage());
            }
        }else{
            try {

                Connection con = DriverManager.getConnection(dest, "root", "");
                PreparedStatement stm1 = con.prepareStatement("SELECT numfou,nomfou FROM fournis where nomfou = ?");
                PreparedStatement stm2 = con.prepareStatement("SELECT*  FROM entcom WHERE numfou = ?");

                stm1.setString(1, nom);
                ResultSet result1 = stm1.executeQuery();
                while (result1.next()){
                    num = result1.getInt("numfou");}

                stm2.setInt(1, num);
                ResultSet result2 = stm2.executeQuery();
                while (result2.next()) {
                    tmp += result2.getString("numcom")+"| "+result2.getString("datcom")+"| "+result2.getString("obscom")+"\n";


                }
                affichageArea.setText(tmp);
                stm1.close();
                stm2.close();
                con.close();
            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e.getMessage());}}
    }

    public void handleButtonMenu(ActionEvent actionEvent) throws IOException {
        changeFxml("menu");
    }

}
