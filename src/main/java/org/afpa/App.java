package org.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static Stage stage;
    static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Méthode de changement de vue
     * @param fxml nom du fxml sans extension
     * @throws IOException
     */
    public static void changeFxml(String fxml) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("/org/afpa/gui/" + fxml + ".fxml"));
        scene.setRoot(root);
        stage.hide();
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/afpa/gui/menu.fxml"));
        scene = new Scene(root);
        stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Exercices JDBC");
        stage.setScene(scene);
        stage.show();
    }
}
