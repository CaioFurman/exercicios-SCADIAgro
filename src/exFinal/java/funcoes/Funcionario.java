package funcoes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Funcionario implements Serializable {

        int codFuncionario;
        String nome;
        double valorSalario;
        LocalDate dataAdmissao;

        public Funcionario(int codFuncionario, String nome, double valorSalario, LocalDate dataAdmissao){
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
}