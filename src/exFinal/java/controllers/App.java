package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.StageStyle;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Cadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        //Image icone = new Image("scadicon.png");
        //stage.getIcons().add(icone);

        stage.setTitle("SCADIAgro - Exercício final");
        stage.setWidth(900);
        stage.setHeight(500);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}