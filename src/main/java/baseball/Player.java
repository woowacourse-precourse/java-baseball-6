package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Player {

    private static final String REGEX_ONE_TO_NINE ="^[1-9]+$";
    private static final String OUT_OF_ONE_TO_NIME = "[ERROR] 1 ~ 9 사이의 값만 입력해주세요";
    private List<Integer> inputNumbers;

    public Player(String inputNumber) {
        List<Integer> inputNumbers = parsingNumber(inputNumber);
        validateOneToNine(inputNumbers);
        this.inputNumbers = inputNumbers;
    }

    private List<Integer> parsingNumber(String inputNumber) {
        List<Integer> parsingNumbers = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            char charDigit = inputNumber.charAt(i);
            int intDigit = Character.getNumericValue(charDigit);
            parsingNumbers.add(intDigit);
        }

        return parsingNumbers;
    }

    private void validateOneToNine(List<Integer> numbers) {
        for (Integer number : numbers) {
            String numberStr = number.toString();
            boolean isValid = Pattern.matches(REGEX_ONE_TO_NINE, numberStr);
            if (!isValid) {
                throw new IllegalArgumentException(OUT_OF_ONE_TO_NIME);
            }
        }
    }
}
