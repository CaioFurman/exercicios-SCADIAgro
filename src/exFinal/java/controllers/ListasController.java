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

public class ListasController {
    private Stage stage;
    private Scene scene;

    @FXML TextArea rtbLista;
    @FXML Label lblTotal;

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

    public void MostrarLista() throws FileNotFoundException {
        String pathDefault = "./data/funcionario.dat";
        ListaEncadeada listaFuncionarios = LerFuncionario(pathDefault);

        rtbLista.setText(listaFuncionarios.Listar());
        lblTotal.setText(String.valueOf(listaFuncionarios.tamanhoLista()));
    }

    public void MostrarListaCodigo() throws IOException {
        String pathDefault = "./data/funcionario.dat";
        ListaEncadeada listaFuncionarios = LerFuncionario(pathDefault);

        rtbLista.setText(listaFuncionarios.ListaCodigo());
    }

    public void MostrarListaNome() throws IOException {
        String pathDefault = "./data/funcionario.dat";
        ListaEncadeada listaFuncionarios = LerFuncionario(pathDefault);

        rtbLista.setText(listaFuncionarios.ListaNome());
    }

    public void SelecionarSalarios(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Salarios.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

        stage.setTitle("SCADIAgro - Exercício final");
        stage.setWidth(900);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void Sair(ActionEvent evento) {
        stage = (Stage)((Node)evento.getSource()).getScene().getWindow();
        stage.close();
    }
}