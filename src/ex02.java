import java.util.Scanner;

// 2) Realizar a leitura do salário do colaborador e calcular o valor do INSS de acordo com a tabela de valores abaixo, seguindo a regra usada no INSS :

//    Por exemplo:
//    Uma pessoa com salário de R$ 4 mil deverá calcular o valor do INSS em todas as faixas, considerando o limite de cada uma, e somar tudo
//    em vez de usar apenas a alíquota da última faixa (14%). Ficaria assim:

//    1ª faixa: R$ 1.100 x 7,5% = R$ 82,50
//    2ª faixa: (R$ 2.203,48 – R$ 1.100) x 9% = R$ 1.103,48 x 9% = R$ 99,31
//    3ª faixa: (R$ 3.305,22 – R$ 2.203,49) x 12% = R$ 1.101,73 x 12% = R$ 132,20
//    4ª faixa: (R$ 4.000 – R$ 3.305,23) x 14% = R$ 694,77 x 14% = R$ 97,26

//    Somando tudo (R$ 82,50 + R$ 99,31 + R$ 132,20 + R$ 97,26) ficaria R$ 411,27 de INSS.

//    Salário do contribuinte Alíquota de INSS
//    Até R$ 1.100 7,5%
//    De R$ 1.100,01 a R$ 2.203,48 9%
//    De R$ 2.203,49 até R$ 3.305,22 12%
//    De R$ 3.305,23 até R$ 6.433,57 14%

public class ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double primeiraFaixa = (1100 * 0.075);
        double segundaFaixa = ((2203.48 - 1100) * 0.09);
        double terceiraFaixa = ((3305.22 - 2203.49) * 0.12);
        double quartaFaixa = ((6433.57 - 3305.23) * 0.14);
        double tetoINSS = (primeiraFaixa + segundaFaixa + terceiraFaixa + quartaFaixa);
        double valorINSS = 0;

        System.out.println("Qual o seu salário?");
        double salario = scanner.nextDouble();

        if (salario <= 1100) {
            valorINSS = (salario * 0.075);

        } else if (salario <= 2203.48) {
            double valorFaixa = ((salario - 1100) * 0.09);
            valorINSS = valorFaixa + primeiraFaixa;


        } else if (salario <= 3305.22) {
            double valorFaixa = ((salario - 2203.49) * 0.12);
            valorINSS = valorFaixa + primeiraFaixa + segundaFaixa;


        } else if (salario <= 6433.57) {
            double valorFaixa = ((salario - 3305.23) * 0.14);
            valorINSS = valorFaixa + primeiraFaixa + segundaFaixa + terceiraFaixa;

        } else if (salario >= 6433.58) {
            valorINSS = tetoINSS;

        }

        System.out.format("O valor do INSS é: %.2f", valorINSS);
    }
}