package baseball;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Integer> inputList;

    public Person() {
        inputList = new ArrayList<>();
    }

    public void insertNumberAndValidate(String input) {
        InputValidator.validateNumberInput(input);
        for (char ch : input.toCharArray()) {
            inputList.add(Character.getNumericValue(ch));
        }
    }

    public void clean() {
        inputList.clear();
    }

    public int getNumberAt(int index) {
        return inputList.get(index);
    }
}
