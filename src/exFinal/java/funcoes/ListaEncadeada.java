package funcoes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

public class ListaEncadeada {
    private Bloco primeiro, ultimo;
    Bloco bloco = primeiro;
    private int tamanho = 0;

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

    public double SomaSalarios() {
        Bloco bloco = primeiro;
        double totalSoma = bloco.getFuncionario().getValorSalario();
        do {
            double nextFuncionario = bloco.getNext().getFuncionario().getValorSalario();
            totalSoma = totalSoma + nextFuncionario;

            bloco = bloco.getNext();

        } while (bloco.getNext() != null);

        return totalSoma;
    }

    public double MediaSalarios() {
        return SomaSalarios() / tamanhoLista();
    }

    public double MaiorSalario() {
        Bloco bloco = primeiro;
        double maiorSalario = 0;
        do {
            double salarioFuncionario = bloco.getFuncionario().getValorSalario();
            if (maiorSalario < salarioFuncionario) {
                maiorSalario = salarioFuncionario;
            }
            bloco = bloco.getNext();
        } while (bloco.getNext() !=null);

        double salarioFuncionario = bloco.getFuncionario().getValorSalario();
        if (maiorSalario < salarioFuncionario) {
            maiorSalario = salarioFuncionario;
        }

        return maiorSalario;
    }

    public double MenorSalario() {
        Bloco bloco = primeiro;
        double menorSalario = Double.MAX_VALUE;
        do {
            double salarioFuncionario = bloco.getFuncionario().getValorSalario();
            if (menorSalario > salarioFuncionario) {
                menorSalario = salarioFuncionario;
            }
            bloco = bloco.getNext();
        } while (bloco.getNext() !=null);

        double salarioFuncionario = bloco.getFuncionario().getValorSalario();
        if (menorSalario > salarioFuncionario) {
            menorSalario = salarioFuncionario;
        }

        return menorSalario;
    }

    public String Listar() {
        Bloco bloco = primeiro;
        StringJoiner s = new StringJoiner("\n");
        while (bloco != null) {
            String funcionario = (String) bloco.funcionarioFormato();
            s.add(funcionario);
            bloco = bloco.getNext();
        }
        return String.valueOf(s);
    }

    public String ListaNome() throws IOException {
        Funcionario temp;
        Bloco bloco = primeiro;
        String pathNome = "./data/funcionario_idx02.idx";
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

        return Listar();
    }

    public String ListaCodigo() throws IOException {
        Funcionario temp;
        bloco = primeiro;
        String pathCod = "./data/funcionario_idx01.idx";
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

        return Listar();
    }
}