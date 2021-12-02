package ex05_06;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

}