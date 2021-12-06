package ex05_06;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Funcionario implements Serializable {

        public static String path = "./src/ex05_06/funcionario.dat";
        public static String separador = " / ";

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

        public long diasEmpresa(){
            return ChronoUnit.DAYS.between(this.dataAdmissao, dataHoje);
        }

        //public String toString(){
          //  return "Código: "+codFuncionario+"\nNome: "+nome+"\nSalário: "+valorSalario+"\nDias de empresa: "+diasEmpresa()+" dias\n-------------\n";
        //}

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
        //buffer.append("Código: ").append(codFuncionario);
        //buffer.append("\n");
        //buffer.append("Nome: ").append(nome);
        //buffer.append("\n");
        //buffer.append("Salário: R$").append(valorSalario);
        //buffer.append("\n");
        //buffer.append("Tempo de empresa: ").append(diasEmpresa()).append(" dias");
        //buffer.append("\n");

        String stringSalario = (String.format("%013.2f", valorSalario));
        stringSalario = stringSalario.replace(",",".");
        StringBuffer buffer = new StringBuffer();
        buffer.append(codFuncionario).append(separador);
        buffer.append(nome).append(separador);
        buffer.append(stringSalario).append(separador);
        buffer.append(dataAdmissao).append("\n");;

        return buffer.toString();
    }
}