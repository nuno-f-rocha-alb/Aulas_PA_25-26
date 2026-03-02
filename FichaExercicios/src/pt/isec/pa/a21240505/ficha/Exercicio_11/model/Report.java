package pt.isec.pa.a21240505.ficha.Exercicio_11.model;

import java.util.ArrayList;

public class Report {
    private String title;
    private ArrayList<String> authors;
    private StringBuilder text;

    public Report(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.text = new StringBuilder();
    }

    public void addAuthor(String author){
        for (String a : authors)
            if (a.equalsIgnoreCase(author))
                return;
        authors.add(author);
    }

    public void removeAuthor(String author){
        for (int i = 0; i < authors.size(); i++){
            if (authors.get(i).equalsIgnoreCase(author)) {
                authors.remove(i);
                return;
            }
        }
    }

    public void addText(String text){
        this.text.append(" ").append(text);
    }


    public void capitalizeSentences() {
        boolean afterPeriod = true;

        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (c == '.' || c == '!' || c == '?') {
                afterPeriod = true;
            } else if (afterPeriod && Character.isLetter(c)) {
                text.setCharAt(i, Character.toUpperCase(c));
                afterPeriod = false;
            } else if(!Character.isWhitespace(c)) {
                afterPeriod = false;
            }
        }
    }

    public int getNumberOfWords() {
        String trimmed = text.toString().trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        String[] words = trimmed.split("[\\s,\\.]+");
        return words.length;
    }

    public int getNumberOfOccurrences(String word) {
        String trimmed = text.toString().trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        String[] words = trimmed.split("[\\s,\\.!?]+");
        int count = 0;
        for(String w : words){
            if(w.equalsIgnoreCase(word)) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO ===\n");
        sb.append("Título: ").append(title).append("\n");
        sb.append("Autores: ").append(authors.toString()).append("\n");
        sb.append("---\n");
        sb.append(text.toString());
        return sb.toString();
    }

}
