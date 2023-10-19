package baseball;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Integer> inputList;

    public Person() {
        inputList = new ArrayList<>();
    }

    public void insert(String input) {
        int inputNum;
        for (int i = 0; i < input.length(); i++) {
            inputNum = Character.getNumericValue(input.charAt(i));
            inputList.add(inputNum);
        }
    }
}
