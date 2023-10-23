package baseball;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private static final int INPUT_NUMBER_LENGTH = 3;
    private String inputNumber;

    public Player(String inputNumber) {
        isInputLengthCorrect(inputNumber);
        isInputOnlyDigit(inputNumber);
        isInputConsistDifferentNumber(inputNumber);

        this.inputNumber = inputNumber;
    }

    public void isInputLengthCorrect(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.length() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException(PrintCollection.NOT_3WORDS);
        }
    }

    public void isInputOnlyDigit(String inputNumber) throws IllegalArgumentException {
        for (int i = 0; i < inputNumber.length(); i++) {
            char tmp = inputNumber.charAt(i);

            if (!Character.isDigit(tmp)) {
                throw new IllegalArgumentException(PrintCollection.NOT_INPUT_NUMBER);
            }
        }
    }

    public void isInputConsistDifferentNumber(String inputNumber) throws IllegalArgumentException {
        char[] inputNumberCharacter = inputNumber.toCharArray();
        Set<Character> checkSet = new HashSet<>();

        for (char number : inputNumberCharacter) {
            checkSet.add(number);
        }

        if (checkSet.size() != inputNumber.length()) {
            throw new IllegalArgumentException(PrintCollection.NOT_INPUT_DIFFERENT_NUMBER);
        }
    }

    public String getInputNumber() {
        return inputNumber;
    }
}