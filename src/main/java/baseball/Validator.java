package baseball;

import java.util.List;

public class Validator {

    public static void validatedBaseballNumber(List<Integer> baseballNumber) {
        validateListInRange(baseballNumber, GameOption.BASEBALL_START_NUMBER, GameOption.BASEBALL_END_NUMBER);
        validateSameNumber(baseballNumber);
    }

    private static void validateListInRange(List<Integer> list, int start, int end) {
        list.forEach(number -> validateInRange(number, start, end));
    }

    private static void validateInRange(int number, int start, int end) {
        if (!Utils.isInRange(number, start, end)) {
            throw new IllegalArgumentException("허용되지 않는 값입니다. " + number);
        }
    }

    private static void validateSameNumber(List<Integer> value) {
        int count = (int) value.stream()
                .distinct()
                .count();
        if (count != GameOption.BASEBALL_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }

    public static void validatedRestart(int inputValue) {
        validateInRange(inputValue, 1, 2);
    }
}
