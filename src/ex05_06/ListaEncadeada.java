package ex05_06;

public class ListaEncadeada {
    private Bloco primeiro, ultimo;
    Bloco bloco = primeiro;
    int tamanho = 0;

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

    public void Imprimir() {
        Bloco bloco = primeiro;

        while (bloco != null) {
            System.out.println(bloco.funcionarioFormato());
            bloco = bloco.getNext();
        }
    }

}