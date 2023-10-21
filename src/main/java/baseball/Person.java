package baseball;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Integer> inputList;

    public Person() {
        inputList = new ArrayList<>();
    }

    public void insert(String input) {
        validateInput(input);
        clean();
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

    private void validateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(GameConstants.NOT_NUMBER);
        }

        if (input.length() != GameConstants.LIST_SIZE) {
            throw new IllegalArgumentException(GameConstants.NOT_VALID_LENGTH);
        }
    }
}
