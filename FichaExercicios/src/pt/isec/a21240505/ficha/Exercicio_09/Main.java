package pt.isec.a21240505.ficha.Exercicio_09;

public class Main {
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle(5);

        System.out.println(pt.getString());

        pt.show(true); // false - v1; true - v2;
    }
}
