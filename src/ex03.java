import java.util.Scanner;

//3) Suponhamos que estamos fazendo um empréstimo e gostariamos de fazer um parcelamento em no máximo 12 vezes sem juros.
//Leia o valor da compra e o nro de parcelas e apresente o valor a ser pago em cada parcela.
// Coloque no final o valor da totalização das parcelas calculadas com precisão decimal de duas casas.

//Obs.: Como se trata de valor financeiro os cálculos das parcelas devem ser representados com a precisão de duas casas decimais.
//O valor total das parcelas somadas, utilizando somente as duas casas decimais, deve ser igual ao valor financiado.

//Exemplo :
//Valor financiado : 100,00
//Nro de Parcelas .: 4
//-------------------
//Parcelas
//-------------------
//Parcela 01 : 25,00
//Parcela 02 : 25,00
//Parcela 03 : 25,00
//Parcela 04 : 25,00
//-------------------
//Total .....: 100,00

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor financiado?");
        double valorFinanciado = scanner.nextDouble();
        System.out.println();

        System.out.println("Quantas parcelas?");
        int quantidadeParcelas = scanner.nextInt();
        System.out.println();

        if (quantidadeParcelas > 12) {
            System.out.println("O limite de parcelas é 12.\nPor favor, tente novamente.");

        } else {

            System.out.format("Valor financiado : %.2f\n", valorFinanciado);
            System.out.println("Nro de parcelas .: " +quantidadeParcelas);

            System.out.println("-------------------");
            System.out.println("Parcelas");
            System.out.println("-------------------");

            double calculoParcelas = ((valorFinanciado / quantidadeParcelas) * 100);
            double valorParcelas = calculoParcelas / 100;

            int i = 0;
            while(i != quantidadeParcelas) {
                i++;
                System.out.format("Parcela " +(i)+ " : %.2f\n", valorParcelas);
            }

            System.out.println("-------------------");

            double valorTotal = ((calculoParcelas * quantidadeParcelas) / 100);

            System.out.format("Total ....: %.2f", valorTotal);
        }
    }
}