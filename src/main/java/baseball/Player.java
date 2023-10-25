package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final static int MINIMUM_THREE_DIGIT_NUMBER = 100;
    private final static int MAXIMUM_THREE_DIGIT_NUMBER = 999;

    Player() {
    }

    public List<Integer> guessNumbers() throws IllegalArgumentException {
        String userInput = Console.readLine();
        validateIsThreeDigitNumber(userInput);
        validateIsNotContaningZero(userInput);
        validateIsComposedOfDistinctDigits(userInput);
        List<Integer> guessingNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char charAtIndex = userInput.charAt(i);
            int numberAtIndex = Character.getNumericValue(charAtIndex);
            guessingNumbers.add(numberAtIndex);
        }
        return guessingNumbers;
    }

    private void validateIsThreeDigitNumber(String userInput) throws IllegalArgumentException {
        try {
            int threeDigitNumberCandidate = Integer.parseInt(userInput);
            if (threeDigitNumberCandidate < MINIMUM_THREE_DIGIT_NUMBER) {
                throw new IllegalArgumentException("3자리 수가 아닌 문자열을 입력");
            }
            if (threeDigitNumberCandidate > MAXIMUM_THREE_DIGIT_NUMBER) {
                throw new IllegalArgumentException("3자리 수가 아닌 문자열을 입력");
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Integer로 변환할 수 없는 문자열을 입력");
        }
    }

    private void validateIsNotContaningZero(String userInput) throws IllegalArgumentException {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException("0이 포함된 문자열을 입력");
        }
    }

    private void validateIsComposedOfDistinctDigits(String userInput) throws IllegalArgumentException {
        String distinctDigitsNumberCandidate = "";
        for (int i = 0; i < userInput.length(); i++) {
            String digit = userInput.substring(i, i + 1);
            if (distinctDigitsNumberCandidate.contains(digit)) {
                throw new IllegalArgumentException("서로 다른 3자리 수가 아닌 문자열을 입력");
            }
            distinctDigitsNumberCandidate += digit;
        }
    }
}