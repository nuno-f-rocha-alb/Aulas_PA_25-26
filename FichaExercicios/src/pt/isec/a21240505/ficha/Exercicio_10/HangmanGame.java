package pt.isec.a21240505.ficha.Exercicio_10;

import pt.isec.a21240505.ficha.Exercicio_10.data.HangmanModel;
import pt.isec.a21240505.ficha.Exercicio_10.ui.HangmanUI;

public class HangmanGame {
    public static void main(String args[]) {
        HangmanModel game = new HangmanModel();
        HangmanUI gameUI = new HangmanUI(game);
        gameUI.play();
    }
}