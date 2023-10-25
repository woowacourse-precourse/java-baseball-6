package baseball;

import java.util.ArrayList;

public class Number {
    public static final int DEFAULT_NUMBER_SIZE = 3;
    int size = DEFAULT_NUMBER_SIZE;
    ArrayList<Integer> values = new ArrayList<>(size);

    public int getSize() {
        return size;
    }
    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }
}

