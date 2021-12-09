package ex05_06;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.io.FileWriter;

public class Funcionario implements Serializable {

        int codFuncionario;
        String nome;
        double valorSalario;
        LocalDate dataAdmissao;

        Funcionario(int codFuncionario, String nome, double valorSalario, LocalDate dataAdmissao){
            this.codFuncionario = codFuncionario;
            this.nome = nome;
            this.valorSalario = valorSalario;
            this.dataAdmissao = dataAdmissao;
        }

        public int getCodFuncionario(){
            return codFuncionario;
        }

        public String getNome(){
            return nome;
        }

        public double getValorSalario(){
            return valorSalario;
        }

        public LocalDate getDataAdmissao() {
            return dataAdmissao;
        }

    public static class CodComparar implements Comparator<Funcionario> {
        @Override
        public int compare(Funcionario f1, Funcionario f2)
        {
            return Integer.compare(f1.getCodFuncionario(), f2.getCodFuncionario());
        }
    }

    public static class NomeComparar implements Comparator<Funcionario> {
        @Override
        public int compare(Funcionario f1, Funcionario f2)
        {
            return f1.getNome().compareTo(f2.getNome());
        }
    }


    public String toString() {
            double dCodFuncionario = codFuncionario;
        String strFuncionario = (String.format("%06.0f", dCodFuncionario));
        String strSalario = (String.format("%016.2f", valorSalario));
        String strNome = String.format("%-100s", nome);
        strSalario = strSalario.replace(",",".");

        StringBuffer buffer = new StringBuffer();
        buffer.append(strFuncionario).append(strNome).append(strSalario).append(dataAdmissao).append("\n");

        return buffer.toString();
    }

    public String Formatar() {

            int Codigo = getCodFuncionario();
            String Nome = getNome().trim();
            double salarioD = getValorSalario();
            String Salario = String.format("%.2f", salarioD);
            LocalDate dataHoje = LocalDate.now();
            long diasEmpresa = ChronoUnit.DAYS.between(dataAdmissao, dataHoje);

            StringBuffer buffer = new StringBuffer();
            buffer.append("Código: ").append(Codigo);
            buffer.append("\nNome: ").append(Nome);
            buffer.append("\nSalario: R$").append(Salario);
            buffer.append("\nTempo de empresa: ").append(diasEmpresa);
            buffer.append(" dias\n");

        return buffer.toString();
    }

    public String SalvarNome() throws IOException {
        String pathNome = "./src/ex05_06/funcionario_idx02.idx";
        FileWriter registrarDadoNome = new FileWriter(pathNome);
        try{
            registrarDadoNome.write("teste");
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}