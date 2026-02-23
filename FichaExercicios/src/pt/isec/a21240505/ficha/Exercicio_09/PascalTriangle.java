package pt.isec.a21240505.ficha.Exercicio_09;

public class PascalTriangle {

    int [][] triangle;
    int n;

    public PascalTriangle(int n) {
        triangle = new int[n][n];
        this.n = n;
        generate();

    }

    private void generate(){
        int i, j;
        triangle[0][0] = 1;
        for (i = 1; i < triangle.length; i++) {
            triangle[i][0] = 1;
            for (j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
            triangle[i][i] = 1;
        }
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();
        int maxNum = triangle[n-1][n/2];
        int width = String.valueOf(maxNum).length();
        for (int i = 0; i < n; i++) {
            int spaces = (n-i-1)*(width+1)/2;
            sb.append(" ".repeat(spaces));
            for (int j = 0; j <= i; j++) {
                sb.append(String.format("%"+(width+1) + "d ", triangle[i][j]));
            }

            sb.append("\n");
        }
        return sb.toString();
    }

    public void show(boolean b) {
        if(b){
            System.out.println(getString());
        } else {
            for(int i = 0; i < n; i++){
                for(int j = 0; j <= i; j++){
                    System.out.print(triangle[i][j]);
                    if(j < i) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
