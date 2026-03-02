package pt.isec.a21240505.ficha.Exercicio_10.ui;
import pt.isec.a21240505.ficha.Exercicio_10.data.HangmanModel;

import java.util.Scanner;

public class HangmanUI {
    private HangmanModel game;
    Scanner teclado;
    public HangmanUI(HangmanModel game) {
        this.game = game;
        teclado = new Scanner(System.in);
    }

    public void play() {
        game.start();

        while(!game.isGameOver() && !game.hasWon()){
            System.out.println(game);
            System.out.println(" ");
            System.out.print("Tentativa: ");
            String tentativa = teclado.nextLine().trim();
            while(!isValidInput(tentativa)){
                System.out.println("Tentativa invalida!");
                System.out.print("Tentativa: ");
                tentativa = teclado.nextLine().trim();
            }
            game.tryGuess(tentativa);
            System.out.println(" ");
            System.out.println(" ");
        }
        if(game.isGameOver()) System.out.println("Fim do jogo!");
        if(game.hasWon()) System.out.println("Parabéns! Acertou na palavra " + game.getCurrentSituation() + " em " + game.getAttempts() + " tentativas");

        System.out.println("Play again? (y/n)");
        String resposta = teclado.nextLine();
        if(resposta.equalsIgnoreCase("n")){
            System.exit(0);
        } else {
            play();
        }

    }

    private boolean isValidInput(String input) {

        if(input == null || input.isEmpty()) return false;

        for (int i = 0; i < input.length(); i++) {
            if(!Character.isLetter(input.charAt(i))) return false;
        }
        return true;
    }
}
