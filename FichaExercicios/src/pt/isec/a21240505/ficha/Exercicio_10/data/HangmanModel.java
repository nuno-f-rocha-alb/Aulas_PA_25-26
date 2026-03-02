package pt.isec.a21240505.ficha.Exercicio_10.data;

import java.util.Random;

public class HangmanModel {

    private static final int MAX_LIVES = 7;
    private String word;
    private StringBuffer guess;
    private StringBuffer wrongLetters;
    private int attempts;
    private int errors;


    public HangmanModel() {
    }

    public void start() {
        getLIbraryWord();
        guess = new StringBuffer();
        guess.append(".".repeat(word.length()));
        wrongLetters = new StringBuffer();
        errors = 0;
        attempts = 0;
    }

    public String getCurrentSituation() {
        return guess.toString();
    }

    public void tryGuess(String guessInput){
        guessInput = guessInput.toUpperCase();
        if(guessInput.length() == 1) {
            char letter = guessInput.charAt(0);
            if (word.indexOf(letter) != -1) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        guess.setCharAt(i, letter);
                    }
                }
            } else {
                wrongLetters.append(letter);
                errors++;
            }
        } else {
            if(guessInput.equals(word)){
                guess = new StringBuffer(word);
            }
            else{
                errors++;
            }
        }
        attempts++;
    }

    public boolean isGameOver(){
        return errors == MAX_LIVES;
    }

    public boolean hasWon(){
        return word.contentEquals(guess);
    }

    public int getAttempts() {return attempts;}

    public int getErrors() {return errors;}

    public String getTriedLetters(){return wrongLetters.toString();}

    //boolean wasLetterTried(char letter){
    //    for(int i = 0; i < wrongLetters.length(); i++)
    //        if(wrongLetters.charAt(i) == letter) return true;
    //    for(int i = 0; i < guess.length(); i++)
    //        if(guess.charAt(i) == letter) return true;
    //    return false;
    //}

    public int getMaxLives(){return MAX_LIVES;}

    public String getWord(){return word;}

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("Situação atual: ").append(guess.toString()).append("\n");
        sb.append("Nr. tentativas: ").append(attempts).append("\n");
        sb.append("Erros: ").append(errors).append(" (máx.: ").append(MAX_LIVES).append(")\n");
        sb.append("Caracteres já tentados: ").append(wrongLetters.toString());

        return sb.toString();
    }

    private void getLIbraryWord() {
        word = "";
        Random generator = new Random();
        word = HangmanDictionary.getWord(generator.nextInt(HangmanDictionary.getDictionarySize()));
    }

}
