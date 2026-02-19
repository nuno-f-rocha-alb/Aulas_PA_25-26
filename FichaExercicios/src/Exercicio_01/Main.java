package Exercicio_01;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Random gerador = new Random();
        int numeroRandom = gerador.nextInt(101);
        boolean acertou = false;
        Scanner teclado = new Scanner(System.in);
        System.out.println(numeroRandom);
        System.out.println("Adivinha o numero entre 0 e 100!");
        while (!acertou){
            System.out.print("Tentativa: ");
            int numeroUtilizador = teclado.nextInt();
            if (numeroUtilizador == numeroRandom) {
                System.out.println("Acertou!");
                acertou = true;
            }else {
                System.out.println("Errou!");
            }
        }
        System.out.println("Parabens! Fim do jogo.");
    }
}