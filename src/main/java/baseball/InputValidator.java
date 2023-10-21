package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    private static final int INITIAL_COUNT = 0;
    private static final int NUMBER_LENGTH = 3;
    private static final String INPUT_NUMBER_REGEX = "[1-9]{3}";

    public static List<Integer> checkInputNumber(String inputNumber) {
        if (inputNumber.length() != NUMBER_LENGTH || !inputNumber.matches(INPUT_NUMBER_REGEX)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 자리 숫자를 입력해주세요.");
        }

        List<Integer> inputNumbers = new ArrayList<>();
        for (char ch : inputNumber.toCharArray()) {
            inputNumbers.add(Character.getNumericValue(ch));
        }

        return inputNumbers;
    }

    public static Baseball matchNumbers(List<Integer> inputNumbers, List<Integer> randomNumbers) {
        int strike = INITIAL_COUNT;
        int ball = INITIAL_COUNT;

        for (int i = 0; i < inputNumbers.size(); i++) {
            if (inputNumbers.get(i).equals(randomNumbers.get(i))) {
                strike++;
            } else if (randomNumbers.contains(inputNumbers.get(i))) {
                ball++;
            }
        }

        return new Baseball(strike, ball);
    }
}
