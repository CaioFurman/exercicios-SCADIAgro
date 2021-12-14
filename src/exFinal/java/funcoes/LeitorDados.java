package funcoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LeitorDados {
    public static String pathDefault = "./data/funcionario.dat";
    public static DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static ListaEncadeada LerFuncionario(String pathDefault) throws FileNotFoundException {
        LeitorDados.pathDefault = pathDefault;
        File f = new File(pathDefault);
        Scanner s = new Scanner(f);

        ListaEncadeada listaFuncionarios = new ListaEncadeada();
        while(s.hasNextLine()){
            String linha = s.nextLine();
            String[] dados = new String[4];
            dados[0] = linha.substring(0,6);
            dados[1] = linha.substring(6,106);
            dados[2] = linha.substring(106, 122);
            dados[3] = linha.substring(122, 132);

            int codFuncionario = Integer.parseInt(dados[0]);
            String nome = dados[1];
            double valorSalario = Double.parseDouble(dados[2]);
            LocalDate dataAdmissao = LocalDate.parse(dados[3], dataFormato);

            Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);
            listaFuncionarios.Adicionar(funcionario);
        }
        return listaFuncionarios;
    }
}