package Exercicio_03;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        int nElementos;
        int[] array;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Vamos criar um array.");
        System.out.println("Quantos elementos vai ter?");
        System.out.print("Numero de Elementos:> ");
        while (!teclado.hasNextInt()) {
            teclado.nextLine();
            System.out.println("Valor invalido!");
            System.out.print("> ");
        }
        nElementos = teclado.nextInt();
        array = new int[nElementos];

        System.out.println("Quais os valores a adicionar no array?");
        for (int i = 0; i < nElementos; i++) {
            System.out.print("Valor[" + i + "]:> ");
            while (!teclado.hasNextInt()){
                teclado.nextLine();
                System.out.println("Valor invalido!");
                System.out.print("Valor[" + i + "]:> ");
            }
            array[i] = teclado.nextInt();
        }

        System.out.println("Alinha a) Imprimir o array:");
        imprimirArray(array);

        System.out.println("Alinha b) Calcular e imprimir o maior e o menor elemento presentes no array:");
        calculaMaiorMenor(array);

        System.out.println("Alinha c) Somar todos os elementos do array, retornando a soma:");
        System.out.println(somaArray(array));

        System.out.println("Alinha d) Calcular e imprimir a média dos valores do array:");
        mediaArray(array);

        System.out.println("Alinha e) Inverter todos os valores presentes no array, [i0, i1, ..., in-1] => [in-1, ..., i1, i0]:");
        int[] arrayInvertido = inverteArray(array);
        imprimirArray(arrayInvertido);

    }

    static void imprimirArray(int[] array){
        for (int elemento : array) {
            System.out.println(elemento + " ");
        }
    }

    static void calculaMaiorMenor(int[] array){
        int maior = array[0];
        int menor = array[0];
        for (int elemento : array) {
            if (elemento > maior) {
                maior = elemento;
            } else if (elemento < menor) {
                menor = elemento;
            }
        }
        System.out.println("Maior: " + maior + " | Menor: " + menor);
    }

    static int somaArray(int[] array){
        int soma = 0;
        for (int elemento : array) {
            soma += elemento;
        }
        return soma;
    }

    static void mediaArray(int[] array){
        System.out.println((double) somaArray(array) / array.length);
    }

    static int[] inverteArray(int[] array){
        int[] arrayInvertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayInvertido[i] = array[array.length - i - 1];
        }
        return arrayInvertido;
    }


}
