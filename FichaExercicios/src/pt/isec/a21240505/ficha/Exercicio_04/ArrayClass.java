package pt.isec.a21240505.ficha.Exercicio_04;

import java.util.Random;

public class ArrayClass {
    int[] array;
    int duplicated;
    int count;
    private static final int MAX_ELEMENTS = 20;

    public ArrayClass(){
        this.array = new int[MAX_ELEMENTS];
        this.duplicated = 0;
        this.count = 0;
    }

    private boolean valueExists(int value){
        for (int i = 0; i < count; i++)
            if (array[i] == value)
                return true;
        return false;
    }

    public boolean add(int value){
        if (valueExists(value)) {
            duplicated++;
            return false;
        }
        array[count++] = value;
        return true;
    }
    public void generate(){
        Random generator = new Random();
        while (count < array.length) {
            add(generator.nextInt(101));
        }
    }

    public void show(){
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print((i==0 ? "" : ", ") + array[i]);
        }
    }
    public void showDuplicateCount(){
        System.out.println("Duplicate count: " + duplicated);
    }
}
