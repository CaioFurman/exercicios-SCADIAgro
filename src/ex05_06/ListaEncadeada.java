package ex05_06;

import java.io.FileWriter;
import java.io.IOException;

public class ListaEncadeada {
    private Bloco primeiro, ultimo;
    Bloco bloco = primeiro;
    private int tamanho = 0;

    public Bloco getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Bloco primeiro) {
        this.primeiro = primeiro;
    }

    public Bloco getUltimo() {
        return ultimo;
    }

    public void setUltimo(Bloco ultimo) {
        this.ultimo = ultimo;
    }

    public int tamanhoLista() {
        bloco = primeiro;
        do {
            tamanho++;
            bloco = bloco.getNext();
        } while (bloco != null);

        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void Adicionar(Funcionario funcionario) {
        Bloco bloco = new Bloco(funcionario);
        bloco.setPrev(ultimo);

        if (ultimo != null) {
            ultimo.setNext(bloco);
        }
        ultimo = bloco;
        if (primeiro == null) {
            primeiro = bloco;
        }
    }

    public void TotalFuncionarios() {
        System.out.println("\nTotal de funcionários: "+tamanhoLista());
    }

    public double SomarSalarios() {
        Bloco bloco = primeiro;
        double totalSoma = bloco.getFuncionario().getValorSalario();
        do {
            double nextFuncionario = bloco.getNext().getFuncionario().getValorSalario();
            totalSoma = totalSoma + nextFuncionario;

            bloco = bloco.getNext();

        } while (bloco.getNext() != null);

        return totalSoma;
    }

    public void SomaSalarios() {
        String resultadoSomaSalario = String.format("%.2f", SomarSalarios());
        System.out.println("\nSoma dos salários: R$" + resultadoSomaSalario);
    }

    public void MediaSalarios() {
        double mediaSalario = SomarSalarios() / tamanhoLista();
        String resultadoMediaSalario = String.format("%.2f", mediaSalario);
        System.out.println("\nMedia dos salários: R$" + resultadoMediaSalario);
    }

    public void MMSalarios() {
        System.out.println("\nMaior salário: ");
        System.out.println("\nMenor salário: ");
    }

    public void Listar() {
        Bloco bloco = primeiro;
        System.out.println();
        while (bloco != null) {
            System.out.println(bloco.funcionarioFormato());
            bloco = bloco.getNext();
        }
    }

    public void ListaNome() throws IOException {
        Funcionario temp;
        bloco = primeiro;
        String pathNome = "./src/ex05_06/funcionario_idx02.idx";
        FileWriter registrarDadoNome = new FileWriter(pathNome);

         do {
            if (bloco.getFuncionario().getNome().compareTo(bloco.getNext().getFuncionario().getNome()) > 0) {
                temp = bloco.getFuncionario();
                bloco.setFuncionario(bloco.getNext().getFuncionario());
                bloco.getNext().setFuncionario(temp);
            }

            try{
                registrarDadoNome.write(String.valueOf(bloco.getFuncionario()));
            } catch (IOException e){
                e.printStackTrace();
            }
            bloco = bloco.getNext();

         } while  (bloco.getNext() != null);

         try{
            registrarDadoNome.write(String.valueOf(bloco.getFuncionario()));
            registrarDadoNome.close();
         } catch (IOException e){
            e.printStackTrace();
         }


        Listar();
    }

    public void ListaCodigo() throws IOException {
        Funcionario temp;
        bloco = primeiro;
        String pathCod = "./src/ex05_06/funcionario_idx01.idx";
        FileWriter registrarDadoCodigo = new FileWriter(pathCod);

        do {
            if (bloco.getFuncionario().getCodFuncionario() > bloco.getNext().getFuncionario().getCodFuncionario()) {
                temp = bloco.getFuncionario();
                bloco.setFuncionario(bloco.getNext().getFuncionario());
                bloco.getNext().setFuncionario(temp);
            }

            try{
                registrarDadoCodigo.write(String.valueOf(bloco.getFuncionario()));
            } catch (IOException e){
                e.printStackTrace();
            }
            bloco = bloco.getNext();

        } while  (bloco.getNext() != null);

        try{
            registrarDadoCodigo.write(String.valueOf(bloco.getFuncionario()));
            registrarDadoCodigo.close();
        } catch (IOException e){
            e.printStackTrace();
        }


        Listar();
    }
}