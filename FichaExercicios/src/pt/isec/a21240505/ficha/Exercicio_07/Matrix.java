package pt.isec.a21240505.ficha.Exercicio_07;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    float[][] matrix;

    public Matrix(int row, int column) {
        matrix = new float[row][column];
    }

    public Matrix(Matrix m){
        matrix = new float[m.matrix.length][m.matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
              matrix[i][j] = m.matrix[i][j];
            }
        }
    }

    public void generate() {
        Random generator = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = generator.nextInt(101);
            }
        }
    }

    public void show() {
        for (float[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public float get(int row, int column) {
        return matrix[row][column];
    }

    public void set(int row, int column, float value) {
        matrix[row][column] = value;
    }

    public boolean add(Matrix m2) {
        if (matrix.length != m2.matrix.length || matrix[0].length != m2.matrix[0].length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += m2.get(i, j);
            }
        }
        return true;
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        Matrix m3 = new Matrix(m1);
        if(!m3.add(m2))
            return null;
        return m3;
    }
}
