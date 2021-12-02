package ex05;
//5) Tendo a estrutura de dados abaixo

//CodFuncionario : Inteiro
//Nome : String
//ValorSalario : String
//DataAdmissao : Date

//Leia uma lista desses funcionários até que seja informado o CodFuncionario igual a zero, após concluir a leitura apresentar :

//a) Total de funcionarios
//b) Lista completa de funcionários mostrando o tempo de empresa de cada um deles (Data Atual - Data de Admissão)
//c} Soma dos Salário
//d) Média dos Salários
//e) Mostrar os dados do Maior e do Menor Salário

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ex05 {


    public static void main(String[] args) {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int codFuncionario;
        double somaSalario = 0;
        LocalDate dataHoje = LocalDate.now();

            do {
                System.out.println("Codigo do funcionário: ");
                codFuncionario = scanner.nextInt();
                if (codFuncionario == 0){
                    break;
                }
                scanner.nextLine();

                System.out.println("\nNome do funcionário:");
                String nome = scanner.nextLine();

                System.out.println("\nSalário do funcionário:");
                double valorSalario = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("\nData de Admissão: (dd/MM/yyyy)");
                String dataInput = scanner.nextLine();

                DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataAdmissao = LocalDate.parse(dataInput, dataFormato);

                System.out.println("\n-------------");

                Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);
                listaFuncionarios.add(funcionario);

            } while (codFuncionario != 0);

            System.out.println("\n-------------");

            //A) Total de funcionários
            int totalFuncionarios = listaFuncionarios.size();
            System.out.println("A)O total de funcionários é: " + totalFuncionarios);
            System.out.println("\n-------------");

            //B) Lista completa de funcionários mostrando o tempo de empresa de cada um deles (Data Atual - Data de Admissão)
            System.out.println("B) Lista completa de funcionários mostrando o tempo de empresa de cada um deles (Data Atual - Data de Admissão)");
            System.out.println();

            for (int i = 0; i < totalFuncionarios; i++) {
                System.out.println(listaFuncionarios.get(i).codFuncionario);
                System.out.println("Nome: " + listaFuncionarios.get(i).nome);
                System.out.format("Salário: R$ %.2f", listaFuncionarios.get(i).valorSalario);
                System.out.println("\nData: " +dataHoje+ " - " + listaFuncionarios.get(i).dataAdmissao);
                System.out.println();
            }
            System.out.println("-------------");

            //C) Soma dos salarios
            for(int i = 0; i < listaFuncionarios.size(); i++) {
                somaSalario += listaFuncionarios.get(i).valorSalario;
            }
            System.out.format("C) Soma dos salarios: R$ %.2f",somaSalario);
            System.out.println("\n\n-------------");

            //D) Média dos salarios
            double mediaSalario = somaSalario / totalFuncionarios;
            System.out.format("D) Média dos salarios: R$ %.2f",mediaSalario);
            System.out.println("\n\n-------------");

            //E) Mostrar os dados do Maior e do Menor Salário
            double[] listaSalarios = new double[totalFuncionarios];
            for(int i = 0; i < listaFuncionarios.size(); i++) {
                listaSalarios[i] = listaFuncionarios.get(i).valorSalario;
            }
            Arrays.sort(listaSalarios);
            System.out.println("E) Mostrar os dados do Maior e do Menor Salário");
            System.out.format("\nMenor salário: R$ %.2f", listaSalarios[0]);
            System.out.format("\nMaior salário: R$ %.2f", listaSalarios[listaFuncionarios.size() - 1]);
    }
}
