package controllers;

import static funcoes.LeitorDados.LerFuncionario;

import funcoes.ListaEncadeada;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SalariosController {
    private Stage stage;
    private Scene scene;

    @FXML Label lblSoma, lblMedia, lblMaior, lblMenor;
    @FXML TextArea rtbSalarios;

    public void SelecionarCadastro(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Cadastro.fxml"));
        stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

        stage.setTitle("SCADIAgro - Exercício final");
        stage.setWidth(900);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void SelecionarListas(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Listas.fxml"));
        stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

        stage.setTitle("SCADIAgro - Exercício final");
        stage.setWidth(900);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void Calcular() throws FileNotFoundException {
        String pathDefault = "./data/funcionario.dat";
        ListaEncadeada listaFuncionarios = LerFuncionario(pathDefault);

        lblSoma.setText(String.format("R$ %.2f", listaFuncionarios.SomaSalarios()));
        lblMedia.setText(String.format("R$ %.2f", listaFuncionarios.MediaSalarios()));
        lblMaior.setText(String.format("R$ %.2f", listaFuncionarios.MaiorSalario()));
        lblMenor.setText(String.format("R$ %.2f", listaFuncionarios.MenorSalario()));

        rtbSalarios.setText(listaFuncionarios.Listar());
    }

    public void Sair(ActionEvent evento) {
        stage = (Stage)((Node)evento.getSource()).getScene().getWindow();
        stage.close();
    }
}