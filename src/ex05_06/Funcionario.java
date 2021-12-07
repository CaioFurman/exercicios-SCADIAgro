package ex05_06;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Funcionario implements Serializable {

        int codFuncionario;
        String nome;
        double valorSalario;
        LocalDate dataAdmissao;
        LocalDate dataHoje = LocalDate.now();

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
        buffer.append(strFuncionario).append(strNome).append(strSalario).append(dataAdmissao).append("\n");;

        return buffer.toString();
    }
}