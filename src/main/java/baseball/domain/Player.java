package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> inputNumbers;

    public void setInputNumber(String inputValue) {
        validateInputNumber(inputValue);
        inputNumbers = List.copyOf(changeStringToList(inputValue));
    }

    private void validateInputNumber(String inputValue) {
        validateLengthThree(inputValue);
        validateEachNumber(inputValue);
    }

    private void validateLengthThree(String inputValue) {
        if(inputValue.length() != 3) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
    }

    private void validateEachNumber(String inputValue) {
        List<Character> compareList = new ArrayList<>();
        for(char currentCharacter : inputValue.toCharArray()) {
            validateBetweenOneAndNine(currentCharacter);
            if(compareList.contains(currentCharacter)) {
                throw new IllegalArgumentException("서로 다른 숫자가 아닙니다.");
            }
            compareList.add(currentCharacter);
        }
    }

    private void validateBetweenOneAndNine(char currentCharacter) {
        if(!('1' <= currentCharacter && currentCharacter <= '9')) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자가 아닙니다.");
        }
    }

    private List<Integer> changeStringToList(String inputValue) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (char currentCharacter : inputValue.toCharArray()) {
            inputNumbers.add(currentCharacter - '0');
        }
        return inputNumbers;
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }
}
