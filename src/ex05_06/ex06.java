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
import java.util.LinkedList;
import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {

        LinkedList<Funcionario> listaEncadeada = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int codFuncionario;

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

            System.out.println("\n-------------");

            Funcionario funcionario = new Funcionario(codFuncionario, nome, valorSalario, dataAdmissao);
            listaEncadeada.offer(funcionario);

        }
        while (codFuncionario != 0);

        //C) Mostrar a lista de funcionários ordenado pelo CodFuncionario usando a lista encadeada
        CodComparar ordemCod = new CodComparar();
        listaEncadeada.sort(ordemCod);
        System.out.println(listaEncadeada);
        System.out.println("\n-------------");

        //D) Mostrar a lista de funcionários ordenado pelo Nome usando a lista encadeada
        NomeComparar ordemNome = new NomeComparar();
        listaEncadeada.sort(ordemNome);
        System.out.println(listaEncadeada);
        System.out.println("\n-------------");

    }
}
