package Exercicio_02;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int nTentativas = 0;
        boolean acertou = false;
        Random gerador = new Random();
        int low = 1;
        int high = 100;

        System.out.println("Pense num numero entre 1 e 100");
        System.out.println("Vou tentar adivinhar");

        while (!acertou){
            int numeroAleatorio = gerador.nextInt(high - low + 1) + low;
            System.out.println("O teu numero é " + numeroAleatorio + "?");
            System.out.println("Maior, menor ou acertei? (maior/menor/acertou)");
            boolean respostaValida = false;
            while (!respostaValida) {
                System.out.print("> ");
                String resposta = teclado.nextLine();
                if (resposta.equalsIgnoreCase("menor")) {
                    high = numeroAleatorio - 1;
                    nTentativas++;
                    respostaValida = true;
                } else if (resposta.equalsIgnoreCase("maior")) {
                    low = numeroAleatorio + 1;
                    nTentativas++;
                    respostaValida = true;
                } else if (resposta.equalsIgnoreCase("acertou")) {
                    nTentativas++;
                    respostaValida = true;
                    acertou = true;
                } else {
                    System.out.println("Resposta invalida!");
                }
            }

        }
        System.out.println("Acertei em " + nTentativas + " tentativas!");
    }
}
