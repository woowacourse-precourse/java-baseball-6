package baseball.Service;

import java.util.List;
import java.util.ArrayList;

public class InputNumberService {
    private static final int NUMBER_SIZE = 3;
    private static final char NOT_FIRST_NUMBER = 0;

    public List<Character> createInputNumberList(String input) {
        List<Character> inputNumberList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNumberList.add(input.charAt(i));
        }
        return inputNumberList;
    }

    public void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberSize(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void validateFirstNumber(String input) {
        if (input.charAt(0) == NOT_FIRST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
