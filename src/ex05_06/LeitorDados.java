package ex05_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LeitorDados {
    public static String pathDefault = "./src/ex05_06/funcionario.dat";
    public static String pathCod = "./src/ex05_06/funcionario_idx01.idx";
    public static String pathNome = "./src/ex05_06/funcionario_idx02.idx";
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

    public static ListaEncadeada LerFuncionarioCod(String pathCod) throws FileNotFoundException {
        LeitorDados.pathCod = pathCod;
        File f = new File(pathCod);
        Scanner s = new Scanner(f);


        return null;
    }

    public static ListaEncadeada LerFuncionarioNome(String pathNome) throws FileNotFoundException {
        LeitorDados.pathNome = pathNome;
        File f = new File(pathNome);
        Scanner s = new Scanner(f);

        return null;
    }

}