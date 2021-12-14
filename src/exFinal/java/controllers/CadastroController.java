package controllers;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import funcoes.Funcionario;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroController {
    private Stage stage;
    private Scene scene;
    ArrayList<String> tempLista = new ArrayList<>();

    @FXML private TextField txtCodigo, txtNome, txtSalario;
    @FXML private DatePicker txtData;


    public void SelecionarSalarios(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Salarios.fxml"));
        stage = (Stage)((Node)evento.getSource()).getScene().getWindow();
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



    public void Registrar() {
        int codFuncionario = parseInt(txtCodigo.getText());
        String nome = txtNome.getText();
        double valorSalario = parseDouble(txtSalario.getText());
        LocalDate dataAdmissao = txtData.getValue();

        Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);

        tempLista.add(String.valueOf(funcionario));

        Limpar();
    }

    public void Salvar() throws IOException {
        String pathDefault = "./data/funcionario.dat";
        FileWriter registrarDado = new FileWriter(pathDefault);
        int i;
        for(i = 0; i < tempLista.size(); i++) {
            String funcionario = tempLista.get(i);

            try{
                registrarDado.write(funcionario);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        registrarDado.close();

        Alert confirmacao = new Alert(AlertType.INFORMATION);
        confirmacao.setTitle("Salvar");
        confirmacao.setHeaderText("Dados salvos na lista.");
        confirmacao.show();
    }

    public void Sair(ActionEvent evento) {
        stage = (Stage)((Node)evento.getSource()).getScene().getWindow();
        stage.close();
    }

    public void Limpar(){
        txtCodigo.clear();
        txtNome.clear();
        txtSalario.clear();
    }
}