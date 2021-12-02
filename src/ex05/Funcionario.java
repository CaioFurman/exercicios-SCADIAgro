package ex05;

import java.time.LocalDate;

public class Funcionario {


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

}