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



import ex05_06.Funcionario.CodComparar;
import ex05_06.Funcionario.NomeComparar;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) throws IOException {
        String path = "./src/ex05_06/funcionario.dat";
        ObjectOutputStream os = null;
        os = new ObjectOutputStream(new FileOutputStream(path));
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
        Funcionario f;

        LinkedList<Funcionario> listaEncadeada = new LinkedList<>();;
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
                os.writeObject(funcionario);


        } while (codFuncionario != 0);
        os.close();
        System.out.println(linha);

        //Exercício 5

        //A) Total de funcionários
        int totalFuncionarios = listaEncadeada.size();
        System.out.println("5 - A)O total de funcionários é: " + totalFuncionarios);
        System.out.println(linha);

        //B) Lista completa de funcionários mostrando o tempo de empresa de cada um deles (Data Atual - Data de Admissão)
        System.out.println("5 - B) Lista completa de funcionários mostrando o tempo de empresa de cada um deles (Data Atual - Data de Admissão)\n");
        ListIterator<Funcionario> iterador = listaEncadeada.listIterator();
        while (iterador.hasNext()){
            System.out.print(iterador.next());
        }
        System.out.println(linha);

        //C) Soma dos salarios
        for (Funcionario funcionario : listaEncadeada) {
            somaSalario += funcionario.valorSalario;
        }
        System.out.format("5 - C) Soma dos salários: R$ %.2f", somaSalario);
        System.out.println("\n" + linha);

        //D) Média dos salarios
        double mediaSalario = somaSalario / totalFuncionarios;
        System.out.format("5 - D) Média dos salários: R$ %.2f",mediaSalario);
        System.out.println("\n" + linha);

        //E) Mostrar os dados do Maior e do Menor Salário
        double[] listaSalarios = new double[totalFuncionarios];
        for(int i = 0; i < totalFuncionarios; i++) {
            listaSalarios[i] = listaEncadeada.get(i).valorSalario;
        }
        Arrays.sort(listaSalarios);
        System.out.println("5 - E) Mostrar os dados do Maior e do Menor Salário:");
        System.out.format("\nMaior salário: R$ %.2f", listaSalarios[totalFuncionarios - 1]);
        System.out.format("\nMenor salário: R$ %.2f", listaSalarios[0]);
        System.out.println("\n" + linha);

        //Exercício 6

        // AC) Mostrar a lista de funcionários ordenado pelo CodFuncionario usando a lista encadeada
        System.out.println("6 - AC) Mostrar a lista de funcionários ordenado pelo CodFuncionario usando a lista encadeada:");
        CodComparar ordemCod = new CodComparar();
        listaEncadeada.sort(ordemCod);
        ListIterator<Funcionario> iteradorCod = listaEncadeada.listIterator();
        while (iteradorCod.hasNext()){
            System.out.print(iteradorCod.next());
        }
        System.out.println(linha);

        //BD) Mostrar a lista de funcionários ordenado pelo Nome usando a lista encadeada
        System.out.println("6 - BD) Mostrar a lista de funcionários ordenado pelo Nome usando a lista encadeada:");
        NomeComparar ordemNome = new NomeComparar();
        listaEncadeada.sort(ordemNome);
        ListIterator<Funcionario> iteradorNome = listaEncadeada.listIterator();
        while (iteradorNome.hasNext()){
            System.out.print(iteradorNome.next());
        }
        System.out.println(linha);

        //Exercício 7
        System.out.println("7 - C) fazer a listagem dos dados dos clientes:");
        System.out.println("Sem indexação:");
        try {
            f = (Funcionario) is.readObject();
            System.out.println(f);
            while ((f = (Funcionario) is.readObject()) != null) {
                System.out.println(f);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        is.close();
        System.out.println(linha);

        System.out.println("Indexação pelo código:");
        System.out.println(linha);

        System.out.println("Indexação pelo nome:");
        System.out.println(linha);
    }
}