//4) Dado um determinado texto responda as seguintes perguntas :
//a) quantidade de caracteres descontando os espaços
//b) quantidade de palavras
//c) cada palavra e o nro de vezes que ela aparece no texto
//d) escrever o texto na ordem inversa
//e) escrever o texto, palavra por palavra na ordem inversa

//- Texto 1 :

//É nas manhãs silenciosas
//Quando não tem ninguém perto que ele mostra o que ele é
//Faz nascer do zero, as mais belas criações
//Ele corre os riscos
//Em cada curva tem um pouco dele
//Lapidando cada traço ele eleva a arte, as linhas se encaixam, rimam, ele ilustra a vida, ele também é poeta.
//E por apreço poético, ele que desenha os seus poemas, agora está desenhado em palavras, porque poeta também pode ser poesia.



//- Bia Brandão

//Texto 2 :
//socorram me subi no onibus em marrocos

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {

        //TODO: usar input, refazer a pergunta D e polir o código.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantas linhas tem o texto?");
        String[] input = new String[scanner.nextInt()];
        scanner.nextLine();

        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextLine();
        }

        for (String texto : input) {
            System.out.println(texto);
        }
        System.out.println();

        //Texto teste (temporário)
        String texto2 = """
            É nas manhãs silenciosas
            Quando não tem ninguém perto que ele mostra o que ele é
            Faz nascer do zero, as mais belas criações
            Ele corre os riscos
            Em cada curva tem um pouco dele
            Lapidando cada traço ele eleva a arte, as linhas se encaixam, rimam, ele ilustra a vida, ele também é poeta.
            E por apreço poético, ele que desenha os seus poemas, agora está desenhado em palavras, porque poeta também pode ser poesia.
            
            - Bia Brandão\"""";

        //A) Contagem de caracteres
        int quantidadeCaracteres = texto2.replace("\\s+", "").length();

        System.out.println("A) Quantidade de caracteres: "+quantidadeCaracteres);
        System.out.println("-------------");

        //B) Contagem de palavras
        String txt = texto2.trim();
        int quantidadePalavras = txt.split("\\s+").length;

        System.out.println("B) Quantidade de palavras: "+quantidadePalavras);
        System.out.println("-------------");

        //C) Cada palavra e o nro de vezes que ela aparece no texto
        System.out.println("C) Cada palavra e a quantidade de vezes que ela aparece no texto:");

        String[] palavras = texto2.split("\\s+");
        int palavrasRepetidas =1;

        for(int i = 0; i < palavras.length; i++)
        {
            for (int j = i + 1; j < palavras.length; j++)
            {
                if (palavras[i].equalsIgnoreCase(palavras[j]))
                {
                    palavrasRepetidas = palavrasRepetidas + 1;
                    palavras[j] = "0";
                }
            }
            if (palavras[i] != "0") {
                System.out.println(palavras[i] + ":" + palavrasRepetidas);
                palavrasRepetidas = 1;
            }
        }

        System.out.println("-------------");

        //D) escrever o texto na ordem inversa
        String textoInverso = new StringBuilder(texto2).reverse().toString();

        System.out.println("D) Texto inverso:");
        System.out.println(textoInverso);

        System.out.println("-------------");

        //E) escrever o texto, palavra por palavra na ordem inversa
        System.out.println("E) Texto na ordem inversa:");

    }
}
