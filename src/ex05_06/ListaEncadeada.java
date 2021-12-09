package ex05_06;

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

    public void SomaSalarios() {
        Bloco bloco = primeiro;
        double somaSalario = 0;
        double f1 = bloco.getFuncionario().getValorSalario();
        do {
            double f2 = bloco.getNext().getFuncionario().getValorSalario();

            somaSalario = f1 + f2;
            f1 = somaSalario;

            bloco = bloco.getNext();

        } while (bloco.getNext() != null);
        String resultadoSomaSalario = String.format("%.2f", somaSalario);
        System.out.println("\nSoma dos salários: R$" + resultadoSomaSalario);

    }

    public void MediaSalarios() {
        System.out.println("\nMedia dos salários: ");
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

    public void ListaNome() {
        Funcionario temp;
        bloco = primeiro;

         do {
            if (bloco.getFuncionario().getNome().compareTo(bloco.getNext().getFuncionario().getNome()) > 0) {
                temp = bloco.getFuncionario();
                bloco.setFuncionario(bloco.getNext().getFuncionario());
                bloco.getNext().setFuncionario(temp);
            }
            bloco = bloco.getNext();
         } while  (bloco.getNext() != null);

        Listar();
    }

    public void ListaCodigo() {
        Funcionario temp;
        bloco = primeiro;

        do {
            if (bloco.getFuncionario().getCodFuncionario() > bloco.getNext().getFuncionario().getCodFuncionario()) {
                temp = bloco.getFuncionario();
                bloco.setFuncionario(bloco.getNext().getFuncionario());
                bloco.getNext().setFuncionario(temp);
            }
            bloco = bloco.getNext();
        } while  (bloco.getNext() != null);

        Listar();
    }
}