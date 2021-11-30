import java.util.Scanner;

// 1) Realizar a leitura do salário do colaborador e calcular o valor do INSS de acordo com a tabela de valores abaixo :
//    Salário do contribuinte Alíquota de INSS

//    Até R$ 1.100 7,5%
//    De R$ 1.100,01 a R$ 2.203,48 9%
//    De R$ 2.203,49 até R$ 3.305,22 12%
//    De R$ 3.305,23 até R$ 6.433,57 14%

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o seu salário?");
        double salario = scanner.nextDouble();
        double valorINSS = 0;

        if (salario <= 1100) {
            valorINSS = (salario * 0.075);

        } else if (salario <= 2203.48) {
            valorINSS = (salario * 0.09);

        } else if (salario <= 3305.22) {
            valorINSS = (salario * 0.12);

        } else if (salario <= 6433.57) {
            valorINSS = (salario * 0.14);

        } else if (salario >= 6433.58) {
            valorINSS = (6433.57 * 0.14);
        }

        System.out.format("O valor do INSS é: %.2f", valorINSS);
    }
}
