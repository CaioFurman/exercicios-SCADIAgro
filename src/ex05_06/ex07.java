package ex05_06;

//7) Ainda utilizando o execicio 5, persistir os dados em arquivos textos com lagura fixa.

//a) Definição dos arquivos
//a - 1) "funcionario.dat" contento os dados dos funcionarios no seguinte formato :
//CodFuncionario -> String 6 caracteres
//Nome -> String 100 caracteres
//ValorSalario -> Numerico formatado com 13 casas antes da virgula, separador decimal . (ponto) e duas decimais com zeros a esquerda ( Ex.: 1500,00 -> 0000000001500.00 )
//DataAdmissao -> Data no formato YYYY-MM-AA
//a - 2) "funcionario_idx01.idx" contendo os dados da lista encadeada com a ordenação por código
//a - 3) "funcionario_idx02.idx" contendo os dados da lista encadeada com a ordenação por Nome

//b) fazer a rotina para ler os dados desses arquivos e preencher a estrutura de dados da lista de funcionários (dados e encadeamentos)
//c) fazer a listagem dos dados dos clientes
//- sem indexação
//- indexada pelo CodFuncionario
//- indexada pelo Nome

import static ex05_06.LeitorDados.LerFuncionario;
import static ex05_06.LeitorDados.LerFuncionarioCod;
import static ex05_06.LeitorDados.LerFuncionarioNome;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) throws IOException {
        String pathDefault = "./src/ex05_06/funcionario.dat";
        String pathCod = "./src/ex05_06/funcionario_idx01.idx";
        String pathNome = "./src/ex05_06/funcionario_idx02.idx";
        int codFuncionario;
        String linha = "\n-------------";
        String linha2 = "-------------";

        FileWriter registrarDado = new FileWriter(pathDefault);
        FileWriter registrarDadoCodigo = new FileWriter(pathCod);
        FileWriter registrarDadoNome = new FileWriter(pathNome);
        ListaEncadeada listaFuncionarios = new ListaEncadeada();
        Scanner scanner = new Scanner(System.in);

        do {
                System.out.println("Codigo do funcionário: ");
                codFuncionario = scanner.nextInt();
                if (codFuncionario == 0) {
                    break;
                }
                scanner.nextLine();

                System.out.println("\nNome do funcionário:");
                String nome = scanner.nextLine();

                System.out.println("\nSalário do funcionário:");
                double valorSalario = scanner.nextDouble();
                scanner.nextLine();


                System.out.println("\nData de Admissão: (yyyy-MM-dd)");
                String dataInput = scanner.nextLine();

                DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dataAdmissao = LocalDate.parse(dataInput, dataFormato);

                System.out.println(linha);

                Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);
                listaFuncionarios.Adicionar(funcionario);


                //SEM INDEXAÇÃO

            try{
                registrarDado.write(String.valueOf(funcionario));
            } catch (IOException e){
                e.printStackTrace();
            }

        } while (codFuncionario != 0);
        registrarDado.close();
        System.out.println(linha);

        //INDEXAÇÃO POR CÓDIGO


        //INDEXAÇÃO POR NOME


        //Exercício 7
        System.out.println("7 - C) Fazer a listagem dos dados dos clientes:");
        System.out.println("Sem indexação:\n");
        LerFuncionario(pathDefault);
        System.out.println(linha2);

        System.out.println("Indexação pelo código:\n");
        LerFuncionarioCod(pathCod);
        System.out.println(linha2);

        System.out.println("Indexação pelo nome:\n");
        LerFuncionarioNome(pathNome);
        System.out.println(linha2);
    }
}