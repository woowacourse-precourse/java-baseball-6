package baseball;

import java.util.ArrayList;

public class InputNumber extends Number {
    public InputNumber(String inputValues) {
        if(inputValues.length() != size) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> values = new ArrayList<>();

        for(int i =0; i < size; i++) {
            values.add(Integer.parseInt(String.valueOf(inputValues.charAt(i))));
        }

        setValues(values);
    }
}
