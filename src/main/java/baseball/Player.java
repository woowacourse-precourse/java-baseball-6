package baseball;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String inputNumber;

    public Player(String inputNumber) {
        isInputLengthCorrect(inputNumber);
        isInputOnlyDigit(inputNumber);
        isInputConsistDifferentNumber(inputNumber);

        this.inputNumber = inputNumber;
    }

    public void isInputLengthCorrect(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력된 수가 3자리가 아닙니다.");
        }
    }

    public void isInputOnlyDigit(String inputNumber) throws IllegalArgumentException {
        for (int i = 0; i < inputNumber.length(); i++) {
            char tmp = inputNumber.charAt(i);

            if (!Character.isDigit(tmp)) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
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
            throw new IllegalArgumentException("입력이 서로 다른 숫자로 이루어지지 않았습니다.");
        }
    }

    public String getInputNumber() {
        return inputNumber;
    }
}