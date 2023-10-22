package baseball.model;

import baseball.constant.ExceptionMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Player {

    private static final String REGEX_ONE_TO_NINE = "^[1-9]+$";

    private List<Integer> inputNumbers;

    public Player(){}

    public void updateNumbers(String inputNumber) {
        initInputNumbers();
        List<Integer> expectedNumbers = parsingNumber(inputNumber);
        validateOneToNine(inputNumbers);
        validateDuplicateNumber(expectedNumbers);
        this.inputNumbers = expectedNumbers;
    }

    public List<Integer> getInputNumbers(){
        return Collections.unmodifiableList(inputNumbers);
    }

    private void initInputNumbers(){
        this.inputNumbers = new ArrayList<>();
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
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_ONE_TO_NIME.getMessage());
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> Numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : Numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(ExceptionMessage.HAVE_DUPLICATE_NUMBER.getMessage());
            }
        }
    }
}
