package baseball.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> randomNumbers;

    private Game(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public static Game numberOf(List<Integer> randomNumbers) {
        return new Game(randomNumbers);
    }

    public void compareNumber(String inputValue) {
        List<Integer> inputNumbers = getStringToList(inputValue);
    }

    private List<Integer> getStringToList(String inputValue) {
        validateInputNumber(inputValue);
        List<Integer> inputNumbers = new ArrayList<>();
        for (char currentCharacter : inputValue.toCharArray()) {
            inputNumbers.add((int) currentCharacter);
        }
        return inputNumbers;
    }

    private void validateInputNumber(String inputValue) {
        validateLengthThree(inputValue);
        validateNumber(inputValue);
    }

    private void validateLengthThree(String inputValue) {
        if(inputValue.length() != 3) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
    }

    private void validateNumber(String inputValue) {
        List<Character> compareList = new ArrayList<>();
        for(char currentCharacter : inputValue.toCharArray()) {
            isBetweenOneAndNine(currentCharacter);
            if(compareList.contains(currentCharacter)) {
                throw new IllegalArgumentException("서로 다른 숫자가 아닙니다.");
            }
            compareList.add(currentCharacter);
        }
    }

    private void isBetweenOneAndNine(char currentCharacter) {
        if(!('1' <= currentCharacter && currentCharacter <= '9')) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자가 아닙니다.");
        }
    }
}
