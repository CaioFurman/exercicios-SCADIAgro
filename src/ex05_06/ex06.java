package ex05_06;

//6) Transforme o exercicio 5 usando uma lista duplamente encadeada (que seja possível navegar entre os registro em ambos os sentidos - próximo e anterior), com as seguintes caracteristicas :
//a) Encadeamento ordenado pelo CodFuncionario
//b) Encadeamento ordenado pelo Nome
//c) Mostrar a lista de funcionários ordenado pelo CodFuncionario usando a lista encadeada
//d) Mostrar a lista de funcionários ordenado pelo Nome usando a lista encadeada

import ex05_06.Funcionario.CodComparar;
import ex05_06.Funcionario.NomeComparar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {

        LinkedList<Funcionario> listaEncadeada = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int codFuncionario;
        double somaSalario = 0;
        String linha = "\n-------------";
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

            System.out.println("\nData de Admissão: (dd/MM/yyyy)");
            String dataInput = scanner.nextLine();

            DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataAdmissao = LocalDate.parse(dataInput, dataFormato);

            System.out.println(linha);

            Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);
            listaEncadeada.offer(funcionario);

        }
        while (codFuncionario != 0);
        System.out.println(linha);

        //A) Total de funcionários
        int totalFuncionarios = listaEncadeada.size();
        System.out.println("A)O total de funcionários é: " + totalFuncionarios);
        System.out.println(linha);

        //B) Lista completa de funcionários mostrando o tempo de empresa de cada um deles (Data Atual - Data de Admissão)
        System.out.println("B) Lista completa de funcionários mostrando o tempo de empresa de cada um deles (Data Atual - Data de Admissão)");
        Iterator<Funcionario> iterador = listaEncadeada.iterator();
        while (iterador.hasNext()){
            System.out.print(iterador.next());
        }
        System.out.println(linha);

        //C) Soma dos salarios
        for (Funcionario funcionario : listaEncadeada) {
            somaSalario += funcionario.valorSalario;
        }
        System.out.format("C) Soma dos salários: R$ %.2f", somaSalario);
        System.out.println("\n" + linha);

        //D) Média dos salarios
        double mediaSalario = somaSalario / totalFuncionarios;
        System.out.format("D) Média dos salários: R$ %.2f",mediaSalario);
        System.out.println("\n" + linha);

        //E) Mostrar os dados do Maior e do Menor Salário
        double[] listaSalarios = new double[totalFuncionarios];
        for(int i = 0; i < totalFuncionarios; i++) {
            listaSalarios[i] = listaEncadeada.get(i).valorSalario;
        }
        Arrays.sort(listaSalarios);
        System.out.println("E) Mostrar os dados do Maior e do Menor Salário:");
        System.out.format("\nMaior salário: R$ %.2f", listaSalarios[totalFuncionarios - 1]);
        System.out.format("\nMenor salário: R$ %.2f", listaSalarios[0]);
        System.out.println("\n" + linha);

        //6- AC) Mostrar a lista de funcionários ordenado pelo CodFuncionario usando a lista encadeada
        CodComparar ordemCod = new CodComparar();
        listaEncadeada.sort(ordemCod);
        Iterator<Funcionario> iteradorCod = listaEncadeada.iterator();
        while (iteradorCod.hasNext()){
            System.out.print(iteradorCod.next());
        }
        System.out.println(linha);

        //6- BD) Mostrar a lista de funcionários ordenado pelo Nome usando a lista encadeada
        NomeComparar ordemNome = new NomeComparar();
        listaEncadeada.sort(ordemNome);
        Iterator<Funcionario> iteradorNome = listaEncadeada.iterator();
        while (iteradorNome.hasNext()){
            System.out.print(iteradorNome.next());
        }
        System.out.println(linha);

    }
}