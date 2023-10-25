package baseball.core;

import baseball.Enum.NumberSize;
import baseball.exception.IllegalCountException;
import baseball.exception.IllegalDuplicateException;
import baseball.exception.IllegalTypeException;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberPicker {

    protected NumberPicker() {
    }

    public static NumberPicker createNumberPicker() {
        return new NumberPicker();
    }

    public List<Integer> pickRandomNumber() {
        Set<Integer> pickedNumbersSet = new HashSet<>();
        while (pickedNumbersSet.size() < NumberSize.MAX_SIZE.getSize()) {
            int randomNumber = Randoms.pickNumberInRange(
                    NumberSize.START_INCLUSIVE.getSize(),
                    NumberSize.END_INCLUSIVE.getSize()
            );
            pickedNumbersSet.add(randomNumber);
        }
        return new ArrayList<>(pickedNumbersSet);
    }

    public List<Integer> picConsoleNumber(String unprocessedNumber) {
        String[] stringBeforeNumber = unprocessedNumber.split("");
        validateInput(stringBeforeNumber);
        return Arrays.stream(stringBeforeNumber).map(Integer::parseInt)
                .toList();
    }

    private static void validateInput(String[] stringBeforeNumber) {
        validateIsNumeric(stringBeforeNumber);
        privateDuplicate(stringBeforeNumber);
        validateCount(stringBeforeNumber.length);
    }

    private static void validateIsNumeric(String[] stringBeforeNumber) {
        for (String string : stringBeforeNumber) {
            if (!string.matches("\\d+")) {
                throw new IllegalTypeException();
            }
        }
    }

    private static void privateDuplicate(String[] stringBeforeNumber) {
        for (int i = 0; i < NumberSize.MAX_SIZE.getSize(); i++) {
            for (int j = i + 1; j < NumberSize.MAX_SIZE.getSize(); j++) {
                if (stringBeforeNumber[i].equals(stringBeforeNumber[j])) {
                    throw new IllegalDuplicateException();
                }
            }
        }
    }

    private static void validateCount(final int count) {
        if (NumberSize.MAX_SIZE.getSize() < count) {
            throw new IllegalCountException();
        }
    }

}
