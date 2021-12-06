package ex05_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class LeitorDados {
    public static String pathDefault = "./src/ex05_06/funcionario.dat";
    public static String pathCod = "./src/ex05_06/funcionario_idx01.idx";
    public static String pathNome = "./src/ex05_06/funcionario_idx02.idx";
    public static String separador = " / ";

    public static LinkedList<Funcionario> LerFuncionario(String pathDefault) throws FileNotFoundException {
        LeitorDados.pathDefault = pathDefault;
        File f = new File(pathDefault);
        Scanner s = new Scanner(f);

        LinkedList<Funcionario> listaFuncionarios = new LinkedList<>();
        while(s.hasNextLine()){
            String linha = s.nextLine();
            String[] dados = linha.split(separador);

            System.out.println("Código: " +dados[0]);
            System.out.println("Nome: " +dados[1]);
            System.out.println("Salário: " +dados[2]);
            System.out.println("Tempo de empresa: " +dados[3]+ " dias");
            System.out.println();

            int codFuncionario = Integer.parseInt(dados[0]);
            String nome = dados[1];
            double valorSalario = Double.parseDouble(dados[2]);
            LocalDate dataAdmissao = LocalDate.now();

            Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);
            listaFuncionarios.offer(funcionario);
        }
        return listaFuncionarios;
    }

    public static LinkedList<Funcionario> LerFuncionarioCod(String pathCod) throws FileNotFoundException {
        LeitorDados.pathCod = pathCod;
        File f = new File(pathCod);
        Scanner s = new Scanner(f);

        LinkedList<Funcionario> listaFuncionarios = new LinkedList<>();
        while(s.hasNextLine()){
            String linha = s.nextLine();
            String[] dados = linha.split(separador);

            System.out.println("Código: " +dados[0]);
            System.out.println("Nome: " +dados[1]);
            System.out.println("Salário: " +dados[2]);
            System.out.println("Tempo de empresa: " +dados[3]+ " dias");
            System.out.println();

            int codFuncionario = Integer.parseInt(dados[0]);
            String nome = dados[1];
            double valorSalario = Double.parseDouble(dados[2]);
            LocalDate dataAdmissao = LocalDate.now();

            Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);
            listaFuncionarios.offer(funcionario);
        }
        return listaFuncionarios;
    }

    public static LinkedList<Funcionario> LerFuncionarioNome(String pathNome) throws FileNotFoundException {
        LeitorDados.pathNome = pathNome;
        File f = new File(pathNome);
        Scanner s = new Scanner(f);

        LinkedList<Funcionario> listaFuncionarios = new LinkedList<>();
        while(s.hasNextLine()){
            String linha = s.nextLine();
            String[] dados = linha.split(separador);

            System.out.println("Código: " +dados[0]);
            System.out.println("Nome: " +dados[1]);
            System.out.println("Salário: " +dados[2]);
            System.out.println("Tempo de empresa: " +dados[3]+ " dias");
            System.out.println();

            int codFuncionario = Integer.parseInt(dados[0]);
            String nome = dados[1];
            double valorSalario = Double.parseDouble(dados[2]);
            LocalDate dataAdmissao = LocalDate.now();

            Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);
            listaFuncionarios.offer(funcionario);
        }
        return listaFuncionarios;
    }
}