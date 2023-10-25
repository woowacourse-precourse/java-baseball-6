package player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberChecker {

    private final int numberLength;
    private static final String SPLIT = "";
    private static final int MORE_THAN_ONE = 1;


    public NumberChecker(int numberLength) {
        this.numberLength = numberLength;
    }

    public void validateNumbers(String inputNumbers) {
        validateNumberLength(inputNumbers.length());

        Set<String> numberSet = new HashSet<>();

        for (String number : inputNumbers.split(SPLIT)) {
            validateNumberFormat(number);
            validateNumberRange(number);
            numberSet.add(number);
        }

        validateDuplicated(numberSet.size(), inputNumbers.length());
    }

    private void validateNumberLength(int length) {
        if (length != numberLength)
            throw new IllegalArgumentException();
    }

    private void validateNumberRange(String number) {
        if (Integer.parseInt(number) < MORE_THAN_ONE)
            throw new IllegalArgumentException();
    }

    private void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(int numberSetSize, int inputNumberLength) {
        if(numberSetSize<inputNumberLength)
            throw new IllegalArgumentException();
    }
}
