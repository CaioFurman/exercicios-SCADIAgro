package ex05_06;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Funcionario {


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

        public String toString(){
            return "\n"+codFuncionario+"\nNome: "+nome+"\nSalário: "+valorSalario+"\nDias de empresa: "+diasEmpresa()+" dias\n";
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

}