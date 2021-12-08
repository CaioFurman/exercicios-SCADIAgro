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

        System.out.println("\nSoma dos salários: "+somaSalario);
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

    public Bloco Ordenar(Funcionario funcionario) {
         return null;
    }
}