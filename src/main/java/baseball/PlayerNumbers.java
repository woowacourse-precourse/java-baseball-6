package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerNumbers {
    private final List<Integer> playerNumbers;

    public PlayerNumbers() {
        this.playerNumbers = createPlayerNumbers();
    }

    public List<Integer> getPlayerNumbers() {
        List<Integer> clonedPlayerNumbers = new ArrayList<>(playerNumbers);
        return Collections.unmodifiableList(clonedPlayerNumbers);
    }

    private List<Integer> createPlayerNumbers() {
        String inputValue = Input.inputPlayerNumbers();
        checkValidValue(inputValue);
        return convertStringToIntegerList(inputValue);
    }

    private void checkValidValue(String inputValue) {
        if(!(isNumeric(inputValue) && isZeroNotIncluded(inputValue)
        && isValidDigit(inputValue) && isNumbersNotDuplicate(inputValue))) {
            throw new IllegalArgumentException("유효하지 않은 입력 형식입니다.");
        }
    }

    private boolean isNumeric(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isZeroNotIncluded(String inputValue) {
        return !inputValue.contains("0");
    }

    private boolean isValidDigit(String inputValue) {
        return inputValue.length() == BaseballGame.GAME_NUMBER_DIGIT;
    }

    private boolean isNumbersNotDuplicate(String inputValue) {
        StringBuilder stringForCheckingDuplicate = new StringBuilder();
        for (char number : inputValue.toCharArray()) {
            if(stringForCheckingDuplicate.toString().contains(String.valueOf(number))) {
                return false;
            }
            stringForCheckingDuplicate.append(number);
        }
        return true;
    }

    private List<Integer> convertStringToIntegerList(String inputValue) {
        List<Integer> numbers = new ArrayList<>();
        for (int numbersIndex = 0; numbersIndex < inputValue.length(); numbersIndex++) {
            char digitChar = inputValue.charAt(numbersIndex);
            int digitNumber = Character.getNumericValue(digitChar);
            numbers.add(digitNumber);
        }
        return numbers;
    }
}
